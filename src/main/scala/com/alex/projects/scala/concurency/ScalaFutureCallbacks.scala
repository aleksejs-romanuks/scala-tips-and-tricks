package com.alex.projects.scala.concurency

import scalaj.http.{Http, HttpResponse}
import scala.concurrent.duration._
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object ScalaFutureCallbacks extends App {

  val url = "https://api.agify.io/"

  def guessAge(name: String): String = {
    val response: HttpResponse[String] = Http(url).param("name", name).asString
    response.body
  }

  var results = ArrayBuffer[String]()

  def callback(f: Future[String]): Unit = {
    f onComplete {
      case Success(s) => results += s
      case Failure(e) => s"Error: $e"
    }
  }

  implicit val globalExecutionContext: ExecutionContext = ExecutionContext.global
  val names: List[String] = List("Bob", "Bruce", "Alex")
  val futures: List[Future[String]] = names.map(name => Future{guessAge(name)})

  futures.foreach(callback)

  val deadline = 5.seconds.fromNow
  while(deadline.hasTimeLeft) {
    Thread.sleep(100)
    println(results.mkString(", "))
  }


}
