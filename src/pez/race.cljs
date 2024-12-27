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
(def app-el (js/document.getElementById "app"))

(def drawing-width 700)
(def start-time-line-x 140)
(def ball-width 40)
(def half-ball-width (/ ball-width 2))
(def start-line-x (+ start-time-line-x half-ball-width 5))

(def min-track-time-ms 600)

(def startup-sequence-ms 2000)
(def greeting-display-ms 4500)

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
  [(min drawing-width (.-offsetWidth app-el)) (+ 80 (* 45 (count (sorted-languages benchmark))))])

(defn arena [width height]
  (let [finish-line-x (- width half-ball-width 5)]
    {:width width
     :finish-line-x finish-line-x
     :track-length (- finish-line-x start-line-x)
     :middle-x (/ width 2)
     :middle-y (/ height 2)}))

(defn setup [benchmark]
  (q/frame-rate 120)
  (q/image-mode :center)

  (let [arena (arena (q/width) (q/height))
        min-time (apply min (benchmark-times benchmark))]
    (merge arena
           {:t 0
            :benchmark benchmark
            :race-started? false
            :max-start-time (max-start-time benchmark)
            :start-message "Starting engines!"
            :race-message (benchmark conf/benchmark-names)
            :languages (mapv (fn [i lang]
                               (let [hello-world (get lang (start-time-key benchmark))
                                     benchmark-time (- (benchmark lang) hello-world)
                                     speed (/ min-time benchmark-time)]
                                 (merge lang
                                        {:speed speed
                                         :start-time-str (str (.toFixed hello-world 1) "ms")
                                         :start-time hello-world
                                         :runs 0
                                         :track-x start-line-x
                                         :start-sequence-x 0
                                         :time-to-stop-greeting greeting-display-ms
                                         :greeting "Hello, World!"
                                         :benchmark-time (- (benchmark lang) hello-world)
                                         :benchmark-time-str (str (-> benchmark-time
                                                                      (.toFixed 1)
                                                                      (.padStart 5))
                                                                  "ms")
                                         :x 0
                                         :y (+ 90 (* i 45))
                                         :logo-image (q/load-image (:logo lang))})))
                             (range)
                             (sorted-languages benchmark))})))

(comment
  (setup :loops)
  :rcf)

(defn update-state [{:keys [max-start-time track-length] :as draw-state} elapsed-ms]
  (let [arena (arena (q/width) (q/height))
        race-started? (> elapsed-ms startup-sequence-ms)
        position-time (- elapsed-ms startup-sequence-ms)]
    (merge draw-state
           arena
           {:t elapsed-ms
            :race-started? race-started?
            :time-to-stop-greeting (- greeting-display-ms elapsed-ms)}
           {:languages (mapv (fn [{:keys [start-time speed] :as lang}]
                               (let [startup-progress (/ elapsed-ms (* startup-sequence-ms (/ start-time max-start-time)))]
                                 (merge lang
                                        {:startup-progress startup-progress}
                                        (if-not race-started?
                                          {:start-sequence-x (min (* start-time-line-x startup-progress)
                                                                  start-time-line-x)}
                                          (let [normalized-time (/ position-time min-track-time-ms)
                                                scaled-time (* normalized-time speed)  ; Apply the speed ratio
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

(defn draw-state! [{:keys [t width time-to-stop-greeting race-started?
                           start-message race-message middle-x] :as draw-state}]
  (q/background offwhite)
  (q/stroke-weight 0)
  (doseq [lang (:languages draw-state)]
    (let [{:keys [language-name logo-image y track-x runs
                  start-sequence-x benchmark-time-str
                  startup-progress start-time-str greeting]} lang]
      (q/text-style :normal)
      (q/fill darkgrey)
      (q/rect 0 (- y 12) (+ start-time-line-x 5) 24)
      (q/text-align :right :center)
      (when-not race-started?
        (q/fill black)
        (q/rect start-sequence-x (- y 10) (- start-time-line-x start-sequence-x) 20))
      (q/fill offwhite)
      (q/text-size 14)
      (q/text language-name start-time-line-x y)
      (q/text-size 12)
      (q/fill darkgrey)
      (q/text-align :right)
      (when (and (> startup-progress 1)
                 (> time-to-stop-greeting 0))
        (q/fill 0 0 0 time-to-stop-greeting)
        (q/text (str "(" start-time-str ") " greeting) start-time-line-x (- y 20)))
      (when (> 0 time-to-stop-greeting)
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
      (if-not race-started?
        (q/text start-message middle-x 45)
        (q/text "How fast is your favorite language?" middle-x 45)))))

(defn run-sketch [benchmark]
  ; TODO: Figure out if there's a way to set the current applet with public API
  #_{:clj-kondo/ignore [:unresolved-namespace]}
  (set! quil.sketch/*applet*
        (let [start-time (js/performance.now)]
          (q/sketch
           :host "race"
           :size (dims benchmark)
           :renderer :p2d
           :setup (fn [] (setup benchmark))
           :update (fn [state]
                     (let [elapsed-ms (- (js/performance.now) start-time)]
                       (update-state state elapsed-ms)))
           :draw draw-state!
    ;; :key-pressed (u/save-image "export.png")
           :middleware [m/fun-mode]))))

(defn app [state]
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

(defn ^{:export true
        :dev/before-load true} stop []
  (js/console.log "stop"))
