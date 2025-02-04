(ns pez.race
  (:require
   [pez.benchmark :as benchmark]
   [pez.config :as conf]
   [pez.db :as db]
   [quil.core :as q]
   [quil.middleware :as m]))

(defn t->elapsed-ms
  [{:keys [start-time]} t]
  (- t start-time))

(defn t->display-time
  [{:keys [min-track-time-ms min-time] :as app-state} t]
  (let [elapsed (t->elapsed-ms app-state t)]
    (/ elapsed
       (/ min-track-time-ms min-time))))

(defn display-time->elapsed-ms
  [{:keys [min-track-time-ms min-time]} display-time]
  (* min-track-time-ms (/ display-time min-time)))

(def drawing-width 700)
(def language-labels-x 140)
(def ball-width 44)
(def half-ball-width (/ ball-width 2))
(def start-line-x (+ language-labels-x half-ball-width 10))

(defn dims [{:keys [app-el] :as app-state}]
  [(min drawing-width (.-offsetWidth app-el)) (+ 100 (* 45 (count (benchmark/sorted-languages app-state))))])

(defn arena [width height]
  (let [finish-line-x (- width half-ball-width 5)]
    {:width width
     :finish-line-x finish-line-x
     :track-length (- finish-line-x start-line-x)
     :middle-x (/ width 2)
     :middle-y (/ height 2)}))

(defn update-draw-state [draw-state app-state now]
  (let [arena (arena (q/width) (q/height))
        paused? (:paused? app-state)
        manual-display-time (:manual-display-time app-state)
        display-time (if paused?
                       (or manual-display-time 0)
                       (t->display-time app-state now))
        elapsed-ms (display-time->elapsed-ms app-state display-time)]
    (merge draw-state
           arena
           {:t (t->elapsed-ms app-state now) ; Not used, but nice for logging
            :display-time-str (.toFixed display-time 1)
            :app-state app-state
            :languages
            (mapv (fn [{:keys [speed] :as lang}]
                    (merge lang
                           (let [normalized-time (/ elapsed-ms (:min-track-time-ms app-state))
                                 scaled-time (* normalized-time speed)
                                 distance (* (:track-length arena) scaled-time)
                                 loop-distance (mod distance (* 2 (:track-length arena)))
                                 x (if (> loop-distance (:track-length arena))
                                     (- (* 2 (:track-length arena)) loop-distance)
                                     loop-distance)]
                             {:x (+ start-line-x x)
                              :runs (quot distance (:track-length arena))})))
                  (:languages draw-state))})))

(defn setup [{:keys [benchmark add-overlaps? min-time] :as app-state}]
  (q/frame-rate 120)
  (q/image-mode :center)
  (let [arena (arena (q/width) (q/height))]
    (merge arena
           {:t 0
            :display-time-str ""
            :app-state app-state
            :benchmark benchmark
            :benchmark-title (benchmark conf/benchmark-names)
            :languages (mapv (fn [i lang]
                               (let [{:keys [mean stddev speed-mean]} (get lang benchmark)
                                     speed (/ min-time speed-mean)]
                                 (merge lang
                                        {:speed speed
                                         :runs 0
                                         :greeting "Hello, World!"
                                         :benchmark-time mean
                                         :benchmark-time-str (str (-> mean (.toFixed 1)))
                                         :std-dev-str (str (-> stddev (.toFixed 1)))
                                         :x start-line-x
                                         :y (+ 110 (* i 45))
                                         :logo-image (q/load-image (:logo lang))})))
                             (range)
                             (if add-overlaps?
                               (benchmark/add-overlaps app-state)
                               (benchmark/sorted-languages app-state)))})))

(comment
  (setup :loops)
  (-> 234.0 (.toFixed 1) (.padStart 7))
  :rcf)


(comment
  (q/no-loop)
  :rcf)

(def offwhite 245)
(def darkgrey 120)
(def black 40)

(defn draw! [{:keys [benchmark-title middle-x width display-time-str] :as draw-state}] 
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
    (let [{:keys [language-name logo-image x y runs benchmark-time-str std-dev-str]} lang]
      (q/fill darkgrey)
      (q/rect 0 (- y 12) (+ language-labels-x 5) 24)
      (q/text-num runs (- width 5) y)
      (q/fill offwhite)
      (q/text language-name language-labels-x y)
      (q/fill darkgrey)
      (q/text std-dev-str 50 (- y 20))
      (q/text benchmark-time-str language-labels-x (- y 20))
      (q/image logo-image x y ball-width ball-width))))

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