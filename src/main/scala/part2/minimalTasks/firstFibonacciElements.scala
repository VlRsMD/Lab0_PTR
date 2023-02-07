package part2.minimalTasks

import scala.collection.mutable.ListBuffer

object firstFibonacciElements {
  // a method to create a Fibonacci sequence containing number of elements specified by an integer parameter
  def fibonacci(length: Int): List[Int] = {
    val fib: ListBuffer[Int] = new ListBuffer[Int]
    // add first 2 elements to the sequence
    fib += 1
    fib += 1
    var i: Int = 0
    var newEl: Int = 0
    // fill the sequence with Fibonacci numbers according to the algorithm until the length limit of the sequence is reached
    for (i <- 2 to length - 1) {
      newEl = fib(i - 2) + fib(i - 1)
      fib += newEl
    }
    val fibList = fib.toList
    return fibList
  }

  def main(args: Array[String]): Unit = {
    println("Introduce the number of the Fibonacci sequence elements: ")
    var n: Int = scala.io.StdIn.readInt()
    val fibonacciList = fibonacci(n)
    println("The Fibonacci sequence containing " + n + " elements is: " + fibonacciList)
  }
}
