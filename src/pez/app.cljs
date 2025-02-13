(ns pez.app
  (:require
   [gadget.inspector :as inspector]
   [pez.ax-fx :as ax-fx]
   [pez.benchmark :as benchmark]
   [pez.db :as db]
   [pez.race :as race]
   [pez.views :as views]
   [replicant.dom :as d]))

(def app-el (js/document.getElementById "app"))

(defn render-app! [el {:keys [app/benchmarks] :as state}]
  (d/render el (views/app state (benchmark/ordered-active-benchmarks benchmarks))))

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
  (ax-fx/event-handler {} [[:ax/init]])
  (js/window.addEventListener "hashchange" #(ax-fx/event-handler {} [[:ax/handle-hash]]))
  (start-app!))

(defn ^{:export true
        :dev/before-load true} stop! []
  (js/console.log "stop"))
