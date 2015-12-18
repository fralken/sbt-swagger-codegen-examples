package swagger.codegen

import play.api.libs.json._
import play.api.libs.functional.syntax._

package object json {
  implicit lazy val petReads: Reads[pet] = Reads[pet] {
    json => JsSuccess(pet((json \ "id").as[Long], (json \ "name").as[String], (json \ "tag").asOpt[List[String]]))
  }
  implicit lazy val petWrites: Writes[pet] = Writes[pet] {
    o => JsObject(Seq("id" -> Json.toJson(o.id), "name" -> Json.toJson(o.name), "tag" -> Json.toJson(o.tag)).filter(_._2 != JsNull))
  }
  implicit lazy val newPetReads: Reads[newPet] = Reads[newPet] {
    json => JsSuccess(newPet((json \ "id").asOpt[Long], (json \ "name").as[String], (json \ "tag").asOpt[List[String]]))
  }
  implicit lazy val newPetWrites: Writes[newPet] = Writes[newPet] {
    o => JsObject(Seq("id" -> Json.toJson(o.id), "name" -> Json.toJson(o.name), "tag" -> Json.toJson(o.tag)).filter(_._2 != JsNull))
  }
  implicit lazy val errorModelReads: Reads[errorModel] = Reads[errorModel] {
    json => JsSuccess(errorModel((json \ "code").as[Int], (json \ "message").as[String]))
  }
  implicit lazy val errorModelWrites: Writes[errorModel] = Writes[errorModel] {
    o => JsObject(Seq("code" -> Json.toJson(o.code), "message" -> Json.toJson(o.message)).filter(_._2 != JsNull))
  }
}
