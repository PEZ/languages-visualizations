(ns pez.config)

(def benchmark-names
  {:loops "1 Billion Loops"
   :fibonacci "Naïve Fibonacci"
   :levenshtein "Levenshtein Distance"
   :hello-world "Hello World!"})

(def languages
  [{:language-name "Ada"
    :logo "images/ada.png"
    :language :ada
    :language-file-name "Ada"}
   #_{:language-name "Babashka"
    :logo "images/babashka.png"
    :language :bb
    :language-file-name "Babashka"}
   {:language-name "Bun"
    :logo "images/bun.png"
    :language :jsBun
    :language-file-name "Bun"}
   {:language-name "Bun Compiled"
    :logo "images/bun.png"
    :language :jsBun
    :language-file-name "Bun__Compiled_"}
   {:language-name "C"
    :logo "images/c.png"
    :language :cClangO0
    :language-file-name "C"}
   {:language-name "C#"
    :logo "images/csharp.png"
    :language :csharp
    :language-file-name "C_"}
   {:language-name "C# AOT"
    :logo "images/csharp.png"
    :language :csharp
    :language-file-name "C__AOT"}
   {:language-name "C3"
    :logo "images/c3.png"
    :language :c3
    :language-file-name "C3"}
   {:language :cobol
    :language-name "COBOL"
    :language-file-name "COBOL"
    :logo "images/Cobol.png"}
   {:language :c++
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
   {:language-name "Crystal"
    :logo "images/crystal.png"
    :language :crystal
    :language-file-name "Crystal"}
   {:language-name "D"
    :logo "images/d.png"
    :language :d
    :language-file-name "D"}
   {:language-name "Dart"
    :logo "images/dart.png"
    :language :dart
    :language-file-name "Dart"}
   {:language-name "Deno"
    :logo "images/deno.png"
    :language :jsDeno
    :language-file-name "Deno"}
   {:language-name "Deno JIT-less"
    :logo "images/deno.png"
    :language :jsDeno
    :language-file-name "Deno__jitless_"}
   {:language-name "Elixir"
    :logo "images/elixir.png"
    :language :elixir
    :language-file-name "Elixir"}
   {:language-name "Emacs Lisp Bytecode"
    :logo "images/Emacs.png"
    :language :emacs
    :language-file-name "Emacs_Lisp_Bytecode"}
   {:language-name "Emacs Lisp Native"
    :logo "images/Emacs.png"
    :language :emacs
    :language-file-name "Emacs_Lisp_Native"}
   {:language-name "F#"
    :logo "images/fsharp.png"
    :language :fsharp
    :language-file-name "F_"}
   {:language-name "F# AOT"
    :logo "images/fsharp.png"
    :language :fsharp
    :language-file-name "F__AOT"}
   {:language-name "Fortran"
    :logo "images/fortran.png"
    :language :fortran
    :language-file-name "Fortran"}
   {:language-name "Go"
    :logo "images/go.png"
    :language :goLang
    :language-file-name "Go"}
   {:language-name "Haskell"
    :logo "images/haskell.png"
    :language :haskell
    :language-file-name "Haskell"}
   {:language-name "Haxe"
    :logo "images/haxe.png"
    :language :haxe
    :language-file-name "Haxe"}
   {:language-name "Inko"
    :logo "images/inko.png"
    :language :inko
    :language-file-name "Inko"}
   {:language-name "Java"
    :logo "images/java.png"
    :language :java
    :language-file-name "Java"}
   {:language :java
    :language-name "Java Native"
    :language-file-name "Java_Native"
    :logo "images/java.png"}
   {:language-name "Julia"
    :logo "images/julia.png"
    :language :julia
    :language-file-name "Julia"}
   {:language-name "Kotlin"
    :logo "images/kotlin.png"
    :language :kotlin
    :language-file-name "Kotlin_JVM"}
   {:language-name "Kotlin Native"
    :logo "images/kotlin.png"
    :language :kotlin
    :language-file-name "Kotlin_Native"}
   {:language-name "Common Lisp"
    :logo "images/common-lisp.png"
    :language :common-lisp
    :language-file-name "Common_Lisp"}
   {:language-name "Lua"
    :logo "images/lua.png"
    :language :lua
    :language-file-name "Lua"}
   {:language-name "LuaJIT"
    :logo "images/lua.png"
    :language :lua
    :language-file-name "LuaJIT"}
   {:language-name "Modula 2"
    :logo "images/Modula_2.png"
    :language :modula-2
    :language-file-name "Modula_2"}
   {:language-name "Nim"
    :logo "images/nim.png"
    :language :nim
    :language-file-name "Nim"}
   {:language-name "Node"
    :logo "images/node.png"
    :language :jsNode
    :language-file-name "Node"}
   {:language-name "Objective C"
    :logo "images/objc.png"
    :language :objc
    :language-file-name "Objective_C"}
   {:language-name "Odin"
    :logo "images/odin.png"
    :language :odin
    :language-file-name "Odin"}
   {:language-name "Pascal"
    :logo "images/pascal.png"
    :language :pascal
    :language-file-name "Free_Pascal"}
   {:language-name "PHP"
    :logo "images/php.png"
    :language :php
    :language-file-name "PHP"}
   {:language-name "PHP JIT"
    :logo "images/php.png"
    :language :php
    :language-file-name "PHP_JIT"}
   {:language-name "PyPy"
    :logo "images/python.png"
    :language :python
    :language-file-name "PyPy"}
   {:language-name "Python"
    :logo "images/python.png"
    :language :python
    :language-file-name "Python"}
   {:language-name "Python JIT"
    :logo "images/python.png"
    :language :python
    :language-file-name "Python_JIT"}
   {:language-name "R"
    :logo "images/R.png"
    :language :r
    :language-file-name "R"}
   {:language-name "Racket"
    :logo "images/Racket.png"
    :language :racket
    :language-file-name "Racket"}
   {:language-name "Ruby"
    :logo "images/ruby.png"
    :language :ruby
    :language-file-name "Ruby"}
   {:language-name "Ruby YJIT"
    :logo "images/ruby.png"
    :language :ruby
    :language-file-name "Ruby_YJIT"}
   {:language-name "Rust"
    :logo "images/rust.png"
    :language :rust
    :language-file-name "Rust"}
   {:language-name "Scala"
    :logo "images/scala.png"
    :language :scala
    :language-file-name "Scala"}
   {:language :scala
    :language-file-name "Scala_Native"
    :language-name "Scala Native"
    :logo "images/scala.png"}
   #_{:language :scala
    :language-file-name "Bun_Scala_JS"
    :language-name "Bun Scala JS"
    :logo "images/scala.png"}
   #_{:language :scala
    :language-file-name "Bun_Scala_JS_Compiled_"
    :language-name "Bun Scala JS Compiled"
    :logo "images/scala.png"}
   {:language-name "Swift"
    :logo "images/swift.png"
    :language :swift
    :language-file-name "Swift"}
   {:language-name "V"
    :logo "images/V.png"
    :language :v
    :language-file-name "V"}
   {:language-name "Zig"
    :logo "images/zig.png"
    :language :zig
    :language-file-name "Zig"}])
