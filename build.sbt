import eu.unicredit.swagger.dependencies._

lazy val common = Seq(
  organization := "eu.unicredit",
  scalaVersion := "2.11.7",
  version := "0.0.8",
  scalacOptions ++= Seq(
    "-feature",
    "-language:postfixOps"),
  libraryDependencies ++=
    DefaultModelGenerator.dependencies ++
    DefaultJsonGenerator.dependencies
  )

lazy val server = project.
  in(file("server")).
  settings(common: _*).
  settings(
    name := "codegen-server",
    routesGenerator := StaticRoutesGenerator,
    swaggerCodeProvidedPackage := "eu.unicredit",
    swaggerGenerateServer := true,
    libraryDependencies ++=
      DefaultServerGenerator.dependencies
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
      DefaultClientGenerator.dependencies
  )
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .enablePlugins(SwaggerCodegenPlugin)

lazy val root = project.in(file(".")).aggregate(server, client)
