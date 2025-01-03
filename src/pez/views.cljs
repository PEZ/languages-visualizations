(ns pez.views
  (:require
   [pez.config :as conf]))

(defn- info-view [_state]
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
   [:p [:a {:href "https://github.com/sharkdp/hyperfine"} "Hyperfine"] " is used to run each benchmark, where each language is given " [:strong "7 runs."]]
   [:blockquote "Especially since there are " [:strong "only 7 runs per language"] " on a given benchmark, the results can vary quite a lot. When the differences are small, the ordering of the languages often varies between runs. "]
   [:p "See also the " [:a {:href "https://github.com/bddicken/languages"} "Languages"] " repository for the source code for each language implementation. There you'll also find all:"]
   [:ul
    [:li [:a {:href "https://github.com/bddicken/languages/blob/main/compile.sh"} "Compilation command lines"]]
    [:li [:a {:href "https://github.com/bddicken/languages/blob/main/run.sh"} "Runner command lines"]]]
   [:h4 "Start time impact"]
   [:p "The start times of executables/environments can vary a lot between languages. Since the benchmarks are run out of process, the " [:strong "benchmark results include the start times"] ". For some benchmark that takes, say 300ms to complete for a language that has start time of, say 100ms, this of course skews the results a lot."]
   [:p "To somewhat mitigate, I've been trying to provide " [:strong "native"] " compilations, to the " [:strong "Languages"] " repository, for as many languages as I can understand how to do that. For e.g. Clojure this brings down the start time from 440ms to 12ms, a quite significant difference when Clojure runs the tests in 40-650ms. But even with that, C starts 10ms faster than Clojure, which is not insignificant in benchmarks like these."]
   [:p "The " [:button {:on {:click [[:ax/set-hash "hello-world"]]}} "hello-world"] " benchmark is included as a sort of measurement of start times. An inexact way to compensate for start times is to subtract hello-world times from the other benchmarks."]
   [:h3 "Language selection"]
   [:p "The selection of languages are the subset of languages that are added to the project for which I have a working toolchain on my benchmarking machine. The languages need to pass the simple output check, and the implementation need to seem compliant (to me). I may also have skipped some of the slower languages because I don't want to wait forever to run it all. I want to include more languages, it is mostly a matter of how much time I can spend of investigating toolchain issues."]
   [:h4 "You favorite language is missing?"]
   [:p "If you lack some language in the visualizations, let me know in an issue " [:a {:href "https://github.com/PEZ/languages-visualizations"} "on the project"] ". If you include instructions on how to get the toolchain installed on a Mac silicon (without any Docker involved) it increases the chances I get the language included."]
   [:h3 "Champions mode"]
   [:p "Some languages have several ways to compile and package the executables. I call them “champions” for their language. When " [:strong "Chamions"] " mode is enabled only the best champion is selected for a given benchmark. E.g. Clojure is represented by “Clojure” and “Clojure Native”, where the former is running the Clojure program using the " [:code "java"] " command, and the latter is a compiled binary (using GraalVM native-image). Unless something really strange is going on, only “Clojure Native” will ever show up in the visualizations, because Clojure takes a lot of time to start in a regular JVM environment. (Which typically doesn't matter in the real world, and all that.)"]
   [:blockquote "Something strange " [:em "is"] " going on with “Kotlin”, where the “Kotlin Native” " [:button {:on {:click [[:ax/set-hash "loops"]]}} "loops"] " results are very slow, and never beats the “Kotlin JVM” results (not even close)."]
   [:h3 "Usage tips"]
   [:blockquote "Save the winning frame as a PNG by enabling " [:strong "Auto-snapshot winner"] ". Then switch benchmark to make it restart the race. The snapshot will be taken when the fastest language reaches the right wall the first time. If you are using a keyboard device, you can save a snapshot by pressing " [:span.kbd "S"]]))

(defn app [{:keys [benchmark snapshot-mode? filter-champions? min-track-time-ms] :as app-state}
           active-benchmarks]
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
       [:option {:value 5} "Warp speed"]]]]]
   [:div.report
    [:section#race]
    [:section.info
     (info-view app-state)]]])

