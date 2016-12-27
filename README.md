sbt-swagger-codegen-example
---------------------------

This project will show you how to use [`sbt-swagger-codegen`](https://github.com/unicredit/sbt-swagger-codegen) plugin. There is a project for the client and a project for the server.

Open a terminal go into this project base dir and type `sbt`.

The example is provided with a `yaml` file that is copy pasted from swagger `simple_petstore_example`.
This file is located into `src/main/swagger` (in both `client` and `server` projects) that is the default directory where the plugin will look for swagger files.

For the `client` project:

- `project client` and then

- `swaggerModelCodeGen`

- `swaggerClientCodeGen`

For the `server` project:

- `project server` and then

- `swaggerModelCodeGen`

- `swaggerServerCodeGen`

where

- `swaggerModelCodeGen` (in both client and server) generates under `target/scala-2.11/src_managed/src/main/swagger/model` (`swagger.codegen` is the default package for generated sources) two new files:

	- Model.scala which contains the case classes for the model described into the swagger file
	- json/package.scala which contains implicit formats for marshalling and unmarshalling model objects from and to json

- `swaggerClientCodeGen` (in `client`) generates a class under `target/scala-2.11/src_managed/src/main/swagger/client` (default package is `swagger.codegen.client`), instantiating this class into any Play 2.5 application let you use the helpful methods to call to a server that follow the provided specification.

- `swaggerServerCodeGen` (in `server`) generates a `routes` file under `src/main/resources` and a partial Controller implementation under `target/scala-2.11/src_managed/src/main/swagger/server` (default package is `swagger.codegen.controller`) that is going to satisfy the routes with all the boilerplate of from/to json and Play 2.5 specific implementation.

At this point you will be asked from the compiler to provide an implementation of the required trait `PetStoreControllerImpl` that will implement all the business logic methods (other than the default `onError` handler).

The `compile` command calls all swagger code generation commands before compiling. `swaggerClean` cleans the generated code. Also, since it is generated in the `target` folder, `clean` command cleans it, too.

##How to run

Here are instructions to programmatically check your services.

Open two terminals into the root directory of this project.

In the first run:
```
sbt ";server/compile;server/run"
```

Into the second terminal run:
```
sbt ";client/compile;client/run 9001"
```

Then, to trigger the client run, you should try to open http://localhost:9001 from whatever ```curl``` or the browser and you should check the output generated.
