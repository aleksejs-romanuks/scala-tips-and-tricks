package com.alex.projects.scala.concurency

import scalaj.http.{Http, HttpResponse}

import scala.concurrent.{ExecutionContext, Future}

object ScalaFuture extends App {
  val url = "https://api.agify.io/"

  def guessAge(name: String): String = {
    val response: HttpResponse[String] = Http(url).param("name", name).asString
    response.body
  }

  implicit val globalExecutionContext: ExecutionContext = ExecutionContext.global

  val r1 = Future {
    guessAge("Aleksejs")
  }

  var finished = r1.isCompleted
  while (!finished) {
    finished = r1.isCompleted
    println(r1.value)
  }
}
