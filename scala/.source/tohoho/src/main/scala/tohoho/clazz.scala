package tohoho;

class Person(var name: String, age: Int = -1) {
  def getName(): String = this.name
  def getAge(): Int = this.age
}

class Person2 {
  private var _name = "(unknown)"
  private var _age = -1
  def name = _name
  def name_=(newName: String): Unit = _name = newName
  def age = _age
  def age_=(newAge: Int): Unit = _age = newAge
}

class ClassA1 {
  def foo(): Unit = println("ClassA")
  def sample(): Unit = println("ClassA:sample")
}

// adding "final" in advance words, you can create the method being prohibited to override/extends itself
class ClassB1 extends ClassA1 {
  def baa(): Unit = println("ClassB")
  override def foo(): Unit = println("ClassA!!!")
  override def sample() {
    super.sample()
    println("ClassB:sample")
  }
}

object clazz {
  def main(args: Array[String]) {
    var p1 = new Person("Yamada", 26)
    var p2 = new Person("Tanaka")
    println("p1.name: " + p1.getName() + ", p1.age: " + p1.getAge())
    println("p2.name: " + p2.getName() + ", p2.age: " + p2.getAge())

    var p3 = new Person("Michel", 27)
    println(p3.getName)
    p3.name = "Michel2"
    println(p3.name)

    val p4 = new Person2
    p4.name = "Sasuke"
    p4.age = 72
    println(p4.name)
    println(p4.age)

    val obj = new ClassB1()
    obj.foo()
    obj.baa()
    obj.sample()
  }
}
