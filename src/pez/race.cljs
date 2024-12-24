(ns pez.race
  (:require [pez.benchmark-data :as bd]
            [quil.core :as q]
            [quil.middleware :as m]
            [replicant.dom :as d]))

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

(def dims [(min 800 (- (.-innerWidth js/window) 20)) (+ 80 (* 50 (count (:languages bd/benchmarks))))])

(defn setup [benchmark]
  (def benchmark benchmark)
  (q/frame-rate frame-rate)
  (q/image-mode :center)

  (let [start-time-line-x (* (q/width) start-time-line-x-%)
        total-starting-sequence-ticks (* frame-rate 2)
        total-track-ticks (/ frame-rate 1)
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
     :greeting-timeout (* frame-rate 2)
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
                                  :y (+ 70 (* i 50))
                                  :logo-image (q/load-image (:logo lang))})))
                      (range)
                      (languages benchmark))}))

(defn update-state [{:keys [race-started greeting-timeout start-time-line-x total-starting-sequence-ticks start-line-x finish-line-x ] :as state}]
  (let [t (inc (:t state))]
    (merge state
           {:t t}
           (when (> t (+ total-starting-sequence-ticks (/ frame-rate 10)))
             {:race-started true})
           (when race-started
             {:greeting-timeout (max 0 (dec greeting-timeout))})
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

(defn draw-state! [{:keys [t greeting-timeout start-time-line-x width race-started middle-x half-ball-width] :as state}]
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
        (q/fill 100)
        (q/rect 0 (- y 10) width 20)
        (q/text-align :right :center)
        (q/fill 40)
        (q/rect (:start-sequence-x lang) (- y 10) (- start-time-line-x (:start-sequence-x lang)) 20)
        (q/fill "white")
        ;(q/text-style :bold)
        (q/text-size 14)
        (q/text (:language-name lang) start-time-line-x y)
        (when race-started
          (q/text (:benchmark-time-str lang) (- width 5) y))
        (q/text-size 12)
        (when (and (> greeting-timeout 0)
                   (:greeting lang))
          (q/fill "black")
          (q/text (:greeting lang) start-time-line-x (- y 20))
          (q/text-align :left)
          (q/text (str "(" (:start-time lang) "ms) ") (+ start-time-line-x 5) (- y 20)))
        (q/image (:logo-image lang) track-x y 40 40)
        (q/text-align :left)
        (q/fill "white")
        (q/text-num runs (+ track-x half-ball-width 5) y)
        (q/text-align :right)
        (q/text-size 20)
        (q/text-style :bold)
        (q/text-align :center)
        (q/fill "black")
        (if-not race-started
          (q/text (:start-message state) middle-x 20)
          (q/text (:race-message state) middle-x 20))))))

(defn run-sketch []
  (q/sketch
    :host "race"
    :size dims
    :renderer :p2d
    :setup (fn [] (setup :levenshtein))
    :update update-state
    :draw draw-state!
    ;; :key-pressed (u/save-image "export.png")
    :middleware [m/fun-mode]))

(def !state (atom {}))

(defn app [state]
  [:div
   "bar"
   [:div#race]])

(defn render-app! [el state]
  (d/render el (app state)))

(def app-el
  (js/document.getElementById "app"))

;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (js/console.log "start")
  (render-app! app-el @!state))

(defn ^:export init! []
  (js/console.log "init")
  (start)
  (render-app! app-el @!state)
  (run-sketch))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))
