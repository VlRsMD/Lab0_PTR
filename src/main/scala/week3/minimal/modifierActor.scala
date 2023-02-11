package week3.minimal

import akka.actor._

class modifierActor extends Actor {
  def receive = {
    case i :Int => println(i+1)
    case s :String => println(s.toLowerCase())
    case list: List[Any]  => println("I don’t know how to handle this!")
  }
}

object mA extends App {
  println("Introduce an integer: ")
  var int: Int = scala.io.StdIn.readInt()
  val system = ActorSystem()
  val modifier_actor = system.actorOf(Props(new modifierActor))
  modifier_actor ! int
  Thread.sleep(1000)
  println("Introduce a string containing upper cases: ")
  var str: String = scala.io.StdIn.readLine()
  modifier_actor ! str
  Thread.sleep(1000)
  println("Introduce 2 values to form a list from them: ")
  var val1: Any = scala.io.StdIn.readLine()
  var val2: Any = scala.io.StdIn.readLine()
  val list :List[Any] = List(val1, val2)
  modifier_actor ! list
}
