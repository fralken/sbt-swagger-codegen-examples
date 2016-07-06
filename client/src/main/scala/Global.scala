import play.api._
import akka.actor._
import akka.stream._
import play.api.libs.ws.ahc._

import scala.concurrent.Await
import scala.concurrent.duration._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    val ws = AhcWSClient()

    val client =
      new swagger.codegen.client.PetStoreClient(ws)("http://localhost:9000")

    val dog = swagger.codegen.newPet(id = Some(1), name = "dog", tag = None)
    val cat = swagger.codegen.newPet(id = Some(2), name = "cat", tag = None)

    Await.result(client.addPet(dog), 30 seconds)
    Await.result(client.addPet(cat), 30 seconds)

    println("pet 1 is a "+Await.result(client.findPetById(1), 30 seconds).name)
    println("pet 2 is a "+Await.result(client.findPetById(2), 30 seconds).name)

    System.exit(0)
  }

}
