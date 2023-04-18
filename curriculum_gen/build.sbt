val http4sVersion = "1.0.0-M39"

lazy val root = project
  .in(file("."))
  // .enablePlugins(SbtTwirl)
  .settings(
    name := "Curriculum_Generator",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "3.2.2",
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      ("com.github.pathikrit" %% "better-files" % "3.9.1")
        .cross(CrossVersion.for3Use2_13)
    ),
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-ember-server" % http4sVersion,
      "org.http4s" %% "http4s-dsl" % http4sVersion
    )
  )
val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

lazy val app = (project in file("app"))
  .settings(
    assembly / mainClass := Some("curriculum.hello")
  )
