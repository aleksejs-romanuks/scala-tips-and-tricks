package com.alex.projects.scala.functions

object Composition extends App {

  val bonus = (salary: Double) => salary + 100
  val socialTax = (salary: Double) => salary * 0.2

  val monthlySalary = 500

  println(socialTax.compose(bonus)(monthlySalary))
  println(bonus.andThen(socialTax)(monthlySalary))
  println(socialTax(bonus(monthlySalary)))

}
