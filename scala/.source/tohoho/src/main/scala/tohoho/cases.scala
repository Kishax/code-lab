package tohoho;

case class Point(x: Int, y: Int)

object cases {
  def main(args: Array[String]) {
    val p1 = Point(100, 200)
    val p2 = Point(100, 200)
    println(if (p1 == p2) "Equal" else "Not equal")
  }
}
