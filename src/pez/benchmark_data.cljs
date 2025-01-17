(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein 967.1210026666669 :loops 2212.3613137999996}
   "Clojure_Native" {:hello-world 5.993319533333334
                     :levenshtein 1648.1433665999998
                     :loops 665.1388860666666
                     :fibonacci 434.1067054666668}
   "Kotlin_JVM" {:hello-world 88.85027779999999
                 :loops 751.8568444000001
                 :fibonacci 574.0480667333333}
   "Emacs_Lisp_Native" {:hello-world 88.99111953333335
                        :loops 15005.086608399999
                        :fibonacci 2641.0720721999996}
   "Bun__Compiled_" {:hello-world 18.08085826666667
                     :levenshtein 1595.1271970666667
                     :loops 2098.054833333333
                     :fibonacci 923.9544666666667}
   "Ruby_YJIT" {:hello-world 39.42044193333334
                :levenshtein 15569.231266666666
                :loops 14983.8338944
                :fibonacci 2567.5898166666675}
   "Java_Native" {:hello-world 6.136594466666667
                  :levenshtein 1528.0068919333335
                  :loops 662.9526333333334
                  :fibonacci 460.1557722}
   "Dart" {:hello-world 16.628566733333333
           :loops 705.0174917333334
           :fibonacci 932.3925696666668}
   "PHP" {:levenshtein 39439.424580733335
          :loops 13556.124411133336
          :fibonacci 16074.02326953333}
   "Elixir" {:hello-world 271.5194388666667
             :loops 3284.3453831999987
             :fibonacci 1660.5321860666668}
   "Objective_C" {:hello-world 4.371908266666668
                  :levenshtein 722.0414028
                  :loops 656.3720112000001
                  :fibonacci 508.55265826666675}
   "F__AOT" {:hello-world 5.822216666666667
             :levenshtein 1630.7655278000002
             :loops 2134.8671946666673
             :fibonacci 658.0181693333334}
   "Python" {:hello-world 24.52059426666667
             :levenshtein 68276.30243046669
             :loops 45087.46532206667
             :fibonacci 27336.012091666664}
   "C_" {:hello-world 33.38117206666667
         :levenshtein 1338.4192666666665
         :loops 2170.0833221999997
         :fibonacci 577.4649445333334}
   "Modula_2" {:hello-world 14.324322133333336}
   "PyPy" {:hello-world 28.117474866666665
           :loops 3299.746180666666
           :fibonacci 2369.8589805999995}
   "Deno" {:hello-world 22.262058399999997
           :levenshtein 2366.546277733333
           :loops 2073.0398388666667
           :fibonacci 1557.2409056000001}
   "Nim" {:levenshtein 2361.9295944000005 :loops 652.0700693333334}
   "CPP" {:hello-world 4.383511000000001
          :levenshtein 708.5599527333333
          :loops 657.2610860666667
          :fibonacci 507.81028066666664}
   "Python_JIT" {:hello-world 24.21322226666667
                 :levenshtein 13567.46792213333
                 :loops 2460.5432417333336
                 :fibonacci 1130.8755583999998}
   "Kotlin_Native" {:hello-world 5.280686133333334
                    :loops 2104.5234445333335
                    :fibonacci 521.5622110666668}
   "Fortran" {:hello-world 4.272488933333333
              :levenshtein 590.9776058000001
              :loops 652.5200445333334
              :fibonacci 5.702905533333333}
   "Scala" {:hello-world 145.83199426666667
            :levenshtein 1292.0506359333335
            :loops 801.9505277333333
            :fibonacci 632.0759056}
   "Ruby" {:hello-world 39.41320553333333
           :levenshtein 36319.00707206666
           :loops 39393.1934388
           :fibonacci 13838.315424999999}
   "Rust" {:hello-world 3.4058387333333333
           :levenshtein 707.1504583999999
           :loops 654.5385194666669
           :fibonacci 505.01601939999995}
   "Lua" {:hello-world 3.8978222000000002
          :levenshtein 29103.031377799998
          :loops 52501.731285999995
          :fibonacci 12105.065066733334}
   "Deno__jitless_" {:hello-world 21.84410833333333
                     :levenshtein 33908.77721386667
                     :loops 22717.714205599998
                     :fibonacci 20202.614027800002}
   "Bun_Scala_JS" {:hello-world 11.686236133333335
                   :levenshtein 1551.0945612000003
                   :loops 2148.529161
                   :fibonacci 958.4089723333335}
   "Swift" {:hello-world 3.715194466666667
            :levenshtein 751.7735554666668
            :loops 651.2548416666667
            :fibonacci 675.6732472666669}
   "R" {:levenshtein 222585.81332240003 :fibonacci 93566.39475553334}
   "C" {:hello-world 3.054597133333334
        :levenshtein 592.4954306
        :loops 677.7765582666667
        :fibonacci 274.39614706666663}
   "C3" {:hello-world 4.020594533333334
         :loops 2673.995611400001
         :fibonacci 924.9714915333335}
   "Clojure" {:hello-world 440.64833613333326
              :levenshtein 2105.820919466667
              :loops 1116.5108362666665
              :fibonacci 958.4321500666667}
   "Bun" {:hello-world 10.726772266666666
          :levenshtein 1606.3785889333333
          :loops 2095.2968943333335
          :fibonacci 1148.9967831333333}
   "C__AOT" {:hello-world 5.4026890000000005
             :levenshtein 1310.673627733333
             :loops 2130.2715666000004
             :fibonacci 650.8295499999999}
   "V" {:hello-world 3.772858333333333
        :levenshtein 740.7803666
        :loops 658.4057890000001
        :fibonacci 520.8993582}
   "Zig" {:hello-world 3.1116224000000003
          :levenshtein 761.5262749333335
          :loops 653.2253414666668
          :fibonacci 519.386775}
   "Racket" {:hello-world 50.426200066666674
             :levenshtein 6101.6335668
             :loops 2304.3042916
             :fibonacci 990.9791806000001}
   "Free_Pascal" {;:levenshtein 273.85144160000004
                  :loops 2236.8419611333334
                  :fibonacci 868.1321250666668}
   "LuaJIT" {:hello-world 3.3301999333333336
             :levenshtein 1260.7047306
             :loops 1006.4970609999999
             :fibonacci 997.5341861333334}
   "F_" {:hello-world 39.69456386666667
         :levenshtein 1594.8296639999996
         :loops 2276.256149933333
         :fibonacci 551.9943557333334}
   "Scala_Native" {:hello-world 3.565175
                   :levenshtein 770.9643526000001
                   :loops 657.4971248666668
                   :fibonacci 507.6458222000001}
   "COBOL" {:hello-world 6.081233333333334 :loops 211700.81156119998}
   "PHP_JIT" {:levenshtein 9919.172402866669
              :loops 3330.6624443999995
              :fibonacci 4217.905027666667}
   "Go" {:hello-world 3.907183333333333
         :levenshtein 1199.3512109333333
         :loops 2132.8680416
         :fibonacci 734.9682335333335}
   "Java" {:hello-world 80.81876666666666
           :levenshtein 1040.7946834666668
           :loops 745.3504389999999
           :fibonacci 568.1215499333334}
   "Odin" {:hello-world 3.0235999333333337
           :levenshtein 715.243425
           :loops 654.9926164666665
           :fibonacci 520.9414082}
   "Node" {:hello-world 46.57630840000001
           :levenshtein 2409.7490360000006
           :loops 2174.964960933333
           :fibonacci 1586.4639529333333}
   "Bun_Scala_JS_Compiled_" {:hello-world 11.308138933333332
                             :levenshtein 1552.4791139333333
                             :loops 2148.2329944666667
                             :fibonacci 956.0877110666667}})

