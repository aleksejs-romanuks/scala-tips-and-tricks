package com.alex.projects.scala.lazyevaluation

object LazyEvaluation extends App {

  lazy val a = {
    println("a: I was executed!!!")
    "a"
  }

  val b = {
    println("b: I was executed!!!")
    "b"
  }

  println(a)
  println(b)

  /**
   * Output:
   *
   * b: I was executed!!!
   * a: I was executed!!!
   * a
   * b
   */
}
