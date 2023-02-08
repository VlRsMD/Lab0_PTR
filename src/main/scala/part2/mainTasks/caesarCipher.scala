package part2.mainTasks

import scala.collection.mutable.ListBuffer

object caesarCipher {
  def encode (str: String, key :Int): String = {
    var alph :String = "abcdefghijklmnopqrstuvwxyz"
    val strArr: Array[String] = str.split("")
    val ciphertextB :ListBuffer[String] = new ListBuffer
    var i :Int = 0
    for (i <- 0 to strArr.length-1) {
      var k :Int = (alph.indexOf(strArr(i))+key) % 26
      ciphertextB += alph.charAt(k).toString
    }
    val ciphertextL = ciphertextB.toList
    var ciphertext :String = ciphertextL.mkString("")
    return ciphertext
  }

  def decode (str: String, key :Int): String = {
    var alph :String = "abcdefghijklmnopqrstuvwxyz"
    val strArr: Array[String] = str.split("")
    val plaintextB :ListBuffer[String] = new ListBuffer
    var i :Int = 0
    for (i <- 0 to strArr.length-1) {
      var k :Int = (alph.indexOf(strArr(i))-key) % 26
      plaintextB += alph.charAt(k).toString
    }
    val plaintextL = plaintextB.toList
    var plaintext :String = plaintextL.mkString("")
    return plaintext
  }

  def main(args: Array[String]): Unit = {
    println("Plaintext 'lorem' encoded with key 3 produces ciphertext: " + encode("lorem", 3))
    println("Ciphertext 'oruhp' encoded with key 3 produces plaintext: " + decode("oruhp", 3))
  }
}
