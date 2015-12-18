package swagger.codegen.controller

import swagger.codegen._

import swagger.codegen.json._

import play.api.mvc.Results._

import play.api.mvc._

import play.api.libs.json._

import eu.unicredit.PetStoreControllerImpl

object PetStoreController extends PetStoreControllerImpl {
  def findPets(limit: Option[Int], tags: Option[List[String]]) = {
    Action(request => try {
      Ok(Json.toJson[List[pet]](findPetsImpl(limit, tags)))
    } catch {
      case (err: Throwable) => {
        BadRequest(onError("findPets", err))
      }
    })
  }
  def addPet() = {
    Action(request => try {
      val pet = Json.fromJson[newPet](request.body.asJson.get).get
      Ok(Json.toJson[pet](addPetImpl(pet)))
    } catch {
      case (err: Throwable) => {
        BadRequest(onError("addPet", err))
      }
    })
  }
  def deletePet(id: Long) = {
    Action(request => try {
      NoContent
    } catch {
      case (err: Throwable) => {
        BadRequest(onError("deletePet", err))
      }
    })
  }
  def findPetById(id: Long) = {
    Action(request => try {
      Ok(Json.toJson[pet](findPetByIdImpl(id)))
    } catch {
      case (err: Throwable) => {
        BadRequest(onError("findPetById", err))
      }
    })
  }
}