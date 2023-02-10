package week2.minimalTasks

object isPrime {
  // a method to check whether an integer number is prime or not
  def check(x: Int): Int = {
    var flag: Int = 0
    // if x is 0 or 1, x is not prime
    if (x == 0 || x == 1) {
      flag = 1
    }
    var i = 0
    // if there are any divisors of x except 1 and x, x is not prime
    for (i <- 2 to x / 2) {
      if (x % i == 0) {
        // increment flag with 1 each time a new divisor of x except 1 and x is found
        flag = flag + 1
      }
    }
    return flag
  }

  def main(args: Array[String]) {
    println("Introduce an integer number: ")
    var x: Int = scala.io.StdIn.readInt()
    // the value returned by the "check" method called passing the introduced integer to it is 0 for prime numbers
    if (check(x) == 0) {
      println("Number " + x + " is prime")
    } else {
      println("Number " + x + " is not prime")
    }
  }
}
