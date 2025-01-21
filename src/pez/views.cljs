(ns pez.views
  (:require
   [pez.config :as conf]
   [pez.benchmark-data :as bd]))

(defn- benchmark-runs-view [{:keys [benchmark-runs selected-run]}]
  (when benchmark-runs
    [:div.benchmark-options
     [:select {:on {:change [[:ax/select-benchmark-run :event/target.value]]}}
      [:option {:value ""
                :selected (= selected-run "")}
       "Default run"]
      (map (fn [run-key]
             [:option {:value run-key
                       :selected (= selected-run run-key)} run-key])
           (keys benchmark-runs))]]))

(defn- info-view [app-state]
  (list
   [:div.buttons
    [:button.cta [:a {:href "https://github.com/PEZ/languages-visualizations/"
                      :target :blank}
                  "Star the repo"]]
    [:button.cta {:on {:click [[:ax/share :site/x "Visualizations of @BenjDicken's Languages benchmark project, by @pappapez."]]}}
     "Share on X"]
    [:button.cta {:on {:click [[:ax/share :site/linkedin "Visualizations of the Languages benchmark project."]]}}
     "Share to LinkedIn"]]
   [:h2 "A visualization experiment"]
   [:p "This is a visualization of results running the benchmarks setup by Benjamin Dicken's " [:a {:href "https://github.com/bddicken/languages"} "Languages"] " project. Source: " [:a {:href "https://github.com/PEZ/languages-visualizations"} "github.com/PEZ/languages-visualizations"]]
   [:h3 "How I run the benchmarks"]
   [:p "The benchmarks are run on a Macbook Pro M1 Max with 32GB of RAM. I have tried to make things nonbusy on the machine. E.g. created a dedicated user, for which I have disabled all startup/login items. And I only have the benchmarks running."]
   [:p [:a {:href "https://github.com/sharkdp/hyperfine"} "Hyperfine"] " is used to run each benchmark, where each language is given " [:strong "15 runs."]]
   [:blockquote "Since there are " [:strong "only 15 runs per language"] " on a given benchmark, and the benchmark is not run in anything like a real-time environment the ranking results can vary quite a lot between batches when contendants are close. Therefore languages that are roughly the same speed, as determined by an overlap from their standar deviations, they will, by default, be rendered as moving at the same speed. It can get a bit misleading if a long string of languages perform at roughly the same speed increasingly, but where the first and last language in the string do not really perform at roughly the same speed, ¯\\_(ツ)_/¯ "]
   [:p "See also the " [:a {:href "https://github.com/bddicken/languages"} "Languages"] " repository for the source code for each language implementation. There you'll also find all:"]
   [:ul
    [:li [:a {:href "https://github.com/bddicken/languages/blob/main/compile.sh"} "Compilation command lines"]]
    [:li [:a {:href "https://github.com/bddicken/languages/blob/main/run.sh"} "Runner command lines"]]]
   [:h4 "Start time impact"]
   [:p "The start times of executables/environments can vary a lot between languages. Since the benchmarks are run out of process, the " [:strong "benchmark results include the start times"] ". For some benchmark that takes, say 300ms to complete for a language that has start time of, say 100ms, this of course skews the results a lot."]
   [:p "To somewhat mitigate, I've been trying to provide " [:strong "native"] " compilations, to the " [:strong "Languages"] " repository, for as many languages as I can understand how to do that. For e.g. Clojure this brings down the start time from 440ms to 12ms, a quite significant difference when Clojure runs the tests in 40-650ms. But even with that, C starts 10ms faster than Clojure, which is not insignificant in benchmarks like these."]
   [:p "The " [:button {:on {:click [[:ax/set-hash "hello-world"]]}} "hello-world"] " benchmark is included as a sort of measurement of start times. An inexact way to compensate for start times is to subtract hello-world times from the other benchmarks."]
   [:p "I have created a new benchmark runner, where the interesting part of each program is benchmarked in-process, thus removing the start-time (and any non-interesting setup) from the results. Here's a PR for adding this runner: " [:a {:href "https://github.com/bddicken/languages/pull/365"} "https://github.com/bddicken/languages/pull/365"] ". With Clojure, Java, C, and also Babashka ready. This data is from a run on the same machine as described above. Why not try it?"]
   [:p
    [:textarea {:replicant/on-mount [[:ax/assoc :element/csv-input :dom/node]]}
     bd/csv]]
   [:div.buttons
    [:button.cta {:on {:click [[:ax/add-benchmark-run [:db/get :element/csv-input]]]}}
     "Load CSV"]]
   (benchmark-runs-view app-state)
   [:h3 "Language selection"]
   [:p "The selection of languages are the subset of languages that are added to the project for which I have a working toolchain on my benchmarking machine. The languages need to pass the simple output check, and the implementation need to seem compliant (to me). I may also have skipped some of the slower languages because I don't want to wait forever to run it all. I want to include more languages, it is mostly a matter of how much time I can spend on investigating toolchain issues."]
   [:h4 "Where's Levenshtein Pascal?"]
   [:p "The suspiciously stellar performance of Pascal in the " [:button {:on {:click [[:ax/set-hash "levenshtein"]]}} "levenshtein"] " test was explained by FreePascal defaulting to " [:code "ShortString"] "which effectively truncates the strings at 256 characters, and many strings in the test are much longer than that. " [:a {:href "https://github.com/bddicken/languages/issues/347"} "https://github.com/bddicken/languages/issues/347"] " I'll reinsitate Pascal when the program is fixed."]
   [:h4 "You favorite language is missing?"]
   [:p "If you lack some language in the visualizations, let me know in an issue " [:a {:href "https://github.com/PEZ/languages-visualizations"} "on the project"] ". If you include instructions on how to get the toolchain installed on a Mac silicon (without any Docker involved) it increases the chances that I get the language included."]
   [:h3 "Champions mode"]
   [:p "Some languages have several ways to compile and package the executables. I call them “champions” for their language. When " [:strong "Chamions"] " mode is enabled only the best champion is selected for a given benchmark. E.g. Clojure is represented by “Clojure” and “Clojure Native”, where the former is running the Clojure program using the " [:code "java"] " command, and the latter is a compiled binary (using GraalVM native-image). Unless something really strange is going on, only “Clojure Native” will ever show up in the visualizations, because Clojure takes a lot of time to start in a regular JVM environment. (Which typically doesn't matter in the real world, and all that.)"]
   [:blockquote "Something strange " [:em "is"] " going on with “Kotlin”, where the “Kotlin Native” " [:button {:on {:click [[:ax/set-hash "loops"]]}} "loops"] " results are very slow, and never beats the “Kotlin JVM” results (not even close)."]
   [:h3 "Usage tips"]
   [:p "The " [:strong "Execution time"] " animation speed setting makes the balls/logos travel one distance across the track in the same time as they executed the active benchmark."]
   [:p "Save the winning frame as a PNG by enabling " [:strong "Auto-snapshot winner"] ". Then switch benchmark to make it restart the race. The snapshot will be taken when the fastest language reaches the right wall the first time."]))

(defn app [{:keys [benchmark snapshot-mode? filter-champions?
                   add-overlaps? min-track-time-ms] :as app-state}
           active-benchmarks]
  [:article
   [:h1 "Languages"]
   [:section
    (benchmark-runs-view app-state)
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
     [:label.benchmark-label
      [:input {:type :checkbox
               :checked add-overlaps?
               :on {:change [[:ax/toggle-overlaps add-overlaps?]]}}]
      [:span "Add std-dev overlaps"]]
     [:label.benchmark-label
      [:input {:type :checkbox
               :checked filter-champions?
               :on {:change [[:ax/toggle-champions-mode filter-champions?]]}}]
      [:span "Champions"]]
     [:button {:on {:click [[:ax/take-snapshot benchmark]]}}
      "Snapshot"]
     [:label.benchmark-label
      [:input {:type :checkbox
               :checked snapshot-mode?
               :on {:change [[:ax/toggle-snapshot-mode snapshot-mode?]]}}]
      [:span "Auto-snapshot winner"]]
     [:label.benchmark-label
      "ms/track length: "
      [:select {:value min-track-time-ms
                :on {:change [[:ax/set-min-track-time-choice :event/target.value]]}}
       [:option {:value 600} "600"]
       [:option {:value "fastest-language"} "Execution time"]
       [:option {:value 60000} "60000"]
       [:option {:value 9600} "9600"]
       [:option {:value 4800} "4800"]
       [:option {:value 2400} "2400"]
       [:option {:value 1200} "1200"]
       [:option {:value 600} "600"]
       [:option {:value 450} "450"]
       [:option {:value 300} "300"]
       [:option {:value 200} "200"]
       [:option {:value 150} "150"]
       [:option {:value 75} "75"]
       [:option {:value 5} "5"]]]]]
   [:div.report
    [:section#race]
    [:section.info
     (info-view app-state)]]])

