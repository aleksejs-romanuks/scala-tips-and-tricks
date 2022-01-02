package com.alex.projects.scala.lazyevaluation

object LazyListExample extends App {

  def fibonacciSequence(a: Int = 0, b:Int = 1): LazyList[Int] = a #:: fibonacciSequence(b, a+b)

  println(fibonacciSequence()) // LazyList(<not computed>)
  println(fibonacciSequence().take(10).toList) // List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)

}
