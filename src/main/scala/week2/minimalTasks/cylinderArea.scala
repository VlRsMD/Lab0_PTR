package week2.minimalTasks

object cylinderArea {
  // a method for calculating the area of cylinder given its radius and height
  def area(r: Double, h: Double): Double = {
    var pi: Double = 3.14159265
    var a: Double = 0
    // calculate the area of cylinder
    a = 2 * pi * r * (r + h)
    return a
  }

  def main(args: Array[String]) {
    // input radius
    println("Introduce the radius of cylinder: ")
    var r: Double = scala.io.StdIn.readDouble()
    // input height
    println("Introduce the height of cylinder: ")
    var h: Double = scala.io.StdIn.readDouble()
    var a: Double = 0
    // call the "area" method passing to it radius and height of cylinder as arguments in order to calculate the area of cylinder
    a = area(r, h)
    // print out the result
    println("The area of cylinder is " + a)
  }
}
