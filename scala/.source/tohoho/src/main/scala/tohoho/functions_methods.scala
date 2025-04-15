package tohoho;

object functions_methods {
  def main(args: Array[String]) {
    val add = (x: Int, y: Int) => x + y
    main2(args)
  }

  def add(x: Int, y: Int): Int = x + y

  // under defs are same
  // "return" key is not likely to be used
  def addA(x: Int, y: Int): Int = {
    x + y
  }

  def addB(x: Int, y: Int): Int = {
    return x + y
  }

  def func(msg: Int): Unit = println(msg)

  def func2(name: String = "(unknown)", age: Int = -1): Unit = {
    println(name + "(" + age + ")")
  }

  def main2(args: Array[String]) {
    func2("Yamada", 26)
    func2("Yamada")
    func2(age = 26)
  }
}
