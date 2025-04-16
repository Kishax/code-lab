package tohoho;

// you can describe implements of function concretly into trait block
trait Shape {
  def getArea(): Float
  def shape(): Unit = println("Shape!")
}

class Rect(width: Float, height: Float) extends Shape {
  override def getArea(): Float = width * height
}

class Circle(r: Float) extends Shape {
  override def getArea(): Float = r * r * 3.14f
}

object traits {
  def main(args: Array[String]) {
    val r1 = new Rect(100, 200)
    val c1 = new Circle(100)
    println(r1.getArea())
    println(c1.getArea())
  }
}
