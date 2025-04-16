package tohoho;

import scala.collection.immutable.List

class Data[A](var value: A) {
  def print(): Unit = println(value)
}

class Animal
class Dog extends Animal
class Cat extends Animal

class Box[A](val content: A)

// scala.collection.immutable.List is +A
// class List[+A]

class Food
class DogFood extends Food

trait Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(a: Animal): Unit = println(s"Animal: $a")
}

class AnyPrinter extends Printer[Any] {
  def print(a: Any): Unit = println(s"Any: $a")
}

object type_param {
  def main(args: Array[String]) {
    var d1 = new Data[Int](123)
    var d2 = new Data[String]("ABC")
    d1.print()
    d2.print()

    // e.g minimumly
    // generally
    // String is sub-class of AnyRef, so holding
    def foo(v: AnyRef) = println(v)
    foo("ABC": String)
    // case of type param
    // invariant (default)
    class Foo_INV[T](v: T)
    class Baa_INV(v: Foo_INV[AnyRef])
    // val e = new Baa_INV(new Foo_INV[String]("ABC")) // error: Foo_INV[String] is not Foo_INV[AnyRef] (invariant)
// covariant (ok: Foo_COV[String] <: Foo_COV[AnyRef], because String <: AnyRef)
    class Foo_COV[+T](v: T)
    class Baa_COV(v: Foo_COV[AnyRef])
    var e_cov = new Baa_COV(new Foo_COV[String]("ABC"))
    // contravariant (ok: Foo_CONTRA[Any] <: Foo_CONTRA[AnyRef], because AnyRef <: Any)
    class Foo_CONTRA[-T](v: T)
    class Baa_CONTRA(v: Foo_CONTRA[AnyRef])
    var e_contra = new Baa_CONTRA(new Foo_CONTRA[Any]("ABC"))

    // e.g concretely
    // invariant (default)
    // Dog != Cat != Animal
    val dogBox: Box[Dog] = new Box(new Dog)
    // you would like to allow the following, you must allow super-class as type param, Box[+A]
    // val animalBox: Box[Animal] = dogBox // ng
    // val catBox: Box[Cat] = dogBox // ng

    // covariant (+T) (can be allowed if it's sub-class)
    // Animal ) Dog
    val dogList: List[Dog] = List(new Dog, new Dog)
    val animalList: List[Animal] = dogList // ok cuz Dog is sub-type of Animal
    // val catList: List[Cat] = animalList // ng cuz Animal is not sub-type of Cat

    // contravariant (-T) (can be allowed if it's super-class)
    def printAnimal(p: Printer[Animal], a: Animal): Unit = p.print(a)
    val animalPrinter: Printer[Animal] = new AnimalPrinter
    val anyPrinter: Printer[Any] = new AnyPrinter

    printAnimal(animalPrinter, new Dog) // ok
    // printAnimal(anyPrinter, new Dog) // ng cuz Printer[Any] is super-type of Printer[Animal], too big as type

    val printerOfAnimal: Printer[Animal] = new AnimalPrinter // ok
    // val printerOfAny: Printer[Any] = animalPrinter // ng cuz type Printer[Any] is too big to extend Printer[Animal]

    // def processFood(handler: Function1[Food, String], food: Food): String = handler(food)
    // modern code(syntax suger writing) is recommended
    def processFood(handler: Food => String, food: Food): String = handler(food)

    def processDogFood(
        handler: Function1[DogFood, String],
        food: DogFood
    ): String = handler(food)

    val foodHandler: Function1[Food, String] = (f: Food) =>
      s"Processing food: $f"
    val dogFoodHandler: Function1[DogFood, String] = (df: DogFood) =>
      s"Processing dog food: $df"

    // processFood(dogFoodHandler, new Food) // ng cuz Function1[DogFood, String] is not sub-type of Function[Food, String]
    processFood(foodHandler, new DogFood)

    // example of `Function1[-T, +R]`(input is contravariant)
    val handler1: Function1[Any, String] = (a: Any) => s"Handling: $a"
    val handler2: Function1[Animal, String] =
      handler1 // ok cuz Animal is sub-type of Any => Function1[Any, String] is super-type of Function1[Animal, String]
  }
}
