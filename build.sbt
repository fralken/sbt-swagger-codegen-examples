import eu.unicredit.swagger.dependencies._

lazy val common: sbt.Project.SettingsDefinition = Seq(
  organization := "eu.unicredit",
  scalaVersion := "2.11.7",
  version := "0.0.6-SNAPSHOT",
  libraryDependencies ++=
    DefaultModelGenerator.dependencies ++
    DefaultJsonGenerator.dependencies
  )

lazy val server = project.
  in(file("server")).
  settings(common: _*).
  settings(
    name := "codegen-server",
    swaggerCodeProvidedPackage := "eu.unicredit",
    routesGenerator := StaticRoutesGenerator,
    libraryDependencies ++=
      DefaultServerGenerator.dependencies
  ).enablePlugins(PlayScala).disablePlugins(PlayLayoutPlugin)

lazy val client = project.
  in(file("client")).
  settings(common: _*).
  settings(
    name := "codegen-client",
    libraryDependencies ++=
      DefaultClientGenerator.dependencies
  ).enablePlugins(PlayScala).disablePlugins(PlayLayoutPlugin)

lazy val root = project.in(file(".")).aggregate(server, client)
