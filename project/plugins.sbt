resolvers += Resolver.sonatypeRepo("releases")

addSbtPlugin("eu.unicredit" % "sbt-swagger-codegen" % "0.1.0-SNAPSHOT")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.0")

lazy val myExtensionPlugin = project.
  in(file("my-extension-plugin")).
  settings(
    name := "My Extension Plugin",
    sbtPlugin := true,
    libraryDependencies +=
      "eu.unicredit" %% "sbt-swagger-codegen-lib" % "0.1.0-SNAPSHOT",
    resolvers += Resolver.sonatypeRepo("releases")
  )

lazy val root = project.in(file(".")).dependsOn(myExtensionPlugin)
