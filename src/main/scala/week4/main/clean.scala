package week4.main

import akka.actor._

class clean extends Actor {
  val lowercase_s_actor = context.actorOf(Props[lowercase_swap], name = "l_s_actor")
  val join_actor = context.actorOf(Props[join], name = "join_actor")
  context.watch(lowercase_s_actor)
  context.watch(join_actor)
  def receive = {
    case m: String => {
      val split_m: Array[String] = m.split("")
      val l_s_actor = ActorSystem().actorOf(Props(new lowercase_swap))
      l_s_actor ! split_m
    }
    case Terminated(join_actor) => {
      val cleaner_actor = ActorSystem().actorOf(Props(new clean))
      println ("Processing line restarted")
      cleaner_actor ! "Monster"
    }
    case Terminated(lowercase_s_actor) => {
      val cleaner_actor = ActorSystem().actorOf(Props(new clean))
      println ("Processing line restarted")
      cleaner_actor ! "Monster"
    }
  }
}

class lowercase_swap extends Actor {
  def receive = {
    case a: Array[String] => {
      val new_arr: Array[String] = new Array[String](_length=a.length)
      var i: Int = 0
      for (i <- 0 to a.length-1) {
        if (a(i)=="m" || a(i)=="M") {
          new_arr(i) = "n"
        } else if (a(i)=="n" || a(i)=="N") {
          new_arr(i) = "m"
        } else {
          new_arr(i) = a(i).toLowerCase()
        }
      }
      val join_actor = ActorSystem().actorOf(Props(new join))
      join_actor ! new_arr
    }
  }
}

class join extends Actor {
  def receive = {
    case a: Array[String] => {
      var join_a: String = a.mkString("")
      println(join_a)
    }
  }
}

object cleaner extends App {
  val system = ActorSystem("Clean")
  val cleaning_actor = system.actorOf(Props[clean], name ="cleaner")
  val lowercase_s_actor = system.actorSelection(path="user/cleaner/l_s_actor")
  val joining_actor = system.actorSelection(path="user/cleaner/join_actor")
  cleaning_actor ! "Monster"
  Thread.sleep(1000)
  joining_actor ! PoisonPill
  Thread.sleep(1000)
  lowercase_s_actor ! PoisonPill
}

