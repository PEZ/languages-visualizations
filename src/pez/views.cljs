(ns pez.views
  (:require
   [pez.config :as conf]))

(defn- info-view [_state]
  (list
   [:h2 "A visualization experiment"]
   [:p "This is a visualization of results running the benchmarks setup by Benjamin Dicken's "
    [:a {:href "https://github.com/bddicken/languages"} "Languages"] " project. The visualization is very much inspired by how Benjamin choose to do it. The main twist here is the experiment with trying to compensate somewhat for the different start times of the executables in the bench. Source: " [:a {:href "https://github.com/PEZ/languages-visualizations"} "github.com/PEZ/languages-visualizations"]]
   [:p "The selection of languages are the subset of languages that are added to the project for which I have a working toolchain on my machine. (A Macbook Pro M4.). The languages need to pass the simple output check, and the implementation need to seem compliant (to me). I may also have skipped some of the slower languages because I don't want to wait forever to run it all."]
   [:p "I run the benchmarks like so, for each benchmark:"]
   [:ol
    [:li "For each language first run the " [:b "hello-world"] " benchmark, " [:b "7 runs"] ", and use this as a measure of start time for the exectutable being benched."]
    [:li "Run the benchmark, " [:b "7 runs."]]
    [:li "Subtract the start time to get the benchmark results"]]
   [:p "Some languages have several ways to compile and package the executables. I call them “champions” for their language, and only the best champion is selected for a given benchmark. E.g. Clojure is represented by “Clojure” and “Clojure Native”, where the former is running the Clojure program using the " [:code "java"] " command, and the latter is a compiled binary (using GraalVM native-image). Several JVM languages gets this treatment."]
   [:p [:b "Note:"] " There are several problems with this naïve way of subtracting start times:"]
   [:ul
    [:li "One is that it still doesn't compensate for that many JIT compilers will optimize the programs as they run. So a Java program getting cold started over and over, like this benchmark is run, will not be given a fair chance to show what it is actually capable of."]
    [:li "Another, bigger(?), problem is that the fluctuations of the start-times and the benchmark runs are too big, at least for the " [:b "levenshtein"] " benchmark, which is very quick. Subtracting the " [:b "hello-world"] " time from the benchmarked time can even result in negative values..."]]))

(defn app [{:keys [benchmark start-times-mode?] :as app-state} active-benchmarks]
  [:article
   [:h1 "Languages"]
   [:section
    [:div.benchmark-options
     (for [benchmark-option active-benchmarks]
       [:label.benchmark-label
        [:input {:type :radio
                 :name :benchmark
                 :value benchmark-option
                 :checked (= benchmark-option benchmark)
                 :on {:change [[:ax/set-hash :event/target.value]]}}]
        (benchmark-option conf/benchmark-names)])]
    [:label.benchmark-label
     [:input {:type :checkbox
              :checked start-times-mode?
              :on {:change [[:ax/toggle-start-time-mode start-times-mode?]]}}]
     [:span "start-time mode " [:em "(Caveats: see below)"]]]]
   [:section#race]
   [:section.info
    (info-view app-state)]])

