package part2.minimalTasks

object uniqueSum {
  def main(args: Array[String]): Unit = {
    // initial list containing integers
    val list: List[Int] = List(1, 2, 4, 8, 4, 2)
    // new list containing only unique elements of the initial list
    val uniqueElList: List[Int] = list.distinct
    // calculate sum of the elements of the new list
    var sum: Int = uniqueElList.sum
    // print out the result
    println("The sum of the unique elements of the list " + list + " is: " + sum)
  }
}
