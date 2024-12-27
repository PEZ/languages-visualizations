(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein-hello-world 198.960111
            :loops-hello-world 206.38886100000002
            :levenshtein 187.25968066666667
            :loops 884.564764}
   "Clojure_Native" {:fibonacci-hello-world 4.645805333333334
                     :levenshtein-hello-world 5.556360666666667
                     :loops-hello-world 4.441347333333334
                     :levenshtein 19.637694333333332
                     :loops 483.91808333333336
                     :fibonacci 307.59337533333337}
   "Kotlin_JVM" {:fibonacci-hello-world 53.964722333333334
                 :loops-hello-world 54.16216666666667
                 :loops 537.7727216666668
                 :fibonacci 346.9430556666667}
   "Bun__Compiled_" {:levenshtein-hello-world 12.674902333333335
                     :levenshtein 37.48947233333334}
   "Ruby_YJIT" {:fibonacci-hello-world 30.425236000000005
                :levenshtein-hello-world 31.157930333333333
                :loops-hello-world 35.712180000000004
                :levenshtein 215.33159733333332
                :loops 9985.363777333334
                :fibonacci 1478.648041666667}
   "Java_Native" {:fibonacci-hello-world 4.670069333333334
                  :levenshtein-hello-world 4.154458000000001
                  :loops-hello-world 5.068708000000001
                  :levenshtein 24.480208333333337
                  :loops 492.6181113333334
                  :fibonacci 281.0415}
   "PHP" {:fibonacci-hello-world 40.81051366666667
          :levenshtein-hello-world 40.33198633333333
          :loops-hello-world 43.37943066666667
          :levenshtein 560.3877500000002
          :loops 7820.380736333334
          :fibonacci 9974.719111333334}
   "Elixir" {:fibonacci-hello-world 200.5854446666667
             :loops-hello-world 199.90933333333336
             :loops 2017.87575
             :fibonacci 978.0331530000001}
   "MAWK" {:fibonacci-hello-world 4.229111
           :levenshtein-hello-world 3.1726940000000003
           :loops-hello-world 3.6829166666666664
           :levenshtein 1529.0968749999997
           :loops 28569.895583333335
           :fibonacci 13836.777957999999}
   "Objective_C" {:levenshtein-hello-world 4.710888666666667
                  :levenshtein 14.187916666666668}
   "Python" {:fibonacci-hello-world 19.100013666666666
             :levenshtein-hello-world 20.085819333333333
             :loops-hello-world 19.899291666666667
             :levenshtein 617.5639586666667
             :loops 27957.689139
             :fibonacci 17772.851527666666}
   "PyPy" {:fibonacci-hello-world 23.024972333333334
           :loops-hello-world 21.971472333333335
           :loops 2278.1748893333333
           :fibonacci 1696.91425}
   "Deno" {:fibonacci-hello-world 25.963986000000006
           :levenshtein-hello-world 26.07819466666667
           :loops-hello-world 25.313638666666666
           :levenshtein 58.15137533333334
           :loops 746.8394163333332
           :fibonacci 962.3555693333334}
   "CPP" {:fibonacci-hello-world 2.127541666666667
          :levenshtein-hello-world 2.1338056666666665
          :loops-hello-world 2.1130833333333334
          :levenshtein 8.747291999999998
          :loops 471.74037533333336
          :fibonacci 275.082875}
   "Fortran" {:levenshtein-hello-world 3.140152666666667 :levenshtein 7.516375}
   "Ruby" {:fibonacci-hello-world 31.349791666666675
           :loops-hello-world 30.881652666666664
           :loops 29514.90427733333
           :fibonacci 11681.001499999998}
   "Rust" {:fibonacci-hello-world 2.210541666666667
           :levenshtein-hello-world 2.703139
           :loops-hello-world 2.3963333333333336
           :levenshtein 12.493625000000002
           :loops 509.4597080000001
           :fibonacci 285.57069500000006}
   "Lua" {:fibonacci-hello-world 4.334069333333334
          :levenshtein-hello-world 2.9582360000000008
          :loops-hello-world 2.991902666666667
          :levenshtein 341.61290266666674
          :loops 34184.123347
          :fibonacci 6390.944902666667}
   "Swift" {:fibonacci-hello-world 3.5954583333333336
            :levenshtein-hello-world 2.551013666666667
            :levenshtein 25.946222666666667
            :fibonacci 402.37181966666674}
   "C" {:fibonacci-hello-world 2.496680666666667
        :levenshtein-hello-world 2.352
        :loops-hello-world 2.260541666666667
        :levenshtein 8.761861000000001
        :loops 473.3396666666667
        :fibonacci 255.58393066666667}
   "Clojure" {:fibonacci-hello-world 302.2928613333334
              :levenshtein-hello-world 297.80970833333333
              :loops-hello-world 302.79800033333333
              :levenshtein 350.002611
              :loops 782.966208
              :fibonacci 863.9085416666667}
   "Bun" {:levenshtein-hello-world 12.147694333333334
          :levenshtein 39.482735999999996}
   "V" {:fibonacci-hello-world 3.7320420000000003
        :levenshtein-hello-world 2.946417
        :levenshtein 9.325055666666668
        :fibonacci 290.8742223333333}
   "Zig" {:fibonacci-hello-world 2.3704306666666666
          :levenshtein-hello-world 2.3439163333333335
          :loops-hello-world 2.5930830000000005
          :levenshtein 10.611444666666669
          :loops 510.23815266666674
          :fibonacci 333.71108333333336}
   "Java_GraalVM" {:levenshtein-hello-world 4.8957776666666675
                   :loops-hello-world 4.161638666666666
                   :levenshtein 24.96037466666667
                   :loops 497.2625973333334}
   "LuaJIT" {:fibonacci-hello-world 3.2337913333333335
             :levenshtein-hello-world 3.1818473333333332
             :levenshtein 29.637639000000004
             :fibonacci 615.5055696666668}
   "PHP_JIT" {:fibonacci-hello-world 41.74606966666667
              :levenshtein-hello-world 39.47055533333333
              :loops-hello-world 44.56580533333334
              :levenshtein 160.56829166666668
              :loops 2141.865777666667
              :fibonacci 4094.857125}
   "Java" {:fibonacci-hello-world 51.319472000000005
           :levenshtein-hello-world 50.96341666666667
           :loops-hello-world 52.246624999999995
           :levenshtein 94.415
           :loops 535.1322500000001
           :fibonacci 345.01050000000004}
   "Odin" {:fibonacci-hello-world 2.2983890000000002
           :levenshtein-hello-world 2.5410973333333335
           :levenshtein 12.334041333333335
           :fibonacci 333.70308300000005}
   "Node" {:fibonacci-hello-world 29.924264
           :levenshtein-hello-world 29.062764
           :loops-hello-world 30.60455566666667
           :levenshtein 58.425389
           :loops 797.5586386666666
           :fibonacci 882.6181803333335}})


