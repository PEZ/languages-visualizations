(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein-hello-world 245.38813099999996
            :loops-hello-world 243.50238078571425
            :levenshtein 253.00474985714288
            :loops 2135.3071247142857}
   "Clojure_Native" {:fibonacci-hello-world 6.060222999999999
                     :levenshtein-hello-world 6.953377857142858
                     :loops-hello-world 6.3504138571428586
                     :levenshtein 34.74248828571429
                     :loops 646.9539107142857
                     :fibonacci 428.39616057142865}
   "Kotlin_JVM" {:fibonacci-hello-world 72.28334214285714
                 :loops-hello-world 76.13286607142858
                 :loops 713.3923332857144
                 :fibonacci 543.5092204285714}
   "Emacs_Lisp_Native" {:fibonacci-hello-world 84.41366357142857
                        :loops-hello-world 85.36048221428571
                        :loops 14506.724309571426
                        :fibonacci 2547.4780238571425}
   "Bun__Compiled_" {:fibonacci-hello-world 10.428925642857143
                     :levenshtein-hello-world 11.88559507142857
                     :loops-hello-world 11.848741071428572
                     :levenshtein 48.99556557142858
                     :loops 2042.1261068571428
                     :fibonacci 898.8203691428571}
   "Ruby_YJIT" {:fibonacci-hello-world 39.33745528571429
                :levenshtein-hello-world 38.88339271428572
                :loops-hello-world 38.12825007142857
                :levenshtein 352.982238
                :loops 14503.072988000002
                :fibonacci 2481.3448451428576}
   "Java_Native" {:fibonacci-hello-world 8.63449107142857
                  :levenshtein-hello-world 5.883621785714288
                  :loops-hello-world 5.933342357142857
                  :levenshtein 36.99667228571429
                  :loops 682.2642200000003
                  :fibonacci 491.87157157142855}
   "Dart" {:fibonacci-hello-world 16.567899
           :loops-hello-world 19.748544785714287
           :loops 690.0767145714287
           :fibonacci 904.3309225714287}
   "PHP" {:fibonacci-hello-world 49.28966371428572
          :levenshtein-hello-world 54.83398814285714
          :loops-hello-world 50.93170821428571
          :levenshtein 774.7591784285715
          :loops 13037.48267242857
          :fibonacci 15541.17318457143}
   "Elixir" {:fibonacci-hello-world 265.30798814285714
             :loops-hello-world 272.8125445000001
             :loops 3186.2372502857143
             :fibonacci 1561.3729047142858}
   "Objective_C" {:levenshtein-hello-world 4.498910785714286
                  :levenshtein 18.17094057142857}
   "Python" {:fibonacci-hello-world 24.719309642857144
             :levenshtein-hello-world 22.97783028571429
             :loops-hello-world 22.086523785714288
             :levenshtein 943.5580298571429
             :loops 44013.52241114286
             :fibonacci 26377.59457142857}
   "C_" {:fibonacci-hello-world 30.58458628571429
         :levenshtein-hello-world 33.769776857142865
         :loops-hello-world 34.4484075
         :levenshtein 53.850893000000006
         :loops 2095.829357142857
         :fibonacci 559.3241367142857}
   "PyPy" {:fibonacci-hello-world 27.183574642857145
           :loops-hello-world 27.709142714285715
           :loops 3278.5399701428573
           :fibonacci 2287.5925238571426}
   "Deno" {:fibonacci-hello-world 22.397997142857143
           :levenshtein-hello-world 23.39275
           :loops-hello-world 21.925482142857145
           :levenshtein 69.06382114285715
           :loops 2011.993678714286
           :fibonacci 1504.478732142857}
   ;"Nim" {:levenshtein 49.78069057142857 :loops 629.6160358571428}
   "CPP" {:fibonacci-hello-world 2.6358005
          :levenshtein-hello-world 3.6509285714285724
          :loops-hello-world 2.997988071428572
          :levenshtein 14.409101142857144
          :loops 641.657512
          :fibonacci 488.3749582857143}
   "Kotlin_Native" {:fibonacci-hello-world 5.169446357142857
                    :loops-hello-world 6.135723357142858
                    :loops 2040.1108989999996
                    :fibonacci 507.5794285714287}
   "Fortran" {;:fibonacci-hello-world 3.847869071428572
              :levenshtein-hello-world 4.5782175
              :loops-hello-world 4.209577500000001
              :levenshtein 11.401791714285718
              :loops 634.236732
              ;:fibonacci 4.924404714285715
              }
   "Scala" {:fibonacci-hello-world 128.18547307142856
            :levenshtein-hello-world 128.5023542857143
            :loops-hello-world 127.47839885714285
            :levenshtein 200.64179171428572
            :loops 761.6234405714287
            :fibonacci 607.737982}
   "Ruby" {:fibonacci-hello-world 39.007627785714284
           :levenshtein-hello-world 40.12277400000001
           :loops-hello-world 36.96842835714287
           :levenshtein 728.5850060000001
           :loops 38189.572720428565
           :fibonacci 13282.002339285715}
   "Rust" {:fibonacci-hello-world 5.888044857142858
           :levenshtein-hello-world 3.4930745000000005
           :loops-hello-world 2.745669571428571
           :levenshtein 31.086654714285714
           :loops 631.5422024285715
           :fibonacci 492.6944104285714}
   "Lua" {:fibonacci-hello-world 2.9860296428571433
          :levenshtein-hello-world 3.4413987857142865
          :loops-hello-world 6.310416785714287
          :levenshtein 540.1934940000001
          :loops 51271.10286299999
          :fibonacci 11736.244011714285}
   "Deno__jitless_" {:fibonacci-hello-world 22.754416785714287
                     :levenshtein-hello-world 23.38401185714286
                     :loops-hello-world 21.787175642857143
                     :levenshtein 670.700047857143
                     :loops 22227.192232
                     :fibonacci 19638.96280957143}
   "Bun_Scala_JS" {:fibonacci-hello-world 11.616160571428571
                   :levenshtein-hello-world 15.28333928571429
                   :loops-hello-world 14.288253142857144
                   :levenshtein 62.34604171428572
                   :loops 2083.262267857143
                   :fibonacci 929.528768}
   "Swift" {:fibonacci-hello-world 3.2161280714285723
            :levenshtein-hello-world 6.606101285714287
            :loops-hello-world 3.1400417857142853
            :levenshtein 43.62898199999999
            :loops 629.8207621428571
            :fibonacci 657.0347202857143}
   "C" {:fibonacci-hello-world 2.518651785714286
        :levenshtein-hello-world 3.1801547142857145
        :loops-hello-world 2.927047428571429
        :levenshtein 14.536874714285716
        :loops 641.4297142857143
        :fibonacci 487.93664314285724}
   "C3" {:fibonacci-hello-world 5.104005928571429
         :loops-hello-world 3.8254197142857143
         :loops 2580.406827285714
         :fibonacci 893.4236485714287}
   "Clojure" {:fibonacci-hello-world 435.3414792142858
              :levenshtein-hello-world 439.5740595714286
              :loops-hello-world 437.52712492857154
              :levenshtein 528.0402917142858
              :loops 1091.3415951428572
              :fibonacci 929.2713215714284}
   "Bun" {:fibonacci-hello-world 10.055392785714286
          :levenshtein-hello-world 11.085404714285717
          :loops-hello-world 11.426821285714288
          :levenshtein 46.805803714285716
          :loops 2046.221624857143
          :fibonacci 1100.8877558571428}
   "V" {:fibonacci-hello-world 3.248109857142857
        :levenshtein-hello-world 3.7304703571428566
        :loops-hello-world 3.3884522857142856
        :levenshtein 15.413815428571429
        :loops 638.8195237142858
        :fibonacci 505.9794342857143}
   "Zig" {:fibonacci-hello-world 2.677663571428572
          :levenshtein-hello-world 3.4201875000000004
          :loops-hello-world 2.8754759999999995
          :levenshtein 14.478958285714288
          :loops 632.0848097142857
          :fibonacci 504.9431427142857}
   "LuaJIT" {:fibonacci-hello-world 2.9952916428571426
             :levenshtein-hello-world 3.4460983571428576
             :loops-hello-world 2.9354494285714283
             :levenshtein 46.53533342857143
             :loops 977.4818991428572
             :fibonacci 925.8737082857144}
   "F_" {:fibonacci-hello-world 35.427297571428575
         :levenshtein-hello-world 39.77235721428571
         :loops-hello-world 39.25254178571429
         :levenshtein 117.38597042857144
         :loops 2217.203678714285
         :fibonacci 529.4076844285714}
   "Scala_Native" {:fibonacci-hello-world 2.891830357142858
                   :levenshtein-hello-world 3.790628071428572
                   :loops-hello-world 3.0172798571428574
                   :levenshtein 17.64957728571429
                   :loops 640.5168870000001
                   :fibonacci 488.6805537142857}
   "COBOL" {:loops-hello-world 6.171211357142858 :loops 206364.28329171427}
   "PHP_JIT" {:fibonacci-hello-world 51.91010414285714
              :levenshtein-hello-world 54.93144342857144
              :loops-hello-world 51.90661300000001
              :levenshtein 240.2557977142857
              :loops 3222.628773857143
              :fibonacci 4092.099690285714}
   "Go" {:fibonacci-hello-world 3.2954582857142865
         :levenshtein-hello-world 3.5876666428571427
         :loops-hello-world 3.8832202142857146
         :levenshtein 22.925315571428573
         :loops 2072.3247024285715
         :fibonacci 713.226125}
   "Java" {:fibonacci-hello-world 65.13201192857143
           :levenshtein-hello-world 67.89897328571429
           :loops-hello-world 65.56356528571429
           :levenshtein 129.14639285714287
           :loops 710.8623811428573
           :fibonacci 534.7835654285715}
   "Odin" {:fibonacci-hello-world 2.731291642857143
           :levenshtein-hello-world 3.1108631428571436
           :loops-hello-world 2.8352529285714287
           :levenshtein 20.232136571428576
           :loops 632.3762501428571
           :fibonacci 509.849273857143}
   "Common_Lisp" {:fibonacci-hello-world 19.331991142857138
                  :levenshtein-hello-world 17.03599692857143
                  :loops-hello-world 17.36794635714286
                  :levenshtein 73.68910728571429
                  :loops 2790.8646011428573
                  :fibonacci 1400.7475835714288}
   "Node" {:fibonacci-hello-world 45.85598214285714
           :levenshtein-hello-world 47.86746728571429
           :loops-hello-world 46.221110214285716
           :levenshtein 90.54491628571431
           :loops 2107.816726142857
           :fibonacci 1539.7990059999997}
   "Bun_Scala_JS_Compiled_" {:fibonacci-hello-world 11.144955428571429
                             :levenshtein-hello-world 16.75497907142858
                             :loops-hello-world 11.45025007142857
                             :levenshtein 60.49992242857143
                             :loops 2078.4728749999995
                             :fibonacci 930.3330597142857}})

