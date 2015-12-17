import eu.unicredit.swagger.generators._
import eu.unicredit.swagger.dependencies._

name := "sbt-codegen-example"

organization := "eu.unicredit"

scalaVersion := "2.11.7"

libraryDependencies ++=
  DefaultModelGenerator.dependencies ++
  DefaultJsonGenerator.dependencies ++
  DefaultServerGenerator.dependencies/* ++
  DefaultClientGenerator.dependencies*/

enablePlugins(PlayScala)

disablePlugins(PlayLayoutPlugin)

swaggerCodeProvidedPackage := "eu.unicredit"

//swaggerServerCodeGenClass := new DefaultAsyncServerGenerator()
/*
swaggerServerCodeGenClass := {
  class Custom1 extends DefaultAsyncServerGenerator {
    override def controllerNameFromFileName(fn: String) =
      objectNameFromFileName(fn, "CustomOne")
  } 

  new Custom1()
}

swaggerServerCodeGenClass := new eu.unicredit.Custom2()
*/
