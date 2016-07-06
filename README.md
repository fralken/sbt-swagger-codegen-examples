sbt-swagger-codegen-example
---------------------------

This project will show you how to use [`sbt-swagger-codegen`](https://github.com/unicredit/sbt-swagger-codegen) plugin. There is a project for the client and a project for the server.

Open a terminal go into this project base dir and type `sbt`.

The example is provided with a `yaml` file that is copy pasted from swagger `simple_petstore_example`.
This file is located into `src/main/swagger` (in both `client` and `server` projects) that is the default directory where the plugin will look for swagger files.

For the `client` project:

- `project client` and then

- `swaggerCodeGen`

- `swaggerClientCodeGen`

For the `server` project:

- `project server` and then

- `swaggerCodeGen`

- `swaggerServerCodeGen`

where

- `swaggerCodeGen` (in both client and server) generates under `src/main/scala/swagger/codegen` (`swagger.codegen` is the default package for generated sources) two new files:

	- Model.scala which contains the case classes for the model described into the swagger file
	- json/package.scala which contains implicit formats for marshalling and unmarshalling model objects from and to json

- `swaggerClientCodeGen` (in `client`) generates a class under package `swagger.codegen.client`, instantiating this class into any Play 2.5 application let you use the helpful methods to call to a server that follow the provided specification.

- `swaggerServerCodeGen` (in `server`) generates a `routes` file under `src/main/resources` and a partial Controller implementation in the package `swagger.codegen.controller` that is going to satisfy the routes with all the boilerplate of from/to json and Play 2.5 specific implementation.

At this point you will be asked from the compiler to provide an implementation of the required trait `PetStoreControllerImpl` that will implement all the business logic methods (other than the default `onError` handler).

For your convenience the `compile` command from the `root` project calls all swagger code generation commands in client and server before compiling. `clean` command also calls `swaggerClean` on both projects.
