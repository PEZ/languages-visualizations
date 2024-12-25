(ns pez.benchmark-data)

(def languages
  [{:language :c++
    :language-name "CPP"
    :language-file-name "CPP"
    :logo "images/cpp.png"}
   {:language :clojure
    :language-name "Clojure"
    :language-file-name "Clojure"
    :logo "images/clojure.png"}
   {:language :clojure
    :language-name "Clojure Native"
    :language-file-name "Clojure_Native"
    :logo "images/clojure.png"}
   {:language :java
    :language-name "Java"
    :language-file-name "Java"
    :logo "images/java.png"}
   {:language :java
    :language-name "Java GraalVM"
    :language-file-name "Java_GraalVM"
    :logo "images/java.png"}
   {:language :node
    :language-name "Node"
    :language-file-name "Node"
    :logo "images/node.png"}])

(def benchmark-names
  {:loops "1 Billion Loops"
   :fibonacci "Naïve Fibonacci"
   :levenshtein "Levenshtein Distance"})

(def benchmarks
  {"CPP" {:hello-world 2.4
          :fibonacci 50.5
          :loops 240.2
          :levenshtein 12.2}
   "Clojure" {:hello-world 240.6
              :fibonacci 338.2
              :loops 570.1
              :levenshtein 257.0}
   "Java" {:hello-world 40.1
           :fibonacci 334.2
           :loops 560.8
           :levenshtein 56.0}})


