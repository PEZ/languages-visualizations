(ns pez.race
  (:require [pez.benchmark-data :as bd]
            [quil.core :as q]
            [quil.middleware :as m]))

(def frame-rate 120)
(def start-time-line-x-% 0.2)

(def max-start-time (->> bd/benchmarks
                         :languages
                         (map :start-time)
                         (apply max)))

(defn benchmark-times [benchmark]
  (->> bd/benchmarks
       :languages
       (map (fn [lang]
              (- (benchmark lang)
                 (:start-time lang))))))

(defn languages [benchmark]
  (sort-by (fn [lang]
             (- (benchmark lang) (:start-time lang)))
           (:languages bd/benchmarks)))

(defn get-viewport
  "Returns a vector of [vw vh] for the current browser window, scaled by the scale parameter.
   If true is passed to force-square the smaller dimension will be used on both axes."
  [scale]
  [(* scale (.-innerWidth js/window)) (* scale (.-innerHeight js/window))])

(def dims [(min 800 (- (.-innerWidth js/window) 20)) (+ 80 (* 60 (count (:languages bd/benchmarks))))])

(defn setup [benchmark]
  (def benchmark benchmark)
  (q/frame-rate frame-rate)
  (q/image-mode :center)

  (let [start-time-line-x (* (q/width) start-time-line-x-%)
        total-starting-sequence-ticks (* frame-rate 2)
        total-track-ticks (/ frame-rate 1.2)
        ball-width 40
        half-ball-width (/ ball-width 2)
        start-line-x (+ start-time-line-x half-ball-width 5)
        finish-line-x (- (q/width) half-ball-width 5)
        track-length (- finish-line-x start-line-x)
        max-time (apply max (benchmark-times benchmark))
        min-time (apply min (benchmark-times benchmark))]
    {:t 0
     :benchmark benchmark
     :width (q/width)
     :start-time-line-x start-time-line-x
     :start-line-x start-line-x
     :finish-line-x finish-line-x
     :track-length track-length
     :middle-x (/ (q/width) 2)
     :middle-y (/ (q/height) 2)
     :ball-width ball-width
     :half-ball-width half-ball-width
     :race-started false
     :max-start-time max-start-time
     :total-starting-sequence-ticks total-starting-sequence-ticks
     :total-track-ticks total-track-ticks
     :max-time max-time
     :min-time min-time
     :start-message "Starting engines!"
     :race-message "github.com/bddicken/languages"
     :languages (mapv (fn [i {:keys [start-time] :as lang}]
                        (let [starting-sequence-ticks (* (/ start-time max-start-time)
                                                         total-starting-sequence-ticks)
                              benchmark-time (- (benchmark lang) start-time)
                              speed (/ min-time benchmark-time)
                              track-ticks (/ total-track-ticks speed)]
                          (merge lang
                                 {:speed speed
                                  :runs 0
                                  :direction 1
                                  :track-ticks track-ticks
                                  :track-x-per-tick (/ track-length track-ticks)
                                  :track-x start-line-x
                                  :starting-sequence-ticks starting-sequence-ticks
                                  :start-sequence-x-per-tick (/ start-time-line-x starting-sequence-ticks)
                                  :start-sequence-x 0
                                  :hello-world-shown false
                                  :greeting nil
                                  :benchmark-time (- (benchmark lang) start-time)
                                  :benchmark-time-str (str (.toFixed benchmark-time 1) " ms")
                                  :x 0
                                  :y (+ 70 (* i 60))
                                  :logo-image (q/load-image (:logo lang))})))
                      (range)
                      (languages benchmark))}))

(defn update-state [{:keys [race-started start-time-line-x total-starting-sequence-ticks start-line-x finish-line-x ] :as state}]
  (let [t (inc (:t state))]
    (merge state
           {:t t}
           (when (> t total-starting-sequence-ticks)
             {:race-started true})
           {:languages (mapv (fn [{:keys [start-sequence-x start-sequence-x-per-tick track-x track-x-per-tick direction runs] :as lang}]
                               (merge lang
                                      (when-not race-started
                                        (if (> start-time-line-x start-sequence-x)
                                          {:start-sequence-x (min start-time-line-x
                                                                  (+ start-sequence-x start-sequence-x-per-tick))}
                                          {:greeting "Hello, World!"}))
                                      (when race-started
                                        (let [new-x (+ track-x (* track-x-per-tick direction))
                                              bounce? (or (>= new-x finish-line-x)
                                                          (<= new-x start-line-x))
                                              new-direction (if bounce?
                                                              (* -1 direction)
                                                              direction)]
                                          {:track-x new-x
                                           :direction new-direction
                                           :runs (if bounce? (inc runs) runs)}))))
                             (:languages state))})))

(defn draw-state! [{:keys [t start-time-line-x width race-started middle-x half-ball-width] :as state}]
  (def state state)
  (let [t' (/ t 10)]
    ; clear screen
    ;(q/fill 225 225 225)
    (q/background 235)
    (q/stroke-weight 0)
    (doseq [lang (:languages state)]
      (let [y (:y lang)
            track-x (:track-x lang)
            runs (:runs lang)]
        (q/text-style :normal)
        (q/fill 150)
        (q/rect 0 (- y 30) width 20)
        (q/text-align :right :center)
        (q/fill "white")
        ;(q/text-style :bold)
        (q/text-size 14)
        (q/text (:language-name lang) start-time-line-x (- y 20))
        (when race-started
          (q/text (:benchmark-time-str lang) (- width 5) (- y 20)))
        (q/text-size 12)
        (when (:greeting lang)
          (q/fill "black")
          (q/text (:greeting lang) start-time-line-x y)
          (q/text (str "(" (:start-time lang) "ms) ") start-time-line-x (+ y 15)))
        (q/fill (:color lang))
        (q/rect (:start-sequence-x lang) (- y 10) (- start-time-line-x (:start-sequence-x lang)) 20)
        (q/image (:logo-image lang) track-x y 40 40)
        (q/text-align :left)
        (q/text-num runs (+ track-x half-ball-width 5) y)
        (q/text-align :right)
        (q/text-size 20)
        (q/text-style :bold)
        (q/text-align :center)
        (q/fill "#1b1b1b")
        (if-not race-started
          (q/text (:start-message state) middle-x 20)
          (q/text (:race-message state) middle-x 20))))))

; this function is called in index.html
(defn ^:export run-sketch []
  (q/sketch
    :host "race"
    :size dims
    :renderer :p2d
    :setup (fn [] (setup :levenshtein))
    :update update-state
    :draw draw-state!
    ;; :key-pressed (u/save-image "export.png")
    :middleware [m/fun-mode]))

;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (js/console.log "start"))

(defn ^:export init! []
  (js/console.log "init")
  (run-sketch)
  (start))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))
