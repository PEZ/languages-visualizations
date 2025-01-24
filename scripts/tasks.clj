(ns tasks
  (:require
   [babashka.fs :as fs]
   [babashka.process :as p]
   [cheshire.core :as json]
   [clojure.pprint :as pprint]
   [clojure.string :as string]))



(defn stats-s->stats-ms [stats-s]
  {:max (* 1000 (:max stats-s))
   :mean (* 1000 (:mean stats-s))
   :median (* 1000 (:median stats-s))
   :min (* 1000 (:min stats-s))
   :stddev (* 1000 (:stddev stats-s))
   :runs (count (:times stats-s))})

(defn file-path->stats-ms [file-path]
  (when (string/blank? (slurp file-path))
    (println "ERROR: Benchmark result file is empty: " file-path))
  #_(def file-path "/Volumes/Macintosh HD-1/tmp/languages/loops/C.json")
  (some-> (slurp file-path)
          (json/parse-string true)
          :results
          first
          stats-s->stats-ms))

(defn  get-benchmark-means-from-path! [path]
  (->> (map str (fs/glob path "*/*.json"))
       (keep (fn [file]
               (let [benchmark (-> (subs file (inc (count path)) (string/last-index-of file "/"))
                                   keyword)
                     language (subs file (inc (string/last-index-of file "/")) (string/index-of file ".json"))]
                 (when-let [stats (file-path->stats-ms file)]
                   [benchmark language stats]))))
       (reduce (fn [acc [benchmark language mean]]
                 (assoc-in acc [language benchmark] mean))
               {})))

(defn compile-old! [languages-dir]
  (doseq [benchmark ["hello-world" "levenshtein" "loops" "fibonacci"]]
    (println "COMPILE:" benchmark)
    (p/shell {:dir (fs/path languages-dir benchmark)
              :continue true}
             "../compile.sh")))

(defn compile! [languages-dir]
  (doseq [benchmark ["hello-world" "levenshtein" "loops" "fibonacci"]]
    (println "COMPILE:" benchmark)
    (p/shell {:dir (fs/path languages-dir benchmark)
              :continue true}
             "../compile-benchmark.sh")))

(defn- scripts-dir []
  (if (System/getProperty "babashka.config")
    (-> (System/getProperty "babashka.config")
        fs/parent
        (fs/path "scripts"))
    (-> *file*
        fs/parent)))

(defn bench-old! [languages-dir bench-some?]
  (let [bench-script (str (fs/path (scripts-dir) (if bench-some?
                                                   "bench-some.sh"
                                                   "bench.sh")))]
    (doseq [benchmark ["hello-world" "levenshtein" "loops" "fibonacci"]]
      (println "BENCH:" benchmark)
      (p/shell {:dir (fs/path languages-dir benchmark)
                :continue true}
               bench-script))))

(defn bench! [languages-dir user languages]
  (let [bench-script (if languages
                       (str "../run-benchmark.sh -u" user " -l " languages)
                       (str "../run-benchmark.sh -u" user))]
    (doseq [benchmark ["hello-world" "levenshtein" "loops" "fibonacci"]]
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
   (get-benchmark-means-from-path! (str (fs/path (or results-dir "/tmp/languages"))))))

(defn ^:export compile-benchmarks-old! [& [languages-dir]]
  (compile-old! (or languages-dir "../languages")))

(defn ^:export bench-benchmarks-old! [& [languages-dir bench-some]]
  (bench-old! (or languages-dir "../languages") (not (nil? bench-some))))

(defn ^:export compile-benchmarks! [& [languages-dir]]
  (compile! (or languages-dir "../languages")))

(defn ^:export bench-benchmarks! [& [user languages languages-dir]]
  (bench! (or languages-dir "../languages") (or user "PEZ") languages))

(defn ^:export compile-and-bench-old! [& [languages-dir bench-some]]
  (compile-old! (or languages-dir "../languages"))
  (bench-old! (or languages-dir "../languages") (not (nil? bench-some))))

(defn ^:export compile-and-bench! [& [user languages languages-dir]]
  (compile! (or languages-dir "../languages"))
  (bench! (or languages-dir "../languages") (or user "PEZ") languages))

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
  (compile-old! "../../languages")
  (bench-old! "../../languages" true)
  :rcf)
