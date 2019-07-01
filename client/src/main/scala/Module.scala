import javax.inject.{Inject, Provider, Singleton}

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.google.inject.AbstractModule
import play.api.{Configuration, Environment}
import play.api.libs.ws.StandaloneWSClient
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import swagger.codegen.PetStoreClientConfig

class Module(environment: Environment,
             configuration: Configuration) extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[StandaloneWSClient]).toProvider(classOf[StandaloneWSClientProvider])
    bind(classOf[PetStoreClientConfig]).toInstance(PetStoreClientConfig(
      host = configuration.getOptional[String]("host").getOrElse("localhost"),
      port = configuration.getOptional[Int]("port").getOrElse(9000)))
  }
}

@Singleton
class StandaloneWSClientProvider @Inject()(implicit system: ActorSystem) extends Provider[StandaloneWSClient] {
  implicit val materializer = ActorMaterializer()
  lazy val get = StandaloneAhcWSClient()
}
