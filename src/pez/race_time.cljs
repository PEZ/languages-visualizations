(ns pez.race-time)

(defn t->elapsed-ms
  [{:keys [start-time]} t]
  (- t start-time))

(defn t->display-time
  [{:keys [min-track-time-ms min-time pre-startup-wait-ms] :as app-state} t]
  (let [elapsed       (t->elapsed-ms app-state t)
        position-time (- elapsed pre-startup-wait-ms)]
    (/ position-time
       (/ min-track-time-ms min-time))))

(defn display-time->elapsed-ms
  [{:keys [min-track-time-ms min-time pre-startup-wait-ms]} display-time]
  (let [position-time (* min-track-time-ms (/ display-time min-time))
        elapsed       (+ pre-startup-wait-ms position-time)]
    elapsed))
