package tohoho;

// C <: B <: A (order by class strength)
class A
class B extends A
class C extends B

class D[T]
class E[T <: B]
class F[T >: B]

object compa_clazz {
  def main(args: Array[String]) {
    val d1 = new D[A]
    val d2 = new D[B]
    val d3 = new D[C]

    // val e1 = new E[A] // ng cuz A !:< B
    val e2 = new E[B]
    val e3 = new D[C]

    val f1 = new F[A]
    val f2 = new F[B]
    // val f3 = new F[C] // ng cuz B !<: C
  }
}
