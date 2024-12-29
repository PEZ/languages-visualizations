(ns tasks
  (:require
   [babashka.fs :as fs]
   [babashka.process :as p]
   [cheshire.core :as json]
   [clojure.pprint :as pprint]
   [clojure.string :as string]))

(defn get-mean-ms [file]
  (-> (slurp file)
      (json/parse-string true)
      :results
      first
      :mean
      (* 1000)))

(defn  get-benchmark-means-from-path! [path]
  (->> (map str (fs/glob path "*/*.json"))
       (map (fn [file]
              (let [benchmark (-> (subs file (inc (count path)) (string/last-index-of file "/"))
                                  keyword)
                    language (subs file (inc (string/last-index-of file "/")) (string/index-of file ".json"))]
                [benchmark language (get-mean-ms file)])))
       (reduce (fn [acc [benchmark language mean]]
                 (assoc-in acc [language benchmark] mean))
               {})))

(defn compile! [languages-dir]
  (doseq [benchmark ["hello-world" "levenshtein" "loops" "fibonacci"]]
    (println "COMPILE:" benchmark)
    (p/shell {:dir (fs/path languages-dir benchmark)
              :continue true}
             "../compile.sh")))

(defn bench! [languages-dir]
  (let [scripts-dir(-> (System/getProperty "babashka.config")
                       fs/parent
                       (fs/path "scripts"))
        bench-script (str (fs/path scripts-dir "bench.sh"))]
    (println scripts-dir bench-script)
    (doseq [benchmark ["levenshtein" "loops" "fibonacci"]]
      (println "BENCH:" benchmark)
      (println bench-script)
      (p/shell {:dir (fs/path languages-dir benchmark)
                :continue true}
               bench-script))))

(defn ^:export collect-benchmark-data! [& args]
  (pprint/pprint
   (get-benchmark-means-from-path! (or (first args) "/tmp/languages"))))

(defn ^:export compile-benchmarks! [& args]
  (compile! (or (first args) "../languages")))

(defn ^:export bench-benchmarks! [& args]
  (println args)
  (bench! (or (first args) "../languages")))

(comment
  (get-benchmark-means-from-path! "/tmp/languages")
  (get-benchmark-means-from-path! "/Volumes/Macintosh HD-1/tmp/languages")
  (compile! "../../languages")
  :rcf)
