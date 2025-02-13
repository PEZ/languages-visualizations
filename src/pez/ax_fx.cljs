(ns pez.ax-fx
  (:require
   [clojure.walk :as walk]
   [pez.benchmark :as benchmark]
   [pez.benchmark-data :as bd]
   [pez.browser :as browser]
   [pez.db :as db]
   [pez.race :as race]))

(defn- enrich-action-from-replicant-data [{:replicant/keys [js-event node]} actions]
  (walk/postwalk
   (fn [x]
     (if (keyword? x)
       (cond (= :event/target.value x) (some-> js-event .-target .-value)
             (= :dom/node x) node
             (= :dom/node.value x) (.-value node)
             :else x)
       x))
   actions))

(defn- enrich-action-from-app-state [app-state action]
  (walk/postwalk
   (fn [x]
     (cond
       (and (vector? x)
            (= :db/get (first x))) (get app-state (second x))
       :else x))
   action))

(defn- action-handler [{state :new-state :as result} replicant-data action]
  (when js/goog.DEBUG
    (def state state)
    (js/console.debug "Triggered action" action))
  (let [[action-name & args :as enriched] (enrich-action-from-app-state
                                           state
                                           (enrich-action-from-replicant-data
                                            replicant-data action))
        _ (when js/goog.DEBUG (js/console.debug "Enriched action" enriched))
        {:keys [new-state effects]}
        (cond
          (= :ax/init action-name)
          {:new-state (assoc state :app/gist-loading? true)
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]
                     [:fx/fetch-gist (:app/default-gist state) [[:ax/handle-hash]]]]}

          (= :ax/handle-hash action-name)
          {:effects [[:fx/handle-hash state]]}

          (= :ax/set-hash action-name)
          {:effects [[:fx/set-hash (first args)]]}

          (= :ax/take-snapshot action-name)
          {:effects [[:fx/take-snapshot state]]}

          (= :ax/run-sketch action-name)
          (let [times (benchmark/benchmark-times state)
                min-time (apply min times)
                max-time (apply max times)
                min-track-time-ms (cond
                                    (= "fastest-language" (:app/fastest-ui-track-time-choice state)) min-time
                                    :else (parse-long (:app/fastest-ui-track-time-choice state)))
                start-state (assoc state
                                   :app/start-time (js/performance.now)
                                   :app/fastest-benchmark-time min-time
                                   :app/slowest-benchmark-time max-time
                                   :app/fastest-ui-track-time-ms min-track-time-ms)]
            {:new-state (assoc start-state
                               :app/paused? true
                               :app/manual-display-time 0)
             :effects [[:fx/run-sketch]]})

          (= :ax/set-benchmark action-name)
          {:new-state (assoc state :app/benchmark (keyword (first args)))
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/set-min-track-time-choice action-name)
          {:new-state (assoc state :app/fastest-ui-track-time-choice (first args))
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/toggle-champions-mode action-name)
          {:new-state (-> state (update :app/filter-champions? not))
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/toggle-overlaps action-name)
          {:new-state (-> state (update :app/add-overlaps? not))
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/share action-name)
          {:effects [[:fx/share (first args) (second args)]]}

          (= :ax/add-benchmark-run action-name)
          (let [runs (benchmark/csv->benchmark-data (first args) (second args))
                run-keys (sort > (keys runs))]
            {:new-state (update state :app/benchmark-runs merge runs)
             :effects [[:fx/dispatch nil [[:ax/select-benchmark-run (first run-keys)]]]]})

          (= :ax/select-benchmark-run action-name)
          (let [selected-run (first args)]
            (if (= "" selected-run)
              {:effects [[:fx/dispatch nil [[:ax/reset-benchmark-data]]]]}
              {:new-state (assoc state
                                 :app/benchmarks (get-in
                                                  (:app/benchmark-runs state)
                                                  [selected-run :measurements])
                                 :app/selected-run selected-run)
               :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}))

          (= :ax/reset-benchmark-data action-name)
          {:new-state (assoc state
                             :app/benchmarks bd/legacy
                             :app/selected-run "")
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/fetch-gist action-name)
          {:new-state (assoc state :app/gist-loading? true)
           :effects [[:fx/fetch-gist (first args)]]}

          (= :ax/pause-sketch action-name)
          (let [current-dt (race/t->display-time state (js/performance.now))]
            {:new-state (assoc state
                               :app/paused? true
                               :app/manual-display-time current-dt)})


          (= :ax/resume-sketch action-name)
          (let [mdt (or (:app/manual-display-time state) 0)
                now (js/performance.now)
                new-elapsed-ms (race/display-time->elapsed-ms state mdt)
                new-start-time (- now new-elapsed-ms)]
            {:new-state (assoc state
                               :app/paused? false
                               :app/start-time new-start-time)})

          (= :ax/set-display-time action-name)
          (when-let [dt (first args)]
            (when-let [new-display-time (browser/parse-number dt)]
              (if (js/isNaN new-display-time)
                {:new-state state}
                (if (:app/paused? state)
                  {:new-state (assoc state :app/manual-display-time new-display-time)}
                  (let [current-time (js/performance.now)
                        new-elapsed-ms (race/display-time->elapsed-ms state new-display-time)
                        time-shift (- new-elapsed-ms (race/t->elapsed-ms state current-time))
                        new-start-time (+ (- current-time new-elapsed-ms) time-shift)]
                    {:new-state (assoc state
                                       :app/start-time new-start-time)})))))

          (= :ax/assoc action-name)
          {:new-state (apply assoc state args)}

          (= :ax/select-all action-name)
          {:effects [[:fx/select-all (first args)]]})]

    (when js/goog.DEBUG
      (js/console.debug "Final new-state:" new-state))

    (cond-> result
      new-state (assoc :new-state new-state)
      effects (update :effects into effects))))

(defn event-handler [replicant-data actions]
  (let [{:keys [new-state effects]} (reduce (fn [result action]
                                              (action-handler result replicant-data action))
                                            {:new-state @db/!app-state
                                             :effects []}
                                            actions)]
    (when new-state
      (reset! db/!app-state new-state))
    (when effects
      (doseq [effect effects]
        (when js/goog.DEBUG
          (js/console.debug "Triggered effect" effect))
        (let [[effect-name & args] effect]
          (cond
            (= :fx/console.log effect-name) (apply js/console.log args)
            (= :fx/handle-hash effect-name) (browser/handle-hash event-handler (first args))
            (= :fx/set-hash effect-name) (set! (-> js/window .-location .-hash) (first args))
            (= :fx/run-sketch effect-name) (race/run-sketch! event-handler)
            (= :fx/take-snapshot effect-name) (race/save-image! (first args))
            (= :fx/share effect-name) (apply browser/share! event-handler args)
            (= :fx/dispatch effect-name) (event-handler (first args) (second args))
            (= :fx/select-all effect-name) (js/requestAnimationFrame #(.select (first args)))
            (= :fx/fetch-gist effect-name) (-> (str #_"https://corsproxy.io/?url="
                                                #_"https://thingproxy.freeboard.io/fetch/"
                                                "https://api.allorigins.win/raw?url="
                                                    (js/encodeURIComponent (str (first args) "/raw")))
                                               js/fetch
                                               (.then (fn [response]
                                                        (if (.-ok response)
                                                          (.text response)
                                                          (throw (js/Error. "Network response was not OK")))))
                                               (.then #(event-handler {} [[:ax/add-benchmark-run % (first args)]]))
                                               (.then #(event-handler {} (second args)))
                                               (.catch #(event-handler {} [[:ax/assoc :app/error "Error fetching gist"]]))
                                               (.finally #(event-handler {} [[:ax/assoc :app/gist-loading? false]])))))))))