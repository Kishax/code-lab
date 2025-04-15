package tohoho;

object name_passing_param {
  def main(args: Array[String]) {
    def loop(n: Int)(stmt: => Unit): Unit = {
      if (n > 0) {
        stmt
        loop(n - 1) { stmt }
      }
    }

    loop(5) {
      println("A")
    }
  }
}
