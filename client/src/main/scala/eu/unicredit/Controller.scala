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

import javax.inject.Inject

import play.api.libs.ws.WSClient
import play.api.mvc.Action
import play.api.mvc.Results._

import scala.concurrent.Await
import scala.concurrent.duration._

import swagger.codegen._

class Controller @Inject()(ws: WSClient) {
  def global() = Action(_ => {
    val client = new swagger.codegen.client.PetStoreClient(ws)("http://localhost:9000")

    val dog = newPet(id = Some(1), name = "dog", tag = None)
    val cat = newPet(id = Some(2), name = "cat", tag = None)

    println("pets now are "+Await.result(client.findPets(None, Some(100)), 30 seconds))

    Await.result(client.addPet(dog), 30 seconds)
    Await.result(client.addPet(cat), 30 seconds)

    println("pet 1 is a "+Await.result(client.findPetById(1), 30 seconds).name)
    println("pet 2 is a "+Await.result(client.findPetById(2), 30 seconds).name)

    println("pets now are "+Await.result(client.findPets(None, Some(100)), 30 seconds))

    Ok("Ok")
  })
}
