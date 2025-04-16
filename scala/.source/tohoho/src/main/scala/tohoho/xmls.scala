package tohoho;

object xmls {
  def main(args: Array[String]) {
    var fooPrice = 500
    val xml =
      <root>
        <items>
          <item><name>foo</name><price>{fooPrice}</price></item>
          <item><name>baa</name><price>320</price></item>
          <item><name>baz</name><price>640</price></item>
        </items>
      </root>

    for (item <- xml \ "items" \ "item") println(item)
    println("")
    for (item <- xml \\ "item") println(item)
  }
}
