package com.alex.projects.scala.anotations

object Exception {

  @throws(classOf[Exception])
  def throwException = throw new Exception("Failed")

}
