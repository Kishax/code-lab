package tohoho;

object map {
  def main(args: Array[String]) {
    val map1 = Map(1->"ABC", 2->123, 3->null)
    println(map1.get(1))
    println(map1.get(2))
    println(map1.get(3))
    println(map1.get(4))

    val o = map1.get(1)
    println(o.get)
    println(o.getOrElse(-1))
    println(o.orNull)

    var colors = Map(1->"Red", 2->"Green", 3->"Blue")
    println(colors(2))
    // println(colors(4))
    println(colors.get(2))
  }
}

