package week2.mainTasks

import scala.collection.mutable.ListBuffer

object lettersCombination {
  def collection(digits: String) :List[String] = {
    val digitsArr :Array[String] = digits.split("")
    var i :Int = 0
    val listB :ListBuffer[String] = new ListBuffer[String]
    var compoundStr :String = ""
    var lettersCombined :String = ""
    for (i <- 0 to digitsArr.length-1) {
      var corrStr :String = ""
      digitsArr(i) match {
        case "2" => {
          corrStr = "abcd"
        }
        case "3" => {
          corrStr = "defg"
        }
        case "4" => {
          corrStr = "ghij"
        }
        case "5" => {
          corrStr = "jklm"
        }
        case "6" => {
          corrStr = "mnop"
        }
        case "7" => {
          corrStr = "pqrs"
        }
        case "8" => {
          corrStr = "stuv"
        }
        case "9" => {
          corrStr = "wxyz"
        }
      }
      compoundStr = compoundStr+corrStr
    }
    val tempArr :Array[String] = compoundStr.split("")
    val tempList :List[String] = tempArr.map(_.toString).toList
    val listDigits :List[String] = List()
    for((first, second) <- tempList zip tempList.drop(1)) {
      lettersCombined = first+second
      listB += lettersCombined
      lettersCombined = ""
    }
    for((first, second) <- tempList zip tempList.drop(2)) {
      lettersCombined = first+second
      listB += lettersCombined
      lettersCombined = ""
    }
    for((first, second) <- tempList zip tempList.drop(3)) {
      lettersCombined = first+second
      listB += lettersCombined
      lettersCombined = ""
    }
    val list = listB.toList
    return list
  }

  def main(args: Array[String]): Unit = {
    println("Introduce a number: ")
    var digits: String = scala.io.StdIn.readLine()
    println("The combination of letters corresponding to the introduced number is: " + collection(digits))
  }
}
