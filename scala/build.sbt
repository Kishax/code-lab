import Dependencies._

ThisBuild / scalaVersion := "2.13.12"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.github"
ThisBuild / organizationName := "takayamaekawa"

lazy val root = (project in file("."))
  .settings(
    name := "code-lab",
    libraryDependencies += munit % Test,
    Compile / run / mainClass := Some("com.github.takayamaekawa.Hello")
  )

lazy val source = project.in(file(".source"))

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype
