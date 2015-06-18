package eu.unicredit

import play.api.mvc.{ Request, AnyContent }
import play.api.libs.json._
import play.api.mvc.Results._

import swagger.codegen._

import scala.collection.mutable.{Seq => MSeq}

import scala.concurrent.Future

import play.api.libs.concurrent.Execution.Implicits._

/*

YOU are in charge of providing this implementation
*/
trait PetStoreControllerImpl {

  def onError(s : String,err: Throwable) =
    err.getMessage
    
  val getJsonBody: Request[AnyContent] => JsValue =
    { request =>
      (request.body.asJson.getOrElse(
        Json.parse(
          (request.body.asText.getOrElse(request.body.asRaw.map(ba => {
            val size = ba.size
            new String(ba.asBytes(size).get.map(_.toChar))
          }).get)))))
    }   
  
  var pets: MSeq[pet] = MSeq() 
  
  def findPetsImpl(limit: Option[Int], tags: Option[List[String]]) = {
    pets 
  }
    
  def addPetImpl(p: newPet) = {
    pets :+ p
    p
  }
  
  def deletePetImpl(id: Long) = {
    val found = pets.find(_.id == id).get
    pets = pets.filter(_.id == id)
    found
  }
  
  def findPetByIdImpl(id: Long) = {
    pets.find(_.id == id)
  }

/*  
use this code in case of :
swaggerServerAsync := true

  def onError(s : String,err: Throwable) =
    Future { err.getMessage }
    
  val getJsonBody: Request[AnyContent] => JsValue =
    { request =>
      (request.body.asJson.getOrElse(
        Json.parse(
          (request.body.asText.getOrElse(request.body.asRaw.map(ba => {
            val size = ba.size
            new String(ba.asBytes(size).get.map(_.toChar))
          }).get)))))
    }   
  
  var pets: MSeq[pet] = MSeq() 
  
  def findPetsImpl(limit: Option[Int], tags: Option[List[String]]) = Future { 
  	pets
  }
    
  def addPetImpl(p: newPet) = Future {
    pets :+ p
    p
  }
  
  def deletePetImpl(id: Long) = Future {
    
    val found = pets.find(_.id == id).get
    pets = pets.filter(_.id == id)
    found
  }
  
  def findPetByIdImpl(id: Long) = Future {
    pets.find(_.id == id)
  }
*/
}
/*
*/