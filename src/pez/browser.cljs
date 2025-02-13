(ns pez.browser
  (:require
   [clojure.string :as string]
   [pez.benchmark :as benchmark]))

(defn share! [site text]
  (let [url (-> js/window .-location .-href)]
    (.open js/window (str (case site
                            :site/x "https://twitter.com/intent/tweet?text="
                            :site/linkedin "https://www.linkedin.com/shareArticle?mini=true&text=")
                          (js/encodeURIComponent text)
                          "&url="
                          (js/encodeURIComponent url)))))

(defn handle-hash [event-handler {:keys [app/benchmarks]}]
  (let [location-hash (-> js/window .-location .-hash)
        benchmark (when (seq location-hash)
                    (keyword (subs location-hash 1)))]
    (cond
      (contains? (set (benchmark/ordered-active-benchmarks benchmarks)) benchmark)
      (event-handler {} [[:ax/set-benchmark benchmark]])

      (string/starts-with? location-hash "#https://gist.github.com")
      (event-handler {} [[:ax/fetch-gist (subs location-hash 1)]])

      :else
      (event-handler {} [[:ax/set-benchmark :loops]]))))

#_(defn format-number [number locale]
  (str (.format (js/Intl.NumberFormat. (name locale))
                number)))

(defn parse-number [number]
  (if (string? number)
    (when-not (re-find #"[.,]$|[^0-9,.]|^$" (string/trim number))
                       (let [normalized-str (clojure.string/replace number #"," ".")]
                         (parse-double normalized-str)))
    number))
