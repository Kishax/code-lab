package tohoho;

object higher_order_func {
  def hello(): Unit = println("Hello")
  def doFunc(n: Int, fn: () => Unit): Unit = {
    for (i <- 1 to n) fn()
  }

  // replace func:"hello" into second arg of doFunc
  def main(args: Array[String]) {
    doFunc(5, hello)
  }
}
