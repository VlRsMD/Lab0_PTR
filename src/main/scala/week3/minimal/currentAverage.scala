package week3.minimal

import akka.actor._

import scala.collection.mutable.ListBuffer

class currentAverage extends Actor {
  val container :ListBuffer[Int] = new ListBuffer[Int]
  def receive = {
    case i:Int => {
      container += i;
      var currentSum :Int = 0
      var j :Int = 0
      for (j <- 0 to container.length-1) {
        currentSum = currentSum + container(j)
      }
      var currentAverage :Double = currentSum.toDouble / container.length.toDouble
      println ("The current average is: " + currentAverage)
    }
  }
}

object cA extends App {
  val system = ActorSystem()
  val current_average = system.actorOf(Props(new currentAverage))
  println("Introduce an integer: ")
  var int1: Int = scala.io.StdIn.readInt()
  current_average ! int1
  Thread.sleep(1000)
  println("Introduce an integer: ")
  var int2: Int = scala.io.StdIn.readInt()
  current_average ! int2
  Thread.sleep(1000)
  println("Introduce an integer: ")
  var int3: Int = scala.io.StdIn.readInt()
  current_average ! int3
  Thread.sleep(1000)
  println("Introduce an integer: ")
  var int4: Int = scala.io.StdIn.readInt()
  current_average ! int4
  Thread.sleep(1000)
  println("Introduce an integer: ")
  var int5: Int = scala.io.StdIn.readInt()
  current_average ! int5
}

