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

import swagger.codegen._

import scala.collection.mutable.{Seq => MSeq}

/*
YOU are in charge of providing this implementation
*/
class PetStoreService {

  def onError(s : String,err: Throwable) =
    err.getMessage

  var pets: MSeq[Pet] = MSeq()

  def findPets(h1: String, h2: Option[String], tags: Option[List[String]], limit: Option[Int]) = {
    pets.toList
  }

  def addPet(p: NewPet) = {
    val petToAdd = Pet(p.id.getOrElse(0), p.name, p.tag)
    pets :+= petToAdd
    petToAdd
  }

  def deletePet(id: Long) = {
    val found = pets.find(_.id == id).get
    pets = pets.filter(_.id != id)
    found
  }

  def findPetById(id: Long) = {
    pets.find(_.id == id).get
  }

}
