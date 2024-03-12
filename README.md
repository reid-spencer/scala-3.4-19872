# scala-3.4-19872
A case for a scala issue 19872.  Two commits are provided as detailed below, the working version 
with Scala 3.3.3 and the failing version with Scala 3.4.0.

Working version with Scala 3.3.3 @bb64512e yields:
```shell
run 1234
[info] compiling 1 Scala source to /Users/reid/Code/reid-spencer/scala-3.4-19872/target/scala-3.3.3/classes ...
[info] done compiling
[info] running testcase.parseAndPrint 1234
1234
[success] Total time: 0 s, completed Mar 12, 2024, 4:08:11 PM
```

Failing version with Scala 3.4.0 @baec8b7b yields:
```shell
[IJ]scala-3.4-19872(root) : main : 0.0.0-3-baec8b7b-20240312-1613>run 1234
[info] compiling 1 Scala source to /Users/reid/Code/reid-spencer/scala-3.4-19872/target/scala-3.4.0/classes ...
[error] -- Error: /Users/reid/Code/reid-spencer/scala-3.4-19872/src/main/scala/Parsers.scala:31:46 -----------------------------
[error] 31 |  val result = Parsers.parseRule[Long](input, Parsers.allLong(_), true)
[error]    |                                              ^^^^^^^^^^^^^^^
[error]    |                                  Context bounds will map to context parameters.
[error]    |                                  A `using` clause is needed to pass explicit arguments to them.
[error]    |                                  This code can be rewritten automatically under -rewrite -source 3.4-migration.
[error] one error found
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 0 s, completed Mar 12, 2024, 4:13:32 PM
[IJ]scala-3.4-19872(root) : main : 0.0.0-3-baec8b7b-20240312-1613>
```

Note that the `-rewrite` and `-source` options were given on the compilation
but that the rewrite did not happen. At the very least remove that last line
of the message. It would be better to have it actually do the rewrite. 
