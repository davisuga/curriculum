val scalaVersion = "3.2.1"
lazy val root = project
  .in(file("."))
  .enablePlugins(com.typesafe.play.SbtTwirl)
  .settings(
    name := "Curriculum Generator",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scalaVersion,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      ("com.github.pathikrit" %% "better-files" % "3.9.1")
        .cross(CrossVersion.for3Use2_13)
    )
  )
val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
