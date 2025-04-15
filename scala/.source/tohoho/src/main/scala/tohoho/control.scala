package tohoho;

object control {
  def main(args: Array[String]) {
    var a = 5
    var x = if (a > 3) "BIG" else "SMALL"
    print(x)
    println("")

    var n = 0
    do {
      println(n)
      n += 1
    } while (n < 5)

    for (i <- 1 to 10) println(i)
    println("")
    for (i <- 1 until 10) println(i)
    println("")
    for (i <- 0 to 10 by 2) println(i)
    println("")
    for (s <- Array("A", "B", "C")) println(s)
    println("")

    for (i <- 1 to 10 if i % 2 == 0) println(i)
    for (i <- 1 to 10 if i % 2 == 0; if i % 3 == 0) println(i)

    println("")
    var list = Array("A", "B", "C")
    val list2 = for (s <- list) yield s + s
    for (s <- list2) println(s)
    println("")

    val msg = 2 match {
      case 1 => "One"
      case 2 => "Two"
      case 3 => "Three"
      case _ => "More"
    }
    println(msg)

    val msg2 = 1 match {
      case 1 | 2 => "Small"
      case _     => "Big"
    }

    var msg3 = 2 match {
      case n if n < 5  => "Small"
      case n if n == 5 => "Equal"
      case n if n > 5  => "Big"
    }
  }

  def getValue(value: Any) = {
    value match {
      case n: Int    => "Int: " + n
      case s: String => "String: " + s
      case _         => "Unknown"
    }
  }
}
