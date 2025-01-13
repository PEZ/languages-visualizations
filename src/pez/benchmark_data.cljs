(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein 954.5491528666669 :loops 2195.5207195999997}
   "Clojure_Native" {:hello-world 7.189747200000001
                     :levenshtein 1640.2624360666669
                     :loops 656.7265556
                     :fibonacci 431.5277666}
   "Kotlin_JVM" {:hello-world 85.36656940000003
                 :loops 735.0726222666666
                 :fibonacci 549.6519142000001}
   "Emacs_Lisp_Native" {:hello-world 87.12758060000002
                        :loops 14967.598466733332
                        :fibonacci 2618.9173944}
   "Bun__Compiled_" {:hello-world 12.1591444
                     :levenshtein 1593.5742472000002
                     :loops 2071.1406165999997
                     :fibonacci 919.8757471333334}
   "Ruby_YJIT" {:hello-world 39.83141386666667
                :levenshtein 16380.063461133332
                :loops 14859.674972199999
                :fibonacci 2560.7051722}
   "Java_Native" {:hello-world 6.391841600000002
                  :levenshtein 1515.2693640000002
                  :loops 659.0282667333333
                  :fibonacci 450.70783600000004}
   "Dart" {:hello-world 20.3126972 :loops 699.3718 :fibonacci 927.8696332666669}
   "PHP" {:levenshtein 39037.98545553333
          :loops 13292.123200066668
          :fibonacci 15993.974916733334}
   "Elixir" {:hello-world 271.38107493333337
             :loops 3298.0461472
             :fibonacci 1603.4691137999998}
   "Objective_C" {:hello-world 5.751016866666668
                  :levenshtein 713.2872637333334
                  :loops 650.5415666
                  :fibonacci 505.64286940000005}
   "F__AOT" {:hello-world 6.133466666666667
             :levenshtein 1615.5671195999998
             :loops 2144.8890945333337
             :fibonacci 645.3328974666666}
   "Python" {:hello-world 23.789327533333335
             :levenshtein 68395.17568906667
             :loops 44960.220861133326
             :fibonacci 26958.25039993334}
   "C_" {:hello-world 34.3133666
         :levenshtein 1326.5872027333335
         :loops 2154.8889
         :fibonacci 574.3117972}
   "Modula_2" {:hello-world 14.602913933333333}
   "PyPy" {:hello-world 26.9795306
           :loops 3178.5563583999997
           :fibonacci 2349.636872333333}
   "Deno" {:hello-world 23.1495918
           :levenshtein 2358.2923084000004
           :loops 2063.403764
           :fibonacci 1553.5225612000002}
   "Nim" {:levenshtein 2340.305783200001 :loops 646.4372472666668}
   "CPP" {:hello-world 3.3330028
          :levenshtein 702.7315777999999
          :loops 647.3515528666667
          :fibonacci 500.71455273333333}
   "Kotlin_Native" {:hello-world 6.1247666
                    :loops 2089.7498250666667
                    :fibonacci 509.6738832666666}
   "Fortran" {:hello-world 4.765383333333333
              :levenshtein 587.4868527333334
              :loops 646.7928305333334
              :fibonacci 5.665591600000001}
   "Scala" {:hello-world 138.0835388
            :levenshtein 1265.2201973333333
            :loops 790.1241388666666
            :fibonacci 621.0766831999999}
   "Ruby" {:hello-world 39.89846093333335
           :levenshtein 36090.916047
           :loops 39123.944769466674
           :fibonacci 13777.757564000001}
   "Rust" {:hello-world 3.2175668666666675
           :levenshtein 1531.6993415333338
           :loops 648.6267415333334
           :fibonacci 502.4559610666667}
   "Lua" {:hello-world 4.020749866666667
          :levenshtein 28797.47759433333
          :loops 52377.16659166666
          :fibonacci 11816.164569399998}
   "Deno__jitless_" {:hello-world 22.035622199999995
                     :levenshtein 33745.129980399994
                     :loops 22643.25250553333
                     :fibonacci 20082.706472133334}
   "Bun_Scala_JS" {:hello-world 12.825594533333337
                   :levenshtein 1534.4963943999999
                   :loops 2132.5261611333335
                   :fibonacci 951.0965834666667}
   "Swift" {:hello-world 5.180538800000001
            :levenshtein 743.1233833333334
            :loops 644.9903833333335
            :fibonacci 671.6413084000003}
   "R" {:levenshtein 226905.81829993334 :fibonacci 94350.5202695333}
   "C" {:hello-world 3.243100066666666
        :levenshtein 585.0204888666666
        :loops 668.8758306666667
        :fibonacci 272.0516332}
   "C3" {:hello-world 3.9682166000000003
         :loops 2695.501650066667
         :fibonacci 917.5197}
   "Clojure" {:hello-world 442.44848060000004
              :levenshtein 2096.3989555333333
              :loops 1097.983666866667
              :fibonacci 946.9864166666665}
   "Bun" {:hello-world 16.680616533333335
          :levenshtein 1587.8240584666664
          :loops 2072.0352832666667
          :fibonacci 1131.0400224666666}
   "C__AOT" {:hello-world 5.548763733333333
             :levenshtein 1301.143355466667
             :loops 2119.1987693999995
             :fibonacci 644.5929971333335}
   "V" {:hello-world 3.651363933333333
        :levenshtein 733.276564
        :loops 653.515875
        :fibonacci 514.5484}
   "Zig" {:hello-world 3.4611444666666675
          :levenshtein 752.4085472
          :loops 647.8785473333332
          :fibonacci 514.0776638666666}
   "Racket" {:hello-world 51.6035832
             :levenshtein 6149.569447333333
             :loops 2292.0664053999994
             :fibonacci 989.8194388666668}
   "Free_Pascal" {;:levenshtein 272.59391373333324
                  :loops 2220.406916733333
                  :fibonacci 848.7302944666667}
   "LuaJIT" {:hello-world 3.6387612000000003
             :levenshtein 1245.6255223333335
             :loops 1002.3037443999998
             :fibonacci 975.7275222000001}
   "F_" {:hello-world 39.02453339999999
         :levenshtein 1583.0877195333335
         :loops 2256.3781388666666
         :fibonacci 538.8253723333333}
   "Scala_Native" {:hello-world 3.723630600000001
                   :levenshtein 765.3819778666667
                   :loops 651.9173168
                   :fibonacci 501.52599460000016}
   "COBOL" {:hello-world 5.786322066666668 :loops 210355.90448053335}
   "PHP_JIT" {:levenshtein 9825.295772133331
              :loops 3317.5144499333333
              :fibonacci 4234.153311266667}
   "Go" {:hello-world 3.848663666666667
         :levenshtein 1194.1333442666667
         :loops 2128.9681027333336
         :fibonacci 722.1116055333334}
   "Java" {:hello-world 78.35908613333334
           :levenshtein 1024.2899556
           :loops 734.4114223999998
           :fibonacci 547.1654000000001}
   "Odin" {:hello-world 3.4098332000000005
           :levenshtein 705.8819165999998
           :loops 647.4928610000002
           :fibonacci 517.2438389333334}
   "Node" {:hello-world 46.999102666666666
           :levenshtein 2383.9420971333334
           :loops 2153.151738866666
           :fibonacci 1584.8899442666666}
   "Bun_Scala_JS_Compiled_" {:hello-world 12.860999933333334
                             :levenshtein 1533.1619916
                             :loops 2136.6142637999997
                             :fibonacci 955.9265000666667}})

