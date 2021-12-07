package com.alex.projects.scala.constructors

object PrimaryConstructor extends App{

  class Ball (t: String, d: Double){
    println(s"${t.capitalize} ball with diameter $d cm.")
  }

  new Ball("tennis", 6.86)
  new Ball("football", 22.5)
}
