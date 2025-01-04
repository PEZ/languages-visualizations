(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein 250.5924999333334 :loops 2132.2735778}
   "Clojure_Native" {:hello-world 5.743747133333333
                     :levenshtein 35.769358399999994
                     :loops 640.7639833999998
                     :fibonacci 422.44730553333335}
   "Kotlin_JVM" {:hello-world 72.51250280000001
                 :loops 710.5418583333335
                 :fibonacci 540.2060334}
   "Emacs_Lisp_Native" {:hello-world 83.95011653333333
                        :loops 14513.198683333338
                        :fibonacci 2547.8591722666665}
   "Bun__Compiled_" {:hello-world 10.714808399999999
                     :levenshtein 46.18232213333333
                     :loops 2033.1790000666663
                     :fibonacci 899.2138333333336}
   "Ruby_YJIT" {:hello-world 38.420516733333336
                :levenshtein 331.15678899999995
                :loops 14487.3901498
                :fibonacci 2485.3152137333327}
   "Java_Native" {:hello-world 7.951158466666667
                  :levenshtein 35.182555666666666
                  :loops 639.9798471999999
                  :fibonacci 446.6989526}
   "Dart" {:hello-world 16.41613886666667
           :loops 683.8491196
           :fibonacci 903.0410029333332}
   "PHP" {:levenshtein 766.7488334666667
          :loops 13106.620861133337
          :fibonacci 15553.800125200003}
   "Elixir" {:hello-world 263.16582773333334
             :loops 3166.3342166666666
             :fibonacci 1562.7483443333333}
   "Objective_C" {:hello-world 3.944697400000001 :levenshtein 20.422244400000004}
   "Python" {:hello-world 24.476597133333332
             :levenshtein 928.6715333999999
             :loops 43609.1818472
             :fibonacci 26406.45868053333}
   "C_" {:hello-world 31.56798606666667
         :levenshtein 53.276247266666665
         :loops 2082.8393499333333
         :fibonacci 558.2478417333334}
   "Modula_2" {:hello-world 14.027941799999999}
   "PyPy" {:hello-world 27.267644333333337
           :loops 3282.174366799999
           :fibonacci 2286.6799222000004}
   "Deno" {:hello-world 19.977466466666666
           :levenshtein 65.0727806
           :loops 2003.1672028666665
           :fibonacci 1515.008749933333}
   "Nim" {:levenshtein 44.43211666666667 :loops 632.3992222000002}
   "CPP" {:hello-world 2.705119266666667
          :levenshtein 15.236433266666666
          :loops 635.6531028666667
          :fibonacci 490.9502611333334}
   "Kotlin_Native" {:hello-world 5.096855600000001
                    :loops 2037.6013027333336
                    :fibonacci 506.0855889333333}
   "Fortran" {:hello-world 3.6706584666666666
              :levenshtein 10.897280666666667
              :loops 631.5926083333334
              ;:fibonacci 5.242308466666667
              }
   "Scala" {:hello-world 127.28201380000002
            :levenshtein 199.33027499999997
            :loops 761.6566916666668
            :fibonacci 601.7186471333334}
   "Ruby" {:hello-world 37.398527666666666
           :levenshtein 713.6059584000001
           :loops 38287.36013333333
           :fibonacci 13325.350055666666}
   "Rust" {:hello-world 3.0137194666666667
           :levenshtein 30.13900833333334
           :loops 632.9700888666667
           :fibonacci 488.80039446666666}
   "Lua" {:hello-world 3.022791666666667
          :levenshtein 541.3753664666667
          :loops 51138.5689916
          :fibonacci 11741.389661333335}
   "Deno__jitless_" {:hello-world 22.278341466666667
                     :levenshtein 660.9332388666668
                     :loops 21986.3753056
                     :fibonacci 19585.78662233333}
   "Bun_Scala_JS" {:hello-world 13.679714000000002
                   :levenshtein 63.38869173333334
                   :loops 2084.3375444666667
                   :fibonacci 929.4886971333334}
   "Swift" {:hello-world 3.3222250000000004
            :levenshtein 43.604005666666666
            :loops 629.7559859999999
            :fibonacci 654.8666165333332}
   "C" {:hello-world 2.8338415333333336
        :levenshtein 15.422083333333333
        :loops 637.4260306666667
        :fibonacci 490.05551940000004}
   "C3" {:hello-world 3.316269266666666
         :loops 2553.0273556
         :fibonacci 895.5360694000001}
   "Clojure" {:hello-world 435.6182860000001
              :levenshtein 517.8706139333333
              :loops 1085.1379113333332
              :fibonacci 930.1996167333333}
   "Bun" {:hello-world 10.166908200000002
          :levenshtein 46.01786100000001
          :loops 2028.0975055333333
          :fibonacci 1106.8034056}
   "V" {:hello-world 3.378619466666667
        :levenshtein 16.8474334
        :loops 636.0954528
        :fibonacci 502.73222786666673}
   "Zig" {:hello-world 2.8336249999999996
          :levenshtein 13.619152733333335
          :loops 635.0024167333333
          :fibonacci 503.3477750000002}
   "Free_Pascal" {:levenshtein 24.33544993333334
                  :loops 2168.655575
                  :fibonacci 842.6177667333334}
   "LuaJIT" {:hello-world 2.854261133333334
             :levenshtein 44.86136380000001
             :loops 976.2590027333334
             :fibonacci 962.631114}
   "F_" {:hello-world 37.50984166666668
         :levenshtein 116.40164159999999
         :loops 2198.9376527333334
         :fibonacci 530.2439695333333}
   "Scala_Native" {:hello-world 3.3661443999999996
                   :levenshtein 16.75780826666667
                   :loops 638.5016361333335
                   :fibonacci 493.103964}
   "COBOL" {:hello-world 5.5250498 :loops 205541.19756106669}
   "PHP_JIT" {:levenshtein 230.29088606666667
              :loops 3227.4057583333333
              :fibonacci 4090.5695472}
   "Go" {:hello-world 3.2392805333333334
         :levenshtein 20.610794400000003
         :loops 2051.6938946
         :fibonacci 713.7793416666668}
   "Java" {:hello-world 65.70854146666666
           :levenshtein 124.55507513333333
           :loops 707.1754943333333
           :fibonacci 534.6286222666668}
   "Odin" {:hello-world 2.7659306000000004
           :levenshtein 13.448149933333335
           :loops 632.4072277333333
           :fibonacci 506.1385999333333}
   "Common_Lisp" {:hello-world 20.12446673333334
                  :levenshtein 73.91378886666668
                  :loops 2771.3611973333336
                  :fibonacci 1401.1101418}
   "Node" {:hello-world 45.3648278
           :levenshtein 88.61598053333334
           :loops 2111.757013733333
           :fibonacci 1541.2265943333337}
   "Bun_Scala_JS_Compiled_" {:hello-world 11.138622200000002
                             :levenshtein 61.728602800000004
                             :loops 2077.9651971999997
                             :fibonacci 928.3328750000001}})

