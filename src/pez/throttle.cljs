(ns pez.throttle)

(def !throttled-events (atom {}))

(defn dispatch! [{:keys [id timeout thunk]}]
  (let [f (fn [events]
            (if (contains? events id)
              events
              (assoc events id
                     {:timeout (js/setTimeout
                                (fn []
                                  (swap! !throttled-events dissoc id))
                                timeout)})))
        [previous _] (swap-vals! !throttled-events f)]
    (when-not (contains? previous id)
      (thunk))))
