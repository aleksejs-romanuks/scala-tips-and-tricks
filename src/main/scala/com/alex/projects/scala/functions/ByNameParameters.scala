package com.alex.projects.scala.functions

object ByNameParameters extends App{

  def time: Long = System.nanoTime()

  // call by value:
  def showTime(time: Long): Unit = {
    println(s"Time: $time")
    println(s"Time now: $time")
  }

  // call by name:
  def showTime2(time: => Long): Unit = {
    println(s"Time: $time")
    println(s"Time now: $time")
  }

  showTime(time)
  showTime2(time)
}
