package part2.minimalTasks

object rotateLeft {
  // method to rotate a list n places to the left
  def rotate(list: List[Int], n: Int) :List[Int] = {
    val rotatedLeft :List[Int] = list.drop(n) ++ list.take(n)
    return rotatedLeft
  }

  def main(args: Array[String]): Unit = {
    // initial list
    val list: List[Int] = List(1, 2, 4, 8, 4, 3)
    // number of places to rotate list to the left
    var n :Int = 3
    // rotate initial list n places to the left
    val rotateLeftList = rotate(list, n)
    // print out the result
    println("The list rotated " + n + " places to the left is: " + rotateLeftList)
  }
}
