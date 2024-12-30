(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein-hello-world 252.1629762142857
            :loops-hello-world 249.18679457142855
            :levenshtein 251.82351771428574
            :loops 2155.101083428571}
   "Clojure_Native" {:fibonacci-hello-world 6.081476071428572
                     :levenshtein-hello-world 6.07374992857143
                     :loops-hello-world 6.131514785714286
                     :levenshtein 35.52245828571429
                     :loops 688.9572381428571
                     :fibonacci 484.99291071428576}
   "Kotlin_JVM" {:fibonacci-hello-world 74.57136300000002
                 :loops-hello-world 74.704515
                 :loops 716.1732144285716
                 :fibonacci 545.3440537142858}
   "Emacs_Lisp_Native" {:fibonacci-hello-world 84.00311307142856
                        :loops-hello-world 83.33876192857144
                        :loops 14550.113875285713
                        :fibonacci 2575.2806012857145}
   "Bun__Compiled_" {:levenshtein-hello-world 10.69988392857143
                     :loops-hello-world 12.07949707142857
                     :levenshtein 48.328166571428575
                     :loops 2041.387779714286}
   "Ruby_YJIT" {:fibonacci-hello-world 41.24633635714286
                :levenshtein-hello-world 41.20522321428572
                :loops-hello-world 38.352396000000006
                :levenshtein 359.58097
                :loops 14618.855357285713
                :fibonacci 2503.975107}
   "Java_Native" {:fibonacci-hello-world 5.671541785714287
                  :levenshtein-hello-world 5.761645714285715
                  :loops-hello-world 5.948205357142857
                  :levenshtein 36.217387
                  :loops 684.7852442857143
                  :fibonacci 487.72991671428576}
   "Dart" {:fibonacci-hello-world 20.164955285714296
           :loops-hello-world 17.963571428571434
           :loops 690.3863750000002
           :fibonacci 912.4922321428572}
   "Elixir" {:fibonacci-hello-world 269.5501280714285
             :loops-hello-world 270.9279790714286
             :loops 3184.068190285714
             :fibonacci 1575.7734584285715}
   "Objective_C" {:levenshtein-hello-world 4.121154642857142
                  :levenshtein 18.311809571428572}
   "Python" {:fibonacci-hello-world 23.22702071428571
             :levenshtein-hello-world 23.21279185714286
             :loops-hello-world 22.1232945
             :levenshtein 941.7731368571428
             :loops 44007.286482
             :fibonacci 26559.21995242857}
   "PyPy" {:fibonacci-hello-world 26.422157571428578
           :loops-hello-world 26.283571428571435
           :loops 3240.5699048571423
           :fibonacci 2316.426493857143}
   "Deno" {:fibonacci-hello-world 22.89595835714286
           :levenshtein-hello-world 21.781604071428575
           :loops-hello-world 24.12142557142857
           :levenshtein 66.43167257142856
           :loops 2017.0075594285715
           :fibonacci 1534.6388692857142}
   ;"Nim" {:levenshtein 45.75692857142858 :loops 636.1264941428573}
   "CPP" {:fibonacci-hello-world 3.3388779285714287
          :levenshtein-hello-world 2.7676993571428574
          :loops-hello-world 2.915532857142858
          :levenshtein 18.950261857142856
          :loops 641.5639942857142
          :fibonacci 500.7482917142858}
   "Kotlin_Native" {:fibonacci-hello-world 6.847214142857144
                    :loops-hello-world 8.24005642857143
                    :loops 2050.8060537142856
                    :fibonacci 509.137131}
   "Fortran" {;:fibonacci-hello-world 4.1107887142857145
              :levenshtein-hello-world 3.904743928571429
              :loops-hello-world 3.9431160714285713
              :levenshtein 11.50858342857143
              :loops 639.2512915714287
              ;:fibonacci 5.606613142857143
              }
   "Scala" {:fibonacci-hello-world 129.94821135714287
            :levenshtein-hello-world 134.6518898571429
            :loops-hello-world 126.56008614285713
            :levenshtein 212.00769028571435
            :loops 761.7181965714286
            :fibonacci 605.8763930000001}
   "Rust" {:fibonacci-hello-world 3.1355863571428575
           :levenshtein-hello-world 3.3103780000000005
           :loops-hello-world 2.8157620000000003
           :levenshtein 31.408952428571432
           :loops 634.4747801428572
           :fibonacci 493.87423771428587}
   "Lua" {:fibonacci-hello-world 3.6596370000000005
          :levenshtein-hello-world 3.4139435714285717
          :loops-hello-world 3.561955428571429
          :levenshtein 541.268755857143
          :loops 51679.21669042858
          :fibonacci 11816.011714142856}
   "Bun_Scala_JS" {:fibonacci-hello-world 12.482988285714287
                   :levenshtein-hello-world 12.52019642857143
                   :loops-hello-world 14.464080285714287
                   :levenshtein 62.58548214285715
                   :loops 2083.732583285714
                   :fibonacci 941.4458035714285}
   "Swift" {:fibonacci-hello-world 3.370107142857143
            :levenshtein-hello-world 3.3501935714285715
            :loops-hello-world 3.0581279285714293
            :levenshtein 43.461648714285715
            :loops 631.1667975714286
            :fibonacci 662.2086371428571}
   "C" {:fibonacci-hello-world 2.579413642857143
        :levenshtein-hello-world 2.775122071428572
        :loops-hello-world 2.8668005
        :levenshtein 14.452904714285715
        :loops 639.3212440000001
        :fibonacci 493.69033942857146}
   "Bun" {:levenshtein-hello-world 11.08664285714286
          :loops-hello-world 10.965348214285713
          :levenshtein 46.776821571428584
          :loops 2038.3889227142856}
   "V" {:fibonacci-hello-world 3.612348214285715
        :levenshtein-hello-world 3.553979357142858
        :loops-hello-world 3.360761857142857
        :levenshtein 17.310505857142857
        :loops 636.4261665714286
        :fibonacci 507.47126799999995}
   "Zig" {:fibonacci-hello-world 5.591928785714287
          :levenshtein-hello-world 2.9344018571428574
          :loops-hello-world 2.655071214285715
          :levenshtein 14.318446428571429
          :loops 633.6282677142858
          :fibonacci 506.40842242857144}
   "LuaJIT" {:fibonacci-hello-world 3.3249255714285715
             :levenshtein-hello-world 4.922946285714286
             :loops-hello-world 3.3112323571428575
             :levenshtein 48.968898714285714
             :loops 980.8257378571429
             :fibonacci 970.3482142857141}
   "Scala_Native" {:fibonacci-hello-world 3.219155000000001
                   :levenshtein-hello-world 3.399627928571428
                   :loops-hello-world 2.997032714285715
                   :levenshtein 17.680309285714287
                   :loops 637.2682915714287
                   :fibonacci 495.76483328571425}
   "COBOL" {:loops-hello-world 7.152586285714286 :loops 207529.26528599998}
   "PHP_JIT" {:fibonacci-hello-world 53.24232435714286
              :levenshtein-hello-world 53.652157714285714
              :loops-hello-world 55.66680385714287
              :levenshtein 234.26667871428572
              :loops 3242.003196714286
              :fibonacci 4170.246309571427}
   "Babashka" {:levenshtein-hello-world 12.775369
               :loops-hello-world 12.472523857142855
               :levenshtein 5830.544386857143
               :loops 74879.51425614285}
   "Go" {:fibonacci-hello-world 3.6377084285714285
         :levenshtein-hello-world 3.761154857142858
         :loops-hello-world 3.6984464999999997
         :levenshtein 20.519672571428572
         :loops 2072.436476142858
         :fibonacci 719.1149704285714}
   "Java" {:fibonacci-hello-world 66.58645514285715
           :levenshtein-hello-world 69.63459514285715
           :loops-hello-world 67.87321728571429
           :levenshtein 125.42245814285715
           :loops 709.0846608571428
           :fibonacci 538.0801667142857}
   "Odin" {:fibonacci-hello-world 2.8631637857142858
           :levenshtein-hello-world 2.9407022857142855
           :loops-hello-world 3.2319732142857145
           :levenshtein 17.305667000000003
           :loops 635.6870121428572
           :fibonacci 506.5457498571428}
   "Node" {:fibonacci-hello-world 47.010788642857165
           :levenshtein-hello-world 47.72617564285714
           :loops-hello-world 46.79375892857144
           :levenshtein 93.34916071428572
           :loops 2116.1164404285714
           :fibonacci 1561.484119}
   "Bun_Scala_JS_Compiled_" {:fibonacci-hello-world 11.326416714285717
                             :levenshtein-hello-world 11.620881
                             :loops-hello-world 12.02403578571429
                             :levenshtein 59.45505971428572
                             :loops 2080.3046252857143
                             :fibonacci 932.4132678571428}})

