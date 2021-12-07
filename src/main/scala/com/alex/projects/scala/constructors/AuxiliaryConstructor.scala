package com.alex.projects.scala.constructors

object AuxiliaryConstructor extends App {

  class Ball(t: String, d: Double) {
    require(t != "", "Type not specified.")
    def this(d: Double) = this("Default", d)
    println(s"${t.capitalize} ball with diameter $d cm.")
  }

  new Ball("tennis", 6.86)
  new Ball("football", 22.5)
  new Ball(10.26)

}
