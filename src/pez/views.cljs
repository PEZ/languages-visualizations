(ns pez.views
  (:require
   [pez.config :as conf]))

(defn- info-view [_state]
  (list
   [:h2 "A visualization experiment"]
   [:blockquote "You can save a snapshot by pressing " [:span.kbd "S"]]
   [:p "This is a visualization of results running the benchmarks setup by Benjamin Dicken's "
    [:a {:href "https://github.com/bddicken/languages"}
     "Languages"]
    " project. The visualization is very much inspired by how Benjamin choose to do it."
    " Source: " [:a {:href "https://github.com/PEZ/languages-visualizations"}
                 "github.com/PEZ/languages-visualizations"]]
   [:p "The selection of languages are the subset of languages that are added to the project
        for which I have a working toolchain on my benchmarking machine. (A Macbook Pro M1 Max
        where I have tried to make things as nonbusy as MaxOS can be). The languages
        need to pass the simple output check, and the implementation need to seem compliant
        (to me). I may also have skipped some of the slower languages because I don't want to
        wait forever to run it all."]
   [:p "I run the benchmarks like so, for each benchmark:"]
   [:ol
    [:li "For each language first run the " [:b "hello-world"] " benchmark, " [:b "14 runs"]
     ", and use this as a measure of start time for the exectutable being benched."]
    [:li "Run the benchmark, " [:b "7 runs."]]
    [:li "At render time, " [:em "and only if in " [:b "start-times mode"]] ": Subtract the start time to get the benchmark results"]]
   [:p "Some languages have several ways to compile and package the executables.
        I call them “champions” for their language, and only the best champion is
        selected for a given benchmark. E.g. Clojure is represented by “Clojure”
        and “Clojure Native”, where the former is running the Clojure program using the
        " [:code "java"]
    " command, and the latter is a compiled binary (using GraalVM
     native-image). Unless something really strange is going on, only “Clojure Native” will ever
     show up in the visualizations, because Clojure takes a lot of time to start in a regular
     JVM environment. (Which typically doesn't matter in the real world, and all that.)"]
   [:blockquote "Something strange " [:em "is"]
    " going on with “Kotlin”, where the “Kotlin Native” results are very slow, and never beats
     the “Kotlin JVM” results (not even close)."]
   [:h3 "You favorite language is missing?"]
   [:p "If you lack some language in the visualizations, let me know in an issue "
   [:a {:href "https://github.com/PEZ/languages-visualizations"}
    "on the project"]
    ". If you include instructions on how to get the toolchain installed on a Mac
     silicon (without any Docker involved) it increases the chances I get the language included."]
   [:h3 "start-times mode – a failed experiment"]
   [:p "The main twist here is the experiment with trying to compensate somewhat for the different
        start times of the executables in the bench."]
   [:p "In " [:b "start-times mode"] " The visualization begins with a an animation, and reporting,"
    " of the start times."]
   [:p [:b "Note:"] " There are several problems with this naïve way of subtracting start times:"]
   [:ul
    [:li "One, problem is that the fluctuations of the start-times and
          the benchmark runs are too big. This gets extra visible with the "
     [:b "levenshtein"] " benchmark, which is very quick. Subtracting the "
     [:b "hello-world"] " time from the benchmarked time can even result in negative values."
     [:blockquote " With Julia this seems to happen consistently. The " [:b "levenshtein"]
      " program runs faster than the " [:b "hello-world"]
      " program. (Something for a Julia expert to explain?)"]]
    [:li "Another problem is that subtracting the start times, even if done accurately, still"
     " doesn't compensate for that many JIT compilers will optimize the programs as they run."
     " So a Java program getting cold started over and over, like this benchmark is run, will"
     " not be given a fair chance to show what it is actually capable of."]]))

(defn app [{:keys [benchmark start-times-mode? min-track-time-ms] :as app-state} active-benchmarks]
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
    [:div.benchmark-options
     [:button {:on {:click [[:ax/take-snapshot benchmark]]}}
      "Snapshot"]
     [:label.benchmark-label
      "Animation speed: "
      [:select {:value min-track-time-ms
                :on {:change [[:ax/set-min-track-time-ms :event/target.value]]}}
       [:option {:value 600} "Normal"]
       [:option {:value 60000} "Too slow"]
       [:option {:value 9600} "Very very slow"]
       [:option {:value 4800} "Very Slow"]
       [:option {:value 2400} "Slow"]
       [:option {:value 1200} "Slower"]
       [:option {:value 600} "Normal"]
       [:option {:value 450} "Faster"]
       [:option {:value 300} "Very fast"]
       [:option {:value 200} "Very very fast"]
       [:option {:value 150} "Too fast"]
       [:option {:value 75} "Way too fast"]
       [:option {:value 5} "Warp speed"]]]
     [:label.benchmark-label
      [:input {:type :checkbox
               :checked start-times-mode?
               :on {:change [[:ax/toggle-start-time-mode start-times-mode?]]}}]
      [:span "start-time mode " [:em "(Major caveats: see below)"]]]]]
   [:div.report
    [:section#race]
    [:section.info
     (info-view app-state)]]])

