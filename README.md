# Languages Visualizations

(With optional Start Times)

![alt text](public/images/langauges-visualizations-header.png)

This a playground for visualizing the the [Languages](https://github.com/bddicken/languages) benchmark of [Benjamin Dicken](https://github.com/bddicken)'s.

* The visualizations are here: [pez.github.io/languages-visualizations/](https://pez.github.io/languages-visualizations/) (There are some more notes about the experiment there.)
* The benchmarks project is [Benjamin Dicken](https://github.com/bddicken)'s **Languages**, here: [github.com/bddicken/languages](https://github.com/bddicken/languages).

## You favorite language is missing?

> If you lack some language in the visualizations, let me know in an issue. If you include instructions on how to get the toolchain installed on a Mac silicon (without any Docker involved) it increases the chances I get the language included.

## How this was built

The visualizations app is written with [Replicant](https://github.com/cjohansen/replicant) (the page with “navigation”) and [Quil](https://github.com/quil/quil) (the animated visualizations). There are also some [Babashka](https://github.com/babashka/babashka) tasks for running benchmarks and collecting the JSON files written by the [hyperfine](https://github.com/sharkdp/hyperfine) benchmark runner. Some of the icons come from [techicons.dev](https://techicons.dev/).

I hope you fork this project and have some fun with it. 😄

## How to have some fun

You'll need the [Clojure](https://clojure.org) CLI tool (`clojure`), and NodeJS.

1. `npm i`
1. Start the app: `npx shadow-cljs watch app`

When the app is compiled, you can access it on [localhost:9797](localhost:9797)

To play with the code, connect your editor to the [shadow-cljs](https://github.com/thheller/shadow-cljs) REPL and go.

### Run benchmarks

To load the app with other data you update [benchmark_data.cljs](src/pez/benchmark_data.cljs). There are some Babashka tasks to make it more straight forward to produce data for the app. The tasks default to assume you have checked out your fork of the Languages project as a sibling project to this one.

#### Compile the benchmarks

Many languages need a compile step to produce a binary. To compile all benchmarks for any languages in the Languages project that you have a working toolchain for:

```sh
bb compile-benchmarks
```

Check the `compile.sh` script in the Languages project for the commands used to compile.

#### Run the benchmarks

To produce the JSON results files and run the hello-world benchmarks together with each benchmark for each langage, there's a “copy” of the `run.sh` script from the Languages project in this repository: [scripts/bench.sh](scripts/bench.sh). Basically what I do is that I copy the `run` commands from `run.sh` and paste them in `bench.sh`, commenting out any languages I don't want to run. (Like I can't stand waiting for COBOL.)

There's a Babashka task for running benchmarks in `bench.sh`:

```sh
bb bench-benchmarks
```

Since this can take very long, there's also a [bench-some.sh](scripts/bench-some.sh) script, where you can have just a few languages enabled. To run that script instead you provide two arguments to task:

```sh
 bb bench-benchmarks ../languages some
```

`some` can really be anything, if the argument is not there the full `bench.sh` script will be run. The `../languages` is the otherwise default directory pointing out where the Languages project is.

#### Compile and Run

Since compiling can also take some time, there's a convenience task for doing both the compile and the benchmark run, and you can go out for a walk or whatever while your computer crunches.

```sh
bb compile-and-bench
```

This task takes the same arguments as `bench-benchmarks`.

#### Collect the results

To produce the map for pasting in [benchmark_data.cljs](src/pez/benchmark_data.cljs):

```sh
bb collect-benchmark-data
```

The task will look for the data in `/tmp/languages` (since that is where `bench.sh` places the files). You can tell it to fetch the files from somewhere else:

```sh
bb collect-benchmark-data somewhere-else
```

E.g. I run the benchmarks on another machine which I have mounted on my regular mac:

```sh
bb collect-benchmark-data /Volumes/Macintosh\ HD-1/tmp/languages/
```

The collect task (like the others) is really “happy path”, with almost no error checking. If it crashes on you, connect your editor to a Babashka repl and go hunting. (Or `println` debug like some cave man.) It's probably some JSON file that contains something funny.

## Share it around, please ❤️

If you share on X, please tag [@pappapez](https://x.com/pappapez) and [@BenjDicken](https://x.com/benjdicken).