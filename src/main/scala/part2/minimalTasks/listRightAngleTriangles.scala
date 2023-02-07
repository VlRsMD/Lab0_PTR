package part2.minimalTasks

import scala.collection.mutable.ListBuffer
import scala.math.sqrt

object listRightAngleTriangles {
  // method to create a list of tuples which consist of the elements which are sides of a right angle triangle
  def tuples (): List[List[Int]] = {
    val tuplesListB :ListBuffer[List[Int]] = new ListBuffer[List[Int]]
    var i :Int = 0
    var j :Int = 0
    var c :Double = 0
    for (i <- 1 to 20) {
      for (j <- 1 to 20) {
        // calculate square root of the sum of i to power of 2 and j to power of 2
        c = sqrt(i*i + j*j)
        // if square root calculated above is an integer, add tuple (i, j, c) to the list
        if (c%1 == 0) {
          tuplesListB += List(i, j, c.toInt)
        }
      }
    }
    val tuplesList = tuplesListB.toList
    return tuplesList
  }

  def main(args: Array[String]): Unit = {
    println("The list of tuples elements of which are sides of a right angle triangle is: " + tuples())
  }
}
