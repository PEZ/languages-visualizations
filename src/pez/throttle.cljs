(ns pez.throttle)

(defonce !throttled-events (atom {}))

(defn dispatch! [{:keys [id timeout event-handler actions]}]
  (let [[previous _] (swap-vals! !throttled-events
                                 (fn [events]
                                   (if (contains? events id)
                                     events
                                     (assoc events id {:timeout (js/setTimeout
                                                                 (fn []
                                                                   (swap! !throttled-events dissoc id))
                                                                 timeout)}))))]
    (when-not (contains? previous id)
      (event-handler nil actions))))
