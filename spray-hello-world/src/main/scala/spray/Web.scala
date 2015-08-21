package spray

import akka.io.IO
import spray.can.Http
import akka.actor._
import spray.routing.Route
import spray.routing.Directives._
import spray.routing.HttpServiceActor
import spray.routing.Directive.pimpApply
import spray.routing.directives.CompletionMagnet.fromObject
import spray.routing.RequestContext

object Web extends App{
  implicit lazy val system = ActorSystem("spray")

  val route: RequestContext => Unit = path("") {
      get {
        complete("Hello World!")
      }
    }

  val routeActor = system.actorOf(Props(new RoutedHttpService(route)))

  IO(Http)(system) ! Http.Bind(routeActor, "0.0.0.0", port = 8080)
}

class RoutedHttpService(route: Route) extends HttpServiceActor {
  def receive: Receive = runRoute(route)
}
