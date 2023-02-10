package week2.minimalTasks

object reverse {
  def main(args: Array[String]): Unit = {
    // list containing integers
    val list: List[Int] = List(1, 2, 4, 8, 4)
    // reversed list
    val reversedList: List[Int] = list.reverse
    println("The reversed list is: " + reversedList)
  }
}
