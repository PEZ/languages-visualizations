(ns tasks
  (:require
   [babashka.fs :as fs]
   [cheshire.core :as json]
   [clojure.string :as string]))

(defn get-mean-ms [file]
  (-> (slurp file)
      (json/parse-string true)
      :results
      first
      :mean
      (* 1000)))

(defn ^:export get-benchmark-means-from-path [path]
  (->> (map str (fs/glob path "*/*.json"))
       (map (fn [file]
              (let [benchmark (-> (subs file (inc (count path)) (string/last-index-of file "/"))
                                  keyword)
                    language (subs file (inc (string/last-index-of file "/")) (string/index-of file ".json"))]
                [benchmark language (get-mean-ms file)])))
       (reduce (fn [acc [benchmark language mean]]
                 (assoc-in acc [language benchmark] mean))
               {})))

(comment
  (get-benchmark-means-from-path "/tmp/languages")
  (map str (fs/glob "/tmp/languages" "*/*.json"))
  :rcf)

