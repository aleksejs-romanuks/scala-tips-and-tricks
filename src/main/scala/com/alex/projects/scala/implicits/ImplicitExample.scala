package com.alex.projects.scala.implicits

object ImplicitExample extends App {

  class Session(implicit val username: String) {
    def getUsername: String = username
  }

  class Computer(implicit val username: String) {
    def getUsername: String = username
  }

  implicit val username: String = "user123"

  val session = new Session()
  val computer = new Computer()

  println(session.getUsername)
  println(computer.getUsername)

}
