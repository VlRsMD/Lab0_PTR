package week3.main

import akka.actor._

import scala.collection.mutable.Queue

class queueActor extends Actor {
  var queue = Queue[Int]()

  def receive = {
    case List("push", i: String) => {
      queue.enqueue(i.toInt)
      println("The element " + i.toInt + " has been added to the queue. The queue now is: " + queue)
    }
    case "pop" => {
      var l :Int = queue.last
      println("The last element of the queue is: " + l)
    }
  }
}

object queueMaintainer extends App {
  val system = ActorSystem()
  val queue_actor = system.actorOf(Props(new queueActor))
  println("Enter 'push' to add element to the queue, or 'pop' to extract the last element from the queue: ")
  var command1: String = scala.io.StdIn.readLine()
  if (command1=="push") {
    println("Introduce the number to add to the queue: ")
    var i :Int = scala.io.StdIn.readInt()
    val list :List[String] = List("push", i.toString)
    queue_actor ! list
  } else if (command1=="pop") {
    queue_actor ! command1
  }
  Thread.sleep(1000)
  println("Enter 'push' to add element to the queue (necessary if you ), or 'pop' to extract the last element from the queue: ")
  var command2: String = scala.io.StdIn.readLine()
  if (command2=="push") {
    println("Introduce the number to add to the queue: ")
    var i :Int = scala.io.StdIn.readInt()
    val list :List[String] = List("push", i.toString)
    queue_actor ! list
  } else if (command2=="pop") {
    queue_actor ! command2
  }
  Thread.sleep(1000)
  println("Enter 'push' to add element to the queue, or 'pop' to extract the last element from the queue: ")
  var command3: String = scala.io.StdIn.readLine()
  if (command3=="push") {
    println("Introduce the number to add to the queue: ")
    var i :Int = scala.io.StdIn.readInt()
    val list :List[String] = List("push", i.toString)
    queue_actor ! list
  } else if (command3=="pop") {
    queue_actor ! command3
  }
  Thread.sleep(1000)
  println("Enter 'push' to add element to the queue, or 'pop' to extract the last element from the queue: ")
  var command4: String = scala.io.StdIn.readLine()
  if (command4=="push") {
    println("Introduce the number to add to the queue: ")
    var i :Int = scala.io.StdIn.readInt()
    val list :List[String] = List("push", i.toString)
    queue_actor ! list
  } else if (command4=="pop") {
    queue_actor ! command4
  }
}
