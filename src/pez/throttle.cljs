(ns pez.throttle)

(defonce !throttles (atom {}))

(defn dispatch! [{:keys [id timeout thunk leading?]}]
  (let [maybe-schedule (fn [current-throttles]
                         (if (contains? current-throttles id)
                           current-throttles
                           (assoc current-throttles id
                                  {:timeout (js/setTimeout
                                             (fn []
                                               (swap! !throttles dissoc id))
                                             timeout)})))
        [previous-throttles _] (swap-vals! !throttles maybe-schedule)]
    (when-not (contains? previous-throttles id)
      (thunk))))
