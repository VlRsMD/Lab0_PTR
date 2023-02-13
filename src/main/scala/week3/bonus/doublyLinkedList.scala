package week3.bonus

import akka.actor._
import scala.collection.mutable._

class doublyLinkedListA extends Actor {
  def receive = {
    case m :String => println(m)
  }
}

object dLL {
  class node (v :Int) {
    var value :Int = v
    var next :node = null
    var prev :node = null
  }

  var head :node = _

  def add(new_val :Int): Unit = {
    val newNode = new node(new_val)
    // adding node to the beginning, previous is null
    newNode.prev = null
    // link the new node to the old list
    newNode.next = head
    // previous of head node becomes new node
    if (head != null) {
      head.prev = newNode
    }
    // move head to point to the new node
    head = newNode
  }

  def inverse(): Unit = {
    val st :Stack[Int] = new Stack[Int]()
    var t :node = head
    while (t != null) {
      st.push(t.value)
      t = t.next
    }
    t = head
    while (t != null) {
      t.value = st.pop()
      t = t.next
    }
  }

  def main(args: Array[String]) {
    val system = ActorSystem()
    for (i <-1 to 5) {
      val dLLA = system.actorOf(Props(new doublyLinkedListA))
      add(dLLA.hashCode())
    }
    val store :node = head
    println("Doubly linked list traversed: ")
    while (head != null) {
      print(head.value + " ")
      head = head.next
    }
    head = store
    println()
    inverse()
    println("Doubly linked list inversed: ")
    while (head != null) {
      print(head.value + " ")
      head = head.next
    }
  }
}




