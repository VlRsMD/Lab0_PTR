package part2.minimalTasks

import scala.collection.mutable.ListBuffer

object translator {
  // a method to translate a sentence given the corresponding dictionary and that sentence passed as parameters
  // dictionary is a list consisting of lists consisting of pairs of string elements: the first element is the initial word and the second element is the translated word
  def translate (dict :List[List[String]], sent: String): String = {
    // split sentence into an array of string elements
    val sentArr :Array[String] = sent.split(" ")
    var i :Int = 0
    var j :Int = 0
    for (i <- 0 to sentArr.length-1) {
      for (j <- 0 to dict.length-1) {
        var str :List[String] = dict(j)
        var strInitial :String = str(0)
        var strTranslated :String = str(1)
        // if the word is found in the dictionary, then translate it
        if (sentArr(i) == strInitial) {
          sentArr(i) = strTranslated
        }
      }
    }
    var translatedSent: String = ""
    // arrange the elements of the array after translation to from the translated sentence
    for (i <- 0 to sentArr.length-1) {
      translatedSent = translatedSent + " " + sentArr(i) + " "
    }
    return translatedSent
  }

  def main(args: Array[String]): Unit = {
    // create dictionary
    val dictB :ListBuffer[List[String]] = new ListBuffer[List[String]]
    dictB += List("the", "das")
    dictB += List("weather", "Wetter")
    dictB += List("is", "ist")
    val dict = dictB.toList
    println("Introduce your sentence to be translated: ")
    var sent: String = scala.io.StdIn.readLine()
    println("The translated sentence is the following: " + "\n")
    println(translate(dict, sent))
  }
}
