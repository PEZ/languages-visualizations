(ns pez.app
  (:require
   [clojure.string :as string]
   [gadget.inspector :as inspector]
   [pez.ax-fx :as ax-fx]
   [pez.benchmark :as benchmark]
   [pez.db :as db]
   [pez.race :as race]
   [pez.views :as views]
   [replicant.dom :as d]))

(def app-el (js/document.getElementById "app"))

(defn render-app! [el {:keys [benchmarks] :as state}]
  (d/render el (views/app state (benchmark/active-benchmarks benchmarks))))

(defn handle-hash [{:keys [benchmarks]}]
  (let [location-hash (-> js/window .-location .-hash)
        benchmark (when (seq location-hash)
                    (keyword (subs location-hash 1)))]
    (cond
      (contains? (set (benchmark/active-benchmarks benchmarks)) benchmark)
      (ax-fx/event-handler {} [[:ax/set-benchmark benchmark]])

      (string/starts-with? location-hash "#https://gist.github.com")
      (ax-fx/event-handler {} [[:ax/fetch-gist (str "https://api.allorigins.win/raw?url="
                                              (js/encodeURIComponent (str (subs location-hash 1) "/raw")))]])

      :else
      (ax-fx/event-handler {} [[:ax/set-benchmark :loops]]))))

(defn ^:dev/after-load start-app! []
  (js/console.log "start")
  (render-app! app-el @db/!app-state))

(defn ^:export init! []
  (js/console.log "init")
  (inspector/inspect "App state" db/!app-state)
  (swap! db/!app-state assoc :app-el app-el)
  (add-watch db/!app-state :update (fn [_k _r _o n]
                                  (render-app! app-el n)))
  (js/window.addEventListener "resize"
                              (fn [_e]
                                (let [[w h] (race/dims @db/!app-state)]
                                  (race/resize-sketch! w h))))
  (d/set-dispatch! ax-fx/event-handler)
  (handle-hash @db/!app-state)
  (js/window.addEventListener "hashchange" #(handle-hash @db/!app-state))
  (start-app!))

(defn ^{:export true
        :dev/before-load true} stop! []
  (js/console.log "stop"))
