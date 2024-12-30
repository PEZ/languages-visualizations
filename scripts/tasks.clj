(ns tasks
  (:require
   [babashka.fs :as fs]
   [babashka.process :as p]
   [cheshire.core :as json]
   [clojure.pprint :as pprint]
   [clojure.string :as string]))

(defn get-mean-ms [file]
  (when (string/blank? (slurp file))
    (println "ERROR: Benchmark result file is empty: " file))
  (some-> (slurp file)
          (json/parse-string true)
          :results
          first
          :mean
          (* 1000)))

(defn  get-benchmark-means-from-path! [path]
  (->> (map str (fs/glob path "*/*.json"))
       (keep (fn [file]
               (let [benchmark (-> (subs file (inc (count path)) (string/last-index-of file "/"))
                                   keyword)
                     language (subs file (inc (string/last-index-of file "/")) (string/index-of file ".json"))]
                 (when-let [mean (get-mean-ms file)]
                   [benchmark language mean]))))
       (reduce (fn [acc [benchmark language mean]]
                 (assoc-in acc [language benchmark] mean))
               {})))

(defn compile! [languages-dir]
  (doseq [benchmark ["hello-world" "levenshtein" "loops" "fibonacci"]]
    (println "COMPILE:" benchmark)
    (p/shell {:dir (fs/path languages-dir benchmark)
              :continue true}
             "../compile.sh")))

(defn- scripts-dir []
  (if (System/getProperty "babashka.config")
    (-> (System/getProperty "babashka.config")
        fs/parent
        (fs/path "scripts"))
    (-> *file*
        fs/parent)))

(defn bench! [languages-dir]
  (let [bench-script (str (fs/path (scripts-dir)
                                   (if (System/getProperty "babashka.config")
                                     "bench.sh"
                                     "bench-some.sh")))]
    (doseq [benchmark ["levenshtein" "loops" "fibonacci"]]
      (println "BENCH:" benchmark)
      (p/shell {:dir (fs/path languages-dir benchmark)
                :continue true}
               bench-script))))
(defn tag-exists? [tag]
  (= 0 (:exit (p/shell {:continue true :out nil :err nil} "git" "rev-parse" tag))))

(defn find-available-tag [base-tag]
  (if-not (tag-exists? base-tag)
    base-tag
    (loop [n 1]
      (let [numbered-tag (str base-tag "-" n)]
        (if-not (tag-exists? numbered-tag)
          numbered-tag
          (recur (inc n)))))))

(defn ^:export collect-benchmark-data! [& [results-dir]]
  (pprint/pprint
   (get-benchmark-means-from-path! (or results-dir "/tmp/languages"))))

(defn ^:export compile-benchmarks! [& [languages-dir]]
  (compile! (or languages-dir "../languages")))

(defn ^:export bench-benchmarks! [& [languages-dir]]
  (bench! (or languages-dir "../languages")))

(defn ^:export compile-and-bench! [& [languages-dir]]
  (compile! (or languages-dir "../languages"))
  (bench! (or languages-dir "../languages")))

(defn ^:export permalink-tag! [& [tag]]
  (let [iso-date (.format (java.time.LocalDate/now)
                          java.time.format.DateTimeFormatter/ISO_DATE)
        default-tag (str "v" (string/replace iso-date #"-" "."))
        final-tag (find-available-tag (or tag default-tag))]
    (p/shell "git" "tag" final-tag)
    (p/shell "git" "push" "origin" final-tag)
    final-tag))

(comment
  (get-benchmark-means-from-path! "/tmp/languages")
  (get-benchmark-means-from-path! "/Volumes/Macintosh HD-1/tmp/languages")
  (compile! "../../languages")
  (bench! "../../languages")
  :rcf)
