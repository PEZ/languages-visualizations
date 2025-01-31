(ns pez.race-time)

;; "elapsed-ms" is now just "wall-clock time" minus :start-time.
;; We do NOT subtract paused durations in this approach.
(defn now->elapsed-ms
  [{:keys [start-time]} now]
  (- now start-time))

(defn now->display-time
  [{:keys [min-track-time-ms min-time pre-startup-wait-ms] :as app-state} now]
  (let [elapsed       (now->elapsed-ms app-state now)
        position-time (- elapsed pre-startup-wait-ms)]
    (/ position-time
       (/ min-track-time-ms min-time))))

(defn display-time->elapsed-ms
  [{:keys [min-track-time-ms min-time pre-startup-wait-ms]} display-time]
  ;; Invert the above calculation:
  (let [position-time (* min-track-time-ms (/ display-time min-time))
        elapsed       (+ pre-startup-wait-ms position-time)]
    elapsed))
