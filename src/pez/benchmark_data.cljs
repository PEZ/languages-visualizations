(ns pez.benchmark-data)

(def benchmarks
  {:description ""
   :date ""
   :benchmarks [:loops :fibonacci :levenshtein]
   :benchmark-info {:loops {:title "1 Billion Loops"}
                    :fibonacci {:title "Naïve Fibonacci"}
                    :levenshtein {:title "Levenshtein Distance"}}
   :languages [{:language-name "C++"
                :logo "images/cpp.png"
                :color "blue"
                :start-time 2.4
                :fibonacci 50.5
                :loops 240.2
                :levenshtein 12.2}
               {:language-name "Clojure"
                :logo "images/clojure.png"
                :color "green"
                :start-time 240.6
                :fibonacci 338.2
                :loops 570.1
                :levenshtein 257.0}
               {:language-name "Java"
                :logo "images/java.png"
                :color "pink"
                :start-time 40.1
                :fibonacci 334.2
                :loops 560.8
                :levenshtein 56.0}]})