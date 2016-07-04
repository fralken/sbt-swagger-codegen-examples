package eu.unicredit

import eu.unicredit.swagger.generators.DefaultServerGenerator

class Custom2 extends DefaultServerGenerator {

  override def controllerNameFromFileName(fn: String) =
    objectNameFromFileName(fn, "CustomTwo")

}