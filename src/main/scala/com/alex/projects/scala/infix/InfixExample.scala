package com.alex.projects.scala.infix

object InfixExample extends App {

  class Person(val name: String) {
    def greet(person2: Person): Unit = println(s"Hi ${person2.name}")
  }

  val peter = new Person("Peter")
  val olaf = new Person("Olaf")

  peter greet olaf

}


