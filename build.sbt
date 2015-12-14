import eu.unicredit.swagger.generators._

name := "sbt-codegen-example"

organization := "eu.unicredit"

scalaVersion := "2.11.7"

libraryDependencies ++=
  DefaultModelGenerator.dependencies ++
  DefaultJsonGenerator.dependencies ++
  DefaultServerGenerator.dependencies //++
  //DefaultClientGenerator.dependencies

enablePlugins(PlayScala)

disablePlugins(PlayLayoutPlugin)

swaggerCodeProvidedPackage := "eu.unicredit"

//swaggerServerCodeGenClass := new DefaultAsyncServerGenerator()
