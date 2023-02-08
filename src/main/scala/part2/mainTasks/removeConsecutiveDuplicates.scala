package part2.mainTasks

import scala.collection.mutable.ListBuffer

object removeConsecutiveDuplicates {
  // a method to remove consecutive duplicates from a list
  def remove (list :List[Int]) :List[Int] = {
    var i :Int = 0
    val noConsDuplB :ListBuffer[Int] = new ListBuffer[Int]
    // add the first element of the initial list to the new list
    noConsDuplB += list(0)
    for (i <- 1 to list.length-1) {
      // add the current element of the initial list to the new list, if the current element does not equal the previous one
      if (list(i) != list(i-1)) {
        noConsDuplB += list(i)
      }
    }
    val noConsDupl = noConsDuplB.toList
    return noConsDupl
  }

  def main(args: Array[String]): Unit = {
    // create a list
    val list :List[Int] = List(1, 2, 2, 2, 4, 8, 4)
    // remove consecutive duplicates from the above list
    println(" The list without consecutive duplicates is: " + remove(list))
  }
}
