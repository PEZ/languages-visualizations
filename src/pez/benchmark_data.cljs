(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein 250.5924999333334 :loops 2167.6468637333332}
   "Clojure_Native" {:hello-world 5.837899933333334
                     :levenshtein 35.10780286666667
                     :loops 647.1511386666667
                     :fibonacci 422.44730553333335}
   "Kotlin_JVM" {:hello-world 74.1944582666667
                 :loops 719.2259444666668
                 :fibonacci 540.2060334}
   "Emacs_Lisp_Native" {:hello-world 81.76669446666666
                        :loops 14631.8693306
                        :fibonacci 2547.8591722666665}
   "Bun__Compiled_" {:hello-world 9.97385266666667
                     :levenshtein 46.896861133333346
                     :loops 2044.6248804666661
                     :fibonacci 899.2138333333336}
   "Ruby_YJIT" {:hello-world 38.745802866666665
                :levenshtein 331.15678899999995
                :loops 14614.683
                :fibonacci 2485.3152137333327}
   "Java_Native" {:hello-world 5.350541533333333
                  :levenshtein 35.182555666666666
                  :loops 652.1768611333333
                  :fibonacci 446.6989526}
   "Dart" {:hello-world 15.669202933333334
           :loops 699.7737057999999
           :fibonacci 903.0410029333332}
   "PHP" {:levenshtein 766.7488334666667
          :loops 13430.985744533333
          :fibonacci 15553.800125200003}
   "Elixir" {:hello-world 261.1094194666667
             :loops 3228.8609582
             :fibonacci 1562.7483443333333}
   "Objective_C" {:hello-world 3.9619832666666666 :levenshtein 20.422244400000004}
   "F__AOT" {:hello-world 5.315180600000001 :loops 2131.3370194666672}
   "Python" {:hello-world 23.70782493333333
             :levenshtein 928.6715333999999
             :loops 44645.55493593332
             :fibonacci 26406.45868053333}
   "C_" {:hello-world 32.562747066666674
         :levenshtein 52.90999166666668
         :loops 2093.0909360666665
         :fibonacci 558.2478417333334}
   "Modula_2" {:hello-world 13.3719502}
   "PyPy" {:hello-world 24.578477666666664
           :loops 3144.9633249333338
           :fibonacci 2286.6799222000004}
   "Deno" {:hello-world 20.833655466666663
           :levenshtein 65.76211393333334
           :loops 2049.3147638
           :fibonacci 1515.008749933333}
   "Nim" {:levenshtein 44.43211666666667 :loops 644.9133555999999}
   "CPP" {:hello-world 2.7905139333333335
          :levenshtein 13.708172200000002
          :loops 648.1515833333334
          :fibonacci 490.9502611333334}
   "Kotlin_Native" {:hello-world 5.0511306000000005
                    :loops 2075.8723055333335
                    :fibonacci 506.0855889333333}
   "Fortran" {:hello-world 3.6581360000000007
              :levenshtein 10.897280666666667
              :loops 644.5133278000002
              ;:fibonacci 5.242308466666667
              }
   "Scala" {:hello-world 125.1531722666667
            :levenshtein 199.33027499999997
            :loops 770.2676054666667
            :fibonacci 601.7186471333334}
   "Ruby" {:hello-world 36.77961673333334
           :levenshtein 713.6059584000001
           :loops 38892.20343053333
           :fibonacci 13325.350055666666}
   "Rust" {:hello-world 3.0439084666666667
           :levenshtein 30.13900833333334
           :loops 635.8396138666668
           :fibonacci 488.80039446666666}
   "Lua" {:hello-world 3.0432638666666665
          :levenshtein 541.3753664666667
          :loops 52257.35686653334
          :fibonacci 11741.389661333335}
   "Deno__jitless_" {:hello-world 24.302789133333334
                     :levenshtein 674.1678111333332
                     :loops 22216.779566666668
                     :fibonacci 19585.78662233333}
   "Bun_Scala_JS" {:hello-world 11.234644533333334
                   :levenshtein 63.38869173333334
                   :loops 2092.4242473333334
                   :fibonacci 929.4886971333334}
   "Swift" {:hello-world 2.9724307333333337
            :levenshtein 43.604005666666666
            :loops 632.4671166666668
            :fibonacci 654.8666165333332}
   "C" {:hello-world 2.8875304000000006
        :levenshtein 13.9187416
        :loops 637.4708693333333
        :fibonacci 490.05551940000004}
   "C3" {:hello-world 5.731175
         :loops 2570.7333278666674
         :fibonacci 895.5360694000001}
   "Emacs_Lisp_Bytecode" {:hello-world 83.06436393333333
                          :loops 25135.130433333336}
   "Clojure" {:hello-world 422.2880110666667
              :levenshtein 516.4919055333334
              :loops 1086.9474585333335
              :fibonacci 930.1996167333333}
   "Bun" {:hello-world 11.0074804
          :levenshtein 45.851605600000006
          :loops 2040.2328000666666
          :fibonacci 1106.8034056}
   "C__AOT" {:hello-world 5.002424866666667
             :levenshtein 24.4892444
             :loops 2062.8914278666666}
   "V" {:hello-world 3.5103916666666666
        :levenshtein 16.8474334
        :loops 640.7115388666667
        :fibonacci 502.73222786666673}
   "Zig" {:hello-world 2.9299305999999996
          :levenshtein 13.619152733333335
          :loops 638.0849498666668
          :fibonacci 503.3477750000002}
   "Racket" {:hello-world 51.031916599999995 :loops 2290.700958333333}
   "Free_Pascal" {:levenshtein 24.33544993333334
                  :loops 2204.3495028666666
                  :fibonacci 842.6177667333334}
   "LuaJIT" {:hello-world 2.9333055333333338
             :levenshtein 44.86136380000001
             :loops 996.3510084000001
             :fibonacci 962.631114}
   "F_" {:hello-world 36.43275560000001
         :levenshtein 110.83874713333333
         :loops 2198.9376527333334
         :fibonacci 530.2439695333333}
   "Scala_Native" {:hello-world 3.165333333333333
                   :levenshtein 16.75780826666667
                   :loops 640.5770388666667
                   :fibonacci 493.103964}
   "COBOL" {:hello-world 7.805366733333334 :loops 209839.31532506668}
   "PHP_JIT" {:levenshtein 230.29088606666667
              :loops 3299.651041666666
              :fibonacci 4090.5695472}
   "Go" {:hello-world 3.2705306
         :levenshtein 20.610794400000003
         :loops 2121.8961250666666
         :fibonacci 713.7793416666668}
   "Java" {:hello-world 65.7672194
           :levenshtein 124.55507513333333
           :loops 717.9449971333333
           :fibonacci 534.6286222666668}
   "Odin" {:hello-world 2.6786664000000004
           :levenshtein 13.448149933333335
           :loops 642.3499499333335
           :fibonacci 506.1385999333333}
   "Common_Lisp" {:hello-world 20.12446673333334
                  :levenshtein 73.91378886666668
                  :loops 2771.3611973333336
                  :fibonacci 1401.1101418}
   "Node" {:hello-world 45.26035546666667
           :levenshtein 88.61598053333334
           :loops 2136.9937640000007
           :fibonacci 1541.2265943333337}
   "Bun_Scala_JS_Compiled_" {:hello-world 11.072766800000002
                             :levenshtein 61.728602800000004
                             :loops 2090.445719533334
                             :fibonacci 928.3328750000001}})

