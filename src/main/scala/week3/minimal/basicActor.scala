package week3.minimal

import akka.actor._

class basicActor extends Actor {
    def receive = {
        case m: String => println(m)
    }
}

object bA extends App {
    var m: String = scala.io.StdIn.readLine()
    val system = ActorSystem()
    val basic_actor = system.actorOf(Props(new basicActor))
    basic_actor ! m
}