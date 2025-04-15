package tohoho;

object try_catch {
  def main(args: Array[String]) {
    try {
      throw new IllegalArgumentException("arg1")
    } catch {
      case e: IllegalArgumentException => println("IllegalArgumentException")
      case e: Exception                => println("Unknown Exception")
    } finally {
      println("Finally")
    }
  }
}
