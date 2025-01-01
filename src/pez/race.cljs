(ns pez.race
  (:require
   [clojure.set :as set]
   [clojure.walk :as walk]
   [gadget.inspector :as inspector]
   [pez.benchmark-data :as bd]
   [pez.config :as conf]
   [pez.views :as views]
   [quil.core :as q]
   [quil.middleware :as m]
   [replicant.dom :as d]))

(defonce !app-state (atom {:benchmark :loops
                           :start-times-mode? false
                           :snapshot-mode? false
                           :min-track-time-ms 600}))

(def app-el (js/document.getElementById "app"))

(def drawing-width 700)
(def start-time-line-x 140)
(def ball-width 44)
(def half-ball-width (/ ball-width 2))
(def start-line-x (+ start-time-line-x half-ball-width 10))

(def pre-startup-wait-ms 1500)
(def startup-sequence-ms 5000)
(def greeting-display-ms 7500)

(defn start-time-key [benchmark]
  (-> benchmark name (str "-hello-world") keyword))

(defn max-start-time [benchmark]
  (->> bd/benchmarks
       vals
       (map (start-time-key benchmark))
       (apply max)))

(defn active-benchmarks [benchmarks]
  (sort-by #(.indexOf [:loops :fibonacci :levenshtein] %)
           (reduce-kv (fn [acc _k v]
                        (into acc (remove (fn [benchmark]
                                            (.endsWith (name benchmark) "-hello-world"))
                                          (keys v))))
                      #{}
                      benchmarks)))

(defn benchmark-times [{:keys [benchmark start-times-mode?]}]
  (let [benchmarks (filter (comp benchmark second) bd/benchmarks)
        times (->> benchmarks
                   vals
                   (map benchmark))
        start-times (->> benchmarks
                         vals
                         (map (start-time-key benchmark)))]
    (if start-times-mode?
      (mapv - times start-times)
      times)))

(comment
  (benchmark-times {:benchmark :loops
                    :start-times-mode? false})
  :rcf)

(defn languages []
  (mapv (fn [{:keys [language-file-name] :as lang}]
          (merge lang
                 (bd/benchmarks language-file-name)))
        conf/languages))

(defn- benchmark-result [{:keys [benchmark start-times-mode? lang]}]
  (if start-times-mode?
    (- (benchmark lang)
       (get lang (start-time-key benchmark)))
    (benchmark lang)))

(defn fastest-implementation [app-state implementations]
  (apply min-key
         (fn [impl]
           (benchmark-result (assoc app-state :lang impl)))
         implementations))

(defn best-languages [{:keys [benchmark] :as app-state}]
  (->> (languages)
       (group-by :language)
       vals
       (map (fn [champions]
              (fastest-implementation app-state (filter benchmark champions))))
       (filter (fn [lang]
                 (benchmark lang)))))

(comment
  (best-languages {:benchmark :loops
                   :start-times-mode? false})
  :rcf)

(defn sorted-languages [app-state]
  (sort-by (fn [lang]
             (benchmark-result (assoc app-state :lang lang)))
           (best-languages app-state)))

(defn find-missing-languages []
  (let [config-languages (set (map :language-file-name conf/languages))
        benchmark-languages (set (keys bd/benchmarks))]
    (set/difference benchmark-languages config-languages)))

(comment
  (languages)
  (sorted-languages {:benchmark :loops})
  (find-missing-languages)
  :rcf)

(defn dims [app-state]
  [(min drawing-width (.-offsetWidth app-el)) (+ 80 (* 45 (count (sorted-languages app-state))))])

(defn arena [width height]
  (let [finish-line-x (- width half-ball-width 5)]
    {:width width
     :finish-line-x finish-line-x
     :track-length (- finish-line-x start-line-x)
     :middle-x (/ width 2)
     :middle-y (/ height 2)}))

(defn setup [{:keys [benchmark start-times-mode?] :as app-state}]
  (q/frame-rate 120)
  (q/image-mode :center)
  (let [arena (arena (q/width) (q/height))
        min-time (apply min (benchmark-times app-state))]
    (merge arena
           {:t 0
            :benchmark benchmark
            :start-times-mode? start-times-mode?
            :race-started? false
            :max-start-time (max-start-time benchmark)
            :start-message "Starting engines!"
            :race-message (benchmark conf/benchmark-names)
            :languages (mapv (fn [i lang]
                               (let [hello-world (get lang (start-time-key benchmark))
                                     benchmark-time (benchmark-result (assoc app-state :lang lang))
                                     speed (/ min-time benchmark-time)]
                                 (merge lang
                                        {:speed speed
                                         :start-time-str (str (.toFixed hello-world 1) "ms")
                                         :start-time hello-world
                                         :runs 0
                                         :track-x start-line-x
                                         :start-sequence-x 0
                                         :time-to-stop-greeting (if start-times-mode?
                                                                  greeting-display-ms
                                                                  0)
                                         :greeting "Hello, World!"
                                         :benchmark-time benchmark-time
                                         :benchmark-time-str (str (-> benchmark-time
                                                                      (.toFixed 1)
                                                                      (.padStart 10))
                                                                  "ms")
                                         :x 0
                                         :y (+ 90 (* i 45))
                                         :logo-image (q/load-image (:logo lang))})))
                             (range)
                             (sorted-languages app-state))})))

(comment
  (setup :loops)
  (-> 234.0 (.toFixed 1) (.padStart 7))
  :rcf)

(defn update-draw-state [{:keys [max-start-time track-length start-times-mode?] :as draw-state}
                         {:keys [elapsed-ms min-track-time-ms snapshot-mode?] :as _app-state}]
  (let [arena (arena (q/width) (q/height))
        wait-adjusted-time (- elapsed-ms pre-startup-wait-ms)
        race-started? (if start-times-mode?
                        (> wait-adjusted-time startup-sequence-ms)
                        (> elapsed-ms pre-startup-wait-ms))
        position-time (if start-times-mode?
                        (- wait-adjusted-time startup-sequence-ms)
                        (- elapsed-ms pre-startup-wait-ms))
        first-lang (first (:languages draw-state))
        first-bounce? (and race-started?
                           (= 0 (:runs first-lang))
                           (>= (:track-x first-lang) (- (:finish-line-x arena) 5)))
        take-snapshot? (and snapshot-mode?
                            first-bounce?
                            (not (:snapshot-taken? draw-state)))]
    (merge draw-state
           arena
           {:t elapsed-ms
            :race-started? race-started?
            :snapshot-taken? (or (:snapshot-taken? draw-state) take-snapshot?)
            :take-snapshot? take-snapshot?
            :time-to-stop-greeting (if start-times-mode?
                                     (- greeting-display-ms wait-adjusted-time)
                                     0)}
           {:languages (mapv (fn [{:keys [start-time speed] :as lang}]
                               (let [startup-progress (if (pos? wait-adjusted-time)
                                                        (/ wait-adjusted-time
                                                           (* startup-sequence-ms
                                                              (/ start-time max-start-time)))
                                                        0)]
                                 (merge lang
                                        {:startup-progress startup-progress}
                                        (if-not race-started?
                                          {:start-sequence-x (min (* start-time-line-x startup-progress)
                                                                  start-time-line-x)}
                                          (let [normalized-time (/ position-time min-track-time-ms)
                                                scaled-time (* normalized-time speed)
                                                distance (* track-length scaled-time)
                                                loop-distance (mod distance (* 2 track-length))
                                                x (if (> loop-distance track-length)
                                                    (- (* 2 track-length) loop-distance)
                                                    loop-distance)]
                                            {:track-x (+ start-line-x x)
                                             :runs (quot distance (* 2 track-length))})))))
                             (:languages draw-state))})))

(comment
  (q/no-loop)
  :rcf)

(def offwhite 245)
(def darkgrey 120)
(def black 40)

(declare event-handler)

(defn draw! [{:keys [t time-to-stop-greeting race-started? start-times-mode?
                     start-message race-message middle-x take-snapshot? benchmark] :as draw-state}]
  (when take-snapshot?
    (event-handler {} [[:ax/take-snapshot benchmark]]))
  (q/background offwhite)
  (q/stroke-weight 0)
  (doseq [lang (:languages draw-state)]
    (let [{:keys [language-name logo-image y track-x runs
                  start-sequence-x benchmark-time-str
                  startup-progress start-time-str greeting]} lang]
      (q/text-style :normal)
      (q/text-align :right :center)
      (q/fill darkgrey)
      (q/rect 0 (- y 12) (+ start-time-line-x 5) 24)
      (when start-times-mode?
        (when-not race-started?
          (q/fill black)
          (q/rect start-sequence-x (- y 10) (- start-time-line-x start-sequence-x) 20))
        (when (and (> startup-progress 1)
                   (> time-to-stop-greeting 0))
          (q/text-size 12)
          (q/fill 0 0 0 time-to-stop-greeting)
          (q/text (str "(" start-time-str ") " greeting) start-time-line-x (- y 20))))
      (q/fill offwhite)
      (q/text-size 14)
      (q/text language-name start-time-line-x y)
      (q/fill darkgrey)
      (when (>= 0 time-to-stop-greeting)
        (q/text-align :left)
        (q/text benchmark-time-str 5 (- y 20))
        (q/text-align :right)
        (q/fill darkgrey)
        (q/text-num runs start-time-line-x (- y 20)))
      (q/image logo-image track-x y ball-width ball-width)
      (q/text-align :right)
      (q/text-align :center)
      (q/text-size 20)
      (q/text-style :bold)
      (q/fill black)
      (q/text race-message middle-x 20)
      (q/text-style :normal)
      (q/text-size 16)
      (q/fill black)
      (if (or (< t pre-startup-wait-ms)
              race-started?)
        (q/text "How fast is your favorite language?" middle-x 45)
        (q/text start-message middle-x 45)))))

(defn save-image [benchmark]
  (println "Saving file...")
  (q/save (str "languages-visualizations-" (name benchmark) ".png")))

(defn save-handler
  [benchmark]
  (fn [state {:keys [key _key-code]}]
    (case key
      (:s) (do
             (event-handler {} [[:ax/take-snapshot benchmark]])
             state)
      state)))

(defn run-sketch []
  ; TODO: Figure out if there's a way to set the current applet with public API
  #_{:clj-kondo/ignore [:unresolved-namespace]}
  (set! quil.sketch/*applet*
        (let [start-time (js/performance.now)]
          (q/sketch
           :host "race"
           :size (dims @!app-state)
           :renderer :p2d
           :setup (fn [] (setup @!app-state))
           :update (fn [state]
                     (let [elapsed-ms (- (js/performance.now) start-time)]
                       (update-draw-state state (assoc @!app-state :elapsed-ms elapsed-ms))))
           :draw draw!
           :key-pressed (save-handler (:benchmark @!app-state))
           :middleware [m/fun-mode]))))

(defn- enrich-action-from-replicant-data [{:replicant/keys [js-event]} actions]
  (walk/postwalk
   (fn [x]
     (if (keyword? x)
       (cond (= :event/target.value x) (some-> js-event .-target .-value)
             :else x)
       x))
   actions))

(defn- action-handler [{state :new-state :as result} replicant-data action]
  (when js/goog.DEBUG
    (js/console.debug "Triggered action" action))
  (let [[action-name & args :as enriched] (enrich-action-from-replicant-data replicant-data action)
        _ (js/console.debug "Enriched action" enriched)
        {:keys [new-state effects]} (cond
                                      (= :ax/set-hash action-name)
                                      {:effects [[:fx/set-hash (first args)]]}

                                      (= :ax/take-snapshot action-name)
                                      {:effects [[:fx/take-snapshot (first args)]]}

                                      (= :ax/set-benchmark action-name)
                                      {:new-state (assoc state :benchmark (keyword (first args)))
                                       :effects [[:fx/run-sketch]]}

                                      (= :ax/toggle-start-time-mode action-name)
                                      {:new-state (update state :start-times-mode? not)
                                       :effects [[:fx/run-sketch]]}

                                      (= :ax/set-min-track-time-ms action-name)
                                      {:new-state (assoc state :min-track-time-ms (parse-long (first args)))}

                                      (= :ax/toggle-snapshot-mode action-name)
                                      {:new-state (update state :snapshot-mode? not)})]
    (cond-> result
      new-state (assoc :new-state new-state)
      effects (update :effects into effects))))

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
            (= :console/log effect-name) (apply js/console.log args)
            (= :fx/set-hash effect-name) (set! (-> js/window .-location .-hash) (first args))
            (= :fx/run-sketch effect-name) (run-sketch)
            (= :fx/take-snapshot effect-name) (save-image (first args))))))))

(defn render-app! [el state]
  (d/render el (views/app state (active-benchmarks bd/benchmarks))))

(defn handle-hash []
  (let [hash (-> js/window .-location .-hash)
        benchmark (when (seq hash)
                    (keyword (subs hash 1)))]
    (if (contains? (set (active-benchmarks bd/benchmarks)) benchmark)
      (event-handler {} [[:ax/set-benchmark benchmark]])
      (event-handler {} [[:ax/set-benchmark :loops]]))))

(defn ^:dev/after-load start []
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
  (start)
  (handle-hash)
  (js/window.addEventListener "hashchange" handle-hash)
  (run-sketch))

(defn ^{:export true
        :dev/before-load true} stop []
  (js/console.log "stop"))
