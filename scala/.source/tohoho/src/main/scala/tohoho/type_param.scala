package tohoho;

class Data[A](var value: A) {
  def print(): Unit = println(value)
}

object type_param {
  def main(args: Array[String]) {
    var d1 = new Data[Int](123)
    var d2 = new Data[String]("ABC")
    d1.print()
    d2.print()
  }
}
