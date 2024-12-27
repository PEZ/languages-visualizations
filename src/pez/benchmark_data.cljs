(ns pez.benchmark-data)

(def benchmarks
  {"Clojure_Native" {:fibonacci-hello-world 4.645805333333334
                     :levenshtein-hello-world 5.0738330000000005
                     :loops-hello-world 4.9552363333333345
                     :levenshtein 19.633610666666666
                     :loops 502.22390300000006
                     :fibonacci 307.59337533333337}
   "Kotlin_JVM" {:fibonacci-hello-world 53.964722333333334
                 :fibonacci 346.9430556666667}
   "Ruby_YJIT" {:fibonacci-hello-world 30.425236000000005
                :fibonacci 1478.648041666667}
   "Java_Native" {:fibonacci-hello-world 4.670069333333334 :fibonacci 281.0415}
   "PHP" {:fibonacci-hello-world 40.81051366666667 :fibonacci 9974.719111333334}
   "Elixir" {:fibonacci-hello-world 200.5854446666667
             :fibonacci 978.0331530000001}
   "MAWK" {:fibonacci-hello-world 4.229111 :fibonacci 13836.777957999999}
   "Python" {:fibonacci-hello-world 19.100013666666666
             :fibonacci 17772.851527666666}
   "PyPy" {:fibonacci-hello-world 23.024972333333334 :fibonacci 1696.91425}
   "Deno" {:fibonacci-hello-world 25.963986000000006 :fibonacci 962.3555693333334}
   "CPP" {:fibonacci-hello-world 2.127541666666667
          :levenshtein-hello-world 2.0641523333333334
          :loops-hello-world 2.0801943333333335
          :levenshtein 9.372250000000001
          :loops 474.5205416666667
          :fibonacci 275.082875}
   "Ruby" {:fibonacci-hello-world 31.349791666666675
           :fibonacci 11681.001499999998}
   "Rust" {:fibonacci-hello-world 2.210541666666667 :fibonacci 285.57069500000006}
   "Lua" {:fibonacci-hello-world 4.334069333333334 :fibonacci 6390.944902666667}
   "Swift" {:fibonacci-hello-world 3.5954583333333336
            :fibonacci 402.37181966666674}
   "C" {:fibonacci-hello-world 2.496680666666667
        :levenshtein-hello-world 2.328542
        :loops-hello-world 2.421097666666667
        :levenshtein 9.177985999999999
        :loops 473.6411943333334
        :fibonacci 255.58393066666667}
   "Clojure" {:fibonacci-hello-world 302.2928613333334
              :levenshtein-hello-world 323.514514
              :loops-hello-world 307.91177766666664
              :levenshtein 363.3546250000001
              :loops 799.478278
              :fibonacci 863.9085416666667}
   "V" {:fibonacci-hello-world 3.7320420000000003 :fibonacci 290.8742223333333}
   "Zig" {:fibonacci-hello-world 2.3704306666666666 :fibonacci 333.71108333333336}
   "Java_GraalVM" {:levenshtein-hello-world 4.8957776666666675
                   :loops-hello-world 4.161638666666666
                   :levenshtein 24.96037466666667
                   :loops 497.2625973333334}
   "LuaJIT" {:fibonacci-hello-world 3.2337913333333335
             :fibonacci 615.5055696666668}
   "PHP_JIT" {:fibonacci-hello-world 41.74606966666667 :fibonacci 4094.857125}
   "Java" {:fibonacci-hello-world 51.319472000000005
           :levenshtein-hello-world 50.539861
           :loops-hello-world 50.65176400000001
           :levenshtein 100.53193066666667
           :loops 530.941486
           :fibonacci 345.01050000000004}
   "Odin" {:fibonacci-hello-world 2.2983890000000002
           :fibonacci 333.70308300000005}
   "Node" {:fibonacci-hello-world 29.924264
           :levenshtein-hello-world 31.135861333333338
           :loops-hello-world 30.615264000000003
           :levenshtein 63.234514000000004
           :loops 777.1532083333334
           :fibonacci 882.6181803333335}})


