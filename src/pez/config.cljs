(ns pez.config)

(def benchmark-names
  {:loops "1 Billion Loops"
   :fibonacci "Naïve Fibonacci"
   :levenshtein "Levenshtein Distance"})

(def languages
  [{:color "#e3a1b6"
    :language :jsBun
    :language-file-name "Bun"
    :language-name "Bun"
    :logo "images/bun.png"}
   {:color "rgb(101, 155, 211)"
    :language :cClangO3
    :language-file-name "C"
    :language-name "C"
    :logo "images/c.png"}
   {:color "rgb(129, 101, 225)"
    :language :csharp
    :language-file-name "C#"
    :language-name "C#"
    :logo "images/csharp.png"}
   {:color "rgb(101, 155, 211)"
    :language :c++
    :language-name "CPP"
    :language-file-name "CPP"
    :logo "images/cpp.png"}
   {:language :clojure
    :language-name "Clojure"
    :language-file-name "Clojure"
    :logo "images/clojure.png"}
   {:language :clojure
    :language-name "Clojure Native"
    :language-file-name "Clojure_Native"
    :logo "images/clojure.png"}
   {:color "rgb(0, 0, 0)"
    :language :crystal
    :language-file-name "Crystal"
    :language-name "Crystal"
    :logo "images/crystal.png"}
   {:color "rgb(39, 185, 247)"
    :language :dart
    :language-file-name "Dart"
    :language-name "Dart"
    :logo "images/dart.png"}
   {:color "rgb(0, 0, 0)"
    :language :jsDeno
    :language-file-name "Deno"
    :language-name "Deno"
    :logo "images/deno.png"}
   {:color "rgb(116, 77, 151)"
    :language :fortran
    :language-file-name "Fortran"
    :language-name "Fortran"
    :logo "images/fortran.png"}
   {:color "#5dcef0"
    :language :goLang
    :language-file-name "Go"
    :language-name "Go"
    :logo "images/go.png"}
   {:color "rgb(242, 164, 67)"
    :language :java
    :language-file-name "Java"
    :language-name "Java"
    :logo "images/java.png"}
   {:language :java
    :language-name "Java GraalVM"
    :language-file-name "Java_GraalVM"
    :logo "images/java.png"}
   {:color "rgb(64, 99, 216)"
    :language :julia
    :language-file-name "Julia"
    :language-name "Julia"
    :logo "images/julia.png"}
   {:color "rgb(177, 36, 234)"
    :language :kotlin
    :language-file-name "Kotlin"
    :language-name "Kotlin"
    :logo "images/kotlin.png"}
   {:color "rgb(0, 0, 128)"
    :language :luajit
    :language-file-name "Lua_JIT"
    :language-name "Lua JIT"
    :logo "images/lua.png"}
   {:color "rgb(239, 200, 67)"
    :language :nim
    :language-file-name "Nim"
    :language-name "Nim"
    :logo "images/nim.png"}
   {:color "#27b648"
    :language :jsNode
    :language-file-name "Node"
    :language-name "Node"
    :logo "images/node.png"}
   {:color "rgb(244, 106, 63)"
    :language :objc
    :language-file-name "ObjC"
    :language-name "ObjC"
    :logo "images/objc.png"}
   {:color "rgb(4, 112, 189)"
    :language :odin
    :language-file-name "Odin"
    :language-name "Odin"
    :logo "images/odin.png"}
   {:color "rgb(120, 124, 180)"
    :language :phpjit
    :language-file-name "PHP_JIT"
    :language-name "PHP JIT"
    :logo "images/php.png"}
   {:color "rgb(193, 198, 187)"
    :language :pypy
    :language-file-name "PyPy"
    :language-name "PyPy"
    :logo "images/pypy.png"}
   {:color "rgb(255, 226, 94)"
    :language :python
    :language-file-name "Python"
    :language-name "Python"
    :logo "images/python.png"}
   {:color "rgb(215, 48, 22)"
    :language :ruby
    :language-file-name "Ruby"
    :language-name "Ruby"
    :logo "images/ruby.png"}
   {:color "rgb(215, 48, 22)"
    :language :rubyyjit
    :language-file-name "Ruby_YJIT"
    :language-name "Ruby YJIT"
    :logo "images/ruby.png"}
   {:color "rgb(50, 20, 10)"
    :language :rust
    :language-file-name "Rust"
    :language-name "Rust"
    :logo "images/rust.png"}
   {:color "rgb(221, 55, 53)"
    :language :scala
    :language-file-name "Scala"
    :language-name "Scala"
    :logo "images/scala.png"}
   {:color "rgb(221, 55, 53)"
    :language :scala
    :language-file-name "Scala_Native"
    :language-name "Scala Native"
    :logo "images/scala.png"}
   {:color "rgb(229, 119, 44)"
    :language :swift
    :language-file-name "Swift"
    :language-name "Swift"
    :logo "images/swift.png"}
   {:color "rgb(247, 165, 23)"
    :language :zig
    :language-file-name "Zig"
    :language-name "Zig"
    :logo "images/zig.png"}])