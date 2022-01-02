package com.alex.projects.scala.concurency

import scalaj.http.{Http, HttpResponse}
import scala.language.postfixOps
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

object DurationCheck extends App {

  val url = "https://api.agify.io/"
  implicit val globalExecutionContext: ExecutionContext = ExecutionContext.global

  def guessAge(name: String): String = {
    val response: HttpResponse[String] = Http(url).param("name", name).asString
    response.body
  }

  def durationCheck[T](f: Future[T]): Unit = {
    val m1 = System.currentTimeMillis() milliseconds

    Await.result(f, 5 seconds)
    val m2 = System.currentTimeMillis() milliseconds

    println(s"Executed in ${m2 - m1}")
  }

  val names: List[String] = List("Bob", "Bruce", "Alex")
  names.foreach(name => durationCheck(Future{guessAge(name)}))

}
