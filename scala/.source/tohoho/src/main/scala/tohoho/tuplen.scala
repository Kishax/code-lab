package tohoho;

class Foo {
  def getErrorInfo(): (Int, String) = (404, "Not Found")
}

object tuplen {
  def main(args: Array[String]) {
    var foo = new Foo()
    var (err, msg) = foo.getErrorInfo()
    println(s"$err: $msg")
  }
}
