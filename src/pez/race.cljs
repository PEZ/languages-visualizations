(ns pez.race
  (:require
   [clojure.walk :as walk]
   [gadget.inspector :as inspector]
   [pez.benchmark-data :as bd]
   [pez.config :as conf]
   [quil.core :as q]
   [quil.middleware :as m]
   [replicant.dom :as d]))

(defonce !app-state (atom {:benchmark :loops}))

(def frame-rate 120)
(def animation-speed 1.5)
(def drawing-width 700)

;(def start-time-line-x-% 0.30)

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

(defn benchmark-times [benchmark]
  (mapv -
        (->> bd/benchmarks
             vals
             (map benchmark))
        (->> bd/benchmarks
             vals
             (map (start-time-key benchmark)))))

(comment
  (benchmark-times :loops)
  (benchmark-times :levenshtein)
  :rcf)

(defn languages []
  (mapv (fn [{:keys [language-file-name] :as lang}]
          (merge lang
                 (bd/benchmarks language-file-name)))
        conf/languages))

(defn sorted-languages [benchmark]
  (sort-by (fn [lang]
             (- (benchmark lang)
                (get lang (start-time-key benchmark))))
           (filter benchmark (languages))))

(comment
  (languages)
  (sorted-languages :levenshtein)
  :rcf)

(defn dims [benchmark]
  [(min drawing-width (- (.-innerWidth js/window) 20)) (+ 80 (* 45 (count (sorted-languages benchmark))))])

(defn arena [width height]
  (let [ball-width 40
        half-ball-width (/ ball-width 2)
        start-time-line-x 140
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
        total-track-ticks (/ frame-rate animation-speed)
        arena (arena (q/width) (q/height))
        {:keys [start-time-line-x start-line-x track-length]} arena
        max-time (apply max (benchmark-times benchmark))
        min-time (apply min (benchmark-times benchmark))]
    (merge arena
           {:t 0
            :benchmark benchmark
            :race-started false
            :max-start-time (max-start-time benchmark)
            :total-starting-sequence-ticks total-starting-sequence-ticks
            :total-track-ticks total-track-ticks
            :max-time max-time
            :min-time min-time
            :start-message "Starting engines!"
            :race-message (benchmark conf/benchmark-names)
            :greeting-timeout (* frame-rate 2.5)
            :languages (mapv (fn [i lang]
                               (let [hello-world (get lang (start-time-key benchmark))
                                     starting-sequence-ticks (* (/ hello-world (max-start-time benchmark))
                                                                total-starting-sequence-ticks)
                                     benchmark-time (- (benchmark lang) hello-world)
                                     speed (/ min-time benchmark-time)
                                     track-ticks (/ total-track-ticks speed)]
                                 (merge lang
                                        {:speed speed
                                         :hello-world-str (str (.toFixed hello-world 1) " ms")
                                         :runs 0
                                         :track-ticks track-ticks
                                         :track-x start-line-x
                                         :starting-sequence-ticks starting-sequence-ticks
                                         :start-sequence-x-per-tick (/ start-time-line-x starting-sequence-ticks)
                                         :start-sequence-x 0
                                         :hello-world-shown false
                                         :greeting nil
                                         :benchmark-time (- (benchmark lang) hello-world)
                                         :benchmark-time-str (str (.toFixed benchmark-time 1) " ms")
                                         :x 0
                                         :y (+ 70 (* i 45))
                                         :logo-image (q/load-image (:logo lang))})))
                             (range)
                             (sorted-languages benchmark))})))

(comment
  (setup :loops)
  :rcf)

(defn update-state [{:keys [race-started greeting-timeout total-starting-sequence-ticks track-length] :as draw-state}]
  (let [arena (arena (q/width) (q/height))
        {:keys [start-time-line-x start-line-x]} arena
        t (inc (:t draw-state))
        elapsed-t (- t total-starting-sequence-ticks)]
    (merge draw-state
           arena
           {:t t}
           (when (> t (+ total-starting-sequence-ticks (/ frame-rate 10)))
             {:race-started true})
           (when race-started
             {:greeting-timeout (max 0 (dec greeting-timeout))})
           {:languages (mapv (fn [{:keys [start-sequence-x start-sequence-x-per-tick track-ticks] :as lang}]
                               (merge lang
                                      (if-not race-started
                                        (if (> start-time-line-x start-sequence-x)
                                          {:start-sequence-x (min start-time-line-x
                                                                  (+ start-sequence-x start-sequence-x-per-tick))}
                                          {:greeting "Hello, World!"})
                                        (let [track-x-per-tick (/ track-length track-ticks)
                                              distance (* track-x-per-tick elapsed-t)
                                              loop-distance (mod distance (* 2 track-length))
                                              x (if (> loop-distance track-length)
                                                  (- (* 2 track-length) loop-distance)
                                                  loop-distance)]
                                          {:track-x (+ start-line-x x)
                                           :runs (quot distance (* 2 track-length))}))))
                             (:languages draw-state))})))

(comment
  (q/no-loop)
  :rcf)

(defn draw-state! [{:keys [t greeting-timeout start-time-line-x race-started middle-x half-ball-width] :as draw-state}]
  (def draw-state draw-state)
  (q/background 245)
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
      (when (and (:greeting lang)
                 (> greeting-timeout 0))
        (q/fill 0 0 0 (* greeting-timeout greeting-timeout))
        (q/text-style :bold)
        (q/text (:greeting lang) start-time-line-x (- y 20))
        (q/text-align :left)
        (q/text-style :normal)
        (q/text (str "(" (:hello-world-str lang) ") ") (+ start-time-line-x 5) (- y 20)))
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
        (q/text (:race-message draw-state) middle-x 20)))))

(defn run-sketch [benchmark]
  (def benchmark benchmark)
  ; TODO: Figure out if there's a way to set the current applet with public API
  (set! quil.sketch/*applet*
        (q/sketch
         :host "race"
         :size (dims benchmark)
         :renderer :p2d
         :setup (fn [] (setup benchmark))
         :update update-state
         :draw draw-state!
    ;; :key-pressed (u/save-image "export.png")
         :middleware [m/fun-mode])))

(defn app [state]
  (def state state)
  [:article
   [:h1 "Languages"]
   (into [:section.benchmark-options]
         (for [benchmark (active-benchmarks bd/benchmarks)]
           [:label.benchmark-label
            [:input {:type :radio
                     :name :benchmark
                     :value benchmark
                     :checked (= benchmark (:benchmark state))
                     :on {:change [[:app/set-benchmark :event/target.value]]}}]
            (benchmark conf/benchmark-names)]))
   [:section#race]
   [:a {:href "https://github.com/bddicken/languages"} "github.com/bddicken/languages"]])

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
                                      (= :app/set-benchmark action-name)
                                      (let [benchmark (keyword (first args))]
                                        {:new-state (assoc state :benchmark benchmark)
                                         :effects [[:draw/run-sketch benchmark]]}))]
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
            (= :draw/run-sketch effect-name) (run-sketch (first args))))))))

(defn render-app! [el state]
  (d/render el (app state)))

(def app-el
  (js/document.getElementById "app"))

;; start is called by init and after code reloading finishes
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
                                (let [[w h] (dims (:benchmark @!app-state))]
                                  (q/resize-sketch w h))))
  (d/set-dispatch! event-handler)
  (start)
  (run-sketch (:benchmark @!app-state)))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))
