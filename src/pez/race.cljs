(ns pez.race
  (:require [pez.benchmark-data :as bd]
            [quil.core :as q]
            [quil.middleware :as m]))

(def frame-rate 50)
(def start-line-x-% 0.2)

(def max-start-time (->> bd/benchmarks
                         :languages
                         (map :start-time)
                         (apply max)))

(defn max-time [benchmark]
  (->> bd/benchmarks
       :languages
       (map benchmark)
       (apply max)))

(defn languages [benchmark]
  (sort-by benchmark (:languages bd/benchmarks)))

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

  (let [start-line-x (* (q/width) start-line-x-%)
        total-starting-sequence-ticks (* frame-rate 3)]
    {:t 0
     :width (q/width)
     :benchmark benchmark
     :start-line-x start-line-x
     :race-started false
     :max-start-time max-start-time
     :total-starting-sequence-ticks total-starting-sequence-ticks
     :max-time (max-time benchmark)
     :languages (mapv (fn [i {:keys [start-time] :as lang}]
                        (let [starting-sequence-ticks (* (/ start-time max-start-time)
                                                         total-starting-sequence-ticks)
                              benchmark-time (- (benchmark lang) start-time)]
                          (merge lang
                                 {:speed (/ (max-time benchmark) (benchmark lang))
                                  :starting-sequence-ticks starting-sequence-ticks
                                  :start-time-x-per-tick (/ start-line-x starting-sequence-ticks)
                                  :start-time-x 0
                                  :hello-world-shown false
                                  :greeting nil
                                  :benchmark-time (- (benchmark lang) start-time)
                                  :benchmark-time-str (str (.toFixed benchmark-time 1) " ms")
                                  :x 0
                                  :y (+ 50 (* i 60))
                                  :logo-image (q/load-image (:logo lang))})))
                      (range)
                      (languages benchmark))}))

(defn update-state [{:keys [race-started start-line-x] :as state}]
  (merge state
         {:t (inc (:t state))}
         (when-not race-started
           {:languages (mapv (fn [{:keys [start-time-x start-time-x-per-tick] :as lang}]
                               (merge lang
                                      (if (> start-line-x start-time-x)
                                        {:start-time-x (min start-line-x
                                                            (+ start-time-x start-time-x-per-tick))}
                                        {:greeting "Hello, World!"})))
                             (:languages state))})))

(defn draw-state! [{:keys [t start-line-x width] :as state}]
  (def state state)
  (let [t' (/ t 10)]
    ; clear screen
    ;(q/fill 225 225 225)
    (q/background 235)
    (q/stroke-weight 0)
    (doseq [lang (:languages state)]
      (let [y (:y lang)]
        (q/fill 150)
        (q/rect 0 (- y 30) width 20)
        (q/text-align :right :center)
        (q/fill "white")
        ;(q/text-style :bold)
        (q/text-size 14)
        (q/text (:language-name lang) start-line-x (- y 20))
        (q/text (:benchmark-time-str lang) (- width 5) (- y 20))
        (q/text-style :normal)
        (q/text-size 12)
        (when (:greeting lang)
          (q/fill "black")
          (q/text (:greeting lang) start-line-x y)
          (q/text (str "(" (:start-time lang) "ms) ") start-line-x (+ y 15)))
        (q/fill (:color lang))
        (q/rect (:start-time-x lang) (- y 10) (- start-line-x (:start-time-x lang)) 20)
        (q/text-align :right)
        (q/image (:logo-image lang) (+ 25 start-line-x) y 40 40)))))

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
