(ns pez.benchmark-data)

(def benchmarks
  {"Julia"             {:levenshtein {:max    976.887292
                                      :mean   976.887292
                                      :median 976.887292
                                      :min    976.887292
                                      :stddev 976.887292
                                      :runs   15}
                        :loops       {:max    2289.511208
                                      :mean   2289.511208
                                      :median 2289.511208
                                      :min    2289.511208
                                      :stddev 2289.511208
                                      :runs   15}}
   "Clojure_Native"    {:hello-world {:max    6.70525
                                      :mean   6.70525
                                      :median 6.70525
                                      :min    6.70525
                                      :stddev 6.70525
                                      :runs   15}
                        :levenshtein {:max    1660.799958
                                      :mean   1660.799958
                                      :median 1660.799958
                                      :min    1660.799958
                                      :stddev 1660.799958
                                      :runs   15}
                        :loops       {:max    669.277833
                                      :mean   669.277833
                                      :median 669.277833
                                      :min    669.277833
                                      :stddev 669.277833
                                      :runs   15}
                        :fibonacci   {:max    438.9105
                                      :mean   438.9105
                                      :median 438.9105
                                      :min    438.9105
                                      :stddev 438.9105
                                      :runs   15}}
   "Kotlin_JVM"        {:hello-world {:max    96.919666
                                      :mean   96.919666
                                      :median 96.919666
                                      :min    96.919666
                                      :stddev 96.919666
                                      :runs   15}
                        :loops       {:max    770.105083
                                      :mean   770.105083
                                      :median 770.105083
                                      :min    770.105083
                                      :stddev 770.105083
                                      :runs   15}
                        :fibonacci   {:max    578.9747080000001
                                      :mean   578.9747080000001
                                      :median 578.9747080000001
                                      :min    578.9747080000001
                                      :stddev 578.9747080000001
                                      :runs   15}}
   "Emacs_Lisp_Native" {:hello-world {:max    93.784667
                                      :mean   93.784667
                                      :median 93.784667
                                      :min    93.784667
                                      :stddev 93.784667
                                      :runs   15}
                        :loops       {:max    15063.393959
                                      :mean   15063.393959
                                      :median 15063.393959
                                      :min    15063.393959
                                      :stddev 15063.393959
                                      :runs   15}
                        :fibonacci   {:max    2663.1977500000003
                                      :mean   2663.1977500000003
                                      :median 2663.1977500000003
                                      :min    2663.1977500000003
                                      :stddev 2663.1977500000003
                                      :runs   15}}
   "Bun__Compiled_"    {:hello-world {:max    24.100375
                                      :mean   24.100375
                                      :median 24.100375
                                      :min    24.100375
                                      :stddev 24.100375
                                      :runs   15}
                        :levenshtein {:max    1600.33025
                                      :mean   1600.33025
                                      :median 1600.33025
                                      :min    1600.33025
                                      :stddev 1600.33025
                                      :runs   15}
                        :loops       {:max    2139.480333
                                      :mean   2139.480333
                                      :median 2139.480333
                                      :min    2139.480333
                                      :stddev 2139.480333
                                      :runs   15}
                        :fibonacci   {:max    927.2060000000001
                                      :mean   927.2060000000001
                                      :median 927.2060000000001
                                      :min    927.2060000000001
                                      :stddev 927.2060000000001
                                      :runs   15}}
   "Ruby_YJIT"         {:hello-world {:max    40.569834
                                      :mean   40.569834
                                      :median 40.569834
                                      :min    40.569834
                                      :stddev 40.569834
                                      :runs   15}
                        :levenshtein {:max    16556.886250000003
                                      :mean   16556.886250000003
                                      :median 16556.886250000003
                                      :min    16556.886250000003
                                      :stddev 16556.886250000003
                                      :runs   15}
                        :loops       {:max    15021.681834
                                      :mean   15021.681834
                                      :median 15021.681834
                                      :min    15021.681834
                                      :stddev 15021.681834
                                      :runs   15}
                        :fibonacci   {:max    2587.043458
                                      :mean   2587.043458
                                      :median 2587.043458
                                      :min    2587.043458
                                      :stddev 2587.043458
                                      :runs   15}}
   "Java_Native"       {:hello-world {:max    7.094209
                                      :mean   7.094209
                                      :median 7.094209
                                      :min    7.094209
                                      :stddev 7.094209
                                      :runs   15}
                        :levenshtein {:max    1534.119042
                                      :mean   1534.119042
                                      :median 1534.119042
                                      :min    1534.119042
                                      :stddev 1534.119042
                                      :runs   15}
                        :loops       {:max    669.1025000000001
                                      :mean   669.1025000000001
                                      :median 669.1025000000001
                                      :min    669.1025000000001
                                      :stddev 669.1025000000001
                                      :runs   15}
                        :fibonacci   {:max    464.804166
                                      :mean   464.804166
                                      :median 464.804166
                                      :min    464.804166
                                      :stddev 464.804166
                                      :runs   15}}
   "Dart"              {:hello-world {:max    17.805291
                                      :mean   17.805291
                                      :median 17.805291
                                      :min    17.805291
                                      :stddev 17.805291
                                      :runs   15}
                        :loops       {:max    725.7118330000001
                                      :mean   725.7118330000001
                                      :median 725.7118330000001
                                      :min    725.7118330000001
                                      :stddev 725.7118330000001
                                      :runs   15}
                        :fibonacci   {:max    950.884542
                                      :mean   950.884542
                                      :median 950.884542
                                      :min    950.884542
                                      :stddev 950.884542
                                      :runs   15}}
   "PHP"               {:levenshtein {:max    39522.290917
                                      :mean   39522.290917
                                      :median 39522.290917
                                      :min    39522.290917
                                      :stddev 39522.290917
                                      :runs   15}
                        :loops       {:max    14026.276875000001
                                      :mean   14026.276875000001
                                      :median 14026.276875000001
                                      :min    14026.276875000001
                                      :stddev 14026.276875000001
                                      :runs   15}
                        :fibonacci   {:max    16225.718541999999
                                      :mean   16225.718541999999
                                      :median 16225.718541999999
                                      :min    16225.718541999999
                                      :stddev 16225.718541999999
                                      :runs   15}}
   "Elixir"            {:hello-world {:max    321.40254200000004
                                      :mean   321.40254200000004
                                      :median 321.40254200000004
                                      :min    321.40254200000004
                                      :stddev 321.40254200000004
                                      :runs   15}
                        :loops       {:max    3519.6630830000004
                                      :mean   3519.6630830000004
                                      :median 3519.6630830000004
                                      :min    3519.6630830000004
                                      :stddev 3519.6630830000004
                                      :runs   15}
                        :fibonacci   {:max    1991.3292920000001
                                      :mean   1991.3292920000001
                                      :median 1991.3292920000001
                                      :min    1991.3292920000001
                                      :stddev 1991.3292920000001
                                      :runs   15}}
   "Objective_C"       {:hello-world {:max    5.102042
                                      :mean   5.102042
                                      :median 5.102042
                                      :min    5.102042
                                      :stddev 5.102042
                                      :runs   15}
                        :levenshtein {:max    725.078208
                                      :mean   725.078208
                                      :median 725.078208
                                      :min    725.078208
                                      :stddev 725.078208
                                      :runs   15}
                        :loops       {:max    659.9432500000001
                                      :mean   659.9432500000001
                                      :median 659.9432500000001
                                      :min    659.9432500000001
                                      :stddev 659.9432500000001
                                      :runs   15}
                        :fibonacci   {:max    529.444375
                                      :mean   529.444375
                                      :median 529.444375
                                      :min    529.444375
                                      :stddev 529.444375
                                      :runs   15}}
   "F__AOT"            {:hello-world {:max    6.528208
                                      :mean   6.528208
                                      :median 6.528208
                                      :min    6.528208
                                      :stddev 6.528208
                                      :runs   15}
                        :levenshtein {:max    1691.245083
                                      :mean   1691.245083
                                      :median 1691.245083
                                      :min    1691.245083
                                      :stddev 1691.245083
                                      :runs   15}
                        :loops       {:max    2146.065791
                                      :mean   2146.065791
                                      :median 2146.065791
                                      :min    2146.065791
                                      :stddev 2146.065791
                                      :runs   15}
                        :fibonacci   {:max    662.870667
                                      :mean   662.870667
                                      :median 662.870667
                                      :min    662.870667
                                      :stddev 662.870667
                                      :runs   15}}
   "Python"            {:hello-world {:max    42.402875
                                      :mean   42.402875
                                      :median 42.402875
                                      :min    42.402875
                                      :stddev 42.402875
                                      :runs   15}
                        :levenshtein {:max    69589.137875
                                      :mean   69589.137875
                                      :median 69589.137875
                                      :min    69589.137875
                                      :stddev 69589.137875
                                      :runs   15}
                        :loops       {:max    47261.756291
                                      :mean   47261.756291
                                      :median 47261.756291
                                      :min    47261.756291
                                      :stddev 47261.756291
                                      :runs   15}
                        :fibonacci   {:max    27819.588208999998
                                      :mean   27819.588208999998
                                      :median 27819.588208999998
                                      :min    27819.588208999998
                                      :stddev 27819.588208999998
                                      :runs   15}}
   "C_"                {:hello-world {:max    36.27850000000001
                                      :mean   36.27850000000001
                                      :median 36.27850000000001
                                      :min    36.27850000000001
                                      :stddev 36.27850000000001
                                      :runs   15}
                        :levenshtein {:max    1346.713291
                                      :mean   1346.713291
                                      :median 1346.713291
                                      :min    1346.713291
                                      :stddev 1346.713291
                                      :runs   15}
                        :loops       {:max    2183.81625
                                      :mean   2183.81625
                                      :median 2183.81625
                                      :min    2183.81625
                                      :stddev 2183.81625
                                      :runs   15}
                        :fibonacci   {:max    585.6225420000001
                                      :mean   585.6225420000001
                                      :median 585.6225420000001
                                      :min    585.6225420000001
                                      :stddev 585.6225420000001
                                      :runs   15}}
   "Modula_2"          {:hello-world {:max    15.411292000000001
                                      :mean   15.411292000000001
                                      :median 15.411292000000001
                                      :min    15.411292000000001
                                      :stddev 15.411292000000001
                                      :runs   15}}
   "PyPy"              {:hello-world {:max    31.382125000000002
                                      :mean   31.382125000000002
                                      :median 31.382125000000002
                                      :min    31.382125000000002
                                      :stddev 31.382125000000002
                                      :runs   15}
                        :loops       {:max    3323.692584
                                      :mean   3323.692584
                                      :median 3323.692584
                                      :min    3323.692584
                                      :stddev 3323.692584
                                      :runs   15}
                        :fibonacci   {:max    2421.384458
                                      :mean   2421.384458
                                      :median 2421.384458
                                      :min    2421.384458
                                      :stddev 2421.384458
                                      :runs   15}}
   "Deno"              {:hello-world {:max    25.273334000000002
                                      :mean   25.273334000000002
                                      :median 25.273334000000002
                                      :min    25.273334000000002
                                      :stddev 25.273334000000002
                                      :runs   15}
                        :levenshtein {:max    2381.8286249999996
                                      :mean   2381.8286249999996
                                      :median 2381.8286249999996
                                      :min    2381.8286249999996
                                      :stddev 2381.8286249999996
                                      :runs   15}
                        :loops       {:max    2085.4709580000003
                                      :mean   2085.4709580000003
                                      :median 2085.4709580000003
                                      :min    2085.4709580000003
                                      :stddev 2085.4709580000003
                                      :runs   15}
                        :fibonacci   {:max    1570.832
                                      :mean   1570.832
                                      :median 1570.832
                                      :min    1570.832
                                      :stddev 1570.832
                                      :runs   15}}
   "Nim"               {:levenshtein {:max    2377.968708
                                      :mean   2377.968708
                                      :median 2377.968708
                                      :min    2377.968708
                                      :stddev 2377.968708
                                      :runs   15}
                        :loops       {:max    674.2538330000001
                                      :mean   674.2538330000001
                                      :median 674.2538330000001
                                      :min    674.2538330000001
                                      :stddev 674.2538330000001
                                      :runs   15}}
   "CPP"               {:hello-world {:max    22.735834
                                      :mean   22.735834
                                      :median 22.735834
                                      :min    22.735834
                                      :stddev 22.735834
                                      :runs   15}
                        :levenshtein {:max    725.625583
                                      :mean   725.625583
                                      :median 725.625583
                                      :min    725.625583
                                      :stddev 725.625583
                                      :runs   15}
                        :loops       {:max    679.95225
                                      :mean   679.95225
                                      :median 679.95225
                                      :min    679.95225
                                      :stddev 679.95225
                                      :runs   15}
                        :fibonacci   {:max    530.221167
                                      :mean   530.221167
                                      :median 530.221167
                                      :min    530.221167
                                      :stddev 530.221167
                                      :runs   15}}
   "Python_JIT"        {:hello-world {:max    24.881542000000003
                                      :mean   24.881542000000003
                                      :median 24.881542000000003
                                      :min    24.881542000000003
                                      :stddev 24.881542000000003
                                      :runs   15}
                        :levenshtein {:max    21372.222875
                                      :mean   21372.222875
                                      :median 21372.222875
                                      :min    21372.222875
                                      :stddev 21372.222875
                                      :runs   15}
                        :loops       {:max    2482.294959
                                      :mean   2482.294959
                                      :median 2482.294959
                                      :min    2482.294959
                                      :stddev 2482.294959
                                      :runs   15}
                        :fibonacci   {:max    1146.377541
                                      :mean   1146.377541
                                      :median 1146.377541
                                      :min    1146.377541
                                      :stddev 1146.377541
                                      :runs   15}}
   "Kotlin_Native"     {:hello-world {:max    6.003583000000001
                                      :mean   6.003583000000001
                                      :median 6.003583000000001
                                      :min    6.003583000000001
                                      :stddev 6.003583000000001
                                      :runs   15}
                        :loops       {:max    2121.731958
                                      :mean   2121.731958
                                      :median 2121.731958
                                      :min    2121.731958
                                      :stddev 2121.731958
                                      :runs   15}
                        :fibonacci   {:max    527.5995
                                      :mean   527.5995
                                      :median 527.5995
                                      :min    527.5995
                                      :stddev 527.5995
                                      :runs   15}}
   "Fortran"           {:hello-world {:max    4.851292
                                      :mean   4.851292
                                      :median 4.851292
                                      :min    4.851292
                                      :stddev 4.851292
                                      :runs   15}
                        :levenshtein {:max    594.3524170000001
                                      :mean   594.3524170000001
                                      :median 594.3524170000001
                                      :min    594.3524170000001
                                      :stddev 594.3524170000001
                                      :runs   15}
                        :loops       {:max    677.696625
                                      :mean   677.696625
                                      :median 677.696625
                                      :min    677.696625
                                      :stddev 677.696625
                                      :runs   15}
                        :fibonacci   {:max    6.848834000000001
                                      :mean   6.848834000000001
                                      :median 6.848834000000001
                                      :min    6.848834000000001
                                      :stddev 6.848834000000001
                                      :runs   15}}
   "Scala"             {:hello-world {:max    150.876708
                                      :mean   150.876708
                                      :median 150.876708
                                      :min    150.876708
                                      :stddev 150.876708
                                      :runs   15}
                        :levenshtein {:max    1295.2215410000001
                                      :mean   1295.2215410000001
                                      :median 1295.2215410000001
                                      :min    1295.2215410000001
                                      :stddev 1295.2215410000001
                                      :runs   15}
                        :loops       {:max    807.7454580000001
                                      :mean   807.7454580000001
                                      :median 807.7454580000001
                                      :min    807.7454580000001
                                      :stddev 807.7454580000001
                                      :runs   15}
                        :fibonacci   {:max    648.193833
                                      :mean   648.193833
                                      :median 648.193833
                                      :min    648.193833
                                      :stddev 648.193833
                                      :runs   15}}
   "Ruby"              {:hello-world {:max    40.95341700000001
                                      :mean   40.95341700000001
                                      :median 40.95341700000001
                                      :min    40.95341700000001
                                      :stddev 40.95341700000001
                                      :runs   15}
                        :levenshtein {:max    36455.136375
                                      :mean   36455.136375
                                      :median 36455.136375
                                      :min    36455.136375
                                      :stddev 36455.136375
                                      :runs   15}
                        :loops       {:max    39658.835416
                                      :mean   39658.835416
                                      :median 39658.835416
                                      :min    39658.835416
                                      :stddev 39658.835416
                                      :runs   15}
                        :fibonacci   {:max    15121.454875
                                      :mean   15121.454875
                                      :median 15121.454875
                                      :min    15121.454875
                                      :stddev 15121.454875
                                      :runs   15}}
   "Rust"              {:hello-world {:max    3.7469580000000002
                                      :mean   3.7469580000000002
                                      :median 3.7469580000000002
                                      :min    3.7469580000000002
                                      :stddev 3.7469580000000002
                                      :runs   15}
                        :levenshtein {:max    709.2919590000001
                                      :mean   709.2919590000001
                                      :median 709.2919590000001
                                      :min    709.2919590000001
                                      :stddev 709.2919590000001
                                      :runs   15}
                        :loops       {:max    674.286416
                                      :mean   674.286416
                                      :median 674.286416
                                      :min    674.286416
                                      :stddev 674.286416
                                      :runs   15}
                        :fibonacci   {:max    508.3649170000001
                                      :mean   508.3649170000001
                                      :median 508.3649170000001
                                      :min    508.3649170000001
                                      :stddev 508.3649170000001
                                      :runs   15}}
   "Lua"               {:hello-world {:max    4.541417
                                      :mean   4.541417
                                      :median 4.541417
                                      :min    4.541417
                                      :stddev 4.541417
                                      :runs   15}
                        :levenshtein {:max    30029.899875000003
                                      :mean   30029.899875000003
                                      :median 30029.899875000003
                                      :min    30029.899875000003
                                      :stddev 30029.899875000003
                                      :runs   15}
                        :loops       {:max    54210.989666
                                      :mean   54210.989666
                                      :median 54210.989666
                                      :min    54210.989666
                                      :stddev 54210.989666
                                      :runs   15}
                        :fibonacci   {:max    12180.9855
                                      :mean   12180.9855
                                      :median 12180.9855
                                      :min    12180.9855
                                      :stddev 12180.9855
                                      :runs   15}}
   "Deno__jitless_"    {:hello-world {:max    22.685125
                                      :mean   22.685125
                                      :median 22.685125
                                      :min    22.685125
                                      :stddev 22.685125
                                      :runs   15}
                        :levenshtein {:max    33948.916084
                                      :mean   33948.916084
                                      :median 33948.916084
                                      :min    33948.916084
                                      :stddev 33948.916084
                                      :runs   15}
                        :loops       {:max    22796.576291
                                      :mean   22796.576291
                                      :median 22796.576291
                                      :min    22796.576291
                                      :stddev 22796.576291
                                      :runs   15}
                        :fibonacci   {:max    20454.7815
                                      :mean   20454.7815
                                      :median 20454.7815
                                      :min    20454.7815
                                      :stddev 20454.7815
                                      :runs   15}}
   "Bun_Scala_JS"      {:hello-world {:max    12.272959
                                      :mean   12.272959
                                      :median 12.272959
                                      :min    12.272959
                                      :stddev 12.272959
                                      :runs   15}
                        :levenshtein {:max    1561.559375
                                      :mean   1561.559375
                                      :median 1561.559375
                                      :min    1561.559375
                                      :stddev 1561.559375
                                      :runs   15}
                        :loops       {:max    2156.280291
                                      :mean   2156.280291
                                      :median 2156.280291
                                      :min    2156.280291
                                      :stddev 2156.280291
                                      :runs   15}
                        :fibonacci   {:max    971.4797500000001
                                      :mean   971.4797500000001
                                      :median 971.4797500000001
                                      :min    971.4797500000001
                                      :stddev 971.4797500000001
                                      :runs   15}}
   "Swift"             {:hello-world {:max    4.065209
                                      :mean   4.065209
                                      :median 4.065209
                                      :min    4.065209
                                      :stddev 4.065209
                                      :runs   15}
                        :levenshtein {:max    772.76325
                                      :mean   772.76325
                                      :median 772.76325
                                      :min    772.76325
                                      :stddev 772.76325
                                      :runs   15}
                        :loops       {:max    657.8543330000001
                                      :mean   657.8543330000001
                                      :median 657.8543330000001
                                      :min    657.8543330000001
                                      :stddev 657.8543330000001
                                      :runs   15}
                        :fibonacci   {:max    681.486292
                                      :mean   681.486292
                                      :median 681.486292
                                      :min    681.486292
                                      :stddev 681.486292
                                      :runs   15}}
   "R"                 {:levenshtein {:max    223273.443042
                                      :mean   223273.443042
                                      :median 223273.443042
                                      :min    223273.443042
                                      :stddev 223273.443042
                                      :runs   15}
                        :fibonacci   {:max    94054.853916
                                      :mean   94054.853916
                                      :median 94054.853916
                                      :min    94054.853916
                                      :stddev 94054.853916
                                      :runs   15}}
   "C"                 {:hello-world {:max    3.312708
                                      :mean   3.312708
                                      :median 3.312708
                                      :min    3.312708
                                      :stddev 3.312708
                                      :runs   15}
                        :levenshtein {:max    610.746542
                                      :mean   610.746542
                                      :median 610.746542
                                      :min    610.746542
                                      :stddev 610.746542
                                      :runs   15}
                        :loops       {:max    697.7210420000001
                                      :mean   697.7210420000001
                                      :median 697.7210420000001
                                      :min    697.7210420000001
                                      :stddev 697.7210420000001
                                      :runs   15}
                        :fibonacci   {:max    277.493791
                                      :mean   277.493791
                                      :median 277.493791
                                      :min    277.493791
                                      :stddev 277.493791
                                      :runs   15}}
   "C3"                {:hello-world {:max    4.265334
                                      :mean   4.265334
                                      :median 4.265334
                                      :min    4.265334
                                      :stddev 4.265334
                                      :runs   15}
                        :loops       {:max    2707.287917
                                      :mean   2707.287917
                                      :median 2707.287917
                                      :min    2707.287917
                                      :stddev 2707.287917
                                      :runs   15}
                        :fibonacci   {:max    944.2427910000001
                                      :mean   944.2427910000001
                                      :median 944.2427910000001
                                      :min    944.2427910000001
                                      :stddev 944.2427910000001
                                      :runs   15}}
   "Clojure"           {:hello-world {:max    460.66125
                                      :mean   460.66125
                                      :median 460.66125
                                      :min    460.66125
                                      :stddev 460.66125
                                      :runs   15}
                        :levenshtein {:max    2126.400042
                                      :mean   2126.400042
                                      :median 2126.400042
                                      :min    2126.400042
                                      :stddev 2126.400042
                                      :runs   15}
                        :loops       {:max    1144.22175
                                      :mean   1144.22175
                                      :median 1144.22175
                                      :min    1144.22175
                                      :stddev 1144.22175
                                      :runs   15}
                        :fibonacci   {:max    995.6398750000001
                                      :mean   995.6398750000001
                                      :median 995.6398750000001
                                      :min    995.6398750000001
                                      :stddev 995.6398750000001
                                      :runs   15}}
   "Bun"               {:hello-world {:max    11.941
                                      :mean   11.941
                                      :median 11.941
                                      :min    11.941
                                      :stddev 11.941
                                      :runs   15}
                        :levenshtein {:max    1623.941792
                                      :mean   1623.941792
                                      :median 1623.941792
                                      :min    1623.941792
                                      :stddev 1623.941792
                                      :runs   15}
                        :loops       {:max    2112.6115
                                      :mean   2112.6115
                                      :median 2112.6115
                                      :min    2112.6115
                                      :stddev 2112.6115
                                      :runs   15}
                        :fibonacci   {:max    1162.4172079999998
                                      :mean   1162.4172079999998
                                      :median 1162.4172079999998
                                      :min    1162.4172079999998
                                      :stddev 1162.4172079999998
                                      :runs   15}}
   "C__AOT"            {:hello-world {:max    5.759833
                                      :mean   5.759833
                                      :median 5.759833
                                      :min    5.759833
                                      :stddev 5.759833
                                      :runs   15}
                        :levenshtein {:max    1324.556042
                                      :mean   1324.556042
                                      :median 1324.556042
                                      :min    1324.556042
                                      :stddev 1324.556042
                                      :runs   15}
                        :loops       {:max    2144.4855000000002
                                      :mean   2144.4855000000002
                                      :median 2144.4855000000002
                                      :min    2144.4855000000002
                                      :stddev 2144.4855000000002
                                      :runs   15}
                        :fibonacci   {:max    666.009667
                                      :mean   666.009667
                                      :median 666.009667
                                      :min    666.009667
                                      :stddev 666.009667
                                      :runs   15}}
   "V"                 {:hello-world {:max    4.400209
                                      :mean   4.400209
                                      :median 4.400209
                                      :min    4.400209
                                      :stddev 4.400209
                                      :runs   15}
                        :levenshtein {:max    761.684958
                                      :mean   761.684958
                                      :median 761.684958
                                      :min    761.684958
                                      :stddev 761.684958
                                      :runs   15}
                        :loops       {:max    676.192417
                                      :mean   676.192417
                                      :median 676.192417
                                      :min    676.192417
                                      :stddev 676.192417
                                      :runs   15}
                        :fibonacci   {:max    539.397166
                                      :mean   539.397166
                                      :median 539.397166
                                      :min    539.397166
                                      :stddev 539.397166
                                      :runs   15}}
   "Zig"               {:hello-world {:max    3.5219590000000003
                                      :mean   3.5219590000000003
                                      :median 3.5219590000000003
                                      :min    3.5219590000000003
                                      :stddev 3.5219590000000003
                                      :runs   15}
                        :levenshtein {:max    763.5706250000001
                                      :mean   763.5706250000001
                                      :median 763.5706250000001
                                      :min    763.5706250000001
                                      :stddev 763.5706250000001
                                      :runs   15}
                        :loops       {:max    658.54775
                                      :mean   658.54775
                                      :median 658.54775
                                      :min    658.54775
                                      :stddev 658.54775
                                      :runs   15}
                        :fibonacci   {:max    523.5282920000001
                                      :mean   523.5282920000001
                                      :median 523.5282920000001
                                      :min    523.5282920000001
                                      :stddev 523.5282920000001
                                      :runs   15}}
   "Racket"            {:hello-world {:max    51.700500000000005
                                      :mean   51.700500000000005
                                      :median 51.700500000000005
                                      :min    51.700500000000005
                                      :stddev 51.700500000000005
                                      :runs   15}
                        :levenshtein {:max    6123.793791
                                      :mean   6123.793791
                                      :median 6123.793791
                                      :min    6123.793791
                                      :stddev 6123.793791
                                      :runs   15}
                        :loops       {:max    2314.1953750000002
                                      :mean   2314.1953750000002
                                      :median 2314.1953750000002
                                      :min    2314.1953750000002
                                      :stddev 2314.1953750000002
                                      :runs   15}
                        :fibonacci   {:max    1007.542709
                                      :mean   1007.542709
                                      :median 1007.542709
                                      :min    1007.542709
                                      :stddev 1007.542709
                                      :runs   15}}
   "Free_Pascal"       {#_#_:levenshtein {:max    278.156334
                                      :mean   278.156334
                                      :median 278.156334
                                      :min    278.156334
                                      :stddev 278.156334
                                      :runs   15}
                        :loops       {:max    2251.4192080000003
                                      :mean   2251.4192080000003
                                      :median 2251.4192080000003
                                      :min    2251.4192080000003
                                      :stddev 2251.4192080000003
                                      :runs   15}
                        :fibonacci   {:max    880.1538750000001
                                      :mean   880.1538750000001
                                      :median 880.1538750000001
                                      :min    880.1538750000001
                                      :stddev 880.1538750000001
                                      :runs   15}}
   "LuaJIT"            {:hello-world {:max    3.822708
                                      :mean   3.822708
                                      :median 3.822708
                                      :min    3.822708
                                      :stddev 3.822708
                                      :runs   15}
                        :levenshtein {:max    1280.915167
                                      :mean   1280.915167
                                      :median 1280.915167
                                      :min    1280.915167
                                      :stddev 1280.915167
                                      :runs   15}
                        :loops       {:max    1009.140583
                                      :mean   1009.140583
                                      :median 1009.140583
                                      :min    1009.140583
                                      :stddev 1009.140583
                                      :runs   15}
                        :fibonacci   {:max    1054.6632499999998
                                      :mean   1054.6632499999998
                                      :median 1054.6632499999998
                                      :min    1054.6632499999998
                                      :stddev 1054.6632499999998
                                      :runs   15}}
   "F_"                {:hello-world {:max    42.528459000000005
                                      :mean   42.528459000000005
                                      :median 42.528459000000005
                                      :min    42.528459000000005
                                      :stddev 42.528459000000005
                                      :runs   15}
                        :levenshtein {:max    1616.3821249999999
                                      :mean   1616.3821249999999
                                      :median 1616.3821249999999
                                      :min    1616.3821249999999
                                      :stddev 1616.3821249999999
                                      :runs   15}
                        :loops       {:max    2297.4527500000004
                                      :mean   2297.4527500000004
                                      :median 2297.4527500000004
                                      :min    2297.4527500000004
                                      :stddev 2297.4527500000004
                                      :runs   15}
                        :fibonacci   {:max    579.5172080000001
                                      :mean   579.5172080000001
                                      :median 579.5172080000001
                                      :min    579.5172080000001
                                      :stddev 579.5172080000001
                                      :runs   15}}
   "Scala_Native"      {:hello-world {:max    4.004042
                                      :mean   4.004042
                                      :median 4.004042
                                      :min    4.004042
                                      :stddev 4.004042
                                      :runs   15}
                        :levenshtein {:max    775.979583
                                      :mean   775.979583
                                      :median 775.979583
                                      :min    775.979583
                                      :stddev 775.979583
                                      :runs   15}
                        :loops       {:max    670.713958
                                      :mean   670.713958
                                      :median 670.713958
                                      :min    670.713958
                                      :stddev 670.713958
                                      :runs   15}
                        :fibonacci   {:max    523.14925
                                      :mean   523.14925
                                      :median 523.14925
                                      :min    523.14925
                                      :stddev 523.14925
                                      :runs   15}}
   "COBOL"             {:hello-world {:max    7.385625000000001
                                      :mean   7.385625000000001
                                      :median 7.385625000000001
                                      :min    7.385625000000001
                                      :stddev 7.385625000000001
                                      :runs   15}
                        :loops       {:max    212286.217459
                                      :mean   212286.217459
                                      :median 212286.217459
                                      :min    212286.217459
                                      :stddev 212286.217459
                                      :runs   15}}
   "PHP_JIT"           {:levenshtein {:max    10314.927917
                                      :mean   10314.927917
                                      :median 10314.927917
                                      :min    10314.927917
                                      :stddev 10314.927917
                                      :runs   15}
                        :loops       {:max    3354.0694169999997
                                      :mean   3354.0694169999997
                                      :median 3354.0694169999997
                                      :min    3354.0694169999997
                                      :stddev 3354.0694169999997
                                      :runs   15}
                        :fibonacci   {:max    4259.843042
                                      :mean   4259.843042
                                      :median 4259.843042
                                      :min    4259.843042
                                      :stddev 4259.843042
                                      :runs   15}}
   "Go"                {:hello-world {:max    4.235834
                                      :mean   4.235834
                                      :median 4.235834
                                      :min    4.235834
                                      :stddev 4.235834
                                      :runs   15}
                        :levenshtein {:max    1212.2653750000002
                                      :mean   1212.2653750000002
                                      :median 1212.2653750000002
                                      :min    1212.2653750000002
                                      :stddev 1212.2653750000002
                                      :runs   15}
                        :loops       {:max    2158.811833
                                      :mean   2158.811833
                                      :median 2158.811833
                                      :min    2158.811833
                                      :stddev 2158.811833
                                      :runs   15}
                        :fibonacci   {:max    737.327917
                                      :mean   737.327917
                                      :median 737.327917
                                      :min    737.327917
                                      :stddev 737.327917
                                      :runs   15}}
   "Java"              {:hello-world {:max    96.12745800000002
                                      :mean   96.12745800000002
                                      :median 96.12745800000002
                                      :min    96.12745800000002
                                      :stddev 96.12745800000002
                                      :runs   15}
                        :levenshtein {:max    1054.254291
                                      :mean   1054.254291
                                      :median 1054.254291
                                      :min    1054.254291
                                      :stddev 1054.254291
                                      :runs   15}
                        :loops       {:max    766.2339170000001
                                      :mean   766.2339170000001
                                      :median 766.2339170000001
                                      :min    766.2339170000001
                                      :stddev 766.2339170000001
                                      :runs   15}
                        :fibonacci   {:max    592.2839590000001
                                      :mean   592.2839590000001
                                      :median 592.2839590000001
                                      :min    592.2839590000001
                                      :stddev 592.2839590000001
                                      :runs   15}}
   "Odin"              {:hello-world {:max    3.494791
                                      :mean   3.494791
                                      :median 3.494791
                                      :min    3.494791
                                      :stddev 3.494791
                                      :runs   15}
                        :levenshtein {:max    729.810917
                                      :mean   729.810917
                                      :median 729.810917
                                      :min    729.810917
                                      :stddev 729.810917
                                      :runs   15}
                        :loops       {:max    672.361208
                                      :mean   672.361208
                                      :median 672.361208
                                      :min    672.361208
                                      :stddev 672.361208
                                      :runs   15}
                        :fibonacci   {:max    525.434333
                                      :mean   525.434333
                                      :median 525.434333
                                      :min    525.434333
                                      :stddev 525.434333
                                      :runs   15}}
   "Node"              {:hello-world {:max    48.155
                                      :mean   48.155
                                      :median 48.155
                                      :min    48.155
                                      :stddev 48.155
                                      :runs   15}
                        :levenshtein {:max    2421.852416
                                      :mean   2421.852416
                                      :median 2421.852416
                                      :min    2421.852416
                                      :stddev 2421.852416
                                      :runs   15}
                        :loops       {:max    2187.439792
                                      :mean   2187.439792
                                      :median 2187.439792
                                      :min    2187.439792
                                      :stddev 2187.439792
                                      :runs   15}
                        :fibonacci   {:max    1591.172375
                                      :mean   1591.172375
                                      :median 1591.172375
                                      :min    1591.172375
                                      :stddev 1591.172375
                                      :runs   15}}
   "Bun_Scala_JS_Compiled_" {:hello-world {:max    12.030709
                                           :mean   12.030709
                                           :median 12.030709
                                           :min    12.030709
                                           :stddev 12.030709
                                           :runs   15}
                             :levenshtein {:max    1574.113916
                                           :mean   1574.113916
                                           :median 1574.113916
                                           :min    1574.113916
                                           :stddev 1574.113916
                                           :runs   15}
                             :loops       {:max    2171.361958
                                           :mean   2171.361958
                                           :median 2171.361958
                                           :min    2171.361958
                                           :stddev 2171.361958
                                           :runs   15}
                             :fibonacci   {:max    960.9545830000001
                                           :mean   960.9545830000001
                                           :median 960.9545830000001
                                           :min    960.9545830000001
                                           :stddev 960.9545830000001
                                           :runs   15}}})

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