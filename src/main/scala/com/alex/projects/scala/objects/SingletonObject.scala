package com.alex.projects.scala.objects

object SingletonObject {
  // singleton object variables:
  val a = 1
  val b = 2

  // singleton object method:
  def add: Int = a + b

  def main(args: Array[String]): Unit = {
    print(add)
  }
}
