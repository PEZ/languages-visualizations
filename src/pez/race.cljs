(ns pez.race
  (:require
   [clojure.walk :as walk]
   [gadget.inspector :as inspector]
   [pez.benchmark-data :as bd]
   [quil.core :as q]
   [quil.middleware :as m]
   [replicant.dom :as d]))

(def frame-rate 180)
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

(defn dims []
  [(min 800 (- (.-innerWidth js/window) 20)) (+ 80 (* 50 (count (:languages bd/benchmarks))))])

(defn arena [width height]
  (let [ball-width 40
        half-ball-width (/ ball-width 2)
        start-time-line-x (* width start-time-line-x-%)
        start-line-x (+ start-time-line-x half-ball-width 5)
        finish-line-x (- width half-ball-width 5)]
    {:width width
     :ball-width ball-width
     :half-ball-width half-ball-width
     :start-time-line-x start-time-line-x
     :start-line-x start-line-x
     :finish-line-x finish-line-x
     :track-length (- finish-line-x start-line-x)
     :middle-x (/ width 2)
     :middle-y (/ height 2)}))

(defn setup [benchmark]
  (q/frame-rate frame-rate)
  (q/image-mode :center)

  (let [total-starting-sequence-ticks (* frame-rate 2)
        total-track-ticks (/ frame-rate 1)
        arena (arena (q/width) (q/height))
        {:keys [start-time-line-x start-line-x track-length]} arena
        max-time (apply max (benchmark-times benchmark))
        min-time (apply min (benchmark-times benchmark))]
    (merge arena
           {:t 0
            :benchmark benchmark
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
                             (languages benchmark))})))

(defn update-state [{:keys [race-started greeting-timeout total-starting-sequence-ticks] :as draw-state}]
  (let [arena (arena (q/width) (q/height))
        {:keys [start-time-line-x start-line-x finish-line-x]} arena
        t (inc (:t draw-state))]
    (merge draw-state
           arena
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
                                          {:track-x (min (max new-x start-line-x) finish-line-x)
                                           :direction new-direction
                                           :runs (if bounce? (inc runs) runs)}))))
                             (:languages draw-state))})))

(defn draw-state! [{:keys [t greeting-timeout start-time-line-x race-started middle-x half-ball-width] :as draw-state}]
  (def draw-state draw-state)
  (let [t' (/ t 10)]
    ; clear screen
    ;(q/fill 225 225 225)
    (q/background 235)
    (q/stroke-weight 0)
    (doseq [lang (:languages draw-state)]
      (let [y (:y lang)
            track-x (:track-x lang)
            runs (:runs lang)]
        (q/text-style :normal)
        (q/fill 120)
        (q/rect 0 (- y 10) (q/width) 20)
        (q/text-align :right :center)
        (when-not race-started
          (q/fill 60)
          (q/rect (:start-sequence-x lang) (- y 10) (- start-time-line-x (:start-sequence-x lang)) 20))
        (q/fill "white")
        ;(q/text-style :bold)
        (q/text-size 14)
        (q/text (:language-name lang) start-time-line-x y)
        (when race-started
          (q/text (:benchmark-time-str lang) (- (q/width) 5) y))
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
          (q/text (:start-message draw-state) middle-x 20)
          (q/text (:race-message draw-state) middle-x 20))))))

(defn run-sketch [benchmark]
  (def benchmark benchmark)
  ; TODO: Figure out if there's a way to set the current applet with public API
  (set! quil.sketch/*applet*
        (q/sketch
         :host "race"
         :size (dims)
         :renderer :p2d
         :setup (fn [] (setup benchmark))
         :update update-state
         :draw draw-state!
    ;; :key-pressed (u/save-image "export.png")
         :middleware [m/fun-mode])))

(defn app [state]
  (def state state)
  [:div
   (into [:div]
         (for [benchmark (:benchmarks bd/benchmarks)]
           [:label
            [:input {:type "radio"
                     :name "benchmark"
                     :value benchmark
                     :checked (= benchmark (:benchmark state))
                     :on {:change [[:app/set-benchmark :event/target.value]]}}]
            (get-in bd/benchmarks [:benchmark-info benchmark :title])]))
   [:div#race]])

(defonce !state (atom {:benchmark :levenshtein}))

(defn- enrich-action-from-replicant-data [{:replicant/keys [js-event]} actions]
  (walk/postwalk
   (fn [x]
     (if (keyword? x)
       (cond (= :event/target.value x) (some-> js-event .-target .-value)
             :else x)
       x))
   actions))

(defn- action-handler [{state :new-state :as result} replicant-data action]
  (js/console.debug "Triggered action" action)
  (let [[action-name & args :as enriched]
        (enrich-action-from-replicant-data replicant-data action)
        _ (js/console.debug "Enriched action" enriched)
        {:keys [new-state effects]}
        (cond
          (= :app/set-benchmark action-name) (let [benchmark (keyword (first args))]
                                               {:new-state (assoc state :benchmark benchmark)
                                                :effects [[:draw/run-sketch benchmark]]}))]
    (cond-> result
      new-state (assoc :new-state new-state)
      effects (update :effects into effects))))

(defn- event-handler [replicant-data actions]
  (let [{:keys [new-state effects]} (reduce (fn [result action]
                                              (action-handler result replicant-data action))
                                            {:new-state @!state
                                             :effects []}
                                            actions)]
    (when new-state
      (reset! !state new-state))
    (when effects
      (doseq [effect effects]
        (js/console.debug "Triggered effect" effect)
        (let [[effect-name & args] effect]
          (cond
            (= :console/log effect-name) (apply js/console.log args)
            (= :draw/run-sketch effect-name) (run-sketch (first args))))))))

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
  (inspector/inspect "App state" !state)
  (add-watch !state :update (fn [_k _r _o n]
                              (render-app! app-el n)))
  (js/window.addEventListener "resize" (fn [_e]
                                         (let [[w h] (dims)]
                                           (q/resize-sketch w h))))
  (d/set-dispatch! event-handler)
  (start)
  (run-sketch (:benchmark @!state)))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))
