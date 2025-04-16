package tohoho.implecits;

import scala.language.implicitConversions

class MyString(val str: String) {
  def hello(): String = "Hello, " + str
}

object rule {
  def main(args: Array[String]) {
    implicit def intToBoolean(n: Int): Boolean = n != 0
    // if there is not any code about rule of `implecit`, occuring a compile error
    if (1) println("OK") else println("NG")

    // modern version is defined as class implicit
    // implicit def stringToMyString(arg: String): MyString = new MyString(arg)
    // println("Yamada".hello())

    implicit class MyString(val str: String) {
      def hello(): String = "Hello, " + str
    }

    println("Yamada".hello())
  }
}
