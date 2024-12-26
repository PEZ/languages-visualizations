(ns pez.config)

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