package tohoho;

object clazz {
  class Person(var name: String, age: Int = -1) {
    def getName(): String = this.name
    def getAge(): Int = this.age
  }

  def main(args: Array[String]) {
    var p1 = new Person("Yamada", 26)
    var p2 = new Person("Tanaka")
    println("p1.name: " + p1.getName() + ", p1.age: " + p1.getAge())
    println("p2.name: " + p2.getName() + ", p2.age: " + p2.getAge())

    var p3 = new Person("Michel", 27)
    println(p3.getName)
    p3.name = "Michel2"
    println(p3.name)
  }
}
