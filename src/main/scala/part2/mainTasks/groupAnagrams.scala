package part2.mainTasks

import scala.collection.mutable.ListBuffer

object groupAnagrams {
  def anagrams(list :List[String]) :List[List[String]] = {
    var i :Int = 0
    var j :Int = 0
    val anagramB :ListBuffer[String] = new ListBuffer[String]
    val allAnagramsB :ListBuffer[List[String]] = new ListBuffer[List[String]]
    for (i <- 0 to list.length-1) {
      val anagramB :ListBuffer[String] = new ListBuffer[String]
      anagramB += list(i)
      for (j <- 0 to list.length-1) {
        if (j!=i && list(j).length==list(i).length) {
          val l1 :Array[String] = list(i).split("")
          val l2 :Array[String] = list(j).split("")
          val l1s = l1.sorted
          val l2s = l2.sorted
          var temp :Int = 0
          var k: Int = 0
          for (k <- 0 to l1s.length-1) {
            if(l1s(k) == l2s(k)) {
              temp = temp+1
            }
          }
          if (temp == l1s.length) {
            anagramB += list(j)
          }
        }
      }
      val anagram = anagramB.toList
      allAnagramsB += anagram
    }
    val allAnagrams = allAnagramsB.toList
    return allAnagrams
  }

  def main(args: Array[String]): Unit = {
    val list :List[String] = List("eat", "tea", "tan", "ate", "nat", "bat")
    println("The list of the lists of anagrams is: " + anagrams(list))
  }
}
