package com.alex.projects.scala.concurency

import com.alex.projects.scala.concurency.ScalaFuture.r1
import scalaj.http.{Http, HttpResponse}

import scala.concurrent.{ExecutionContext, Future}

object CombineScalaFutures extends App {

  val url = "https://api.agify.io/"

  def guessAge(name: String): String = {
    val response: HttpResponse[String] = Http(url).param("name", name).asString
    response.body
  }

  implicit val globalExecutionContext: ExecutionContext = ExecutionContext.global
  val names: List[String] = List("Bob", "Bruce", "Alex")
  val futures: List[Future[String]] = names.map(name => Future{guessAge(name)})

  val result = Future.reduceLeft(futures)(_ + ", " + _)

  var finished = result.isCompleted
  while (!finished) {
    finished = result.isCompleted
    println(result.value)
  }

}
