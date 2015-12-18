/* Copyright 2015 UniCredit S.p.A.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
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
/*    
  val getJsonBody: Request[AnyContent] => JsValue =
    { request =>
      (request.body.asJson.getOrElse(
        Json.parse(
          (request.body.asText.getOrElse(request.body.asRaw.map(ba => {
            val size = ba.size
            new String(ba.asBytes(size).get.map(_.toChar))
          }).get)))))
    }   
*/  
  var pets: MSeq[pet] = MSeq() 
  
  def findPetsImpl(limit: Option[Int], tags: Option[List[String]]) = {
    pets.toList
  }
    
  def addPetImpl(p: newPet) = {
    val petToAdd = pet(p.id.getOrElse(0), p.name, p.tag)
    pets :+= petToAdd
    petToAdd
  }
  
  def deletePetImpl(id: Long) = {
    val found = pets.find(_.id == id).get
    pets = pets.filter(_.id == id)
    found
  }
  
  def findPetByIdImpl(id: Long) = {
    pets.find(_.id == id).get
  }

}
