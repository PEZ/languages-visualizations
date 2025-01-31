(ns pez.race
  (:require
   [clojure.set :as set]
   [clojure.string :as string]
   [clojure.walk :as walk]
   [gadget.inspector :as inspector]
   [pez.benchmark-data :as bd]
   [pez.config :as conf]
   [pez.race-time :as rt]
   [pez.views :as views]
   [quil.core :as q]
   [quil.middleware :as m]
   [replicant.dom :as d]))

(defonce !app-state (atom {:benchmark :loops
                           :snapshot-mode? false
                           :filter-champions? false
                           :min-track-time-choice "600" #_"fastest-language"
                           :benchmarks bd/benchmarks
                           :add-overlaps? true
                           :paused? false
                           :manual-display-time nil}))

(def app-el (js/document.getElementById "app"))

(def drawing-width 700)
(def language-labels-x 140)
(def ball-width 44)
(def half-ball-width (/ ball-width 2))
(def start-line-x (+ language-labels-x half-ball-width 10))

(def pre-startup-wait-ms 500)

(defn active-benchmarks [benchmarks]
  (sort-by #(.indexOf [:loops :fibonacci :levenshtein :hello-world] %)
           (reduce-kv (fn [acc _k v]
                        (into acc (remove (fn [benchmark]
                                            (.endsWith (name benchmark) "-hello-world"))
                                          (keys v))))
                      #{}
                      benchmarks)))

(defn benchmark-times [{:keys [benchmark benchmarks]}]
  (let [benchmarks (filter (comp benchmark second) benchmarks)]
    (->> benchmarks
         vals
         (map benchmark)
         (map :mean))))

(comment
  (benchmark-times {:benchmark :loops})
  :rcf)

(defn languages [{:keys [benchmarks]}]
  (mapv (fn [{:keys [language-file-name] :as lang}]
          (merge lang
                 (benchmarks language-file-name)))
        conf/languages))

(defn fastest-implementation [{:keys [benchmark]} implementations]
  (apply min-key benchmark implementations))

(defn best-languages [{:keys [benchmark filter-champions?] :as app-state}]
  (let [langs (languages app-state)]
    (if filter-champions?
      (->> langs
           (group-by :language)
           vals
           (map (fn [champions]
                  (fastest-implementation app-state (filter #(get-in % [benchmark :mean]) champions))))
           (filter (fn [lang]
                     (get-in lang [benchmark :mean]))))
      (filter (fn [lang]
                (get-in lang [benchmark :mean]))
              langs))))

(comment
  (best-languages {:benchmark :loops})
  :rcf)

(defn- add-default-speed-mean [benchmark lang]
  (assoc-in lang [benchmark :speed-mean]
            (get-in lang [benchmark :mean])))

(defn sorted-languages [{:keys [benchmark] :as app-state}]
  (map (partial add-default-speed-mean benchmark)
       (sort-by #(get-in % [benchmark :mean]) (best-languages app-state))))

(defn find-missing-languages [benchmarks]
  (let [config-languages (set (map :language-file-name conf/languages))
        benchmark-languages (set (keys benchmarks))]
    (set/difference benchmark-languages config-languages)))

(comment
  (languages (:benchmarks @!app-state))
  (sorted-languages {:benchmark :loops
                     :benchmarks @!app-state})
  (find-missing-languages (:benchmarks @!app-state))
  :rcf)

(defn dims [app-state]
  [(min drawing-width (.-offsetWidth app-el)) (+ 100 (* 45 (count (sorted-languages app-state))))])

(defn arena [width height]
  (let [finish-line-x (- width half-ball-width 5)]
    {:width width
     :finish-line-x finish-line-x
     :track-length (- finish-line-x start-line-x)
     :middle-x (/ width 2)
     :middle-y (/ height 2)}))

(defn- add-overlaps [{:keys [benchmark] :as app-state}]
  (let [langs-with-stats (filter #(get-in % [benchmark :mean])
                                 (sorted-languages app-state))
        pairs (partition 2 1 langs-with-stats)]
    (reduce (fn [langs [lang1 lang2]]
              (let [mean1 (get-in (first (filter #(= % lang1) langs)) [benchmark :speed-mean])
                    std-dev1 (get-in lang1 [benchmark :stddev])
                    mean2 (get-in lang2 [benchmark :mean])
                    std-dev2 (get-in lang2 [benchmark :stddev])
                    interval1 [(max 0 (- mean1 std-dev1)) (+ mean1 std-dev1)]
                    interval2 [(max 0 (- mean2 std-dev2)) (+ mean2 std-dev2)]
                    overlap? (and (<= (first interval1) (second interval2))
                                  (>= (second interval1) (first interval2)))]
                (if overlap?
                  (let [shared-mean mean2]
                    (mapv #(if (or (= % lang1)
                                   (= (get-in % [benchmark :speed-mean]) mean1))
                             (assoc-in % [benchmark :speed-mean] shared-mean)
                             %)
                          langs))
                  langs)))
            langs-with-stats
            pairs)))

(defn setup [{:keys [benchmark add-overlaps? min-time] :as app-state}]
  (q/frame-rate 120)
  (q/image-mode :center)
  (let [arena (arena (q/width) (q/height))]
    (merge arena
           {:t 0
            :display-time-str ""
            :app-state app-state
            :benchmark benchmark
            :race-started? false
            :benchmark-title (benchmark conf/benchmark-names)
            :languages (mapv (fn [i lang]
                               (let [{:keys [mean stddev speed-mean]} (get lang benchmark)
                                     speed (/ min-time speed-mean)]
                                 (merge lang
                                        {:speed speed
                                         :runs 0
                                         :track-x start-line-x
                                         :greeting "Hello, World!"
                                         :benchmark-time mean
                                         :benchmark-time-str (str (-> mean (.toFixed 1)))
                                         :std-dev-str (str (-> stddev (.toFixed 1)))
                                         :x 0
                                         :y (+ 110 (* i 45))
                                         :logo-image (q/load-image (:logo lang))})))
                             (range)
                             (if add-overlaps?
                               (add-overlaps app-state)
                               (sorted-languages app-state)))})))

(comment
  (setup :loops)
  (-> 234.0 (.toFixed 1) (.padStart 7))
  :rcf)

(defn update-draw-state [draw-state app-state now]
  (let [arena (arena (q/width) (q/height))
        paused? (:paused? app-state)
        manual-display-time (:manual-display-time app-state)
        display-time (if paused?
                       (or manual-display-time
                           (rt/t->display-time app-state now))
                       (rt/t->display-time app-state now))
        elapsed-ms (rt/display-time->elapsed-ms app-state display-time)
        race-started? (>= elapsed-ms pre-startup-wait-ms)
        position-time (max 0 (- elapsed-ms pre-startup-wait-ms))
        take-snapshot? (and (:snapshot-mode? app-state)
                            (= 1 (:runs (first (:languages draw-state))))
                            (not (:snapshot-taken? draw-state)))]
    (merge draw-state
           arena
           {:t (rt/t->elapsed-ms app-state now) ; Not used, but nice for logging
            :position-time position-time
            :display-time display-time
            :display-time-str (.toFixed display-time 1)
            :app-state app-state
            :race-started? race-started?
            :snapshot-taken? (or (:snapshot-taken? draw-state) take-snapshot?)
            :take-snapshot? take-snapshot?
            :languages
            (mapv (fn [{:keys [speed] :as lang}]
                    (merge lang
                           (let [normalized-time (/ position-time (:min-track-time-ms app-state))
                                 scaled-time (* normalized-time speed)
                                 distance (* (:track-length arena) scaled-time)
                                 loop-distance (mod distance (* 2 (:track-length arena)))
                                 x (if (> loop-distance (:track-length arena))
                                     (- (* 2 (:track-length arena)) loop-distance)
                                     loop-distance)]
                             {:track-x (+ start-line-x x)
                              :runs (quot distance (:track-length arena))})))
                  (:languages draw-state))})))

(comment
  (q/no-loop)
  :rcf)

(def offwhite 245)
(def darkgrey 120)
(def black 40)

(declare event-handler)

(defn draw! [{:keys [benchmark-title middle-x width display-time-str
                     take-snapshot? app-state] :as draw-state}]
  (when take-snapshot?
    (event-handler {} [[:ax/take-snapshot app-state]]))
  (q/background offwhite)
  (q/stroke-weight 0)
  (q/text-align :center)
  (q/fill black)
  (q/text-size 20)
  (q/text-style :bold)
  (q/text benchmark-title middle-x 20)
  (q/text-size 16)
  (q/text-style :normal)
  (q/text "How fast is your favorite language?" middle-x 45)
  (q/text-style :normal)
  (q/text-align :right :center)
  (q/text "±" 50 65)
  (q/text "ms" language-labels-x 65)
  (q/text display-time-str (- width 5) 65)
  (q/text-size 14)
  (doseq [lang (:languages draw-state)]
    (let [{:keys [language-name logo-image y track-x runs benchmark-time-str std-dev-str]} lang]
      (q/fill darkgrey)
      (q/rect 0 (- y 12) (+ language-labels-x 5) 24)
      (q/text-num runs (- width 5) y)
      (q/fill offwhite)
      (q/text language-name language-labels-x y)
      (q/fill darkgrey)
      (q/text std-dev-str 50 (- y 20))
      (q/text benchmark-time-str language-labels-x (- y 20))
      (q/image logo-image track-x y ball-width ball-width))))

(defn save-image [{:keys [benchmark filter-champions?]}]
  (let [iso-date (.substring (.toISOString (js/Date.)) 0 10)]
    (println "Saving file...")
    (q/save (str "languages-visualizations-"
                 (name benchmark) "-" iso-date
                 (when-not filter-champions? "-all")
                 ".png"))))

(defn- share! [site text]
  (let [url (-> js/window .-location .-href)]
    (.open js/window (str (case site
                            :site/x "https://twitter.com/intent/tweet?text="
                            :site/linkedin "https://www.linkedin.com/shareArticle?mini=true&text=")
                          (js/encodeURIComponent text)
                          "&url="
                          (js/encodeURIComponent url)))))

(defn run-sketch! []
  ; TODO: Figure out if there's a way to set the current applet with public API
  #_{:clj-kondo/ignore [:unresolved-namespace]}
  (set! quil.sketch/*applet*
        (q/sketch
         :host "race"
         :size (dims @!app-state)
         :renderer :p2d
         :setup (fn [] (setup @!app-state))
         :update (fn [state]
                   (update-draw-state state @!app-state (js/performance.now)))
         :draw draw!
         :middleware [m/fun-mode])))

(defn csv->benchmark-data [csv-text]
  (let [lines (as-> csv-text $
                (string/split $ #"\n")
                (remove (partial re-find #"^benchmark,timestamp|^\s*$") $))
        rows (map #(string/split % #",") lines)]
    (try
      (reduce (fn [acc [benchmark timestamp commit-sha
                        _is-checked user model ram os
                        arch language run-ms mean-ms
                        std-dev-ms _min-ms _max-ms runs]]
                (let [language-slug (string/replace language #"[^a-zA-Z0-9]" "_")
                      run-key (str user "," timestamp "," model "," ram "," os "," arch "," commit-sha "," run-ms)]
                  (assoc-in acc
                            [run-key language-slug (keyword benchmark)]
                            {:mean (parse-double mean-ms)
                             :stddev (parse-double std-dev-ms)
                             :runs (parse-long runs)})))
              {}
              rows)
      (catch :default e
        (js/alert (str "Error while parsing CSV. " e))))))

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
                min-time (apply min (benchmark-times state))
                min-track-time-ms (if (= "fastest-language" (:min-track-time-choice state))
                                    min-time
                                    (parse-long (:min-track-time-choice state)))
                start-state (assoc state
                                   :start-time now
                                   :min-time min-time
                                   :pre-startup-wait-ms pre-startup-wait-ms
                                   :min-track-time-ms min-track-time-ms)
                display-time (rt/t->display-time start-state now)]
            {:new-state (assoc start-state
                               :display-time display-time
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
          (let [runs (csv->benchmark-data (first args))
                run-keys (sort > (keys runs))]
            {:new-state (update state :benchmark-runs merge runs)
             :effects [[:fx/dispatch nil [[:ax/select-benchmark-run (first run-keys)]]]]})

          (= :ax/select-benchmark-run action-name)
          (let [selected-run (first args)]
            (if (= "" selected-run)
              {:effects [[:fx/dispatch nil [[:ax/reset-benchmark-data]]]]}
              {:new-state (assoc state
                                 :benchmarks (get
                                              (:benchmark-runs state)
                                              selected-run)
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
          (let [current-dt (rt/t->display-time state (js/performance.now))]
            {:new-state (assoc state
                               :paused? true
                               :manual-display-time current-dt)})


          (= :ax/resume-sketch action-name)
          (let [mdt (or (:manual-display-time state)
                        (rt/t->display-time state (js/performance.now)))
                now (js/performance.now)
                new-elapsed-ms (rt/display-time->elapsed-ms state mdt)
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
                      new-elapsed-ms (rt/display-time->elapsed-ms state new-display-time)
                      time-shift (- new-elapsed-ms (rt/t->elapsed-ms state current-time))
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

(comment
  (:display-time state)
  :rcf)

(defn- event-handler [replicant-data actions]
  (let [{:keys [new-state effects]} (reduce (fn [result action]
                                              (action-handler result replicant-data action))
                                            {:new-state @!app-state
                                             :effects []}
                                            actions)]
    (when new-state
      (reset! !app-state new-state))
    (when effects
      (doseq [effect effects]
        (when js/goog.DEBUG
          (js/console.debug "Triggered effect" effect))
        (let [[effect-name & args] effect]
          (cond
            (= :fx/console.log effect-name) (apply js/console.log args)
            (= :fx/set-hash effect-name) (set! (-> js/window .-location .-hash) (first args))
            (= :fx/run-sketch effect-name) (run-sketch!)
            (= :fx/take-snapshot effect-name) (save-image (first args))
            (= :fx/share effect-name) (apply share! args)
            (= :fx/dispatch effect-name) (event-handler (first args) (second args))
            (= :fx/fetch-gist effect-name) (-> (js/fetch (first args))
                                               (.then #(.text %))
                                               (.then #(event-handler {} [[:ax/add-benchmark-run %]])))))))))

(defn render-app! [el {:keys [benchmarks] :as state}]
  (d/render el (views/app state (active-benchmarks benchmarks))))

(defn handle-hash [{:keys [benchmarks]}]
  (let [location-hash (-> js/window .-location .-hash)
        benchmark (when (seq location-hash)
                    (keyword (subs location-hash 1)))]
    (cond
      (contains? (set (active-benchmarks benchmarks)) benchmark)
      (event-handler {} [[:ax/set-benchmark benchmark]])

      (string/starts-with? location-hash "#https://gist.github.com")
      (event-handler {} [[:ax/fetch-gist (str "https://api.allorigins.win/raw?url="
                                              (js/encodeURIComponent (str (subs location-hash 1) "/raw")))]])

      :else
      (event-handler {} [[:ax/set-benchmark :loops]]))))

(defn ^:dev/after-load start-app! []
  (js/console.log "start")
  (render-app! app-el @!app-state))

(defn ^:export init! []
  (js/console.log "init")
  (inspector/inspect "App state" !app-state)
  (add-watch !app-state :update (fn [_k _r _o n]
                                  (render-app! app-el n)))
  (js/window.addEventListener "resize"
                              (fn [_e]
                                (let [[w h] (dims @!app-state)]
                                  (q/resize-sketch w h))))
  (d/set-dispatch! event-handler)
  (handle-hash @!app-state)
  (js/window.addEventListener "hashchange" #(handle-hash @!app-state))
  (start-app!))

(defn ^{:export true
        :dev/before-load true} stop! []
  (js/console.log "stop"))
