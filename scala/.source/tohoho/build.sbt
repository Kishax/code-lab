name := "Tohoho"
version := "0.1.0"
scalaVersion := "2.13.12"

mainClass in (Compile, run) := Some("tohoho.hello")
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.3.0"
