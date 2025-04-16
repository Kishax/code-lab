package tohoho;

abstract class Foo2 {
  def hello(): Unit
}

class Baa extends Foo2 {
  def hello(): Unit = println("Hello")
}

object abstructor {
  def main(args: Array[String]) {
    var obj = new Baa()
    obj.hello()
  }
}
