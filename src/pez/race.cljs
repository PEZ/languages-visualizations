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
(def language-labels-x 200)
(def ball-width 44)
(def half-ball-width (/ ball-width 2))
(def start-line-x (+ language-labels-x 10))
(def logo-start-line-x (+ start-line-x half-ball-width))
(def projectile-lifetime 2500)

(defn dims [{:keys [app-el] :as app-state}]
  [(min drawing-width (.-offsetWidth app-el)) (+ 100 (* 45 (count (benchmark/best-languages < app-state))))])

(defn arena [width height]
  (let [logo-finish-line-x (- width half-ball-width 10)
        track-length (- logo-finish-line-x logo-start-line-x)]
    {:width width
     :logo-finish-line-x logo-finish-line-x
     :bar-length (- width start-line-x)
     :track-length track-length
     :finish-line-x (+ start-line-x track-length)
     :middle-x (/ width 2)
     :middle-y (/ height 2)}))


(defn update-draw-state [draw-state app-state now]
  (let [arena               (arena (q/width) (q/height))
        track-length        (:track-length arena)
        paused?             (:paused? app-state)
        manual-display-time (:manual-display-time app-state)
        display-time        (if paused?
                              (or manual-display-time 0)
                              (t->display-time app-state now))
        elapsed-ms          (display-time->elapsed-ms app-state display-time)

        updated-languages
        (mapv (fn [{:keys [speed] :as lang}]
                (let [normalized  (double (/ elapsed-ms (:min-track-time-ms app-state)))
                      scaled-time (* normalized speed)
                      distance    (* track-length scaled-time)]
                  (merge lang
                         (if (>= distance track-length)
                           {:x    (+ logo-start-line-x track-length)
                            :runs (long (quot distance track-length))}
                           {:x    (+ logo-start-line-x distance)
                            :runs (long (quot distance track-length))}))))
              (:languages draw-state))

        computed-projectiles
        (mapcat
         (fn [lang]
           (let [speed (:speed lang)
                 ms-per-run (double (/ (:min-track-time-ms app-state) speed))
                 completed-runs (:runs lang)
                 projectile-lifetime (/ projectile-lifetime speed)
                 i-min (long (Math/floor
                              (max 1 (/ (- elapsed-ms projectile-lifetime)
                                        ms-per-run))))
                 i-max completed-runs]
             (for [i (range i-min (inc i-max))]
               (let [run-completion-ms (* i ms-per-run)
                     dt (- elapsed-ms run-completion-ms)]
                 (when (and (>= dt 0)
                            (< dt projectile-lifetime))
                   (let [dt                  (- elapsed-ms run-completion-ms)
                         fraction           (/ dt projectile-lifetime)
                         wave-factor        (* 2 speed)
                         phase              (* i 1.2)
                         wave-amplitude     10
                         wave               (Math/sin (+ (* fraction 2 Math/PI wave-factor)
                                                         phase))
                         wave-offset        (* wave wave-amplitude)
                         x (q/lerp (:finish-line-x arena)
                                   start-line-x
                                   fraction)
                         y (+ (:y lang) wave-offset)]
                     {:x     x
                      :y     y
                      :color (:color lang)}))))))
         updated-languages)]

    (merge draw-state
           arena
           {:t                (t->elapsed-ms app-state now)
            :display-time-str (.toFixed display-time 7)
            :app-state        app-state
            :languages        updated-languages
            :projectiles      (vec (keep identity computed-projectiles))})))

(defn setup [{:keys [benchmark add-overlaps? max-time min-time] :as app-state}]
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
                                         :bar-color (str (:color lang) "33")
                                         :runs 0
                                         :speed-ratio (/ max-time min-time mean)
                                         :greeting "Hello, World!"
                                         :benchmark-time mean
                                         :benchmark-time-str (str (-> mean (.toFixed 2)))
                                         :std-dev-str (str (-> stddev (.toFixed 2)))
                                         :x logo-start-line-x
                                         :y (+ 110 (* i 45))
                                         :logo-image (q/load-image (:logo lang))})))
                             (range)
                             (if add-overlaps?
                               (benchmark/add-overlaps app-state)
                               (benchmark/best-languages < app-state)))})))

(def offwhite 245)
(def darkgrey 120)
(def lightygrey 200)
(def black 40)

(defn button-dims [y]
  (let [w 80
        h 18]
    {:button-x (- language-labels-x (- w 5))
     :button-y (- y h 12)
     :button-w w
     :button-h h}))

(defn render-languages! [{:keys [bar-length] :as draw-state}]
  (q/text-size 14)
  (let [paused? (get-in draw-state [:app-state :paused?])]
    (doseq [lang (:languages draw-state)]
      (let [{:keys [language-name bar-color logo-image x y runs benchmark-time-str std-dev-str speed]} lang]
        (q/fill bar-color)
        (q/rect (+ language-labels-x 5) (- y 12) (* speed bar-length) 24)
        (q/fill darkgrey)
        (q/rect 0 (- y 12) (+ language-labels-x 5) 24)
        (q/fill offwhite)
        (q/text language-name language-labels-x y)
        (q/text-num runs (- language-labels-x 120) y)
        (q/fill darkgrey)
        (q/text std-dev-str (- language-labels-x 80) (- y 20))
        (when paused?
          (let [{:keys [button-x button-y button-w button-h]} (button-dims y)]
            (q/fill lightygrey)
            (q/stroke-weight 1)
            (q/stroke black)
            (q/rect button-x button-y button-w button-h 2)
            (q/stroke-weight 0))
          (q/fill black))
        (q/text benchmark-time-str language-labels-x (- y 20))
        (q/image logo-image x y ball-width ball-width)))))

(defn render-projectiles! [{:keys [projectiles]}]
  (doseq [{:keys [x y color]} projectiles]
    (q/fill color)
    (q/no-stroke)
    (q/ellipse (- x 4) y 8 8)))

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
  (q/text "±" (- language-labels-x 80) 65)
  (q/text "ms" language-labels-x 65)
  (q/text display-time-str (- width 5) 65)
  (render-projectiles! draw-state)
  (render-languages! draw-state))

(defn save-image! [{:keys [benchmark filter-champions?]}]
  (let [iso-date (.substring (.toISOString (js/Date.)) 0 10)]
    (println "Saving file...")
    (q/save (str "languages-visualizations-"
                 (name benchmark) "-" iso-date
                 (when-not filter-champions? "-all")
                 ".png"))))

(defn run-sketch! [event-handler]
  (set! quil.sketch/*applet*
        (q/sketch
         :host "race"
         :size (dims @db/!app-state)
         :renderer :p2d
         :setup (fn [] (setup @db/!app-state))
         :update (fn [draw-state]
                   (update-draw-state draw-state @db/!app-state (js/performance.now)))
         :draw draw!
         :mouse-clicked (fn [draw-state]
                          (when (get-in draw-state [:app-state :paused?])
                            (let [mx (q/mouse-x)
                                  my (q/mouse-y)]
                              (doseq [lang (:languages draw-state)]
                                (let [{:keys [button-x button-y button-w button-h]}
                                      (button-dims (:y lang))]
                                  (when (and (>= mx button-x)
                                             (<= mx (+ button-x button-w))
                                             (>= my button-y)
                                             (<= my (+ button-y button-h)))
                                    (event-handler {} [[:ax/set-display-time (:benchmark-time lang)]]))))))
                          draw-state)
         :middleware [m/fun-mode])))

(defn resize-sketch! [w h]
  (q/resize-sketch w h))