package swagger.codegen

case class pet(id: Long, name: String, tag: Option[List[String]])

case class newPet(id: Option[Long], name: String, tag: Option[List[String]])

case class errorModel(code: Int, message: String)
