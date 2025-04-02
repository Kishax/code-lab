package tohoho;

object reserved_word {
  def main(args: Array[String]) {
    val bool1: Boolean = true
    val bool2: Boolean = false

    val char1: Char = 'a'
    val char2: Char = 'あ'

    val string1: String = "ABCDEFG"

    val name1 = "Yamada"
    println(s"His name is $name1. ${name1} is ${12 + 14} years old.")

    val num1 = 123
    println(f"${num1}%05d")

    println("ABC\nDEF")
    println(raw"ABC\nDEF")
    println("""ABC\nDEF""")
    println("""This is Japan.
This is America.""")

    val bite1: Byte = 127
    val short1: Short = 32767
    val int1: Int = 2147483647
    val long1: Long = 9223372036854775807L

    val bigint1: BigInt = BigInt(9223372036854775807L)
    val bigint2: BigInt = bigint1 + bigint1

    val float1: Float = 1.2f
    val double1: Double = 1.2e3
    val bigdecimal1: BigDecimal = BigDecimal(1.2e99)

    val symbol1: Symbol = 'ABC
    val symbol2: Symbol = Symbol("ABC")

    main2(Array())
  }

  def log(str: String): Unit = {}

  def main2(args: Array[String]) {
    println("This is main2 method.")

    val any1: Any = 123
    val any2: Any = "ABC"

    var anyval1: AnyVal = 123
    var anyval2: AnyVal = 12.3

    var anyref1: AnyRef = "ABC"
    var anyref2: AnyRef = null
  }
}

