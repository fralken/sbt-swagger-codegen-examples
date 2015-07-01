name := "sbt-codegen-example"

organization := "eu.unicredit"

scalaVersion := "2.11.6"

//libraryDependencies += "com.typesafe.play" %% "play-ws" % "2.4.0"

enablePlugins(PlayScala)

disablePlugins(PlayLayoutPlugin)

//swaggerServerAsync := true

//(compile in Compile) <<= (compile in Compile) dependsOn (
//	swaggerPlayServerCodeGenTask.dependsOn(
//	swaggerPlayClientCodeGenTask.dependsOn(
//	swaggerCodeGenTask.dependsOn(
//	swaggerCleanTask))))
