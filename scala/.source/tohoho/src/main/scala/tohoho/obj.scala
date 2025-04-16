package tohoho;

object Counter {
  private var counter = 0
  def countUp(): Unit = { counter += 1 }
  def getCount(): Int = counter
}

// this is called "the companion object"
class Math
object Math {
  val Pi = 3.14f
}

// this is called "the class that has the factory method"
class Factory(name: String)
object Factory {
  // return instance itself with name
  def apply(name: String): Factory = new Factory(name)
}

// this is called "extractor"
class Extractor(val name: String)
object Extractor {
  def apply(name: String): Extractor = new Extractor(name)
  def unapply(p: Extractor): Option[String] =
    if (p.name != "Unknown") Some(p.name) else None
}

object obj {
  def main(args: Array[String]) {
    val cnt = Counter
    println(cnt.getCount())
    cnt.countUp()
    println(cnt.getCount())

    println(Math.Pi)

    var p = Factory("Factory")

    var p2 = Extractor("Extractor")
    // var p2 = Extractor("Unknown")
    var name = p2 match {
      case Extractor(n) => n
      case _            => "(Unknown)"
    }
    println(name)
  }
}
