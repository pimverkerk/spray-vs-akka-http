package akka.http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.RequestContext
import scala.concurrent.Future
import akka.http.scaladsl.server.RouteResult

object Web extends App{
  implicit def system = ActorSystem("akka-http")
  implicit val materializer = ActorMaterializer()
  
  def route: RequestContext => Future[RouteResult] = path(""){
    get {
       complete("Hello World!")
    }
  }
  
  val serverBinding = Http().bindAndHandle(interface = "0.0.0.0", port = 8080, handler = route)
}
