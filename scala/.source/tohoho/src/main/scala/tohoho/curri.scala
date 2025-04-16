package tohoho;

object curri {
  def main(args: Array[String]) {
    val add = (x: Int, y: Int, z: Int) => x + y + z
    println(add(3, 4, 5))
    val curriedAdd = add.curried
    val curriedAdd2 = curriedAdd(3)
    val curriedAdd3 = curriedAdd2(4)
    println(curriedAdd3(5))
    println(((curriedAdd(3))(4))(5))
    println(curriedAdd(3)(4)(5))

    var partialAdd = add(_: Int, _: Int, 5)
    println(partialAdd(3, 4))
  }
}
