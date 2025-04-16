package tohoho;

object lazys {
  def funcA(s: String) = { println("A"); "A" }
  def funcC(s: String) = { println("C"); "C" }
  def main(args: Array[String]) {
    lazy val a = funcA("")
    println("B")
    funcC(a)
    println("D")
  }
}
