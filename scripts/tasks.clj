(ns tasks
  (:require
   [babashka.process :as p]
   [clojure.string :as string]))

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

(defn ^:export permalink-tag! [& [tag]]
  (let [iso-date (.format (java.time.LocalDate/now)
                          java.time.format.DateTimeFormatter/ISO_DATE)
        default-tag (str "v" (string/replace iso-date #"-" "."))
        final-tag (find-available-tag (or tag default-tag))]
    (p/shell "git" "tag" final-tag)
    (p/shell "git" "push" "origin" final-tag)
    final-tag))

