addSbtPlugin("eu.unicredit" % "sbt-swagger-codegen" % "0.0.6-SNAPSHOT")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.3")

lazy val myExtensionPlugin = project.
  in(file("my-extension-plugin")).
  settings(
    name := "My Extension Plugin",
    sbtPlugin := true,
    libraryDependencies +=
      "eu.unicredit" %% "sbt-swagger-codegen-lib" % "0.0.6-SNAPSHOT"
  )

lazy val root = project.in(file(".")).dependsOn(myExtensionPlugin)
