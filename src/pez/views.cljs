(ns pez.views
  (:require
   [pez.config :as conf]
   [pez.benchmark-data :as bd]))

(defn- benchmark-runs-view [{:keys [app/benchmark-runs app/selected-run app/meta-visible? app/gist-loading?]}]
  (list
   [:div.benchmark-options {:replicant/key "benchmark-runs-view"
                            :style {:max-height "60px"
                                    :transition "max-height 0.35s"
                                    :overflow :hidden}
                            :replicant/mounting {:style {:max-height 0}}
                            :replicant/unmounting {:style {:max-height 0}}}
    [:select {:on {:change [[:ax/select-benchmark-run :event/target.value]]}}
     (map (fn [run-key]
            [:option {:value run-key
                      :selected (= selected-run run-key)} run-key])
          (sort > (keys benchmark-runs)))
     [:option {:value ""
               :selected (= selected-run "")}
      "Legacy run (start times included)"]]
    [:button.no-bg {:on {:click [[:ax/assoc :app/meta-visible? (not meta-visible?)]]}}
     [:i.fas.fa-info-circle]]
    (when gist-loading?
      [:span [:i.fas.fa-spinner.fa-spin]])]
   (when meta-visible?
     [:div.meta {:replicant/key "benchmark-runs-info"
                 :style {:max-height "300px"
                         :transition "max-height 0.35s"
                         :overflow-y :hidden}
                 :replicant/mounting {:style {:max-height 0}}
                 :replicant/unmounting {:style {:max-height 0}}}
      [:table
       [:tbody
        (for [[k v] (get-in benchmark-runs [selected-run :meta])]
          [:tr
           [:td [:strong (name k)]]
           [:td (cond
                  (= :gist k) [:a {:href v :target :_blank} (subs v 24)]
                  (#{:commit_sha :commit-sha} k) [:a {:href (str "https://github.com/bddicken/languages/tree/" v) :target :_blank} v]
                  :else v)]])]]])))

(defn- info-view [{:keys [benchmark/csv-input app/add-overlaps? app/filter-champions?] :as app-state}]
  (list
   [:div.buttons
    [:button.cta [:a {:href "https://github.com/PEZ/languages-visualizations/"
                      :target :blank}
                  "Star the repo"]]
    [:button.cta {:on {:click [[:ax/share :site/x "Visualizations of @BenjDicken's Languages benchmark project, by @pappapez."]]}}
     "Share on X"]
    [:button.cta {:on {:click [[:ax/share :site/linkedin "Visualizations of the Languages benchmark project."]]}}
     "Share to LinkedIn"]]
   [:h2 "A Languages Benchmark Visualizer"]
   [:p "This is a visualization of results running the benchmarks setup by Benjamin Dicken's " [:a {:href "https://github.com/bddicken/languages"} "Languages"] " project. Source: " [:a {:href "https://github.com/PEZ/languages-visualizations"} "github.com/PEZ/languages-visualizations"]]
   [:h3 "How benchmarks are run"]
   [:p "See the " [:a {:href "https://github.com/bddicken/languages"} "Languages"] " repository for the source code for each language implementation. There you'll also find all " [:a {:href "https://github.com/bddicken/languages/blob/main/languages.sh"} "Compilation, and run command lines"]]
   [:p "The runner script runs each language's program for respective benchmark an equal amount of time, prepended by an equal amount of warmup time. Per default the run time is 10 seconds and warmup is 2 seconds. Each program runs the benchmarked function as many times as fits in the run time window, and from those runs a mean time is calculated, which is the result for the particular language for a particular benchmark. A standard deviation is also calculated."]
   [:p "Each benchmark run is augmented with information about the CPU, RAM, OS, and some more info."]
   [:h4 "What about start time impact?"]
   [:p "There is no start time included in the results. The benchmarked functions are measured in process, and we only measure the benchmarked functions. Sometimes the measurements are around a function that collects data from the benchmarked function, for correctness check purposes. Care is taken to make this collecting function have as little impact as possible on the results."]
   [:p "An exception to the in-process measurement is the  " [:button {:on {:click [[:ax/set-hash "hello-world"]]}} "hello-world"] " benchmark. For that " [:a {:href "https://github.com/sharkdp/hyperfine"} "Hyperfine"] " is used, running a " [:strong "Hello World"] " program some 20 times. Because the purpose of the hello-world benchmark is to give an idea of the start time for a minimal program."]
   [:h3 "Loading benchmark run data"]
   [:p "There are two ways to load the visualizer with data from benchmark runs:"]
   [:ol
    [:li "Append a GitHub gist url to the url of the app. Like so: " [:a {:href "https://pez.github.io/languages-visualizations/#https://gist.github.com/PEZ/6ded27ce37722f6dd00fca314a65a781"} "https://pez.github.io/languages-visualizations/#https://gist.github.com/PEZ/6ded27ce37722f6dd00fca314a65a781"] " Where the gist contains CSV output from a benchmark run, duh. Like " [:a {:href "https://gist.github.com/PEZ/6ded27ce37722f6dd00fca314a65a781"} "the gist used in this example"]]
    [:li "Paste benchmark run result (CSV) here:"]]
   [:p
    [:textarea {:replicant/on-mount [[:ax/assoc :benchmark/csv-input :dom/node.value]]
                :on {:change [[:ax/assoc :benchmark/csv-input :event/target.value]]}}
     bd/csv]]
   [:div.buttons
    [:button.cta {:on {:click [[:ax/add-benchmark-run csv-input nil]]}}
     "Load CSV"]]
   (benchmark-runs-view app-state)
   [:h3 "You favorite language is missing?"]
   [:p "The current selection of languages is mainly constrained by which languages have been ported to use the new in-process runner. Please consider helping in " [:a {:href "https://github.com/bddicken/languages/issues/371"} "porting"] " (and addding) languages to the benchmark project.  🙏♥️"]
   [:h3 "Champions mode"]
   [:p "Some languages have several ways to compile and package the executables. I call them “champions” for their language. When " [:strong "Champions"] " mode is enabled ("
    [:label {:style {:text-wrap :nowrap}}
     [:input {:type :checkbox
              :checked filter-champions?
              :on {:change [[:ax/toggle-champions-mode filter-champions?]]}}]
     [:span "toggle at will"]]
    ") only the best champion is selected for a given benchmark. E.g. Clojure is represented by “Clojure” and “Clojure Native”, where the former is running the Clojure program using the " [:code "java"] " command, and the latter is a compiled binary (using GraalVM native-image)."]
   [:h3 "Notes"]
   [:p "The benchmark typically is not run in anything like a real-time environment. The ranking results can vary quite a lot between batches when contendants are close. Therefore languages that are roughly the same speed, as determined by an overlap from their standard deviations, will, by default, be rendered as moving at the same speed. It can get a bit misleading if a long string of languages perform at roughly the same speed increasingly, but where the first and last language in the string do not really perform at roughly the same speed, ¯\\_(ツ)_/¯. You can toggle this grouping:"
    [:label
     [:input {:type :checkbox
              :checked add-overlaps?
              :on {:change [[:ax/toggle-overlaps add-overlaps?]]}}]
     [:span "Group similar perf"]]]))

(defn app [{:keys [app/benchmark app/filter-champions?
                   app/add-overlaps? app/fastest-ui-track-time-choice app/paused?
                   app/manual-display-time app/bounce-logos?] :as app-state}
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
      [:span "Group similar perf"]]
     [:label.benchmark-label
      [:input {:type :checkbox
               :checked filter-champions?
               :on {:change [[:ax/toggle-champions-mode filter-champions?]]}}]
      [:span "Champions"]]
     [:button {:on {:click [[:ax/take-snapshot benchmark]]}
               :title "Take a snapshot"}
      [:i.fas.fa-camera]]
     [:label.benchmark-label
      "ms/track length: "
      [:select {:value (str fastest-ui-track-time-choice)
                :on {:change [[:ax/set-min-track-time-choice :event/target.value]]}}
       [:option {:value "600"} "600"]
       [:option {:value "fastest-language"} "Execution time"]
       [:option {:value "60000"} "60000"]
       [:option {:value "9600"} "9600"]
       [:option {:value "4800"} "4800"]
       [:option {:value "2400"} "2400"]
       [:option {:value "1200"} "1200"]
       [:option {:value "600"} "600"]
       [:option {:value "450"} "450"]
       [:option {:value "300"} "300"]
       [:option {:value "200"} "200"]
       [:option {:value "150"} "150"]
       [:option {:value "75"} "75"]
       [:option {:value "5"} "5"]
       [:option {:value "1"} "1"]]]]
    [:div.benchmark-options
     [:label.benchmark-label
      [:input {:type :checkbox
               :checked bounce-logos?
               :on {:change [[:ax/assoc :app/bounce-logos? (not bounce-logos?)]]}}]
      [:span "Bounce?"]]
     [:button {:on {:click [(if paused?
                              [:ax/resume-sketch]
                              [:ax/pause-sketch])]}
               :title (if paused?
                        "Play"
                        "Pause")}
      (if paused?
        [:i.fas.fa-play]
        [:i.fas.fa-pause])]
     (when paused?
       (list
        [:input {:type :text
                 :inputmode :decimal
                 :value manual-display-time
                 :step 1
                 :on {:focus [[:ax/select-all :dom/node]]
                      :input [[:ax/set-display-time :event/target.value]]}}]
        [:button {:on {:click [[:ax/set-display-time "0"]]}}
        [:i.fas.fa-backward-step]]))]]
   [:div.report
    [:section
     [:div#race]]
    [:section.info
     (info-view app-state)]]])

