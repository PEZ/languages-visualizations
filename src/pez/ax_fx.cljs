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
          (= :ax/set-hash action-name)
          {:effects [[:fx/set-hash (first args)]]}

          (= :ax/take-snapshot action-name)
          {:effects [[:fx/take-snapshot state]]}

          (= :ax/run-sketch action-name)
          (let [now (js/performance.now)
                min-time (apply min (benchmark/benchmark-times state))
                min-track-time-ms (if (= "fastest-language" (:min-track-time-choice state))
                                    min-time
                                    (parse-long (:min-track-time-choice state)))
                start-state (assoc state
                                   :start-time now
                                   :min-time min-time
                                   :pre-startup-wait-ms race/pre-startup-wait-ms
                                   :min-track-time-ms min-track-time-ms)
                display-time (race/t->display-time start-state now)]
            {:new-state (assoc start-state
                               :manual-display-time display-time)
             :effects [[:fx/run-sketch]]})

          (= :ax/set-benchmark action-name)
          {:new-state (assoc state :benchmark (keyword (first args)))
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/set-min-track-time-choice action-name)
          {:new-state (assoc state :min-track-time-choice (first args))
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/toggle-snapshot-mode action-name)
          {:new-state (update state :snapshot-mode? not)}

          (= :ax/toggle-champions-mode action-name)
          {:new-state (-> state (update :filter-champions? not))
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/toggle-overlaps action-name)
          {:new-state (-> state (update :add-overlaps? not))
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/share action-name)
          {:effects [[:fx/share (first args) (second args)]]}

          (= :ax/add-benchmark-run action-name)
          (let [runs (benchmark/csv->benchmark-data (first args))
                run-keys (sort > (keys runs))]
            {:new-state (update state :benchmark-runs merge runs)
             :effects [[:fx/dispatch nil [[:ax/select-benchmark-run (first run-keys)]]]]})

          (= :ax/select-benchmark-run action-name)
          (let [selected-run (first args)]
            (if (= "" selected-run)
              {:effects [[:fx/dispatch nil [[:ax/reset-benchmark-data]]]]}
              {:new-state (assoc state
                                 :benchmarks (get-in
                                              (:benchmark-runs state)
                                              [selected-run :measurements])
                                 :selected-run selected-run)
               :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}))

          (= :ax/reset-benchmark-data action-name)
          {:new-state (assoc state
                             :benchmarks bd/benchmarks
                             :selected-run "")
           :effects [[:fx/dispatch nil [[:ax/run-sketch]]]]}

          (= :ax/fetch-gist action-name)
          {:effects [[:fx/fetch-gist (first args)]]}

          (= :ax/pause-sketch action-name)
          (let [current-dt (race/t->display-time state (js/performance.now))]
            {:new-state (assoc state
                               :paused? true
                               :manual-display-time current-dt)})


          (= :ax/resume-sketch action-name)
          (let [mdt (or (:manual-display-time state) 0)
                now (js/performance.now)
                new-elapsed-ms (race/display-time->elapsed-ms state mdt)
                new-start-time (- now new-elapsed-ms)]
            {:new-state (assoc state
                               :paused? false
                               :start-time new-start-time)})

          (= :ax/set-display-time action-name)
          (let [new-display-time (parse-double (first args))]
            (if (js/isNaN new-display-time)
              {:new-state state}
              (if (:paused? state)
                {:new-state (assoc state :manual-display-time new-display-time)}
                (let [current-time (js/performance.now)
                      new-elapsed-ms (race/display-time->elapsed-ms state new-display-time)
                      time-shift (- new-elapsed-ms (race/t->elapsed-ms state current-time))
                      new-start-time (+ (- current-time new-elapsed-ms) time-shift)]
                  {:new-state (assoc state
                                     :start-time new-start-time)}))))

          (= :ax/assoc action-name)
          {:new-state (apply assoc state args)})]

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
            (= :fx/set-hash effect-name) (set! (-> js/window .-location .-hash) (first args))
            (= :fx/run-sketch effect-name) (race/run-sketch!)
            (= :fx/take-snapshot effect-name) (race/save-image! (first args))
            (= :fx/share effect-name) (apply browser/share! args)
            (= :fx/dispatch effect-name) (event-handler (first args) (second args))
            (= :fx/fetch-gist effect-name) (-> (js/fetch (first args))
                                               (.then #(.text %))
                                               (.then #(event-handler {} [[:ax/add-benchmark-run %]])))))))))