(ns pez.benchmark
  (:require
   [clojure.string :as string]
   [pez.config :as conf]))

(defn csv->benchmark-data [csv-text gist]
  (let [lines (as-> csv-text $
                (string/split $ #"\n")
                (remove (partial re-find #"^\s*$") $))
        header (first lines)
        headers (->> (string/split header #",")
                     (map keyword))
        rows (map #(zipmap headers (string/split % #",")) (rest lines))]
    (try
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
                                               :run-ms :run_ms
                                               :is-checked :is_checked
                                               :mean-ms :mean_ms
                                               :min-ms :min_ms
                                               :max-ms :max_ms
                                               :std-dev-ms))))))
              {}
              rows)
      (catch :default e
        (js/alert (str "Error while parsing CSV. " e))))))

(defn benchmark-times [{:keys [benchmark benchmarks]}]
  (let [benchmarks (filter (comp benchmark second) benchmarks)]
    (->> benchmarks
         vals
         (map benchmark)
         (map :mean))))

(defn- languages [{:keys [benchmarks]}]
  (mapv (fn [{:keys [language-file-name] :as lang}]
          (merge lang
                 (benchmarks language-file-name)))
        conf/languages))

(defn- fastest-implementation [{:keys [benchmark]} implementations]
  (->> implementations
       (sort-by #(get-in % [benchmark :mean]))
       first))

(defn- add-default-speed-mean [benchmark lang]
  (assoc-in lang [benchmark :speed-mean]
            (get-in lang [benchmark :mean])))

(defn- best-languages [cmp {:keys [benchmark filter-champions?] :as app-state}]
  (let [candidates (->> (languages app-state)
                        (filter (fn [lang]
                                  (get-in lang [benchmark :mean]))))]
    (sort-by #(get-in % [benchmark :mean]) cmp
             (if filter-champions?
               (->> candidates
                    (group-by :language)
                    vals
                    (map (fn [champions]
                           (fastest-implementation app-state champions))))
               candidates))))

(defn add-overlaps [{:keys [benchmark] :as app-state}]
  (let [langs (->> (best-languages > app-state)
                   (filter #(get-in % [benchmark :mean]))
                   (map (partial add-default-speed-mean benchmark)))
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

(defn active-benchmarks [benchmarks]
  (sort-by #(.indexOf [:loops :fibonacci :levenshtein :hello-world] %)
           (reduce-kv (fn [acc _k v]
                        (into acc (remove (fn [benchmark]
                                            (.endsWith (name benchmark) "-hello-world"))
                                          (keys v))))
                      #{}
                      benchmarks)))