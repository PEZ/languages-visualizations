(ns pez.db
  (:require
   [pez.benchmark-data :as bd]))

(defonce !app-state (atom {;; changed keys:
                           :app/benchmark :loops
                           :app/filter-champions? false
                           :app/min-track-time-choice "600"  ;;"fastest-language"
                           :app/benchmarks bd/legacy
                           :app/default-gist "https://gist.github.com/PEZ/411e2da1af3bbe21c4ad1d626451ec1d"
                           :app/add-overlaps? true
                           :app/paused? false
                           :app/manual-display-time nil}))