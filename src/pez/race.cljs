(ns pez.race
  (:require
   [clojure.set :as set]
   [pez.config :as conf]
   [pez.db :as db]
   [quil.core :as q]
   [quil.middleware :as m]))

(defn t->elapsed-ms
  [{:keys [start-time]} t]
  (- t start-time))

(defn t->display-time
  [{:keys [min-track-time-ms min-time pre-startup-wait-ms] :as app-state} t]
  (let [elapsed       (t->elapsed-ms app-state t)
        position-time (- elapsed pre-startup-wait-ms)]
    (/ position-time
       (/ min-track-time-ms min-time))))

(defn display-time->elapsed-ms
  [{:keys [min-track-time-ms min-time pre-startup-wait-ms]} display-time]
  (let [position-time (* min-track-time-ms (/ display-time min-time))
        elapsed       (+ pre-startup-wait-ms position-time)]
    elapsed))

(def drawing-width 700)
(def language-labels-x 140)
(def ball-width 44)
(def half-ball-width (/ ball-width 2))
(def start-line-x (+ language-labels-x half-ball-width 10))

(def pre-startup-wait-ms 1000)

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
  (languages (:benchmarks @db/!app-state))
  (sorted-languages {:benchmark :loops
                     :benchmarks @db/!app-state})
  (find-missing-languages (:benchmarks @db/!app-state))
  :rcf)

(defn dims [{:keys [app-el] :as app-state}]
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
                       (or manual-display-time 0)
                       (t->display-time app-state now))
        elapsed-ms (display-time->elapsed-ms app-state display-time)
        race-started? (>= elapsed-ms pre-startup-wait-ms)
        position-time (max 0 (- elapsed-ms pre-startup-wait-ms))
        take-snapshot? (and (:snapshot-mode? app-state)
                            (= 1 (:runs (first (:languages draw-state))))
                            (not (:snapshot-taken? draw-state)))]
    (merge draw-state
           arena
           {:t (t->elapsed-ms app-state now) ; Not used, but nice for logging
            :position-time position-time
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

(defn save-image! [{:keys [benchmark filter-champions?]}]
  (let [iso-date (.substring (.toISOString (js/Date.)) 0 10)]
    (println "Saving file...")
    (q/save (str "languages-visualizations-"
                 (name benchmark) "-" iso-date
                 (when-not filter-champions? "-all")
                 ".png"))))

(defn run-sketch! []
  ; TODO: Figure out if there's a way to set the current applet with public API
  #_{:clj-kondo/ignore [:unresolved-namespace]}
  (set! quil.sketch/*applet*
        (q/sketch
         :host "race"
         :size (dims @db/!app-state)
         :renderer :p2d
         :setup (fn [] (setup @db/!app-state))
         :update (fn [state]
                   (update-draw-state state @db/!app-state (js/performance.now)))
         :draw draw!
         :middleware [m/fun-mode])))

(defn resize-sketch! [w h]
  (q/resize-sketch w h))