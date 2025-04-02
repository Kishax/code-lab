package tohoho;

object list {
  def main(args: Array[String]) {
    // var list = Nil // empty one
    var list = List[Int](1, 2, 3)
    // or
    // var list: List[Int] = List(1, 2, 3)
    // or
    // var list = List(1, 2, 3)
    println(list(0))

    // list(0) = 10 // do not write this cuz of immutable one now

    list = 0 :: list
    list = list ++ List(4, 5)
    list = list ::: List(6, 7)

    for (n <- list) print(n)
    print("\n")
    println("list:")
    list.foreach(n => println("  " + n))

    var list2 = list.map(n => n * 2)
    println("list2:")
    list2.foreach(n => println("  " + n))

    println(s"list length: ${list.length}\nlist2 length: ${list.length}")
  }
}
