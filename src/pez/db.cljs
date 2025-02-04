(ns pez.db 
  (:require
   [pez.benchmark-data :as bd]))

(defonce !app-state (atom {:benchmark :loops
                           :snapshot-mode? false
                           :filter-champions? false
                           :min-track-time-choice "600" #_"fastest-language"
                           :benchmarks bd/benchmarks
                           :add-overlaps? true
                           :paused? false
                           :manual-display-time nil}))