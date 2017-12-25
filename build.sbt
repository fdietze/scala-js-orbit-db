organization := "com.github.fdietze"
name := "scala-js-orbit-db"
version := "master-SNAPSHOT"

scalaVersion := "2.12.4"
crossScalaVersions := Seq("2.10.6", "2.11.11", "2.12.4")

enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)

npmDependencies in Compile ++= (
  "orbit-db" -> "0.18.12" ::
  "ipfs" -> "0.27.5" ::
  Nil
)

useYarn := true

libraryDependencies ++= (
  "io.monix" %%% "minitest" % "2.0.0" % "test" ::
  "io.monadless" %%% "monadless-stdlib" % "0.0.13" % "test" ::
  Nil
)

testFrameworks += new TestFramework("minitest.runner.Framework")


scalacOptions ++=
    "-encoding" :: "UTF-8" ::
    "-unchecked" ::
    "-deprecation" ::
    "-explaintypes" ::
    "-feature" ::
    "-language:_" ::
    "-Xcheckinit" ::
    "-Xfuture" ::
    "-Xlint:-unused" ::
    "-Ypartial-unification" ::
    "-Yno-adapted-args" ::
    "-Ywarn-infer-any" ::
    "-Ywarn-value-discard" ::
    "-Ywarn-nullary-override" ::
    "-Ywarn-nullary-unit" ::
    "-P:scalajs:sjsDefinedByDefault" ::
    Nil
