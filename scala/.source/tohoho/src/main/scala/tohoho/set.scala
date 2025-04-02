package tohoho;

object set {
  def main(args: Array[String]) {
    import scala.collection.mutable.ListBuffer

    var lb = ListBuffer[Int](1, 2, 3)
    println(lb(0))
    lb(0) = 1
    lb += 4
    0 +=: lb
    lb.foreach(n => print(n))
    println("")

    lb.update(1, 999)
    println(lb)

    lb.remove(2)
    println(lb)

    for (n <- lb) print(n); println("")

    var lb2 = lb.map(n => n * 2)
    println(lb2)
  }
}
