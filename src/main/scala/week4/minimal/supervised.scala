package week4.minimal

import akka.actor._

class supervised extends Actor {
  def receive = {
    case m: String => println(m)
  }
}
class supervisor extends Actor {
  val supervised_actor = context.actorOf(Props[supervised], name = "supervised")
  context.watch(supervised_actor)
  def receive = {
    case Terminated(supervised_actor) => {
      val supervised_1 = ActorSystem().actorOf(Props(new supervised))
      supervised_1 ! "Actor restarted"
    }
  }
}

object supervise extends App {
  val system = ActorSystem("Supervise")
  val supervisorA = system.actorOf(Props[supervisor], name = "supervisor")
  val supervisedA1 = system.actorSelection("user/supervisor/supervised")
  val supervisedA2 = system.actorSelection("user/supervisor/supervised")
  val supervisedA3 = system.actorSelection("user/supervisor/supervised")
  val supervisedA4 = system.actorSelection("user/supervisor/supervised")
  val supervisedA5 = system.actorSelection("user/supervisor/supervised")
  supervisedA1 ! "Hello"
  Thread.sleep(1000)
  supervisedA3 ! PoisonPill
}
