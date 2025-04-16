package tohoho;

trait Foo3 { def foo(): Unit = println("Foo") }
trait Baa3 { def baa(): Unit = println("Baa") }
trait Baz3 { def baz(): Unit = println("Baz") }
class MixClass extends Foo3 with Baa3 with Baz3

object mixin {
  def main(args: Array[String]) {
    val obj = new MixClass()
    obj.foo; obj.baa(); obj.baz()
  }
}
