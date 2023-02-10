package week2.mainTasks

import scala.collection.mutable.ListBuffer

object lineWords {
  def words (list :List[String]): List[List[String]] = {
    // letters of the first row of the keyboard only
    var line1Str :String = "qwertyuiopQWERTYUIOP"
    val line1 :Array[String] = line1Str.split("")
    // letters of the second row of the keyboard only
    var line2Str :String = "asdfghjklASDFGHJKL"
    val line2 :Array[String] = line2Str.split("")
    // letters of the third row of the keyboard only
    var line3Str :String = "zxcvbnmZXCVBNM"
    val line3 :Array[String] = line3Str.split("")
    val listAllLinesB :ListBuffer[List[String]] = new ListBuffer[List[String]]
    var i :Int = 0
    var j :Int = 0
    var k :Int = 0
    val listLine1B :ListBuffer[String] = new ListBuffer
    val listLine2B :ListBuffer[String] = new ListBuffer
    val listLine3B :ListBuffer[String] = new ListBuffer
    // check if in the initial list there are words formed only of letters of the first row
    for (i <- 0 to list.length-1) {
      val tempArr :Array[String] = list(i).split("")
      var ind: Int = 0
      for (j <- 0 to list(i).length-1) {
        for (k <- 0 to line1.length-1) {
          if (line1(k)==tempArr(j)) {
            // increment "ind" each time letter of the current list element equals the letter from the corresponding row
            ind = ind + 1
          }
        }
      }
      // if "ind" equals the length of the current element of the list, add that element to the corresponding new list
      if (ind == list(i).length) {
        listLine1B += list(i)
      }
    }
    // check if in the initial list there are words formed only of letters of the second row
    for (i <- 0 to list.length-1) {
      val tempArr :Array[String] = list(i).split("")
      var ind: Int = 0
      for (j <- 0 to list(i).length-1) {
        for (k <- 0 to line2.length-1) {
          if (line2(k)==tempArr(j)) {
            // increment "ind" each time letter of the current list element equals the letter from the corresponding row
            ind = ind + 1
          }
        }
      }
      // if "ind" equals the length of the current element of the list, add that element to the corresponding new list
      if (ind == list(i).length) {
        listLine2B += list(i)
      }
    }
    // check if in the initial list there are words formed only of letters of the third row
    for (i <- 0 to list.length-1) {
      val tempArr :Array[String] = list(i).split("")
      var ind: Int = 0
      for (j <- 0 to list(i).length-1) {
        for (k <- 0 to line3.length-1) {
          if (line3(k)==tempArr(j)) {
            // increment "ind" each time letter of the current list element equals the letter from the corresponding row
            ind = ind + 1
          }
        }
      }
      // if "ind" equals the length of the current element of the list, add that element to the corresponding new list
      if (ind == list(i).length) {
        listLine3B += list(i)
      }
    }
    val listLine1 = listLine1B.toList
    val listLine2 = listLine2B.toList
    val listLine3 = listLine3B.toList
    listAllLinesB += listLine1
    listAllLinesB += listLine2
    listAllLinesB += listLine3
    // list containing the lists containing words which are formed only of the letters of a particular row of the keyboard
    val listAllLines = listAllLinesB.toList
    return listAllLines
  }

  def main(args: Array[String]): Unit = {
    val list :List[String] = List("Alaska", "Half", "X", "Retro", "Top")
    println("Words which consist only of letters of the first row of the English keyboard are: " + words(list)(0))
    println("Words which consist only of letters of the second row of the English keyboard are: " + words(list)(1))
    println("Words which consist only of letters of the third row of the English keyboard are: " + words(list)(2))
  }
}
