/* Copyright 2017 UniCredit S.p.A.
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

import javax.inject.{Inject, Singleton}
import swagger.codegen.petstore._

import scala.collection.mutable.{Seq => MSeq}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext

/*
YOU are in charge of providing this implementation
*/
@Singleton
class PetStoreService @Inject()(implicit ec: ExecutionContext) {

  def onError(s : String,err: Throwable) = Future {
    err.getMessage
  }

  var pets: MSeq[Pet] = MSeq()

  def findPets(h1: String, h2: Option[String], tags: Seq[String], limit: Option[Int]) = Future {
    println("h1: " + h1 + " h2: " + h2)
    pets.toList
  }

  def addPet(p: NewPet) = Future {
    val petToAdd = Pet(p.id.getOrElse(0), p.name, p.tag)
    pets :+= petToAdd
    petToAdd
  }

  def deletePet(id: Long) = Future {
    val found = pets.find(_.id == id).get
    pets = pets.filter(_.id != id)
    found
  }

  def findPetById(id: Long) = Future {
    pets.find(_.id == id).get
  }

}
