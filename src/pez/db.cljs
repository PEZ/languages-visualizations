(ns pez.db 
  (:require
   [pez.benchmark-data :as bd]))

(defonce !app-state (atom {:benchmark :loops
                           :snapshot-mode? false
                           :filter-champions? false
                           :min-track-time-choice "600" #_"fastest-language"
                           :benchmarks bd/legacy
                           :default-gist "https://gist.github.com/PEZ/411e2da1af3bbe21c4ad1d626451ec1d"
                           :add-overlaps? true
                           :paused? false
                           :manual-display-time nil}))