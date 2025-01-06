(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein 937.3119111333334 :loops 2149.377080533334}
   "Clojure_Native" {:hello-world 6.400174933333334
                     :levenshtein 1620.7152777999997
                     :loops 651.1665166666667
                     :fibonacci 431.20506393333335}
   "Kotlin_JVM" {:hello-world 75.60078626666667
                 :loops 718.1704277333334
                 :fibonacci 548.2312472666667}
   "Emacs_Lisp_Native" {:hello-world 85.36318899999999
                        :loops 14785.459105533333
                        :fibonacci 2603.175449933333}
   "Bun__Compiled_" {:hello-world 11.926219466666668
                     :levenshtein 1580.8977776666668
                     :loops 2061.780886266667
                     :fibonacci 913.2984501333333}
   "Ruby_YJIT" {:hello-world 39.51826113333334
                :levenshtein 15764.08893886667
                :loops 14796.109228
                :fibonacci 2478.2464390000005}
   "Java_Native" {:hello-world 6.255375066666666
                  :levenshtein 1503.3454555333335
                  :loops 648.7561861999999
                  :fibonacci 454.4031472000001}
   "Dart"
   {:hello-world 20.10699720000001 :loops 693.8378 :fibonacci 920.4033582666666}
   "PHP" {:levenshtein 38979.72732493335
          :loops 13161.72966666667
          :fibonacci 15816.666469399997}
   "Elixir" {:hello-world 272.1539333333334
             :loops 3237.370636066667
             :fibonacci 1619.4534665333335}
   "Objective_C" {:hello-world 4.1741 :levenshtein 705.9534028666666}
   "Python" {:hello-world 23.036575200000005
             :levenshtein 68251.41772506665
             :loops 44969.43471646667
             :fibonacci 26627.4037528}
   "C_" {:hello-world 33.0957806
         :levenshtein 1316.4450388
         :loops 2141.9195443999997
         :fibonacci 563.5821028000001}
   "Modula_2" {:hello-world 14.060994533333336}
   "PyPy" {:hello-world 27.53301933333334
           :loops 3257.161533333333
           :fibonacci 2311.571516666667}
   "Deno" {:hello-world 22.0365722
           :levenshtein 2342.6758832666665
           :loops 2041.3866500666668
           :fibonacci 1540.0992388666666}
   "Nim" {:levenshtein 2324.2700388000003 :loops 637.9290444}
   "CPP" {:hello-world 3.0712000000000006
          :levenshtein 699.9453973333334
          :loops 645.1190807333334
          :fibonacci 496.6336028666667}
   "Kotlin_Native" {:hello-world 5.6017946
                    :loops 2072.288747266666
                    :fibonacci 514.5313555333333}
   "Fortran" {:hello-world 3.9947556666666664
              :levenshtein 32.40541106666666
              :loops 638.9113027333334
              :fibonacci 5.423311000000001}
   "Scala" {:hello-world 131.19441673333336
            :levenshtein 1249.7832749333336
            :loops 774.3076776
            :fibonacci 611.4343748666666}
   "Ruby" {:hello-world 39.29239726666667
           :levenshtein 35894.22749993334
           :loops 39252.15586679999
           :fibonacci 13627.196819533334}
   "Rust" {:hello-world 3.0298750000000005
           :levenshtein 1524.6968694666666
           :loops 642.0583722
           :fibonacci 495.9713252}
   "Lua" {:hello-world 3.579325133333333
          :levenshtein 28704.826647266666
          :loops 52265.84870546667
          :fibonacci 11980.574102866667}
   "Deno__jitless_" {:hello-world 21.673855533333334
                     :levenshtein 33567.6735666
                     :loops 22519.636175000003
                     :fibonacci 20025.781469533336}
   "Bun_Scala_JS" {:hello-world 12.4949418
                   :levenshtein 1526.2489666666668
                   :loops 2111.6597028
                   :fibonacci 947.512786}
   "Swift" {:hello-world 3.3823110000000005
            :levenshtein 1869.0115915333333
            :loops 639.9036776
            :fibonacci 669.8212749333334}
   "C" {:hello-world 3.1567360666666673
        :levenshtein 727.0045917333334
        :loops 646.3109582666667
        :fibonacci 495.43874733333337}
   "C3" {:hello-world 3.9390193999999994
         :loops 2686.525552733333
         :fibonacci 908.7562584000003}
   "Clojure" {:hello-world 434.50646939999996
              :levenshtein 2068.1152583999997
              :loops 1094.1665748666667
              :fibonacci 942.3307028}
   "Bun" {:hello-world 22.44227493333334
          :levenshtein 1573.3990610666665
          :loops 2061.618627933333
          :fibonacci 1132.0675832666666}
   "C__AOT" {:hello-world 6.854380533333334
             :levenshtein 1290.8087112000003
             :loops 2113.7848305999996
             :fibonacci 641.8385555333332}
   "V" {:hello-world 3.753136066666667
        :levenshtein 728.6326528000001
        :loops 644.2442972000001
        :fibonacci 510.8471110666667}
   "Zig" {:hello-world 2.9322943333333336
          :levenshtein 765.4275167333332
          :loops 641.3595803333333
          :fibonacci 511.02475000000004}
   "Racket" {:hello-world 51.177911200000004
             :levenshtein 6026.393300066668
             :loops 2290.284663733333
             :fibonacci 958.4305360000001}
   "Free_Pascal" {:levenshtein 271.60205279999997
                  :loops 2196.551719533333
                  :fibonacci 858.2845944666667}
   "LuaJIT" {:hello-world 3.444175066666667
             :levenshtein 1234.5481472000001
             :loops 987.8116610000001
             :fibonacci 974.9997388000002}
   "F_" {:hello-world 37.75307766666667
         :levenshtein 1574.0451302666665
         :loops 2232.4284362666663
         :fibonacci 540.9583193999999}
   "Scala_Native" {:hello-world 3.316058266666667
                   :levenshtein 761.2898387333333
                   :loops 644.7479722
                   :fibonacci 499.8222611333334}
   "PHP_JIT" {:levenshtein 9765.099733266665
              :loops 3266.7155083333337
              :fibonacci 4177.646388933333}
   "Go" {:hello-world 3.7939056666666664
         :levenshtein 1185.5276751333336
         :loops 2109.1272249333333
         :fibonacci 725.6518944}
   "Java" {:hello-world 68.30641106666667
           :levenshtein 1010.3494581999998
           :loops 713.1153724
           :fibonacci 544.9817027333333}
   "Odin" {:hello-world 3.138041666666667
           :levenshtein 701.4868084666666
           :loops 640.9588168666667
           :fibonacci 512.3117556666666}
   "Node" {:hello-world 45.98713880000001
           :levenshtein 2368.3366886666663
           :loops 2130.8371724666667
           :fibonacci 1573.2736056000003}
   "Bun_Scala_JS_Compiled_" {:hello-world 12.24826126666667
                             :levenshtein 1521.9338306000004
                             :loops 2114.2146749999997
                             :fibonacci 948.403975}})

