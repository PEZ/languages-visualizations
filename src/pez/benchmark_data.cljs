(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein-hello-world 247.7863244285714
            :loops-hello-world 238.20539578571427
            :levenshtein 247.707726
            :loops 2132.7385595714286}
   "Clojure_Native" {:fibonacci-hello-world 5.726366000000001
                     :levenshtein-hello-world 6.5051250000000005
                     :loops-hello-world 6.2776665000000005
                     :levenshtein 36.77423814285714
                     :loops 689.2010118571428
                     :fibonacci 474.0770534285715}
   "Kotlin_JVM" {:fibonacci-hello-world 72.05775307142858
                 :loops-hello-world 73.87602371428572
                 :loops 709.0153214285715
                 :fibonacci 542.6649702857144}
   "Emacs_Lisp_Native" {:fibonacci-hello-world 84.06069957142856
                        :loops-hello-world 83.85592857142858
                        :loops 14528.91811928571
                        :fibonacci 2544.485024}
   "Bun__Compiled_" {:fibonacci-hello-world 11.7198185
                     :levenshtein-hello-world 11.892229214285717
                     :loops-hello-world 11.624634071428572
                     :levenshtein 49.57466657142857
                     :loops 2036.6582977142857
                     :fibonacci 896.56222}
   "Ruby_YJIT" {:fibonacci-hello-world 39.23086621428572
                :levenshtein-hello-world 40.51562800000001
                :loops-hello-world 38.67560135714286
                :levenshtein 355.20363685714284
                :loops 14528.925470142856
                :fibonacci 2488.692012}
   "Java_Native" {:fibonacci-hello-world 5.402238
                  :levenshtein-hello-world 5.713622142857144
                  :loops-hello-world 5.082104142857142
                  :levenshtein 37.212559428571424
                  :loops 688.7398694285714
                  :fibonacci 491.012476}
   "Dart" {:fibonacci-hello-world 17.21121728571429
           :loops-hello-world 17.424041785714284
           :loops 683.7294464285716
           :fibonacci 902.6497144285714}
   "PHP" {:fibonacci-hello-world 52.326315214285714
          :levenshtein-hello-world 52.49495521428572
          :loops-hello-world 51.90543735714286
          :levenshtein 773.9296961428572
          :loops 13129.274934428571
          :fibonacci 15580.923315285714}
   "Elixir" {:fibonacci-hello-world 261.2962145000001
             :loops-hello-world 259.1882113571429
             :loops 3165.7846845714284
             :fibonacci 1565.502809428571}
   "Objective_C" {:levenshtein-hello-world 3.9258035714285713
                  :levenshtein 17.972827}
   "Python" {:fibonacci-hello-world 22.105032857142852
             :levenshtein-hello-world 22.60919057142857
             :loops-hello-world 21.762970214285712
             :levenshtein 942.3880532857145
             :loops 44153.004982285725
             :fibonacci 26438.793160714285}
   "C_" {:fibonacci-hello-world 30.735589357142857
         :levenshtein-hello-world 32.2005505
         :loops-hello-world 34.354116285714284
         :levenshtein 53.28379171428571
         :loops 2092.879553714286
         :fibonacci 558.1334642857144}
   "PyPy" {:fibonacci-hello-world 25.524041642857142
           :loops-hello-world 27.09402392857143
           :loops 3243.377440857143
           :fibonacci 2285.6600358571427}
   "Deno" {:fibonacci-hello-world 20.940288714285717
           :levenshtein-hello-world 21.813773785714286
           :loops-hello-world 20.927818357142858
           :levenshtein 65.70019642857145
           :loops 2007.6335534285715
           :fibonacci 1510.9762857142857}
   ;"Nim" {:levenshtein 45.70647014285715 :loops 633.8165835714286}
   "CPP" {:fibonacci-hello-world 2.447166571428572
          :levenshtein-hello-world 3.4427530714285717
          :loops-hello-world 2.6053033571428577
          :levenshtein 18.95098828571429
          :loops 635.0266428571429
          :fibonacci 489.9393747142857}
   "Kotlin_Native" {:fibonacci-hello-world 8.109925714285714
                    :loops-hello-world 5.503458357142857
                    :loops 2045.9149049999996
                    :fibonacci 508.3088572857143}
   "Fortran" {;:fibonacci-hello-world 3.8033899285714288
              :levenshtein-hello-world 4.512136714285715
              :loops-hello-world 3.4801161428571423
              :levenshtein 11.216904857142858
              :loops 631.3059524285715
              ;:fibonacci 5.1150654285714285
              }
   "Scala" {:fibonacci-hello-world 125.7635
            :levenshtein-hello-world 131.457985
            :loops-hello-world 127.2375507857143
            :levenshtein 202.939649
            :loops 762.4824227142859
            :fibonacci 600.1305060000001}
   "Ruby" {:fibonacci-hello-world 37.57520242857143
           :levenshtein-hello-world 38.60414892857143
           :loops-hello-world 37.627503214285724
           :levenshtein 722.2259581428573
           :loops 38701.944255857146
           :fibonacci 13397.773107}
   "Rust" {:fibonacci-hello-world 2.8322795714285713
           :levenshtein-hello-world 3.4928691428571432
           :loops-hello-world 2.744862928571429
           :levenshtein 31.08093457142857
           :loops 636.3542080000001
           :fibonacci 492.2742141428572}
   "Lua" {:fibonacci-hello-world 2.958345142857143
          :levenshtein-hello-world 3.4775654999999994
          :loops-hello-world 3.0591935
          :levenshtein 546.6423689999999
          :loops 51346.60945257143
          :fibonacci 11757.542285714284}
   "Deno__jitless_" {:fibonacci-hello-world 20.724205500000004
                     :levenshtein-hello-world 21.57759542857143
                     :loops-hello-world 22.71896135714286
                     :levenshtein 673.4836489999999
                     :loops 22212.98677971428
                     :fibonacci 19680.781356999996}
   "Bun_Scala_JS" {:fibonacci-hello-world 11.370017714285714
                   :levenshtein-hello-world 15.065756000000004
                   :loops-hello-world 13.535125071428576
                   :levenshtein 62.084851571428565
                   :loops 2085.2668569999996
                   :fibonacci 932.9119881428572}
   "Swift" {:fibonacci-hello-world 3.1644404285714294
            :levenshtein-hello-world 3.3850862857142854
            :loops-hello-world 2.8907796428571433
            :levenshtein 43.42485128571428
            :loops 631.5692321428571
            :fibonacci 658.2127258571428}
   "C" {:fibonacci-hello-world 2.546461357142857
        :levenshtein-hello-world 3.131467214285715
        :loops-hello-world 2.776681571428571
        :levenshtein 14.438821428571432
        :loops 640.7297858571427
        :fibonacci 490.07219628571437}
   "C3" {:fibonacci-hello-world 3.178047785714286
         :loops-hello-world 4.054625071428571
         :loops 2568.5184345714283
         :fibonacci 894.9278871428572}
   "Bun" {:fibonacci-hello-world 10.114574500000002
          :levenshtein-hello-world 12.37843435714286
          :loops-hello-world 12.189803428571427
          :levenshtein 47.38651785714286
          :loops 2038.9149761428573
          :fibonacci 1091.3566487142857}
   "V" {:fibonacci-hello-world 3.222035857142858
        :levenshtein-hello-world 4.164985214285714
        :loops-hello-world 3.135672714285714
        :levenshtein 18.800595285714287
        :loops 637.850125
        :fibonacci 503.3866905714286}
   "Zig" {:fibonacci-hello-world 2.7329135
          :levenshtein-hello-world 3.4158509999999995
          :loops-hello-world 2.6164017857142863
          :levenshtein 14.107303285714288
          :loops 633.9020295714286
          :fibonacci 505.655988}
   "LuaJIT" {:fibonacci-hello-world 2.8749495
             :levenshtein-hello-world 3.3355625
             :loops-hello-world 2.8934135714285723
             :levenshtein 46.32618457142858
             :loops 978.875910857143
             :fibonacci 952.0719642857144}
   "F_" {:fibonacci-hello-world 35.511624999999995
         :levenshtein-hello-world 39.481181428571425
         :loops-hello-world 35.357895785714284
         :levenshtein 113.12598228571431
         :loops 2203.791279714286
         :fibonacci 532.4649462857143}
   "Scala_Native" {:fibonacci-hello-world 3.0902201428571434
                   :levenshtein-hello-world 5.050124857142858
                   :loops-hello-world 3.057455428571429
                   :levenshtein 17.140893000000002
                   :loops 639.356994
                   :fibonacci 493.4630055714286}
   "COBOL" {:loops-hello-world 6.165470285714286 :loops 205812.56835128576}
   "PHP_JIT" {:fibonacci-hello-world 53.45619935714286
              :levenshtein-hello-world 53.261151999999996
              :loops-hello-world 52.00208914285715
              :levenshtein 234.27536328571432
              :loops 3227.1193928571433
              :fibonacci 4074.957101}
   "Go" {:fibonacci-hello-world 3.2238332857142855
         :levenshtein-hello-world 3.7257857857142853
         :loops-hello-world 3.1570176428571433
         :levenshtein 23.621869142857143
         :loops 2058.966267857143
         :fibonacci 712.3275240000002}
   "Java" {:fibonacci-hello-world 65.21205657142858
           :levenshtein-hello-world 67.31384807142857
           :loops-hello-world 64.9917977857143
           :levenshtein 128.38932128571432
           :loops 703.067988
           :fibonacci 534.5012797142858}
   "Odin" {:fibonacci-hello-world 2.5780030000000003
           :levenshtein-hello-world 3.3774225714285717
           :loops-hello-world 2.630827357142858
           :levenshtein 19.42841657142857
           :loops 637.0094407142857
           :fibonacci 504.0921072857143}
   "Node" {:fibonacci-hello-world 44.41768457142858
           :levenshtein-hello-world 46.05727100000001
           :loops-hello-world 44.45195814285715
           :levenshtein 89.38507771428571
           :loops 2108.6145475714284
           :fibonacci 1546.2016605714284}
   "Bun_Scala_JS_Compiled_" {:fibonacci-hello-world 11.072663714285715
                             :levenshtein-hello-world 12.046666714285713
                             :loops-hello-world 11.061369142857144
                             :levenshtein 60.47729757142857
                             :loops 2080.2555712857143
                             :fibonacci 930.6451605714285}})

