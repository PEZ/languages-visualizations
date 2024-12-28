(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {;:levenshtein-hello-world 213.4316962857143
            :loops-hello-world 200.9608692857143
            ;:levenshtein 202.764
            :loops 873.6935595714286}
   "Clojure_Native" {:fibonacci-hello-world 5.125356857142857
                     :levenshtein-hello-world 4.951119142857142
                     :loops-hello-world 4.699244
                     :levenshtein 20.246101142857142
                     :loops 489.92117257142854
                     :fibonacci 311.996381}
   "Kotlin_JVM" {:fibonacci-hello-world 55.07993442857144
                 :loops-hello-world 53.1714342857143
                 :loops 531.8556310000001
                 :fibonacci 356.92360128571426}
   "Bun__Compiled_" {:levenshtein-hello-world 12.125744142857146
                     :levenshtein 40.755887}
   "Ruby_YJIT" {:fibonacci-hello-world 31.044553428571426
                :levenshtein-hello-world 31.34401185714286
                :loops-hello-world 31.782821285714288
                :levenshtein 222.83371414285716
                :loops 9994.988089285715
                :fibonacci 1480.5943691428572}
   "Java_Native" {:fibonacci-hello-world 4.402970285714286
                  :levenshtein-hello-world 7.787184285714288
                  :loops-hello-world 4.64953
                  :levenshtein 25.015988285714286
                  :loops 491.5745652857143
                  :fibonacci 283.60799999999995}
   "PHP" {:fibonacci-hello-world 40.81051366666667
          :levenshtein-hello-world 40.33198633333333
          :loops-hello-world 43.93726785714286
          :levenshtein 560.3877500000002
          :loops 7719.725380999999
          :fibonacci 9974.719111333334}
   "Elixir" {:fibonacci-hello-world 203.6907022857143
             :loops-hello-world 197.11391671428572
             :loops 2048.8707498571425
             :fibonacci 992.8725002857144}
   "MAWK" {:fibonacci-hello-world 4.229111
           :levenshtein-hello-world 3.1726940000000003
           :loops-hello-world 3.324857
           :levenshtein 1529.0968749999997
           :loops 28248.226166571425
           :fibonacci 13836.777957999999}
   "Objective_C" {:levenshtein-hello-world 3.409577571428571
                  :levenshtein 14.093868857142855}
   "Python" {:fibonacci-hello-world 19.79418457142857
             :levenshtein-hello-world 19.86352971428571
             :loops-hello-world 17.93755357142857
             :levenshtein 629.5299405714286
             :loops 28461.41479757143
             :fibonacci 17890.97222042857}
   "PyPy" {:fibonacci-hello-world 21.30884514285714
           :loops-hello-world 21.507220142857147
           :loops 2258.8675774285716
           :fibonacci 1693.8908392857143}
   "Deno" {:fibonacci-hello-world 24.219916714285716
           :levenshtein-hello-world 26.168273714285714
           :loops-hello-world 24.49794042857143
           :levenshtein 57.19685714285715
           :loops 752.6737022857144
           :fibonacci 950.6272141428572}
   "CPP" {:fibonacci-hello-world 2.0644225714285716
          :levenshtein-hello-world 1.9817855714285717
          :loops-hello-world 2.184726
          :levenshtein 9.027220000000002
          :loops 470.0578811428571
          :fibonacci 287.341268}
   "Fortran" {:levenshtein-hello-world 2.967363
              :loops-hello-world 3.0898511428571425
              :levenshtein 8.719452571428572
              :loops 482.20650000000006}
   "Ruby" {:fibonacci-hello-world 31.349791666666675
           :loops-hello-world 30.881652666666664
           :loops 29514.90427733333
           :fibonacci 11681.001499999998}
   "Rust" {:fibonacci-hello-world 2.2621667142857143
           :levenshtein-hello-world 2.3335594285714283
           :loops-hello-world 2.3008215714285716
           :levenshtein 13.747571285714285
           :loops 495.84754157142856
           :fibonacci 285.569518}
   "Lua" {:fibonacci-hello-world 3.1762200000000003
          :levenshtein-hello-world 3.0600240000000007
          :loops-hello-world 3.3965120000000004
          :levenshtein 355.6111011428572
          :loops 33345.93283942856
          :fibonacci 6370.897654857144}
   "Swift" {:fibonacci-hello-world 2.5293271428571433
            :levenshtein-hello-world 2.462690285714286
            :loops-hello-world 2.418446571428572
            :levenshtein 26.65226785714286
            :loops 511.2207678571429
            :fibonacci 405.5696962857143}
   "C" {:fibonacci-hello-world 2.4124702857142855
        :levenshtein-hello-world 2.2222381428571434
        :loops-hello-world 2.0311308571428572
        :levenshtein 8.909845285714287
        :loops 469.7514405714286
        :fibonacci 270.74585128571425}
   "Emacs_Lisp_Bytecode" {:loops-hello-world 94.34625000000001
                          :loops 85650.97974999998}
   "Clojure" {:fibonacci-hello-world 311.62238057142855
              :levenshtein-hello-world 321.55032142857146
              :loops-hello-world 300.22858942857147
              :levenshtein 361.81019042857145
              :loops 774.7447144285716
              :fibonacci 885.6936962857144}
   "Bun" {:levenshtein-hello-world 12.424065571428573
          :levenshtein 40.93055357142857}
   "V" {:fibonacci-hello-world 2.5174941428571427
        :levenshtein-hello-world 2.723464285714285
        :levenshtein 9.784244142857142
        :fibonacci 284.9366191428572}
   "Zig" {:fibonacci-hello-world 2.159696428571429
          :levenshtein-hello-world 2.1990060000000002
          :loops-hello-world 2.297672428571429
          :levenshtein 11.040327285714284
          :loops 502.96283942857144
          :fibonacci 336.7765954285714}
   "Java_GraalVM" {:levenshtein-hello-world 4.8957776666666675
                   :loops-hello-world 4.161638666666666
                   :levenshtein 24.96037466666667
                   :loops 497.2625973333334}
   "LuaJIT" {:fibonacci-hello-world 3.228666571428572
             :levenshtein-hello-world 2.9736547142857153
             :loops-hello-world 2.918000142857143
             :levenshtein 32.35642871428572
             :loops 748.6628811428571
             :fibonacci 633.9830535714287}
   "PHP_JIT" {:fibonacci-hello-world 41.74803000000001
              :levenshtein-hello-world 45.557482142857154
              :loops-hello-world 42.24418442857142
              :levenshtein 173.305375
              :loops 2140.073029714286
              :fibonacci 4101.854672571429}
   "Java" {:fibonacci-hello-world 49.593529714285715
           :levenshtein-hello-world 53.20574985714287
           :loops-hello-world 49.93017242857144
           :levenshtein 107.57714271428573
           :loops 527.872119
           :fibonacci 347.6161188571429}
   "Odin" {:fibonacci-hello-world 2.5983451428571436
           :levenshtein-hello-world 2.1928391428571428
           :loops-hello-world 2.2337082857142856
           :levenshtein 12.357178714285714
           :loops 483.34432128571433
           :fibonacci 338.2031368571429}
   "Node" {:fibonacci-hello-world 30.721083571428572
           :levenshtein-hello-world 31.567803428571427
           :loops-hello-world 30.43969028571429
           :levenshtein 61.60490485714286
           :loops 791.2084582857143
           :fibonacci 888.5165775714287}})


