(ns pez.benchmark-data)

(def legacy
  {"Julia"             {:levenshtein {:max    976.887292
                                      :mean   967.1210026666669
                                      :median 969.815375
                                      :min    946.9689160000001
                                      :stddev 7.132191628407268
                                      :runs   15}
                        :loops       {:max    2289.511208
                                      :mean   2212.3613137999996
                                      :median 2206.870042
                                      :min    2187.847875
                                      :stddev 23.595082591970037
                                      :runs   15}}
   "Clojure_Native"    {:hello-world {:max    6.70525
                                      :mean   5.993319533333334
                                      :median 5.9527090000000005
                                      :min    5.347417
                                      :stddev 0.4221093331736065
                                      :runs   15}
                        :levenshtein {:max    1660.799958
                                      :mean   1648.1433665999998
                                      :median 1646.703084
                                      :min    1643.8220000000001
                                      :stddev 4.349474827760758
                                      :runs   15}
                        :loops       {:max    669.277833
                                      :mean   665.1388860666666
                                      :median 665.427541
                                      :min    661.586709
                                      :stddev 2.0983904904234203
                                      :runs   15}
                        :fibonacci   {:max    438.9105
                                      :mean   434.1067054666668
                                      :median 433.654541
                                      :min    429.774917
                                      :stddev 2.75908212301301
                                      :runs   15}}
   "Kotlin_JVM"        {:hello-world {:max    96.919666
                                      :mean   88.85027779999999
                                      :median 90.86087500000001
                                      :min    72.62666700000001
                                      :stddev 7.230433180168017
                                      :runs   15}
                        :loops       {:max    770.105083
                                      :mean   751.8568444000001
                                      :median 751.0627910000001
                                      :min    746.0639170000001
                                      :stddev 5.357752510044183
                                      :runs   15}
                        :fibonacci   {:max    578.9747080000001
                                      :mean   574.0480667333333
                                      :median 575.0472080000001
                                      :min    552.072417
                                      :stddev 6.404894655670057
                                      :runs   15}}
   "Emacs_Lisp_Native" {:hello-world {:max    93.784667
                                      :mean   88.99111953333335
                                      :median 90.050375
                                      :min    83.701166
                                      :stddev 3.4309417133603586
                                      :runs   15}
                        :loops       {:max    15063.393959
                                      :mean   15005.086608399999
                                      :median 14993.869917
                                      :min    14967.349625
                                      :stddev 29.33486374340735
                                      :runs   15}
                        :fibonacci   {:max    2663.1977500000003
                                      :mean   2641.0720721999996
                                      :median 2635.8445
                                      :min    2630.6534580000002
                                      :stddev 10.049330816647256
                                      :runs   15}}
   "Bun__Compiled_"    {:hello-world {:max    24.100375
                                      :mean   18.08085826666667
                                      :median 18.062250000000002
                                      :min    13.970541
                                      :stddev 2.8283165241597454
                                      :runs   15}
                        :levenshtein {:max    1600.33025
                                      :mean   1595.1271970666667
                                      :median 1596.359083
                                      :min    1582.513083
                                      :stddev 4.287741104937116
                                      :runs   15}
                        :loops       {:max    2139.480333
                                      :mean   2098.054833333333
                                      :median 2095.571583
                                      :min    2087.0045410000002
                                      :stddev 12.273036624329457
                                      :runs   15}
                        :fibonacci   {:max    927.2060000000001
                                      :mean   923.9544666666667
                                      :median 923.336625
                                      :min    921.557625
                                      :stddev 1.723313827785242
                                      :runs   15}}
   "Ruby_YJIT"         {:hello-world {:max    40.569834
                                      :mean   39.42044193333334
                                      :median 39.628375
                                      :min    36.471334
                                      :stddev 1.0840606054384778
                                      :runs   15}
                        :levenshtein {:max    16556.886250000003
                                      :mean   15569.231266666666
                                      :median 15133.653208
                                      :min    14811.959125
                                      :stddev 709.7265531467117
                                      :runs   15}
                        :loops       {:max    15021.681834
                                      :mean   14983.8338944
                                      :median 14979.633959
                                      :min    14953.634958
                                      :stddev 18.756498803116013
                                      :runs   15}
                        :fibonacci   {:max    2587.043458
                                      :mean   2567.5898166666675
                                      :median 2563.90275
                                      :min    2561.22575
                                      :stddev 7.7498071862091145
                                      :runs   15}}
   "Java_Native"       {:hello-world {:max    7.094209
                                      :mean   6.136594466666667
                                      :median 6.006292000000001
                                      :min    5.544833000000001
                                      :stddev 0.5503444553531731
                                      :runs   15}
                        :levenshtein {:max    1534.119042
                                      :mean   1528.0068919333335
                                      :median 1528.3319589999999
                                      :min    1520.8205420000002
                                      :stddev 2.949724639472763
                                      :runs   15}
                        :loops       {:max    669.1025000000001
                                      :mean   662.9526333333334
                                      :median 663.29825
                                      :min    656.032167
                                      :stddev 2.9024481441125136
                                      :runs   15}
                        :fibonacci   {:max    464.804166
                                      :mean   460.1557722
                                      :median 460.978083
                                      :min    455.322959
                                      :stddev 2.7047593310600258
                                      :runs   15}}
   "Dart"              {:hello-world {:max    17.805291
                                      :mean   16.628566733333333
                                      :median 16.905125
                                      :min    15.1935
                                      :stddev 0.8689472261534535
                                      :runs   15}
                        :loops       {:max    725.7118330000001
                                      :mean   705.0174917333334
                                      :median 704.3748750000001
                                      :min    698.062709
                                      :stddev 6.391314142690774
                                      :runs   15}
                        :fibonacci   {:max    950.884542
                                      :mean   932.3925696666668
                                      :median 929.9999590000001
                                      :min    927.408708
                                      :stddev 7.416229947109396
                                      :runs   15}}
   "PHP"               {:levenshtein {:max    39522.290917
                                      :mean   39439.424580733335
                                      :median 39444.819707999995
                                      :min    39364.632375
                                      :stddev 51.693184965464006
                                      :runs   15}
                        :loops       {:max    14026.276875000001
                                      :mean   13556.124411133336
                                      :median 13497.779959000001
                                      :min    13417.187583
                                      :stddev 156.6405803489976
                                      :runs   15}
                        :fibonacci   {:max    16225.718541999999
                                      :mean   16074.02326953333
                                      :median 16061.750916
                                      :min    16012.990291000002
                                      :stddev 51.33787604949667
                                      :runs   15}}
   "Elixir"            {:hello-world {:max    321.40254200000004
                                      :mean   271.5194388666667
                                      :median 269.5135
                                      :min    252.32316600000004
                                      :stddev 16.281972899512944
                                      :runs   15}
                        :loops       {:max    3519.6630830000004
                                      :mean   3284.3453831999987
                                      :median 3262.426584
                                      :min    3253.9207499999998
                                      :stddev 67.17789583374125
                                      :runs   15}
                        :fibonacci   {:max    1991.3292920000001
                                      :mean   1660.5321860666668
                                      :median 1611.3036250000002
                                      :min    1601.711958
                                      :stddev 132.72179169698
                                      :runs   15}}
   "Objective_C"       {:hello-world {:max    5.102042
                                      :mean   4.371908266666668
                                      :median 4.33525
                                      :min    3.714667
                                      :stddev 0.35255013128681767
                                      :runs   15}
                        :levenshtein {:max    725.078208
                                      :mean   722.0414028
                                      :median 722.1040830000001
                                      :min    718.8302090000001
                                      :stddev 1.690480160292543
                                      :runs   15}
                        :loops       {:max    659.9432500000001
                                      :mean   656.3720112000001
                                      :median 656.687625
                                      :min    653.543625
                                      :stddev 1.8986252996813031
                                      :runs   15}
                        :fibonacci   {:max    529.444375
                                      :mean   508.55265826666675
                                      :median 507.2342080000001
                                      :min    500.904958
                                      :stddev 7.492374870699703
                                      :runs   15}}
   "F__AOT"            {:hello-world {:max    6.528208
                                      :mean   5.822216666666667
                                      :median 5.641875
                                      :min    5.390542
                                      :stddev 0.4033244881238692
                                      :runs   15}
                        :levenshtein {:max    1691.245083
                                      :mean   1630.7655278000002
                                      :median 1625.787458
                                      :min    1622.94275
                                      :stddev 17.028224036372695
                                      :runs   15}
                        :loops       {:max    2146.065791
                                      :mean   2134.8671946666673
                                      :median 2134.116542
                                      :min    2123.747875
                                      :stddev 6.128083990173309
                                      :runs   15}
                        :fibonacci   {:max    662.870667
                                      :mean   658.0181693333334
                                      :median 657.68525
                                      :min    654.007208
                                      :stddev 2.431941015855179
                                      :runs   15}}
   "Python"            {:hello-world {:max    42.402875
                                      :mean   24.52059426666667
                                      :median 23.212042000000004
                                      :min    21.826583
                                      :stddev 5.008918299897557
                                      :runs   15}
                        :levenshtein {:max    69589.137875
                                      :mean   68276.30243046669
                                      :median 68859.266208
                                      :min    66680.068625
                                      :stddev 1133.0497821070696
                                      :runs   15}
                        :loops       {:max    47261.756291
                                      :mean   45087.46532206667
                                      :median 45032.126375
                                      :min    44474.475542
                                      :stddev 688.1870584229736
                                      :runs   15}
                        :fibonacci   {:max    27819.588208999998
                                      :mean   27336.012091666664
                                      :median 27272.932999999997
                                      :min    27197.430833
                                      :stddev 180.08241294672808
                                      :runs   15}}
   "C_"                {:hello-world {:max    36.27850000000001
                                      :mean   33.38117206666667
                                      :median 32.081625
                                      :min    31.269000000000005
                                      :stddev 1.9728605628691787
                                      :runs   15}
                        :levenshtein {:max    1346.713291
                                      :mean   1338.4192666666665
                                      :median 1338.678375
                                      :min    1325.2105840000002
                                      :stddev 5.535681968643792
                                      :runs   15}
                        :loops       {:max    2183.81625
                                      :mean   2170.0833221999997
                                      :median 2169.152083
                                      :min    2161.1626250000004
                                      :stddev 6.375388253916849
                                      :runs   15}
                        :fibonacci   {:max    585.6225420000001
                                      :mean   577.4649445333334
                                      :median 580.0187500000001
                                      :min    563.892375
                                      :stddev 6.811564440014633
                                      :runs   15}}
   "Modula_2"          {:hello-world {:max    15.411292000000001
                                      :mean   14.324322133333336
                                      :median 14.732375000000001
                                      :min    12.623666
                                      :stddev 0.9709651863684674
                                      :runs   15}}
   "PyPy"              {:hello-world {:max    31.382125000000002
                                      :mean   28.117474866666665
                                      :median 28.503042000000004
                                      :min    24.986833
                                      :stddev 1.8171882455384545
                                      :runs   15}
                        :loops       {:max    3323.692584
                                      :mean   3299.746180666666
                                      :median 3300.9827920000002
                                      :min    3276.9122089999996
                                      :stddev 12.56672453804225
                                      :runs   15}
                        :fibonacci   {:max    2421.384458
                                      :mean   2369.8589805999995
                                      :median 2367.865583
                                      :min    2351.858541
                                      :stddev 15.123834053404401
                                      :runs   15}}
   "Deno"              {:hello-world {:max    25.273334000000002
                                      :mean   22.262058399999997
                                      :median 22.132792000000002
                                      :min    21.256500000000003
                                      :stddev 0.9646825622444632
                                      :runs   15}
                        :levenshtein {:max    2381.8286249999996
                                      :mean   2366.546277733333
                                      :median 2366.002375
                                      :min    2358.464083
                                      :stddev 4.889311639104109
                                      :runs   15}
                        :loops       {:max    2085.4709580000003
                                      :mean   2073.0398388666667
                                      :median 2073.920709
                                      :min    2065.149167
                                      :stddev 4.950586567596109
                                      :runs   15}
                        :fibonacci   {:max    1570.832
                                      :mean   1557.2409056000001
                                      :median 1556.951875
                                      :min    1552.774375
                                      :stddev 4.182055607225979
                                      :runs   15}}
   "Nim"               {:levenshtein {:max    2377.968708
                                      :mean   2361.9295944000005
                                      :median 2361.5414170000004
                                      :min    2345.622959
                                      :stddev 6.540511636380981
                                      :runs   15}
                        :loops       {:max    674.2538330000001
                                      :mean   652.0700693333334
                                      :median 651.344
                                      :min    647.4899580000001
                                      :stddev 6.361685490084028
                                      :runs   15}}
   "CPP"               {:hello-world {:max    22.735834
                                      :mean   4.383511000000001
                                      :median 3.208
                                      :min    2.585166
                                      :stddev 5.086243625885287
                                      :runs   15}
                        :levenshtein {:max    725.625583
                                      :mean   708.5599527333333
                                      :median 707.8162500000001
                                      :min    699.5429160000001
                                      :stddev 6.235727826849709
                                      :runs   15}
                        :loops       {:max    679.95225
                                      :mean   657.2610860666667
                                      :median 655.5817910000001
                                      :min    651.611667
                                      :stddev 6.673700507889083
                                      :runs   15}
                        :fibonacci   {:max    530.221167
                                      :mean   507.81028066666664
                                      :median 506.168292
                                      :min    498.680625
                                      :stddev 7.857387142814512
                                      :runs   15}}
   "Python_JIT"        {:hello-world {:max    24.881542000000003
                                      :mean   24.21322226666667
                                      :median 24.151042
                                      :min    23.506333
                                      :stddev 0.3961109320550189
                                      :runs   15}
                        :levenshtein {:max    21372.222875
                                      :mean   13567.46792213333
                                      :median 12914.836083
                                      :min    12878.853083
                                      :stddev 2182.8002940458287
                                      :runs   15}
                        :loops       {:max    2482.294959
                                      :mean   2460.5432417333336
                                      :median 2455.094875
                                      :min    2448.5809999999997
                                      :stddev 11.462734484418105
                                      :runs   15}
                        :fibonacci   {:max    1146.377541
                                      :mean   1130.8755583999998
                                      :median 1129.583416
                                      :min    1123.0724169999999
                                      :stddev 6.021401039055028
                                      :runs   15}}
   "Kotlin_Native"     {:hello-world {:max    6.003583000000001
                                      :mean   5.280686133333334
                                      :median 5.0589580000000005
                                      :min    4.728791
                                      :stddev 0.47047644863491717
                                      :runs   15}
                        :loops       {:max    2121.731958
                                      :mean   2104.5234445333335
                                      :median 2104.042958
                                      :min    2090.37525
                                      :stddev 6.287241882255912
                                      :runs   15}
                        :fibonacci   {:max    527.5995
                                      :mean   521.5622110666668
                                      :median 520.4246250000001
                                      :min    517.9149160000001
                                      :stddev 2.7240691024945938
                                      :runs   15}}
   "Fortran"           {:hello-world {:max    4.851292
                                      :mean   4.272488933333333
                                      :median 4.404542
                                      :min    3.575416
                                      :stddev 0.3359421989710362
                                      :runs   15}
                        :levenshtein {:max    594.3524170000001
                                      :mean   590.9776058000001
                                      :median 590.6751250000001
                                      :min    588.268625
                                      :stddev 1.8088859834615698
                                      :runs   15}
                        :loops       {:max    677.696625
                                      :mean   652.5200445333334
                                      :median 650.582542
                                      :min    644.7585
                                      :stddev 8.310531574423523
                                      :runs   15}
                        :fibonacci   {:max    6.848834000000001
                                      :mean   5.702905533333333
                                      :median 5.707291000000001
                                      :min    5.020125
                                      :stddev 0.5802213248407723
                                      :runs   15}}
   "Scala"             {:hello-world {:max    150.876708
                                      :mean   145.83199426666667
                                      :median 148.053708
                                      :min    125.71116700000002
                                      :stddev 6.519432572893643
                                      :runs   15}
                        :levenshtein {:max    1295.2215410000001
                                      :mean   1292.0506359333335
                                      :median 1292.738666
                                      :min    1286.84325
                                      :stddev 2.4849156499970753
                                      :runs   15}
                        :loops       {:max    807.7454580000001
                                      :mean   801.9505277333333
                                      :median 803.829333
                                      :min    783.8137500000001
                                      :stddev 7.473097747213808
                                      :runs   15}
                        :fibonacci   {:max    648.193833
                                      :mean   632.0759056
                                      :median 634.2694170000001
                                      :min    613.6382920000001
                                      :stddev 10.442043646565997
                                      :runs   15}}
   "Ruby"              {:hello-world {:max    40.95341700000001
                                      :mean   39.41320553333333
                                      :median 39.73762500000001
                                      :min    36.276375
                                      :stddev 1.2805662847930581
                                      :runs   15}
                        :levenshtein {:max    36455.136375
                                      :mean   36319.00707206666
                                      :median 36286.133166
                                      :min    36255.843540999995
                                      :stddev 63.66924260118709
                                      :runs   15}
                        :loops       {:max    39658.835416
                                      :mean   39393.1934388
                                      :median 39383.685041
                                      :min    39125.710292
                                      :stddev 158.56914502890368
                                      :runs   15}
                        :fibonacci   {:max    15121.454875
                                      :mean   13838.315424999999
                                      :median 13741.502208
                                      :min    13624.813667
                                      :stddev 360.89555458164665
                                      :runs   15}}
   "Rust"              {:hello-world {:max    3.7469580000000002
                                      :mean   3.4058387333333333
                                      :median 3.356208
                                      :min    3.1022500000000006
                                      :stddev 0.2303777237189477
                                      :runs   15}
                        :levenshtein {:max    709.2919590000001
                                      :mean   707.1504583999999
                                      :median 706.947333
                                      :min    705.305416
                                      :stddev 1.225346858386334
                                      :runs   15}
                        :loops       {:max    674.286416
                                      :mean   654.5385194666669
                                      :median 653.495209
                                      :min    648.379667
                                      :stddev 6.050506836312137
                                      :runs   15}
                        :fibonacci   {:max    508.3649170000001
                                      :mean   505.01601939999995
                                      :median 504.887917
                                      :min    500.87075000000004
                                      :stddev 2.3188505218630904
                                      :runs   15}}
   "Lua"               {:hello-world {:max    4.541417
                                      :mean   3.8978222000000002
                                      :median 3.887208
                                      :min    3.4677500000000006
                                      :stddev 0.29589434181168683
                                      :runs   15}
                        :levenshtein {:max    30029.899875000003
                                      :mean   29103.031377799998
                                      :median 29226.851166
                                      :min    28637.682417
                                      :stddev 383.8890795614194
                                      :runs   15}
                        :loops       {:max    54210.989666
                                      :mean   52501.731285999995
                                      :median 52583.984625
                                      :min    50743.108666
                                      :stddev 982.7794076677287
                                      :runs   15}
                        :fibonacci   {:max    12180.9855
                                      :mean   12105.065066733334
                                      :median 12097.485083
                                      :min    12060.424333
                                      :stddev 32.8043368736659
                                      :runs   15}}
   "Deno__jitless_"    {:hello-world {:max    22.685125
                                      :mean   21.84410833333333
                                      :median 22.081875
                                      :min    21.00475
                                      :stddev 0.5275179822352254
                                      :runs   15}
                        :levenshtein {:max    33948.916084
                                      :mean   33908.77721386667
                                      :median 33905.829957999995
                                      :min    33885.626625
                                      :stddev 19.184709033429375
                                      :runs   15}
                        :loops       {:max    22796.576291
                                      :mean   22717.714205599998
                                      :median 22713.017375
                                      :min    22683.9385
                                      :stddev 27.58614385598826
                                      :runs   15}
                        :fibonacci   {:max    20454.7815
                                      :mean   20202.614027800002
                                      :median 20162.921749999998
                                      :min    20004.697125
                                      :stddev 130.2737627807838
                                      :runs   15}}
   "Bun_Scala_JS"      {:hello-world {:max    12.272959
                                      :mean   11.686236133333335
                                      :median 11.745500000000002
                                      :min    11.037167
                                      :stddev 0.32291206295563923
                                      :runs   15}
                        :levenshtein {:max    1561.559375
                                      :mean   1551.0945612000003
                                      :median 1552.507167
                                      :min    1531.8903750000002
                                      :stddev 6.893312452192366
                                      :runs   15}
                        :loops       {:max    2156.280291
                                      :mean   2148.529161
                                      :median 2149.13075
                                      :min    2141.405958
                                      :stddev 4.068093796220557
                                      :runs   15}
                        :fibonacci   {:max    971.4797500000001
                                      :mean   958.4089723333335
                                      :median 957.7241250000001
                                      :min    952.2330410000001
                                      :stddev 4.781257925931759
                                      :runs   15}}
   "Swift"             {:hello-world {:max    4.065209
                                      :mean   3.715194466666667
                                      :median 3.631542
                                      :min    3.3115
                                      :stddev 0.21813681045843897
                                      :runs   15}
                        :levenshtein {:max    772.76325
                                      :mean   751.7735554666668
                                      :median 750.0020420000001
                                      :min    748.4039170000001
                                      :stddev 5.93586189781383
                                      :runs   15}
                        :loops       {:max    657.8543330000001
                                      :mean   651.2548416666667
                                      :median 650.937625
                                      :min    648.0173330000001
                                      :stddev 2.6014704674575264
                                      :runs   15}
                        :fibonacci   {:max    681.486292
                                      :mean   675.6732472666669
                                      :median 675.7417090000001
                                      :min    670.928166
                                      :stddev 2.8112291088446906
                                      :runs   15}}
   "R"                 {:levenshtein {:max    223273.443042
                                      :mean   222585.81332240003
                                      :median 222681.312916
                                      :min    220575.031209
                                      :stddev 707.9778137688538
                                      :runs   15}
                        :fibonacci   {:max    94054.853916
                                      :mean   93566.39475553334
                                      :median 93776.05725
                                      :min    91221.466042
                                      :stddev 754.1586054284599
                                      :runs   15}}
   "C"                 {:hello-world {:max    3.312708
                                      :mean   3.054597133333334
                                      :median 3.121291
                                      :min    2.5947090000000004
                                      :stddev 0.23720744947585037
                                      :runs   15}
                        :levenshtein {:max    610.746542
                                      :mean   592.4954306
                                      :median 590.8755
                                      :min    585.8804170000001
                                      :stddev 6.535060759924134
                                      :runs   15}
                        :loops       {:max    697.7210420000001
                                      :mean   677.7765582666667
                                      :median 677.099041
                                      :min    670.660166
                                      :stddev 6.253194543322127
                                      :runs   15}
                        :fibonacci   {:max    277.493791
                                      :mean   274.39614706666663
                                      :median 275.130916
                                      :min    271.075959
                                      :stddev 2.185296206642519
                                      :runs   15}}
   "C3"                {:hello-world {:max    4.265334
                                      :mean   4.020594533333334
                                      :median 4.004792
                                      :min    3.8906670000000005
                                      :stddev 0.1059764686683299
                                      :runs   15}
                        :loops       {:max    2707.287917
                                      :mean   2673.995611400001
                                      :median 2675.369542
                                      :min    2660.0638339999996
                                      :stddev 11.659592596264401
                                      :runs   15}
                        :fibonacci   {:max    944.2427910000001
                                      :mean   924.9714915333335
                                      :median 923.023125
                                      :min    914.300417
                                      :stddev 8.045992239787461
                                      :runs   15}}
   "Clojure"           {:hello-world {:max    460.66125
                                      :mean   440.64833613333326
                                      :median 441.76312500000006
                                      :min    422.005375
                                      :stddev 11.556382625756799
                                      :runs   15}
                        :levenshtein {:max    2126.400042
                                      :mean   2105.820919466667
                                      :median 2105.49825
                                      :min    2091.878125
                                      :stddev 9.351772286887279
                                      :runs   15}
                        :loops       {:max    1144.22175
                                      :mean   1116.5108362666665
                                      :median 1117.665334
                                      :min    1097.667834
                                      :stddev 12.895617287149953
                                      :runs   15}
                        :fibonacci   {:max    995.6398750000001
                                      :mean   958.4321500666667
                                      :median 958.2357090000002
                                      :min    933.9581250000001
                                      :stddev 17.427822396879158
                                      :runs   15}}
   "Bun"               {:hello-world {:max    11.941
                                      :mean   10.726772266666666
                                      :median 10.394833
                                      :min    10.066042000000001
                                      :stddev 0.6027087827535029
                                      :runs   15}
                        :levenshtein {:max    1623.941792
                                      :mean   1606.3785889333333
                                      :median 1602.988167
                                      :min    1599.695792
                                      :stddev 7.665114479241258
                                      :runs   15}
                        :loops       {:max    2112.6115
                                      :mean   2095.2968943333335
                                      :median 2094.835583
                                      :min    2076.533875
                                      :stddev 8.254282595054724
                                      :runs   15}
                        :fibonacci   {:max    1162.4172079999998
                                      :mean   1148.9967831333333
                                      :median 1154.669041
                                      :min    1111.06025
                                      :stddev 16.078957278807614
                                      :runs   15}}
   "C__AOT"            {:hello-world {:max    5.759833
                                      :mean   5.4026890000000005
                                      :median 5.385209000000001
                                      :min    5.135334
                                      :stddev 0.1663836381473337
                                      :runs   15}
                        :levenshtein {:max    1324.556042
                                      :mean   1310.673627733333
                                      :median 1309.977208
                                      :min    1307.0689579999998
                                      :stddev 4.0943516080059945
                                      :runs   15}
                        :loops       {:max    2144.4855000000002
                                      :mean   2130.2715666000004
                                      :median 2131.853959
                                      :min    2113.2272909999997
                                      :stddev 8.108126003778793
                                      :runs   15}
                        :fibonacci   {:max    666.009667
                                      :mean   650.8295499999999
                                      :median 650.631084
                                      :min    646.0092910000001
                                      :stddev 4.739008477194248
                                      :runs   15}}
   "V"                 {:hello-world {:max    4.400209
                                      :mean   3.772858333333333
                                      :median 3.8111660000000005
                                      :min    3.21125
                                      :stddev 0.3266278060343448
                                      :runs   15}
                        :levenshtein {:max    761.684958
                                      :mean   740.7803666
                                      :median 741.178292
                                      :min    718.8396250000001
                                      :stddev 10.61900294305392
                                      :runs   15}
                        :loops       {:max    676.192417
                                      :mean   658.4057890000001
                                      :median 656.3492090000001
                                      :min    653.4640420000001
                                      :stddev 6.679694138309514
                                      :runs   15}
                        :fibonacci   {:max    539.397166
                                      :mean   520.8993582
                                      :median 519.408167
                                      :min    516.7230000000001
                                      :stddev 5.577048997400693
                                      :runs   15}}
   "Zig"               {:hello-world {:max    3.5219590000000003
                                      :mean   3.1116224000000003
                                      :median 3.1107080000000003
                                      :min    2.731125
                                      :stddev 0.22644128839748798
                                      :runs   15}
                        :levenshtein {:max    763.5706250000001
                                      :mean   761.5262749333335
                                      :median 761.6337920000001
                                      :min    760.349041
                                      :stddev 0.7909615276283806
                                      :runs   15}
                        :loops       {:max    658.54775
                                      :mean   653.2253414666668
                                      :median 653.3396250000001
                                      :min    649.074875
                                      :stddev 2.492236782038128
                                      :runs   15}
                        :fibonacci   {:max    523.5282920000001
                                      :mean   519.386775
                                      :median 518.981167
                                      :min    516.4519170000001
                                      :stddev 2.3058713756916815
                                      :runs   15}}
   "Racket"            {:hello-world {:max    51.700500000000005
                                      :mean   50.426200066666674
                                      :median 50.725417
                                      :min    47.33825
                                      :stddev 1.118577187832922
                                      :runs   15}
                        :levenshtein {:max    6123.793791
                                      :mean   6101.6335668
                                      :median 6102.859083
                                      :min    6074.747
                                      :stddev 13.317873949612089
                                      :runs   15}
                        :loops       {:max    2314.1953750000002
                                      :mean   2304.3042916
                                      :median 2303.27475
                                      :min    2302.567834
                                      :stddev 2.936129032877216
                                      :runs   15}
                        :fibonacci   {:max    1007.542709
                                      :mean   990.9791806000001
                                      :median 990.3435840000001
                                      :min    986.706167
                                      :stddev 4.955080419377605
                                      :runs   15}}
   "Free_Pascal"       {#_#_:levenshtein {:max    278.156334
                                      :mean   273.85144160000004
                                      :median 273.765667
                                      :min    270.741583
                                      :stddev 2.3035773091537046
                                      :runs   15}
                        :loops       {:max    2251.4192080000003
                                      :mean   2236.8419611333334
                                      :median 2235.602417
                                      :min    2232.504417
                                      :stddev 4.800543963751998
                                      :runs   15}
                        :fibonacci   {:max    880.1538750000001
                                      :mean   868.1321250666668
                                      :median 868.324125
                                      :min    861.1320420000001
                                      :stddev 3.983306237948574
                                      :runs   15}}
   "LuaJIT"            {:hello-world {:max    3.822708
                                      :mean   3.3301999333333336
                                      :median 3.321792
                                      :min    2.91275
                                      :stddev 0.28711548376007334
                                      :runs   15}
                        :levenshtein {:max    1280.915167
                                      :mean   1260.7047306
                                      :median 1259.739959
                                      :min    1252.492333
                                      :stddev 7.024306258367871
                                      :runs   15}
                        :loops       {:max    1009.140583
                                      :mean   1006.4970609999999
                                      :median 1006.4086249999999
                                      :min    1004.309208
                                      :stddev 1.3435976508864935
                                      :runs   15}
                        :fibonacci   {:max    1054.6632499999998
                                      :mean   997.5341861333334
                                      :median 1010.751
                                      :min    931.813666
                                      :stddev 38.421712177011756
                                      :runs   15}}
   "F_"                {:hello-world {:max    42.528459000000005
                                      :mean   39.69456386666667
                                      :median 41.297125
                                      :min    34.126209
                                      :stddev 2.8627263613915783
                                      :runs   15}
                        :levenshtein {:max    1616.3821249999999
                                      :mean   1594.8296639999996
                                      :median 1593.089833
                                      :min    1582.2005
                                      :stddev 8.930302618138922
                                      :runs   15}
                        :loops       {:max    2297.4527500000004
                                      :mean   2276.256149933333
                                      :median 2273.883958
                                      :min    2256.114042
                                      :stddev 9.138641619899428
                                      :runs   15}
                        :fibonacci   {:max    579.5172080000001
                                      :mean   551.9943557333334
                                      :median 546.744084
                                      :min    542.2717920000001
                                      :stddev 11.102636080611951
                                      :runs   15}}
   "Scala_Native"      {:hello-world {:max    4.004042
                                      :mean   3.565175
                                      :median 3.5122500000000003
                                      :min    2.9355830000000003
                                      :stddev 0.32272667103382
                                      :runs   15}
                        :levenshtein {:max    775.979583
                                      :mean   770.9643526000001
                                      :median 772.0131250000001
                                      :min    765.9904580000001
                                      :stddev 2.9331198547961495
                                      :runs   15}
                        :loops       {:max    670.713958
                                      :mean   657.4971248666668
                                      :median 656.8437500000001
                                      :min    653.5310410000001
                                      :stddev 3.9420405226376145
                                      :runs   15}
                        :fibonacci   {:max    523.14925
                                      :mean   507.6458222000001
                                      :median 505.722208
                                      :min    500.67641699999996
                                      :stddev 6.678627171641926
                                      :runs   15}}
   "COBOL"             {:hello-world {:max    7.385625000000001
                                      :mean   6.081233333333334
                                      :median 5.927625000000001
                                      :min    5.4154160000000005
                                      :stddev 0.5536506210208831
                                      :runs   15}
                        :loops       {:max    212286.217459
                                      :mean   211700.81156119998
                                      :median 212062.297792
                                      :min    208778.849042
                                      :stddev 1074.7770147080773
                                      :runs   15}}
   "PHP_JIT"           {:levenshtein {:max    10314.927917
                                      :mean   9919.172402866669
                                      :median 9906.632625
                                      :min    9825.412124999999
                                      :stddev 116.98617402112615
                                      :runs   15}
                        :loops       {:max    3354.0694169999997
                                      :mean   3330.6624443999995
                                      :median 3328.4962920000003
                                      :min    3319.788375
                                      :stddev 8.806831177085854
                                      :runs   15}
                        :fibonacci   {:max    4259.843042
                                      :mean   4217.905027666667
                                      :median 4205.444958
                                      :min    4183.573542
                                      :stddev 29.775518514162368
                                      :runs   15}}
   "Go"                {:hello-world {:max    4.235834
                                      :mean   3.907183333333333
                                      :median 3.9229160000000003
                                      :min    3.334458
                                      :stddev 0.22192167657070452
                                      :runs   15}
                        :levenshtein {:max    1212.2653750000002
                                      :mean   1199.3512109333333
                                      :median 1200.284916
                                      :min    1188.510041
                                      :stddev 5.740796589874914
                                      :runs   15}
                        :loops       {:max    2158.811833
                                      :mean   2132.8680416
                                      :median 2130.488958
                                      :min    2119.521792
                                      :stddev 10.401397987564064
                                      :runs   15}
                        :fibonacci   {:max    737.327917
                                      :mean   734.9682335333335
                                      :median 734.6828330000001
                                      :min    732.550958
                                      :stddev 1.4437251443903674
                                      :runs   15}}
   "Java"              {:hello-world {:max    96.12745800000002
                                      :mean   80.81876666666666
                                      :median 84.814333
                                      :min    66.21887500000001
                                      :stddev 9.602632643648473
                                      :runs   15}
                        :levenshtein {:max    1054.254291
                                      :mean   1040.7946834666668
                                      :median 1041.418334
                                      :min    1024.489458
                                      :stddev 7.202377506589751
                                      :runs   15}
                        :loops       {:max    766.2339170000001
                                      :mean   745.3504389999999
                                      :median 745.4379160000001
                                      :min    725.327708
                                      :stddev 8.126737417034002
                                      :runs   15}
                        :fibonacci   {:max    592.2839590000001
                                      :mean   568.1215499333334
                                      :median 568.8184580000001
                                      :min    551.323833
                                      :stddev 9.565519058242728
                                      :runs   15}}
   "Odin"              {:hello-world {:max    3.494791
                                      :mean   3.0235999333333337
                                      :median 3.042917
                                      :min    2.546417
                                      :stddev 0.22930477841805302
                                      :runs   15}
                        :levenshtein {:max    729.810917
                                      :mean   715.243425
                                      :median 714.0162080000001
                                      :min    711.988541
                                      :stddev 4.204882095658673
                                      :runs   15}
                        :loops       {:max    672.361208
                                      :mean   654.9926164666665
                                      :median 653.165
                                      :min    651.331666
                                      :stddev 5.344824653636582
                                      :runs   15}
                        :fibonacci   {:max    525.434333
                                      :mean   520.9414082
                                      :median 521.7015
                                      :min    516.3537500000001
                                      :stddev 2.8267962358840184
                                      :runs   15}}
   "Node"              {:hello-world {:max    48.155
                                      :mean   46.57630840000001
                                      :median 47.081625
                                      :min    44.145667
                                      :stddev 1.1071081214412886
                                      :runs   15}
                        :levenshtein {:max    2421.852416
                                      :mean   2409.7490360000006
                                      :median 2409.174625
                                      :min    2404.605959
                                      :stddev 4.839418642517065
                                      :runs   15}
                        :loops       {:max    2187.439792
                                      :mean   2174.964960933333
                                      :median 2174.3363750000003
                                      :min    2168.9573750000004
                                      :stddev 5.257278528964862
                                      :runs   15}
                        :fibonacci   {:max    1591.172375
                                      :mean   1586.4639529333333
                                      :median 1586.566667
                                      :min    1579.2881250000003
                                      :stddev 2.9058889877136282
                                      :runs   15}}
   "Bun_Scala_JS_Compiled_" {:hello-world {:max    12.030709
                                           :mean   11.308138933333332
                                           :median 11.252625
                                           :min    10.63475
                                           :stddev 0.4745620113896702
                                           :runs   15}
                             :levenshtein {:max    1574.113916
                                           :mean   1552.4791139333333
                                           :median 1551.425708
                                           :min    1544.009542
                                           :stddev 8.633739719445018
                                           :runs   15}
                             :loops       {:max    2171.361958
                                           :mean   2148.2329944666667
                                           :median 2146.106208
                                           :min    2135.663167
                                           :stddev 8.60813035998577
                                           :runs   15}
                             :fibonacci   {:max    960.9545830000001
                                           :mean   956.0877110666667
                                           :median 956.2751250000001
                                           :min    951.1644580000001
                                           :stddev 2.6028782116799696
                                           :runs   15}}})

(def csv
  "benchmark,timestamp,commit_sha,is_checked,user,model,ram,os,arch,language,run_ms,mean_ms,std-dev-ms,min_ms,max_ms,runs
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Babashka,10000,5355.1636045,434.5625205,4920.601084,5789.726125,2
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,C,10000,51.406518,1.274742,49.215000,65.385000,195
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Clojure,10000,50.61945726767677,0.7328381112649973,48.800791,52.811583,198
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Clojure Native,10000,51.14991239795918,0.6878133416878155,49.530167,54.517417,196
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Crystal,10000,52.145833333333336,1.4251236130213119,51,69,192
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,C++,10000,51.590237,1.587443,49.291000,70.743000,194
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Fortran,10000,51.291733,.873137,49.320999,57.637001,195
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Java,10000,50.360746,0.745647,48.549041,52.834875,199
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Java Native,10000,51.177855,0.665637,49.821417,53.412375,196
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Rust,10000,50.940024,3.498577,48.921834,95.064417,197
loops,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Zig,10000,50.996208,0.716236,49.115000,53.769000,197
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Babashka,10000,5441.5335625,2.7888125,5438.74475,5444.322375,2
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,C,10000,22.676379,0.489413,21.913000,24.286000,441
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Clojure,10000,47.19395991037736,1.1169950485466587,44.608375,51.083125,212
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Clojure Native,10000,50.64656122222222,0.9477032816440808,47.954334,53.110916,198
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Crystal,10000,39.90438247011952,0.9627152835244045,39,44,251
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,C++,10000,23.092596,0.521888,22.075000,24.986000,434
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Fortran,10000,25.655297,.595284,24.077999,27.327000,390
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Java,10000,42.331257,1.337031,39.733000,54.563209,237
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Java Native,10000,38.759704,0.797347,36.831500,41.881875,258
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Rust,10000,43.777538,0.793790,42.268125,46.299458,229
fibonacci,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Zig,10000,50.216260,0.914566,47.597000,53.175000,200
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Babashka,10000,23168.495459,0.0,23168.495459,23168.495459,1
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,C,10000,28.667404,0.549185,27.943000,34.415000,349
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Clojure,10000,56.68451955367232,0.987893365044312,55.386667,65.673,177
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Clojure Native,10000,61.27929929268293,1.2656117841780814,58.842,65.147583,164
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Crystal,10000,42.74786324786325,0.8644726781463394,42,49,234
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,C++,10000,31.847264,0.501691,31.181000,35.477000,314
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Fortran,10000,31.126904,.636563,30.385000,36.618999,322
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Java,10000,54.985837,1.586385,52.150875,59.342084,182
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Java Native,10000,62.145143,5.530012,52.911333,72.230708,161
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Rust,10000,39.764794,0.584270,38.930583,41.569541,252
levenshtein,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Zig,10000,50.703429,0.547183,49.665000,53.555000,198
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Babashka,10000,13.1179,1.99046,11.3011,20.1628,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,C,10000,2.30466,0.357201,1.93583,3.1155,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Clojure,10000,320.767,3.18739,315.478,328.043,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Clojure Native,10000,5.0487,0.466111,4.32921,6.07371,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Crystal,10000,3.65364,0.595515,2.92871,5.83512,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,C++,10000,10.5745,0.8636,9.795,13.7635,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Fortran,10000,3.33778,0.407362,2.67963,4.36154,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Java,10000,49.6987,1.80642,47.4236,54.7401,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Java Native,10000,4.59049,0.332863,4.02271,5.15563,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Rust,10000,2.58036,0.321434,2.0785,3.31567,25
hello-world,2025-02-02T11:20:11Z,638504c,true,PEZ,Apple M4 Max,64GB,darwin24,arm64,Zig,10000,2.31215,0.274188,1.95204,2.82171,25
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Babashka,10000,7429.2306875,39.0346455,7390.196042,7468.265333,2
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C,10000,62.599150,0.446762,62.114000,63.970000,160
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure,10000,63.53201608227848,0.5693390522301751,62.946,66.765167,158
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure Native,10000,62.4389019068323,0.29081053344833785,62.075041,63.8395,161
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Crystal,10000,62.22360248447205,2.21634596599759,62,90,161
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C++,10000,63.477183,0.284592,63.100000,64.917000,158
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Fortran,10000,62.410143,.271082,62.019001,63.813999,161
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java,10000,62.733684,3.052952,62.140042,100.708416,160
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java Native,10000,62.451514,0.286960,62.028375,63.769000,161
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Rust,10000,63.167309,0.268296,62.770917,64.621709,159
loops,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Zig,10000,63.115478,0.277007,62.799000,64.310000,159
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Babashka,10000,7968.2439795,19.3840205,7948.859959,7987.628,2
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C,10000,33.410980,0.175854,33.198000,34.478000,300
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure,10000,65.1517115974026,0.3967486111375215,64.548791,66.676375,154
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure Native,10000,57.87424440462428,0.25743337984799775,57.559708,59.191125,173
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Crystal,10000,70.13286713286713,0.3406241627515168,70,71,143
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C++,10000,33.951976,0.281222,33.708000,35.622000,295
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Fortran,10000,42.131437,.249646,41.862000,43.644001,238
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java,10000,63.029940,0.251943,62.495416,64.117208,159
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java Native,10000,52.834280,0.224696,52.569416,53.879167,190
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Rust,10000,70.676408,0.356923,70.272708,72.515458,142
fibonacci,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Zig,10000,72.573355,0.319541,72.194000,74.123000,138
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Babashka,10000,31488.885292,0.0,31488.885292,31488.885292,1
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C,10000,52.507178,5.027903,51.907000,121.738000,191
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure,10000,149.9697842089552,0.8164780673532945,148.91725,152.769209,67
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure Native,10000,146.9556214782609,0.8971458157048459,145.655208,151.753042,69
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Crystal,10000,145.33333333333334,0.9801960588196064,144,150,69
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C++,10000,51.598329,0.236738,51.261000,52.558000,194
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Fortran,10000,54.998928,.244072,54.751999,56.175999,182
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java,10000,82.262698,0.612845,81.637959,84.542083,122
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java Native,10000,144.157352,0.676260,142.493458,146.702958,70
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Rust,10000,63.119836,0.443108,62.715292,65.137083,159
levenshtein,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Zig,10000,62.522312,0.263318,62.138000,63.622000,160
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Babashka,10000,13.5124,0.617059,12.1739,14.6445,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C,10000,2.95882,0.369211,2.433,4.12208,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure,10000,436.099,2.63103,430.527,441.366,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Clojure Native,10000,7.44793,5.02793,5.25888,29.8877,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Crystal,10000,3.97678,0.26499,3.54221,4.51104,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,C++,10000,13.5156,0.579848,11.9866,14.5643,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Fortran,10000,3.95528,0.294546,3.39179,4.43513,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java,10000,69.9657,1.25689,67.6055,72.2482,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Java Native,10000,5.70562,0.330765,5.06629,6.44054,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Rust,10000,3.14108,0.331274,2.593,3.88804,25
hello-world,2025-02-02T15:49:12Z,060bb60,true,PEZ,Apple M1 Max,32GB,darwin24,arm64,Zig,10000,2.98008,0.28476,2.54167,3.82654,25")