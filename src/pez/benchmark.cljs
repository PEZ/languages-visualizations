(ns pez.benchmark
  (:require
   [clojure.string :as string]
   [pez.config :as conf]))

(defn csv->benchmark-data
  "Parses CSV text into benchmark data.
   - Splits the CSV text into lines, extracts headers, and maps each row to a map of header-value pairs.
   - Reduces the rows into a nested map structure, associating benchmark measurements and metadata.
   - The resulting map is keyed by a combination of user, timestamp, model, and RAM, with nested keys for measurements and metadata."
  [csv-text gist]
  (try
    (let [lines (as-> csv-text $
                  (string/split $ #"\n")
                  (remove (partial re-find #"^\s*$") $))
          header (first lines)
          headers (->> (string/split header #",")
                       (map keyword))
          rows (map #(zipmap headers (string/split % #",")) (rest lines))]
      (reduce (fn [acc {:keys [benchmark timestamp
                               user model ram language
                               std-dev-ms runs] :as row}]
                (let [language-slug (string/replace language #"[^a-zA-Z0-9]" "_")
                      run-key (str user ", " timestamp ", " model ", " ram)]
                  (-> acc
                      (assoc-in [run-key :measurements language-slug (keyword benchmark)]
                                {:mean (parse-double
                                        (or (:mean-ms row)
                                            (:mean_ms row)))
                                 :stddev (parse-double std-dev-ms)
                                 :runs (parse-long runs)})
                      (assoc-in [run-key :meta]
                                (merge {:gist gist}
                                       (dissoc row
                                               :language :runs :benchmark
                                               :is-checked :is_checked
                                               :mean-ms :mean_ms
                                               :min-ms :min_ms
                                               :max-ms :max_ms
                                               :std-dev-ms))))))
              {}
              rows))
    (catch :default e
      (js/alert (str "Error while parsing CSV. " e)))))

(defn benchmark-times
  "Extracts the mean benchmark time for the active benchmark"
  [{:keys [benchmark benchmarks]}]
  (let [benchmarks (filter (comp benchmark second) benchmarks)]
    (->> benchmarks
         vals
         (map benchmark)
         (map :mean))))

(defn- languages
  "Merges benchmark data with language configurations"
  [{:keys [benchmarks]}]
  (mapv (fn [{:keys [language-file-name] :as lang}]
          (merge lang
                 (benchmarks language-file-name)))
        conf/languages))

(defn- fastest-implementation
  "Finds the fastest implementation for a given benchmark. Sorts implementations by their mean benchmark time and returns the first (fastest) one."
  [{:keys [benchmark]} implementations]
  (->> implementations
       (sort-by #(get-in % [benchmark :mean]))
       first))

(defn best-languages
  "Filters and groups languages based on benchmark data. If `filter-champions?` is true, groups languages by name and selects the fastest implementation for each group."
  [cmp {:keys [benchmark filter-champions?] :as app-state}]
  (let [candidates (->> (languages app-state)
                        (filter (fn [lang]
                                  (get-in lang [benchmark :mean])))
                        (map #(assoc-in % [benchmark :speed-mean] (get-in % [benchmark :mean]))))]
    (sort-by #(get-in % [benchmark :mean]) cmp
             (if filter-champions?
               (->> candidates
                    (group-by :language)
                    vals
                    (map (fn [champions]
                           (fastest-implementation app-state champions))))
               candidates))))

(defn add-overlaps
  "Handles overlapping benchmark intervals between pairs of languages.
   Overlaps are determined by the standard deviation of the mean values for a language.
   - Adds a `speed-mean`, initializing it to each language's mean,
   - Then updates it to the fastest language's mean, for all languages in any overlapping group."
  [{:keys [benchmark] :as app-state}]
  (let [langs (->> (best-languages > app-state)
                   (filter #(get-in % [benchmark :mean])))
        pairs (partition 2 1 langs)]
    (reverse
     (reduce (fn [langs [lang1 lang2]]
               (let [mean1 (get-in (first (filter #(= % lang1) langs)) [benchmark :speed-mean])
                     std-dev1 (get-in lang1 [benchmark :stddev])
                     mean2 (get-in lang2 [benchmark :mean])
                     std-dev2 (get-in lang2 [benchmark :stddev])
                     interval1 [(max 0 (- mean1 std-dev1)) (+ mean1 std-dev1)]
                     interval2 [(max 0 (- mean2 std-dev2)) (+ mean2 std-dev2)]
                     overlap? (and (<= (first interval1) (second interval2))
                                   (>= (second interval1) (first interval2)))]
                 (if overlap?
                   (let [shared-mean mean2]
                     (mapv #(if (or (= % lang1)
                                    (= (get-in % [benchmark :speed-mean]) mean1))
                              (assoc-in % [benchmark :speed-mean] shared-mean)
                              %)
                           langs))
                   langs)))
             langs
             pairs))))

(defn ordered-active-benchmarks
  "Returns the active benchmarks in a predetermined order"
  [benchmarks]
  (sort-by #(.indexOf [:loops :fibonacci :levenshtein :hello-world] %)
           (reduce-kv (fn [acc _k v]
                        (into acc (keys v)))
                      #{}
                      benchmarks)))