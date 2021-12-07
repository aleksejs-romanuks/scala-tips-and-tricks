package com.alex.projects.scala.objects

// companion class:
class CompanionExample {
  // companion class variables:
  val a = 1
  val b = 2

  // companion class method:
  def add: Int = a + b
}

// companion object:
object  CompanionExample {
  def main(args: Array[String]): Unit = {
    val o = new CompanionExample
    println(o.add)
  }
}

