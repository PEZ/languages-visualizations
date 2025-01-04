(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein 248.35073336000002 :loops 2134.4779583600002}
   "Clojure_Native" {:hello-world 5.795108320000001
                     :levenshtein 35.810878360000004
                     :loops 641.67846172
                     :fibonacci 421.7577234800001}
   "Kotlin_JVM" {:hello-world 73.28951488
                 :loops 709.2812166799999
                 :fibonacci 540.2419248800002}
   "Emacs_Lisp_Native" {:hello-world 83.86903504000001
                        :loops 14514.175565
                        :fibonacci 2563.2096768399997}
   "Bun__Compiled_" {:hello-world 10.95209336
                     :levenshtein 46.652075040000014
                     :loops 2030.6784899599998
                     :fibonacci 897.0270499599999}
   "Ruby_YJIT" {:hello-world 37.75084496
                :levenshtein 334.06120504
                :loops 14512.941764959996
                :fibonacci 2498.0988017600007}
   "Java_Native" {:hello-world 5.416788480000001
                  :levenshtein 32.97887988000001
                  :loops 639.28741648
                  :fibonacci 448.0071366000001}
   "Dart" {:hello-world 16.876148280000002
           :loops 684.2185216399998
           :fibonacci 901.8178517199996}
   "PHP" {:levenshtein 766.53749668
          :loops 13112.520853279997
          :fibonacci 15545.295593440002}
   "Elixir"
   {:hello-world 264.74834664 :loops 3176.815636680001 :fibonacci 1601.11967012}
   "Objective_C" {:hello-world 3.8716564800000004 :levenshtein 17.378716760000003}
   "Python" {:hello-world 23.513494960000003
             :levenshtein 931.23858824
             :loops 43715.36557675999
             :fibonacci 26395.211148320002}
   "C_" {:hello-world 31.632818439999994
         :levenshtein 52.41713339999999
         :loops 2082.9901333599996
         :fibonacci 559.90126168}
   "Modula_2" {:hello-world 13.021626719999999}
   "PyPy" {:hello-world 25.905869920000008
           :loops 3281.7958366000007
           :fibonacci 2288.9359782}
   "Deno" {:hello-world 20.9497034
           :levenshtein 64.98765340000003
           :loops 2003.4346065600005
           :fibonacci 1511.53066008}
   "Nim" {:levenshtein 46.48482168000001 :loops 631.1695598800002}
   "CPP" {:hello-world 3.8627000400000004
          :levenshtein 14.414843439999999
          :loops 634.9274
          :fibonacci 488.71586827999994}
   "Kotlin_Native" {:hello-world 5.070411600000002
                    :loops 2040.9761367599995
                    :fibonacci 505.10216496000004}
   "Fortran" {:hello-world 3.561208320000001
              :levenshtein 10.587495039999999
              :loops 631.09043
              ;:fibonacci 5.20564168
              }
   "Scala" {:hello-world 126.44512188000004
            :levenshtein 197.88554496
            :loops 766.78167348
            :fibonacci 605.2680883200002}
   "Ruby" {:hello-world 37.679051640000004
           :levenshtein 715.8527566
           :loops 38342.81558832001
           :fibonacci 13384.766488320001}
   "Rust" {:hello-world 3.9831150000000006
           :levenshtein 30.55019824
           :loops 632.2690232800002
           :fibonacci 493.46645164000006}
   "Lua" {:hello-world 3.2245283600000008
          :levenshtein 537.1401916799999
          :loops 51075.94621672
          :fibonacci 11744.9260684}
   "Deno__jitless_" {:hello-world 19.843235000000004
                     :levenshtein 659.6170316000001
                     :loops 21979.492424960004
                     :fibonacci 19678.697958359997}
   "Bun_Scala_JS" {:hello-world 11.068178320000001
                   :levenshtein 61.92560492
                   :loops 2082.3714850000006
                   :fibonacci 936.4255216800003}
   "Swift" {:hello-world 5.0732498800000005
            :levenshtein 43.85518324
            :loops 630.1819915600001
            :fibonacci 661.2148533200001}
   "R" {:levenshtein 4339.447135119999 :fibonacci 90839.41078175999}
   "C" {:hello-world 2.83236664
        :levenshtein 13.47550992
        :loops 633.3690150400001
        :fibonacci 488.82391676000015}
   "C3" {:hello-world 3.163465 :loops 2550.14944168 :fibonacci 894.7753800400001}
   "Clojure" {:hello-world 432.682775
              :levenshtein 516.662305
              :loops 1081.26235496
              :fibonacci 929.0189499600001}
   "Bun" {:hello-world 10.14670152
          :levenshtein 46.76817812
          :loops 2030.47254656
          :fibonacci 1104.7468150800003}
   "V" {:hello-world 3.24671168
        :levenshtein 14.404653319999998
        :loops 636.9512032800001
        :fibonacci 507.8219783200001}
   "Zig" {:hello-world 2.65433332
          :levenshtein 14.892523440000002
          :loops 633.81969672
          :fibonacci 505.1304315599999}
   "Free_Pascal"
   {:levenshtein 25.207331600000003 :loops 2168.37159012 :fibonacci 841.0206084}
   "LuaJIT" {:hello-world 2.928366880000001
             :levenshtein 45.368344920000006
             :loops 976.9210184800002
             :fibonacci 943.6219733200002}
   "F_" {:hello-world 37.051993360000004
         :levenshtein 112.53079835999999
         :loops 2202.1249217600002
         :fibonacci 532.8007166800002}
   "Scala_Native" {:hello-world 3.3263217199999997
                   :levenshtein 16.68633836
                   :loops 636.2186133600001
                   :fibonacci 497.73543831999996}
   "COBOL" {:hello-world 5.647380857142857 :loops 205437.40019642853}
   "PHP_JIT" {:levenshtein 231.23672667999998
              :loops 3224.0993950399998
              :fibonacci 4084.4699650000002}
   "Babashka" {:hello-world 12.630738000000001
               :levenshtein 5867.248238
               :loops 73734.78709557142
               :fibonacci 54486.692875}
   "Go" {:hello-world 3.404885
         :levenshtein 20.57194332
         :loops 2054.4500133600004
         :fibonacci 713.9968667200002}
   "Java" {:hello-world 64.28095156
           :levenshtein 126.17649176
           :loops 705.7273918
           :fibonacci 537.10336992}
   "Odin" {:hello-world 2.704033440000001
           :levenshtein 14.586821679999998
           :loops 633.0783866
           :fibonacci 504.9510516000001}
   "Common_Lisp" {:hello-world 18.733839960000005
                  :levenshtein 75.55107011999999
                  :loops 2775.1881000400003
                  :fibonacci 1399.5182800399998}
   "Node" {:hello-world 46.905978360000006
           :levenshtein 89.19933332
           :loops 2109.1765018400006
           :fibonacci 1542.1983383199997}
   "Bun_Scala_JS_Compiled_" {:hello-world 11.24158164
                             :levenshtein 61.038356639999996
                             :loops 2081.89305672
                             :fibonacci 933.42643996}})

