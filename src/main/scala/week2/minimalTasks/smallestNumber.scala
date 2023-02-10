package week2.minimalTasks

object smallestNumber {
  def smallestNum (a: Int, b: Int, c:Int): Int = {
    var num :Int = 0;
    // comparing digits and arranging them to obtain the smallest number
    if (a <= b &&  b<=c && a!=0) {
      num = a*100 + b*10 + c
    }
    if (a <= c &&  c<=b && a!=0) {
      num = a*100 + c*10 + b
    }
    if (b <= a &&  a<=c && b!=0) {
      num = b*100 + a*10 + c
    }
    if (b <= c &&  c<=a && b!=0) {
      num = b*100 + c*10 + a
    }
    if (c <= a &&  a<=b && c!=0) {
      num = c*100 + a*10 + b
    }
    if (c <= b &&  b<=a && c!=0) {
      num = c*100 + b*10 + a
    }
    // if one of the digits is 0, put that digit on the second place and arrange other digits correspondingly
    if (a==0) {
      if (b <= c) {
        num = b*100 + c
      } else {
        num = c*100 + b
      }
    }
    if (b==0) {
      if (a <= c) {
        num = a*100 + c
      } else {
        num = c*100 + a
      }
    }
    if (c==0) {
      if (b <= a) {
        num = b*100 + a
      } else {
        num = a*100 + b
      }
    }
    return num
  }

  def main(args: Array[String]): Unit = {
    println("Introduce the first digit: ")
    var a: Int = scala.io.StdIn.readInt()
    if (a >= 10) {
      println("The digit value cannot be greater or equal to 10! Introduce the first digit once again: ")
      a = scala.io.StdIn.readInt()
    }
    println("Introduce the second digit: ")
    var b: Int = scala.io.StdIn.readInt()
    if (b >= 10) {
      println("The digit value cannot be greater or equal to 10! Introduce the second digit once again: ")
      b = scala.io.StdIn.readInt()
    }
    println("Introduce the third digit: ")
    var c: Int = scala.io.StdIn.readInt()
    if (c >= 10) {
      println("The digit value cannot be greater or equal to 10! Introduce the third digit once again: ")
      c = scala.io.StdIn.readInt()
    }
    var smallNum = smallestNum(a, b, c)
    println("The smallest number obtained from the introduced digits is: " + smallNum)
  }
}
