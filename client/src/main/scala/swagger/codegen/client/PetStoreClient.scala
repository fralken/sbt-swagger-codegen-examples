package swagger.codegen.client

import swagger.codegen._

import swagger.codegen.json._

import play.api.libs.ws._

import play.api.libs.json._

import play.api.Play.current

import play.api.libs.concurrent.Execution.Implicits._

class PetStoreClient(baseUrl: String) {
  def findPets(limit: Option[Int], tags: Option[List[String]]) = {
    WS.url(s"$baseUrl/api/pets?tags=$tags&limit=$limit").get().map({ resp =>
      assert((resp.status > 199) && (resp.status < 300))
      Json.parse(resp.body).as[List[pet]]
    })
  }
  def addPet(pet: newPet) = {
    WS.url(s"$baseUrl/api/pets").post(Json.toJson(pet)).map({ resp =>
      assert((resp.status > 199) && (resp.status < 300))
      Json.parse(resp.body).as[pet]
    })
  }
  def deletePet(id: Long): scala.concurrent.Future[Unit] = {
    WS.url(s"$baseUrl/api/pets/$id").delete().map({ resp =>
      assert((resp.status > 199) && (resp.status < 300))
      Unit
    })
  }
  def findPetById(id: Long) = {
    WS.url(s"$baseUrl/api/pets/$id").get().map({ resp =>
      assert((resp.status > 199) && (resp.status < 300))
      Json.parse(resp.body).as[pet]
    })
  }
}