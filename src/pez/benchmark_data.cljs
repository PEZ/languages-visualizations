(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein 249.5059045714286 :loops 2141.723881}
   "Clojure_Native" {:hello-world 12.18320242857143
                     :levenshtein 37.53363671428571
                     :loops 642.2546072857144
                     :fibonacci 421.739113}
   "Kotlin_JVM" {:hello-world 72.6093452857143
                 :loops 708.3232855714286
                 :fibonacci 537.435875}
   "Emacs_Lisp_Native" {:hello-world 89.57385114285714
                        :loops 14516.604874857141
                        :fibonacci 2547.1313868571424}
   "Bun__Compiled_" {:hello-world 11.23547657142857
                     :levenshtein 47.043518
                     :loops 2032.7347857142856
                     :fibonacci 896.3428395714287}
   "Ruby_YJIT" {:hello-world 38.735600857142856
                :levenshtein 333.41544642857144
                :loops 14506.083815428572
                :fibonacci 2482.5435832857147}
   "Java_Native" {:hello-world 5.7432617142857145
                  :levenshtein 33.054232285714285
                  :loops 639.4532321428572
                  :fibonacci 444.44799985714286}
   "Dart" {:hello-world 18.37703585714286
           :loops 684.0801607142857
           :fibonacci 903.6457381428571}
   "PHP" {:levenshtein 764.3921905714286
          :loops 13159.970553571427
          :fibonacci 15540.412446428572}
   "Elixir" {:hello-world 269.8130594285714
             :loops 3167.0870594285716
             :fibonacci 1683.0594824285713}
   "Objective_C" {:hello-world 4.338279857142857 :levenshtein 17.28423228571429}
   "Python" {:hello-world 22.648214428571432
             :levenshtein 928.4196250000001
             :loops 43549.15591657143
             :fibonacci 26381.78014257143}
   "C_" {:hello-world 32.67572028571429
         :levenshtein 55.65591657142858
         :loops 2086.355833142857
         :fibonacci 558.5870415714286}
   "Modula_2" {:hello-world 13.796256000000001}
   "PyPy" {:hello-world 29.493589142857147
           :loops 3271.493398857143
           :fibonacci 2284.9876010000003}
   "Deno" {:hello-world 21.251821428571432
           :levenshtein 70.16748200000002
           :loops 2003.6198394285711
           :fibonacci 1511.9965954285717}
   "Nim" {:levenshtein 47.15838114285715 :loops 630.1210357142858}
   "CPP" {:hello-world 3.2555238571428573
          :levenshtein 14.106964142857144
          :loops 633.4824880000002
          :fibonacci 489.2314938571428}
   "Kotlin_Native"
   {:hello-world 5.367089 :loops 2041.066631142857 :fibonacci 504.3714165714286}
   "Fortran" {:hello-world 4.121262
              :levenshtein 11.065029857142859
              :loops 630.2463274285716
              ;:fibonacci 12.371863142857142
              }
   "Scala" {:hello-world 132.49278585714285
            :levenshtein 199.43131528571428
            :loops 765.5231371428572
            :fibonacci 606.8484940000001}
   "Ruby" {:hello-world 41.44148214285715
           :levenshtein 713.2097025714286
           :loops 38249.45275585714
           :fibonacci 13277.845940285715}
   "Rust" {:hello-world 3.5798867142857143
           :levenshtein 29.961946714285713
           :loops 637.817238
           :fibonacci 488.74667242857146}
   "Lua" {:hello-world 3.4238751428571432
          :levenshtein 547.2651011428572
          :loops 51115.33776185714
          :fibonacci 11736.296244285713}
   "Deno__jitless_" {:hello-world 21.22582142857143
                     :levenshtein 668.5767322857143
                     :loops 21976.443494285715
                     :fibonacci 19581.126256142856}
   "Bun_Scala_JS" {:hello-world 12.087868714285715
                   :levenshtein 63.193821428571425
                   :loops 2084.9894164285715
                   :fibonacci 935.4318274285714}
   "Swift" {:hello-world 3.3518811428571436
            :levenshtein 42.37846414285714
            :loops 629.3761787142857
            :fibonacci 655.9423094285714}
   "C" {:hello-world 2.922994142857143
        :levenshtein 14.599422571428573
        :loops 633.8812675714287
        :fibonacci 487.8901724285715}
   "C3" {:hello-world 3.5213688571428574
         :loops 2550.2006011428575
         :fibonacci 893.3493334285715}
   "Clojure" {:hello-world 448.975756
              :levenshtein 516.3572617142858
              :loops 1084.0512324285714
              :fibonacci 931.5529167142857}
   "Bun" {:hello-world 11.272422285714287
          :levenshtein 49.44972628571429
          :loops 2029.6672858571428
          :fibonacci 1096.7735831428572}
   "V" {:hello-world 3.7471075714285718
        :levenshtein 14.375006142857144
        :loops 638.0925532857142
        :fibonacci 507.2824641428573}
   "Zig" {:hello-world 2.872124857142858
          :levenshtein 13.661214428571428
          :loops 632.8163038571429
          :fibonacci 502.5358512857142}
   "LuaJIT" {:hello-world 3.2417082857142856
             :levenshtein 44.82083314285714
             :loops 977.1691667142858
             :fibonacci 964.7478454285715}
   "F_" {:hello-world 37.03279757142857
         :levenshtein 111.70591657142859
         :loops 2201.0181784285714
         :fibonacci 527.5483867142857}
   "Scala_Native" {:hello-world 3.5443630000000006
                   :levenshtein 16.644821285714286
                   :loops 639.0081188571429
                   :fibonacci 492.7440537142857}
   "COBOL" {:hello-world 5.647380857142857 :loops 205437.40019642853}
   "PHP_JIT"
   {:levenshtein 232.42942271428578 :loops 3223.228768 :fibonacci 4096.690286}
   "Babashka" {:hello-world 12.630738000000001
               :levenshtein 5867.248238
               :loops 73734.78709557142
               :fibonacci 54486.692875}
   "Go" {:hello-world 3.7196668571428573
         :levenshtein 20.027125285714288
         :loops 2051.5450597142853
         :fibonacci 715.2716485714286}
   "Java" {:hello-world 65.37307171428571
           :levenshtein 121.91089871428574
           :loops 707.5259821428571
           :fibonacci 536.5516727142857}
   "Odin" {:hello-world 3.054119142857143
           :levenshtein 13.47139285714286
           :loops 634.9352737142857
           :fibonacci 504.08745242857145}
   "Common_Lisp" {:hello-world 16.483321571428572
                  :levenshtein 72.55543442857144
                  :loops 2767.654095285715
                  :fibonacci 1396.6435360000003}
   "Node" {:hello-world 48.47107142857144
           :levenshtein 89.78320842857143
           :loops 2108.797041714286
           :fibonacci 1540.7868211428572}
   "Bun_Scala_JS_Compiled_" {:hello-world 12.237786
                             :levenshtein 60.08689285714286
                             :loops 2078.689107142857
                             :fibonacci 925.8012798571428}})

