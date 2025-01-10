(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein 925.6380166666667 :loops 2174.0608889333334}
   "Clojure_Native" {:hello-world 5.975552666666665
                     :levenshtein 1626.2045387333333
                     :loops 657.3596111333335
                     :fibonacci 429.1961972000001}
   "Kotlin_JVM"
   {:hello-world 77.2805222 :loops 725.9792806 :fibonacci 545.8078472000001}
   "Emacs_Lisp_Native" {:hello-world 84.37614453333335
                        :loops 14827.55346086667
                        :fibonacci 2606.122363933333}
   "Bun__Compiled_" {:hello-world 11.121652733333331
                     :levenshtein 1576.5594832666668
                     :loops 2075.6314444666664
                     :fibonacci 910.8083222666667}
   "Ruby_YJIT" {:hello-world 37.709141733333325
                :levenshtein 15572.550460933333
                :loops 14864.009105466668
                :fibonacci 2536.1772916000004}
   "Java_Native" {:hello-world 5.590919466666666
                  :levenshtein 1503.9890639333332
                  :loops 653.4373806666666
                  :fibonacci 453.3366804666667}
   "Dart" {:hello-world 16.307169466666668
           :loops 697.0377278666667
           :fibonacci 917.7332556666665}
   "PHP" {:levenshtein 39215.14761393334
          :loops 13383.253027999997
          :fibonacci 15842.513947266667}
   "Elixir"
   {:hello-world 272.6698112 :loops 3240.9938472 :fibonacci 1689.564869533333}
   "Objective_C" {:hello-world 3.7503916666666663 :levenshtein 713.0635082666669}
   "F__AOT" {:hello-world 5.817058333333334
             :levenshtein 1608.4901196666665
             :loops 2132.8318418
             :fibonacci 648.8464694}
   "Python" {:hello-world 23.551425000000002
             :levenshtein 68494.39643060001
             :loops 45124.316536133345
             :fibonacci 27119.055558466665}
   "C_" {:hello-world 33.190827733333336
         :levenshtein 1320.369036066667
         :loops 2166.8748110666666
         :fibonacci 560.6301108666668}
   "Modula_2" {:hello-world 13.556508333333333}
   "PyPy"
   {:hello-world 26.301155466666675 :loops 3183.7710972 :fibonacci 2325.6240444}
   "Deno" {:hello-world 21.32788613333333
           :levenshtein 2336.3770581999997
           :loops 2055.8857500666663
           :fibonacci 1538.9800111333334}
   "Nim" {:levenshtein 2340.4296442666664 :loops 645.1861609333332}
   "CPP" {:hello-world 3.0798307333333335
          :levenshtein 703.7661028
          :loops 650.1137054666668
          :fibonacci 501.9833833999999}
   "Kotlin_Native"
   {:hello-world 5.526880600000001 :loops 2081.2762666 :fibonacci 514.2941556}
   "Fortran" {:hello-world 3.780869333333334
              :levenshtein 584.6133474000001
              :loops 644.7547608666666
              :fibonacci 5.303225066666666}
   "Scala" {:hello-world 131.82109173333333
            :levenshtein 1262.2593362
            :loops 780.4448194666667
            :fibonacci 617.1604943333334}
   "Ruby" {:hello-world 38.03203893333334
           :levenshtein 35881.84545553334
           :loops 39209.86203893334
           :fibonacci 13670.12023886667}
   "Rust" {:hello-world 3.3172667333333337
           :levenshtein 1534.2225138666668
           :loops 645.1905333999999
           :fibonacci 498.87655813333345}
   "Lua" {:hello-world 3.408372333333334
          :levenshtein 28836.916827933328
          :loops 52136.96370826666
          :fibonacci 11814.454285933334}
   "Deno__jitless_" {:hello-world 21.882141533333332
                     :levenshtein 33604.1594056
                     :loops 22597.78481113333
                     :fibonacci 19988.30048606667}
   "Bun_Scala_JS" {:hello-world 11.479208266666669
                   :levenshtein 1539.2347307333334
                   :loops 2125.89565
                   :fibonacci 945.7668748}
   "Swift" {:hello-world 3.084783333333333
            :levenshtein 746.6501166666665
            :loops 642.5357778000001
            :fibonacci 668.8809696}
   "R" {:levenshtein 221101.79456119996 :fibonacci 92921.76577233334}
   "C" {:hello-world 2.8221890666666667
        :levenshtein 729.660894466667
        :loops 650.3999862000001
        :fibonacci 501.0528304666667}
   "C3" {:hello-world 5.079347200000001
         :loops 2686.3378305333326
         :fibonacci 911.1861361333333}
   "Clojure" {:hello-world 431.2018194
              :levenshtein 2074.9292054666666
              :loops 1092.0136555333333
              :fibonacci 926.1156499999998}
   "Bun" {:hello-world 11.641202800000002
          :levenshtein 1578.757088933333
          :loops 2074.0925499333334
          :fibonacci 1117.2665028}
   "C__AOT" {:hello-world 4.955085933333335
             :levenshtein 1292.8886553999996
             :loops 2127.103802599999
             :fibonacci 642.9658000000001}
   "V" {:hello-world 3.483047400000001
        :levenshtein 733.0816277333336
        :loops 648.3307277999999
        :fibonacci 513.8308110666666}
   "Zig" {:hello-world 3.1042804
          :levenshtein 773.2873472
          :loops 647.1213056666667
          :fibonacci 512.1839167333333}
   "Racket" {:hello-world 50.35637766666667
             :levenshtein 6037.192766666667
             :loops 2291.8697832666667
             :fibonacci 978.4668112000002}
   "Free_Pascal" {:levenshtein 270.23485293333334
                  :loops 2210.2778222
                  :fibonacci 857.5081861333333}
   "LuaJIT" {:hello-world 2.9315417333333333
             :levenshtein 1246.4914778666666
             :loops 992.7738583333335
             :fibonacci 951.901483466667}
   "F_" {:hello-world 36.393038866666664
         :levenshtein 1573.6551888000004
         :loops 2247.907963866667
         :fibonacci 538.3438473333334}
   "Scala_Native" {:hello-world 3.7906612000000006
                   :levenshtein 764.5793749999999
                   :loops 650.4312418
                   :fibonacci 500.06550006666663}
   "COBOL" {:hello-world 5.690088733333335 :loops 210210.51394733335}
   "PHP_JIT"
   {:levenshtein 9788.4612222 :loops 3286.532544266667 :fibonacci 4197.4702166}
   "Go" {:hello-world 3.7727472
         :levenshtein 1188.4626584
         :loops 2121.5666194000005
         :fibonacci 726.3495332666668}
   "Java" {:hello-world 72.05546673333333
           :levenshtein 1017.4809195333335
           :loops 724.5354000666669
           :fibonacci 542.3136889333334}
   "Odin" {:hello-world 2.9674221999999997
           :levenshtein 705.5938554666668
           :loops 644.3413304666666
           :fibonacci 513.5786666666668}
   "Node" {:hello-world 45.29790833333333
           :levenshtein 2382.941488866666
           :loops 2143.7582001333335
           :fibonacci 1569.094325066667}
   "Bun_Scala_JS_Compiled_" {:hello-world 11.065816733333332
                             :levenshtein 1531.7055055333337
                             :loops 2122.0133193333336
                             :fibonacci 945.3775973333335}})

