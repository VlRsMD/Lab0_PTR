package week3

import akka.actor._

class monitoredActor extends Actor {
  def receive = {
    case _ => println("The monitored actor has received a message")
  }
}

class monitoringActor extends Actor {
  val monitored_actor = context.actorOf(Props[monitoredActor], name = "monitored_actor")
  context.watch(monitored_actor)
  def receive = {
    case Terminated(monitored_actor) => println("The monitored actor has stopped")
    case _ => println("The monitoring actor has received a message")
  }
}

object monitor extends App {
  val system = ActorSystem("Monitor")
  val monitoringA = system.actorOf(Props[monitoringActor], name = "monitoring_actor")
  val monitoredA = system.actorSelection("user/monitoring_actor/monitored_actor")
  monitoredA ! PoisonPill
  Thread.sleep(1000)
  system.terminate()
}
