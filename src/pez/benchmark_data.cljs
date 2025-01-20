(ns pez.benchmark-data)

(def benchmarks
  {"Julia" {:levenshtein {:mean 967.1210026666669}
            :loops {:mean 2212.3613137999996}}
   "Clojure_Native" {:hello-world {:mean 5.993319533333334}
                     :levenshtein {:mean 1648.1433665999998}
                     :loops {:mean 665.1388860666666}
                     :fibonacci {:mean 434.1067054666668}}
   "Kotlin_JVM" {:hello-world {:mean 88.85027779999999}
                 :loops {:mean 751.8568444000001}
                 :fibonacci {:mean 574.0480667333333}}
   "Emacs_Lisp_Native" {:hello-world {:mean 88.99111953333335}
                        :loops {:mean 15005.086608399999}
                        :fibonacci {:mean 2641.0720721999996}}
   "Bun__Compiled_" {:hello-world {:mean 18.08085826666667}
                     :levenshtein {:mean 1595.1271970666667}
                     :loops {:mean 2098.054833333333}
                     :fibonacci {:mean 923.9544666666667}}
   "Ruby_YJIT" {:hello-world {:mean 39.42044193333334}
                :levenshtein {:mean 15569.231266666666}
                :loops {:mean 14983.8338944}
                :fibonacci {:mean 2567.5898166666675}}
   "Java_Native" {:hello-world {:mean 6.136594466666667}
                  :levenshtein {:mean 1528.0068919333335}
                  :loops {:mean 662.9526333333334}
                  :fibonacci {:mean 460.1557722}}
   "Dart" {:hello-world {:mean 16.628566733333333}
           :loops {:mean 705.0174917333334}
           :fibonacci {:mean 932.3925696666668}}
   "PHP" {:levenshtein {:mean 39439.424580733335}
          :loops {:mean 13556.124411133336}
          :fibonacci {:mean 16074.02326953333}}
   "Elixir" {:hello-world {:mean 271.5194388666667}
             :loops {:mean 3284.3453831999987}
             :fibonacci {:mean 1660.5321860666668}}
   "Objective_C" {:hello-world {:mean 4.371908266666668}
                  :levenshtein {:mean 722.0414028}
                  :loops {:mean 656.3720112000001}
                  :fibonacci {:mean 508.55265826666675}}
   "F__AOT" {:hello-world {:mean 5.822216666666667}
             :levenshtein {:mean 1630.7655278000002}
             :loops {:mean 2134.8671946666673}
             :fibonacci {:mean 658.0181693333334}}
   "Python" {:hello-world {:mean 24.52059426666667}
             :levenshtein {:mean 68276.30243046669}
             :loops {:mean 45087.46532206667}
             :fibonacci {:mean 27336.012091666664}}
   "C_" {:hello-world {:mean 33.38117206666667}
         :levenshtein {:mean 1338.4192666666665}
         :loops {:mean 2170.0833221999997}
         :fibonacci {:mean 577.4649445333334}}
   "Modula_2" {:hello-world {:mean 14.324322133333336}}
   "PyPy" {:hello-world {:mean 28.117474866666665}
           :loops {:mean 3299.746180666666}
           :fibonacci {:mean 2369.8589805999995}}
   "Deno" {:hello-world {:mean 22.262058399999997}
           :levenshtein {:mean 2366.546277733333}
           :loops {:mean 2073.0398388666667}
           :fibonacci {:mean 1557.2409056000001}}
   "Nim" {:levenshtein {:mean 2361.9295944000005}
          :loops {:mean 652.0700693333334}}
   "CPP" {:hello-world {:mean 4.383511000000001}
          :levenshtein {:mean 708.5599527333333}
          :loops {:mean 657.2610860666667}
          :fibonacci {:mean 507.81028066666664}}
   "Python_JIT" {:hello-world {:mean 24.21322226666667}
                 :levenshtein {:mean 13567.46792213333}
                 :loops {:mean 2460.5432417333336}
                 :fibonacci {:mean 1130.8755583999998}}
   "Kotlin_Native" {:hello-world {:mean 5.280686133333334}
                    :loops {:mean 2104.5234445333335}
                    :fibonacci {:mean 521.5622110666668}}
   "Fortran" {:hello-world {:mean 4.272488933333333}
              :levenshtein {:mean 590.9776058000001}
              :loops {:mean 652.5200445333334}
              :fibonacci {:mean 5.702905533333333}}
   "Scala" {:hello-world {:mean 145.83199426666667}
            :levenshtein {:mean 1292.0506359333335}
            :loops {:mean 801.9505277333333}
            :fibonacci {:mean 632.0759056}}
   "Ruby" {:hello-world {:mean 39.41320553333333}
           :levenshtein {:mean 36319.00707206666}
           :loops {:mean 39393.1934388}
           :fibonacci {:mean 13838.315424999999}}
   "Rust" {:hello-world {:mean 3.4058387333333333}
           :levenshtein {:mean 707.1504583999999}
           :loops {:mean 654.5385194666669}
           :fibonacci {:mean 505.01601939999995}}
   "Lua" {:hello-world {:mean 3.8978222000000002}
          :levenshtein {:mean 29103.031377799998}
          :loops {:mean 52501.731285999995}
          :fibonacci {:mean 12105.065066733334}}
   "Deno__jitless_" {:hello-world {:mean 21.84410833333333}
                     :levenshtein {:mean 33908.77721386667}
                     :loops {:mean 22717.714205599998}
                     :fibonacci {:mean 20202.614027800002}}
   "Bun_Scala_JS" {:hello-world {:mean 11.686236133333335}
                   :levenshtein {:mean 1551.0945612000003}
                   :loops {:mean 2148.529161}
                   :fibonacci {:mean 958.4089723333335}}
   "Swift" {:hello-world {:mean 3.715194466666667}
            :levenshtein {:mean 751.7735554666668}
            :loops {:mean 651.2548416666667}
            :fibonacci {:mean 675.6732472666669}}
   "R" {:levenshtein {:mean 222585.81332240003}
        :fibonacci {:mean 93566.39475553334}}
   "C" {:hello-world {:mean 3.054597133333334}
        :levenshtein {:mean 592.4954306}
        :loops {:mean 677.7765582666667}
        :fibonacci {:mean 274.39614706666663}}
   "C3" {:hello-world {:mean 4.020594533333334}
         :loops {:mean 2673.995611400001}
         :fibonacci {:mean 924.9714915333335}}
   "Clojure" {:hello-world {:mean 440.64833613333326}
              :levenshtein {:mean 2105.820919466667}
              :loops {:mean 1116.5108362666665}
              :fibonacci {:mean 958.4321500666667}}
   "Bun" {:hello-world {:mean 10.726772266666666}
          :levenshtein {:mean 1606.3785889333333}
          :loops {:mean 2095.2968943333335}
          :fibonacci {:mean 1148.9967831333333}}
   "C__AOT" {:hello-world {:mean 5.4026890000000005}
             :levenshtein {:mean 1310.673627733333}
             :loops {:mean 2130.2715666000004}
             :fibonacci {:mean 650.8295499999999}}
   "V" {:hello-world {:mean 3.772858333333333}
        :levenshtein {:mean 740.7803666}
        :loops {:mean 658.4057890000001}
        :fibonacci {:mean 520.8993582}}
   "Zig" {:hello-world {:mean 3.1116224000000003}
          :levenshtein {:mean 761.5262749333335}
          :loops {:mean 653.2253414666668}
          :fibonacci {:mean 519.386775}}
   "Racket" {:hello-world {:mean 50.426200066666674}
             :levenshtein {:mean 6101.6335668}
             :loops {:mean 2304.3042916}
             :fibonacci {:mean 990.9791806000001}}
   "Free_Pascal" {;:levenshtein {:mean 273.85144160000004}
                  :loops {:mean 2236.8419611333334}
                  :fibonacci {:mean 868.1321250666668}}
   "LuaJIT" {:hello-world {:mean 3.3301999333333336}
             :levenshtein {:mean 1260.7047306}
             :loops {:mean 1006.4970609999999}
             :fibonacci {:mean 997.5341861333334}}
   "F_" {:hello-world {:mean 39.69456386666667}
         :levenshtein {:mean 1594.8296639999996}
         :loops {:mean 2276.256149933333}
         :fibonacci {:mean 551.9943557333334}}
   "Scala_Native" {:hello-world {:mean 3.565175}
                   :levenshtein {:mean 770.9643526000001}
                   :loops {:mean 657.4971248666668}
                   :fibonacci {:mean 507.6458222000001}}
   "COBOL" {:hello-world {:mean 6.081233333333334}
            :loops {:mean 211700.81156119998}}
   "PHP_JIT" {:levenshtein {:mean 9919.172402866669}
              :loops {:mean 3330.6624443999995}
              :fibonacci {:mean 4217.905027666667}}
   "Go" {:hello-world {:mean 3.907183333333333}
         :levenshtein {:mean 1199.3512109333333}
         :loops {:mean 2132.8680416}
         :fibonacci {:mean 734.9682335333335}}
   "Java" {:hello-world {:mean 80.81876666666666}
           :levenshtein {:mean 1040.7946834666668}
           :loops {:mean 745.3504389999999}
           :fibonacci {:mean 568.1215499333334}}
   "Odin" {:hello-world {:mean 3.0235999333333337}
           :levenshtein {:mean 715.243425}
           :loops {:mean 654.9926164666665}
           :fibonacci {:mean 520.9414082}}
   "Node" {:hello-world {:mean 46.57630840000001}
           :levenshtein {:mean 2409.7490360000006}
           :loops {:mean 2174.964960933333}
           :fibonacci {:mean 1586.4639529333333}}
   "Bun_Scala_JS_Compiled_" {:hello-world {:mean 11.308138933333332}
                             :levenshtein {:mean 1552.4791139333333}
                             :loops {:mean 2148.2329944666667}
                             :fibonacci {:mean 956.0877110666667}}})

(def csv
  "benchmark,timestamp,commit_sha,is_checked,user,model,ram,os,arch,language,run_ms,mean_ms,std-dev-ms,min_ms,max_ms,runs
loops,2025-01-19T22:46:26Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Babashka,10000,7424.6105625,15.1540215,7409.456541,7439.764584,2
loops,2025-01-19T22:46:26Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C,10000,62.584331,0.361769,61.983000,63.846000,160
loops,2025-01-19T22:46:26Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure,10000,63.49096494936709,1.8132703710071516,62.863292,85.778417,158
loops,2025-01-19T22:46:26Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure Native,10000,62.43854038509317,0.25551889399353184,62.075375,63.692708,161
loops,2025-01-19T22:46:26Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java,10000,62.346321,0.273229,61.997250,63.794333,161
loops,2025-01-19T22:46:26Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java Native,10000,62.434206,0.373731,62.018791,64.486000,161
levenshtein,2025-01-19T22:43:38Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Babashka,10000,31774.268,0.0,31774.268,31774.268,1
levenshtein,2025-01-19T22:43:38Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C,10000,52.100229,0.259625,51.786000,53.643000,192
levenshtein,2025-01-19T22:43:38Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure,10000,152.9290183333333,0.6283193912264139,151.846375,155.472792,66
levenshtein,2025-01-19T22:43:38Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure Native,10000,146.5472023188406,1.1395722245945648,145.141958,151.900458,69
levenshtein,2025-01-19T22:43:38Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java,10000,82.003262,0.388162,81.401084,84.121917,122
levenshtein,2025-01-19T22:43:38Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java Native,10000,143.956083,0.753868,142.855583,148.174708,70
hello-world,2025-01-19T22:43:21Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Babashka,10000,19.8309,7.22935,11.987,32.5077,25
hello-world,2025-01-19T22:43:21Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C,10000,3.15546,0.279976,2.81488,3.83396,25
hello-world,2025-01-19T22:43:21Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure,10000,428.491,6.42927,421.271,445.199,25
hello-world,2025-01-19T22:43:21Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure Native,10000,5.95841,0.353384,5.19296,6.63154,25
hello-world,2025-01-19T22:43:21Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java,10000,68.7885,5.01181,65.3752,92.4734,25
hello-world,2025-01-19T22:43:21Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java Native,10000,5.54246,0.343417,5.12571,6.418,25
fibonacci,2025-01-19T22:48:32Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Babashka,10000,6565.949938,33.363396,6532.586542,6599.313334,2
fibonacci,2025-01-19T22:48:32Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C,10000,32.608759,0.379883,32.202000,34.183000,307
fibonacci,2025-01-19T22:48:32Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure,10000,64.95256036363637,0.441154849773581,64.409208,67.658792,154
fibonacci,2025-01-19T22:48:32Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure Native,10000,58.03022950867052,0.30005473301274266,57.560209,59.945583,173
fibonacci,2025-01-19T22:48:32Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java,10000,61.704780,0.300087,60.784000,62.769625,163
fibonacci,2025-01-19T22:48:32Z,69de15c,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java Native,10000,80.030737,2.029489,79.367500,102.211959,125")