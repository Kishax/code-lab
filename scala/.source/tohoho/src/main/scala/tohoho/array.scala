package tohoho;

object array {
  def main(args: Array[String]) {
    var arr: Array[String] = Array.empty
    println(arr)

    arr = Array("A", "B", "C")

    arr = arr :+ "D"

    arr = "@" +: arr

    println(arr.length)
    println(arr(0))

    arr(0) = "$"

    for (a <- arr) println(a)

    arr.map(n => n + n)
    arr.foreach(a => print(a))

    var arr2 = Array.ofDim[Int](2, 3)
    arr2(1)(2) = 10002
  }
}
