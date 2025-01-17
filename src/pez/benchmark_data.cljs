(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein 972.7283888666668 :loops 2208.5497249333334}
   "Clojure_Native" {:hello-world 7.021066733333332
                     :levenshtein 1650.831564
                     :loops 667.5466027999998
                     :fibonacci 422.132886}
   "Kotlin_JVM" {:hello-world 91.18588060000002
                 :loops 751.5554946000001
                 :fibonacci 573.9333444000001}
   "Emacs_Lisp_Native" {:hello-world 91.38228886666667
                        :loops 15008.838816733336
                        :fibonacci 2636.9255388}
   "Bun__Compiled_" {:hello-world 12.440077800000001
                     :levenshtein 1601.2581222000001
                     :loops 2092.0195723333336
                     :fibonacci 909.9523556000001}
   "Ruby_YJIT" {:hello-world 40.76618053333334
                :levenshtein 15939.175110999999
                :loops 14970.851113933333
                :fibonacci 2566.7175444}
   "Java_Native" {:hello-world 6.472961200000001
                  :levenshtein 1529.8319416000004
                  :loops 663.1550944000002
                  :fibonacci 460.0822248666667}
   "Dart" {:hello-world 20.854488733333337
           :loops 706.2091529333334
           :fibonacci 913.7045807333333}
   "PHP" {:levenshtein 39664.91024993334
          :loops 13521.171989
          :fibonacci 16080.642922200002}
   "Elixir" {:hello-world 275.422861
             :loops 3288.440574866667
             :fibonacci 1613.7779194000002}
   "Objective_C" {:hello-world 4.5059417333333345
                  :levenshtein 722.9879249333334
                  :loops 657.4057528666668
                  :fibonacci 506.7164473333333}
   "F__AOT" {:hello-world 6.249611266666667
             :levenshtein 1626.5963917333336
             :loops 2136.061375066666
             :fibonacci 658.7151139333333}
   "Python" {:hello-world 23.954886133333336
             :levenshtein 68944.05976386665
             :loops 45287.993269266655
             :fibonacci 27303.1607944}
   "C_" {:hello-world 34.39518900000001
         :levenshtein 1342.5076473333336
         :loops 2168.6736333999997
         :fibonacci 557.5641585333334}
   "Modula_2" {:hello-world 15.678333400000001}
   "PyPy" {:hello-world 30.14934446666667
           :loops 3304.984638933334
           :fibonacci 2364.332119466667}
   "Deno" {:hello-world 22.930069600000003
           :levenshtein 2370.0150304000003
           :loops 2071.532372266667
           :fibonacci 1556.1772195333335}
   "Nim" {:levenshtein 2363.1157612000006 :loops 650.5611668000001}
   "CPP" {:hello-world 4.686325133333334
          :levenshtein 711.1546583333335
          :loops 656.7976584
          :fibonacci 487.43505260000006}
   "Kotlin_Native" {:hello-world 6.388769533333334
                    :loops 2106.4519084666667
                    :fibonacci 521.8322970666668}
   "Fortran" {:hello-world 4.7212445333333335
              :levenshtein 593.8907166000001
              :loops 652.9967361333335
              :fibonacci 5.813650066666666}
   "Scala" {:hello-world 145.2315804
            :levenshtein 1286.1487749333332
            :loops 803.8308946000001
            :fibonacci 636.3751193333335}
   "Ruby" {:hello-world 42.53522206666667
           :levenshtein 36293.64546653334
           :loops 39417.03442526667
           :fibonacci 13774.4103944}
   "Rust" {:hello-world 3.617661266666667
           :levenshtein 1547.1667501333334
           :loops 653.5243388000001
           :fibonacci 506.53324433333336}
   "Lua" {:hello-world 3.8288111333333337
          :levenshtein 29056.02324166667
          :loops 52860.084636333326
          :fibonacci 12120.690972333334}
   "Deno__jitless_" {:hello-world 22.590072266666667
                     :levenshtein 33948.5136722
                     :loops 22716.66310553333
                     :fibonacci 20418.879244333333}
   "Bun_Scala_JS" {:hello-world 13.083099933333333
                   :levenshtein 1548.7564861333333
                   :loops 2149.6681693333335
                   :fibonacci 956.4450054666668}
   "Swift" {:hello-world 3.7037778666666665
            :levenshtein 749.8512414666667
            :loops 650.5769528
            :fibonacci 676.8415918000001}
   "R" {:levenshtein 226183.52920846667 :fibonacci 93779.71895280002}
   "C" {:hello-world 6.1798111333333345
        :levenshtein 593.2985748666667
        :loops 678.0700388
        :fibonacci 266.07882493333335}
   "C3" {:hello-world 5.649569333333335
         :loops 2669.2820192
         :fibonacci 893.3126166666665}
   "Clojure" {:hello-world 456.6315528
              :levenshtein 2128.5447139999997
              :loops 1115.5892194
              :fibonacci 923.4781944666667}
   "Bun" {:hello-world 11.081277866666666
          :levenshtein 1600.3298194666668
          :loops 2090.2110525333333
          :fibonacci 1100.2985222000002}
   "C__AOT" {:hello-world 6.080230733333334
             :levenshtein 1311.5449416666668
             :loops 2133.0816833333333
             :fibonacci 627.426189}
   "V" {:hello-world 3.9899693333333337
        :levenshtein 742.1709111333334
        :loops 657.9033972
        :fibonacci 520.0666195333334}
   "Zig" {:hello-world 3.3069055333333335
          :levenshtein 758.0950083333335
          :loops 654.5473165999999
          :fibonacci 519.9720028666667}
   "Racket" {:hello-world 52.1601306
             :levenshtein 6105.009930599999
             :loops 2306.4440055333334
             :fibonacci 992.7047528666667}
   "Free_Pascal"
   {#_#_:levenshtein 275.30683600000003 :loops 2236.6932972 :fibonacci 870.4411112}
   "LuaJIT" {:hello-world 4.003130466666668
             :levenshtein 1262.7826165999998
             :loops 1008.0857279333333
             :fibonacci 971.1030333333334}
   "F_" {:hello-world 41.41702506666667
         :levenshtein 1596.5275528
         :loops 2277.2461666000004
         :fibonacci 549.1431943333332}
   "Scala_Native" {:hello-world 3.5982360666666673
                   :levenshtein 770.8656640666667
                   :loops 656.5076639333332
                   :fibonacci 505.4111750000001}
   "COBOL" {:hello-world 6.046152733333333 :loops 211890.0310084}
   "PHP_JIT" {:levenshtein 9878.281416533333
              :loops 3332.8938915999997
              :fibonacci 4227.4803888666665}
   "Go" {:hello-world 4.194122133333335
         :levenshtein 1198.7012112
         :loops 2134.0265638666665
         :fibonacci 737.0247194666669}
   "Java" {:hello-world 86.5235584
           :levenshtein 1045.6651584666668
           :loops 741.1567000666666
           :fibonacci 572.1541890666667}
   "Odin" {:hello-world 3.4227973333333335
           :levenshtein 712.6277554000001
           :loops 652.8568249999998
           :fibonacci 520.3875166666667}
   "Node" {:hello-world 47.11314446666667
           :levenshtein 2405.9340249333336
           :loops 2177.3863057333333
           :fibonacci 1590.6922499333336}
   "Bun_Scala_JS_Compiled_" {:hello-world 12.873013866666668
                             :levenshtein 1541.6338526000002
                             :loops 2146.4449806666667
                             :fibonacci 958.1158584666666}})

