package tohoho;

class ClassA {
  def publicFunc() { println("publicFunc") }
  protected def protectedFunc() { println("protectedFunc") }
  private def privateFunc() { println("privateFunc") }

  def funcA() {
    this.publicFunc()
    this.protectedFunc()
    this.privateFunc()
  }
}

class ClassB extends ClassA {
  def funcB() {
    this.publicFunc()
    this.protectedFunc()
    // this.private()
  }
}

object access {
  def main(args: Array[String]) {}
}

package packageA {
  class ClassA {
    protected[packageA] def protectedXFunc() { println("protectedXFunc") }
    private[packageA] def privateXFunc() { println("privateXFunc") }
  }

  class ClassB {
    def funcB() {
      var d = new ClassA()
      d.protectedXFunc()
      d.privateXFunc()
    }
  }

  package packageC {
    class ClassC {
      def funcC() {
        var d = new ClassA()
        d.protectedXFunc()
        // d.privateXFunc()
      }
    }
  }
}
