'sbt-swagger-codegen-example' will show you how to use `sbt-swagger-codegen` plugin.

open a terminal go into this project base dir and type ```sbt```

the example is provided with a "yaml" file that is copy pasted from swagger "simple_petstore_example"

this file is locate into `./src/main/swagger` that is the default directory where the plugin will look for swagger files.

- `swaggerCodeGen` and you will see under `./src/main/scala/swagger/codegen` ("swagger.codegen" is the default package for generated sources) two new files:

	- Model.scala which contains the case classes for the model described into the swagger file
	- json/package.scala which contains implicit formats for marshalling and unmarshalling model objects from and to json

at this point you usually whant to create a client or a server for this specification and we provide commands for that:

	- ```swaggerPlayClientCodeGen``` will generate a class under package "swagger.codegen.client" , instatiating this class into any Play 2.4 application let you use the helpful methods to call to a server that follow the provided specification.
	please note that to compile you need to uncomment in ```build.sbt``` the dependency from ```play-ws```

- ```swaggerPlayServerCodeGen``` will generate a ```routes``` file under "./src/main/resources/" and a partial Controller implementation in the package "swagger.codegen.controller" that is going to satisfy the routes with all the boilerplate of from/to json and Play specific implmentation
	
	at this point you will be asked from the compiler to provide an implementation of the required trait ```PetStoreControllerImpl``` that will implement all the business logic methods (other than the default ```onError``` handler and ```getJsonBody```) so feel free at first to uncomment my basic implementation and work with it!

