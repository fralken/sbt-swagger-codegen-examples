import eu.unicredit.swagger.dependencies._
import eu.unicredit.swagger.generators.DefaultAsyncServerGenerator

lazy val common = Seq(
  organization := "eu.unicredit",
  scalaVersion := "2.11.7",
  version := "0.0.11",
  scalacOptions ++= Seq(
    "-feature",
    "-language:postfixOps"),
  libraryDependencies ++=
    Dependencies(DefaultModelGenerator.dependencies) ++
      Dependencies(DefaultJsonGenerator.dependencies)
  )

lazy val commonServer = Seq(
  swaggerCodeProvidedPackage := "eu.unicredit",
  swaggerGenerateServer := true,
  libraryDependencies ++=
    Dependencies(DefaultServerGenerator.dependencies)
  )

lazy val server = project.
  in(file("server")).
  settings(common: _*).
  settings(commonServer: _*).
  settings(
    name := "codegen-server"
  )
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .enablePlugins(SwaggerCodegenPlugin)

lazy val serverAsync = project.
  in(file("server-async")).
  settings(common: _*).
  settings(commonServer: _*).
  settings(
    name := "codegen-server-async",
    swaggerServerCodeGenClass := new DefaultAsyncServerGenerator()
  )
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .enablePlugins(SwaggerCodegenPlugin)

lazy val client = project.
  in(file("client")).
  settings(common: _*).
  settings(
    name := "codegen-client",
    swaggerGenerateClient := true,
    libraryDependencies ++=
      Dependencies(DefaultClientGenerator.dependencies)
  )
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .enablePlugins(SwaggerCodegenPlugin)

lazy val root = project.in(file(".")).aggregate(server, serverAsync, client)
