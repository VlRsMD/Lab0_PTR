package part2

import scala.collection.mutable.ListBuffer
import scala.util.Random

object extractRandomN {
  def rand(list :List[Int]) :List[Int] = {
    // initialize a ListBuffer for random elements
    val randListB :ListBuffer[Int] = new ListBuffer[Int]
    // generate 3 random numbers between 0 and the length of the parameter list
    val r = new Random()
    var rnd1 :Int = r.between(0, list.length)
    var rnd2 :Int = r.between(0, list.length)
    var rnd3 :Int = r.between(0, list.length)
    // add elements from the parameter list which have the indexes of the random numbers generated above to the ListBuffer
    randListB += list(rnd1)
    randListB += list(rnd2)
    randListB += list(rnd3)
    // convert ListBuffer into list
    val randList = randListB.toList
    return randList
  }

  def main(args: Array[String]): Unit = {
    // list containing integers
    val list :List[Int] = List(1, 2, 4, 8, 4, 3)
    // list containing 3 random integers from the initial list
    val randomList :List[Int] = rand(list)
    println("The random list is: " + randomList)
  }
}
