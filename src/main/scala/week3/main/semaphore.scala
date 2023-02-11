package week3.main

import akka.actor._

import java.util.concurrent.Semaphore

class actor extends Actor {
  def receive = {
    case List(m :String, n :String) => {
      println("Response " + n + ": ")
      println("The message '" + m + "' has been received." + "\n")
    }
  }
}

class actorThread extends Thread {
  override def run(): Unit = {
    val system = ActorSystem()
    val act = system.actorOf(Props(new actor))
    var message :String = "Hello!"
    var number :String = actorThread.super.getName
    val list :List[String] = List(message, number)
    act ! list
  }
}

object multithreading_actors {
  var mutex = new Semaphore(1)
  def main(args: Array[String])
  {
    for (i <- 1 to 5)
    {
      mutex.acquire()
      var thread = new actorThread()
      thread.setName(i.toString())
      thread.start()
      mutex.release()
    }
  }
}
