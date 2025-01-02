(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein-hello-world 249.6651785714286
            :loops-hello-world 237.648994
            :levenshtein 251.38713714285714
            :loops 2122.555928571429}
   "Clojure_Native" {:fibonacci-hello-world 5.6343720714285705
                     :levenshtein-hello-world 7.336779714285716
                     :loops-hello-world 8.019916714285715
                     :levenshtein 38.16127971428572
                     :loops 646.5950952857144
                     :fibonacci 425.21020842857143}
   "Kotlin_JVM" {:fibonacci-hello-world 74.02048192857144
                 :loops-hello-world 73.04896714285715
                 :loops 707.4128987142857
                 :fibonacci 543.6672498571429}
   "Emacs_Lisp_Native" {:fibonacci-hello-world 83.61962214285715
                        :loops-hello-world 84.90257442857144
                        :loops 14542.685785571432
                        :fibonacci 2559.6636668571427}
   "Bun__Compiled_" {:fibonacci-hello-world 10.69032142857143
                     :levenshtein-hello-world 12.201104285714287
                     :loops-hello-world 11.88946435714286
                     :levenshtein 49.823851285714284
                     :loops 2049.505363142857
                     :fibonacci 904.4675415714286}
   "Ruby_YJIT" {:fibonacci-hello-world 38.539565499999995
                :levenshtein-hello-world 39.03361314285714
                :loops-hello-world 37.76259521428572
                :levenshtein 358.79115471428577
                :loops 14527.754512142857
                :fibonacci 2487.060119142857}
   "Java_Native" {:fibonacci-hello-world 5.469271
                  :levenshtein-hello-world 6.4428661428571425
                  :loops-hello-world 5.362333428571428
                  :levenshtein 35.41588699999999
                  :loops 636.8531190000001
                  :fibonacci 446.0390834285715}
   "Dart" {:fibonacci-hello-world 19.171383714285717
           :loops-hello-world 20.257360071428568
           :loops 693.7603811428572
           :fibonacci 904.279523857143}
   "PHP" {:fibonacci-hello-world 52.32488992857143
          :levenshtein-hello-world 54.58130635714285
          :loops-hello-world 51.488678642857145
          :levenshtein 772.9549345714286
          :loops 13158.492505857143
          :fibonacci 15584.512511857143}
   "Elixir" {:fibonacci-hello-world 267.54047335714284
             :loops-hello-world 260.66346742857144
             :loops 3168.6468867142858
             :fibonacci 1635.5696785714285}
   "Objective_C" {:levenshtein-hello-world 6.131062571428573
                  :levenshtein 18.205214142857145}
   "Python" {:fibonacci-hello-world 24.24740478571428
             :levenshtein-hello-world 22.923318500000004
             :loops-hello-world 21.969517928571427
             :levenshtein 940.273982
             :loops 44355.20441657143
             :fibonacci 26502.95378557143}
   "C_" {:fibonacci-hello-world 32.284050571428565
         :levenshtein-hello-world 33.29972928571429
         :loops-hello-world 32.132547428571435
         :levenshtein 53.34946414285714
         :loops 2110.3900417142854
         :fibonacci 560.7894522857143}
   "PyPy" {:fibonacci-hello-world 26.866372214285718
           :loops-hello-world 25.610984928571426
           :loops 3220.0822738571433
           :fibonacci 2290.675946285714}
   "Deno" {:fibonacci-hello-world 21.26566664285714
           :levenshtein-hello-world 23.42722914285714
           :loops-hello-world 21.03816385714286
           :levenshtein 65.9619702857143
           :loops 2007.8832202857143
           :fibonacci 1518.6950535714286}
   ;"Nim" {:levenshtein 48.44616657142858 :loops 636.3311904285715}
   "CPP" {:fibonacci-hello-world 2.6269613571428576
          :levenshtein-hello-world 3.3438125000000007
          :loops-hello-world 6.028928428571429
          :levenshtein 14.288410857142859
          :loops 641.7971607142857
          :fibonacci 489.09772642857155}
   "Kotlin_Native" {:fibonacci-hello-world 8.494836285714285
                    :loops-hello-world 6.124416785714286
                    :loops 2043.1683688571427
                    :fibonacci 505.0259465714286}
   "Fortran" {;:fibonacci-hello-world 6.746285714285714
              :levenshtein-hello-world 4.6467795714285725
              :loops-hello-world 3.5724078571428572
              :levenshtein 11.548131000000001
              :loops 630.856839
              ;:fibonacci 5.323130857142857
              }
   "Scala" {:fibonacci-hello-world 128.28978271428568
            :levenshtein-hello-world 133.0011757857143
            :loops-hello-world 127.92880935714285
            :levenshtein 199.70580957142857
            :loops 765.5166130000001
            :fibonacci 605.7578454285715}
   "Ruby" {:fibonacci-hello-world 38.31379764285714
           :levenshtein-hello-world 39.75900621428572
           :loops-hello-world 37.66666957142857
           :levenshtein 725.4287202857145
           :loops 38829.789607142855
           :fibonacci 13607.022862857144}
   "Rust" {:fibonacci-hello-world 2.6344375000000007
           :levenshtein-hello-world 3.2853602142857143
           :loops-hello-world 2.5925567142857147
           :levenshtein 31.502476142857137
           :loops 633.4474342857143
           :fibonacci 489.5977024285715}
   "Lua" {:fibonacci-hello-world 3.018130857142857
          :levenshtein-hello-world 6.4995985
          :loops-hello-world 3.408514857142858
          :levenshtein 543.783124857143
          :loops 51564.036125142855
          :fibonacci 11752.566750142858}
   "Deno__jitless_" {:fibonacci-hello-world 21.073351285714285
                     :levenshtein-hello-world 21.333663714285716
                     :loops-hello-world 21.757104214285718
                     :levenshtein 673.5369405714285
                     :loops 22314.473506000002
                     :fibonacci 19672.264893142856}
   "Bun_Scala_JS" {:fibonacci-hello-world 11.26206542857143
                   :levenshtein-hello-world 15.588598000000001
                   :loops-hello-world 11.50970828571429
                   :levenshtein 62.02771414285714
                   :loops 2088.1895772857147
                   :fibonacci 930.7532441428572}
   "Swift" {:fibonacci-hello-world 3.0792709285714293
            :levenshtein-hello-world 6.402633857142857
            :loops-hello-world 3.2910269285714273
            :levenshtein 43.86308900000001
            :loops 630.441256
            :fibonacci 657.6189285714286}
   "C" {:fibonacci-hello-world 2.595104285714286
        :levenshtein-hello-world 3.299095357142858
        :loops-hello-world 2.7909107142857144
        :levenshtein 14.559505999999999
        :loops 641.9182025714287
        :fibonacci 494.19741042857146}
   "C3" {:fibonacci-hello-world 3.1104255000000003
         :loops-hello-world 3.5494820714285713
         :loops 2593.0957200000003
         :fibonacci 900.9730891428571}
   "Clojure" {:fibonacci-hello-world 429.09149700000006
              :levenshtein-hello-world 437.81125000000003
              :loops-hello-world 438.29160428571436
              :levenshtein 526.5871964285716
              :loops 1095.9464522857143
              :fibonacci 927.3492382857143}
   "Bun" {:fibonacci-hello-world 10.022452357142859
          :levenshtein-hello-world 11.1725865
          :loops-hello-world 11.380562285714285
          :levenshtein 47.256851142857144
          :loops 2047.9484228571425
          :fibonacci 1098.8073154285714}
   "V" {:fibonacci-hello-world 3.248898785714286
        :levenshtein-hello-world 4.050229071428571
        :loops-hello-world 3.257723214285714
        :levenshtein 15.298887
        :loops 641.5237561428572
        :fibonacci 507.2950774285714}
   "Zig" {:fibonacci-hello-world 2.653595142857143
          :levenshtein-hello-world 3.364845285714286
          :loops-hello-world 4.625985214285715
          :levenshtein 14.757006
          :loops 632.9101365714286
          :fibonacci 502.4345891428572}
   "LuaJIT" {:fibonacci-hello-world 2.990279714285714
             :levenshtein-hello-world 6.469461357142857
             :loops-hello-world 3.030461285714286
             :levenshtein 46.74215485714286
             :loops 976.5968925714287
             :fibonacci 949.3298032857143}
   "F_" {:fibonacci-hello-world 35.833330214285716
         :levenshtein-hello-world 40.219467214285714
         :loops-hello-world 37.166172571428575
         :levenshtein 113.39911900000001
         :loops 2208.468988142857
         :fibonacci 532.5165597142857}
   "Scala_Native" {:fibonacci-hello-world 2.8317261428571423
                   :levenshtein-hello-world 3.9151371428571435
                   :loops-hello-world 3.262047571428571
                   :levenshtein 17.612035571428574
                   :loops 638.694517857143
                   :fibonacci 495.3183094285714}
   "COBOL" {:loops-hello-world 6.171211357142858 :loops 206364.28329171427}
   "PHP_JIT" {:fibonacci-hello-world 53.3928065
              :levenshtein-hello-world 55.75344649999999
              :loops-hello-world 53.23914578571429
              :levenshtein 236.18755957142858
              :loops 3226.062017571429
              :fibonacci 4161.069809571428}
   "Go" {:fibonacci-hello-world 3.3775297857142865
         :levenshtein-hello-world 3.7298542142857145
         :loops-hello-world 3.3146279285714284
         :levenshtein 20.511392857142855
         :loops 2059.748083285714
         :fibonacci 712.8407082857143}
   "Java" {:fibonacci-hello-world 65.99421135714286
           :levenshtein-hello-world 67.03420550000001
           :loops-hello-world 68.715006
           :levenshtein 129.8648095714286
           :loops 708.0519762857143
           :fibonacci 542.6615118571428}
   "Odin" {:fibonacci-hello-world 2.6435090000000008
           :levenshtein-hello-world 3.4435150714285716
           :loops-hello-world 4.004672642857143
           :levenshtein 17.897470142857145
           :loops 633.5089642857142
           :fibonacci 504.5191428571428}
   "Common_Lisp" {:fibonacci-hello-world 16.779386714285717
                  :levenshtein-hello-world 16.910253000000004
                  :loops-hello-world 19.469386857142858
                  :levenshtein 74.41837500000001
                  :loops 2800.810869
                  :fibonacci 1402.1260238571429}
   "Node" {:fibonacci-hello-world 44.68151792857143
           :levenshtein-hello-world 47.52867257142858
           :loops-hello-world 46.60002685714286
           :levenshtein 90.44641671428573
           :loops 2107.305029714286
           :fibonacci 1548.9960001428572}
   "Bun_Scala_JS_Compiled_" {:fibonacci-hello-world 11.197699571428574
                             :levenshtein-hello-world 17.021973142857146
                             :loops-hello-world 11.242348071428571
                             :levenshtein 61.21638671428571
                             :loops 2086.3242797142852
                             :fibonacci 930.7340000000002}})

