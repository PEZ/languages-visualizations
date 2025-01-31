;; Adapted from: https://github.com/day8/re-frame/pull/249

(ns pez.debounce)

(def !debounced-events (atom {}))

(defn cancel-timeout! [id]
  (let [[previous _] (swap-vals! !debounced-events dissoc id)]
    (js/clearTimeout (:timeout previous))))

(defn dispatch-debounce! [{:keys [id type actions timeout event-handler]
                           :or   {type :dispatch}}]
  (case type
    :dispatch (let [timeout-id (js/setTimeout (fn []
                                                (swap! !debounced-events dissoc id)
                                                (event-handler nil actions))
                                              timeout)
                    [previous _] (swap-vals! !debounced-events assoc id
                                             {:timeout timeout-id
                                              :dispatch actions})]
                (js/clearTimeout (:timeout previous)))
    :cancel (cancel-timeout! id)
    :flush (let [flush-actions (get-in @!debounced-events [id :dispatch])]
             (cancel-timeout! id)
             (event-handler nil flush-actions))
    (js/console.warn "dispatch-debounce!: ignoring bad :dispatch-debounce action:" type "id:" id)))
