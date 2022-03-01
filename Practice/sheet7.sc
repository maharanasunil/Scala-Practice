import scala.math.sqrt

// PART 1
def swap(p: (Int, Int)) = p match {
  case (x, y) => (y, x)
}
swap((3,4))

def swap2(a: Array[Int]) = a match {
  case Array(x, y, rest @ _*) => Array(y, x) ++ rest
  case _ => a
}
swap2(Array(1,7,2,9))
swap2(Array(1))

// PART 2
abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item

val book = Article("Scala Book", 39.95)
val gift = Bundle("xmas special", 10, book, Article("Old Potrero Straight Rye Whiskey", 79.95))

def price(it: Item): Double = it match {
  case Article(_, price) => price
  case Bundle(_, discount, its @ _ *) => its.map(price).sum - discount
}
price(book)
price(gift)

val specialBundle = Bundle("Fathers Day special", 20.0,
  Article("Scala Book", 39.95),
  Bundle("Anchor Distillery Sampler", 10.0,
  Article("Old Portrero Ray", 79.95),
  Article("Junipero Gin", 32.95))
)

val Bundle(_,_, Article(descr, pr), _*) = specialBundle

// PART 3
/*
abstract class DoubleOption
case class SomeDouble(value: Double) extends DoubleOption
case object NoDouble extends DoubleOption


def inv(x: Double) = if(x == 0) NoDouble else SomeDouble(1/x)
inv(5)
inv(0)

def f(x: Double) = if (x <= 1) SomeDouble(sqrt(1-x)) else NoDouble

def compose(f: Double => DoubleOption, g: Double => DoubleOption) = (x: Double) => g(x) match {
  case SomeDouble(result) => f(result)
  case NoDouble => NoDouble
}
val h = compose(f, inv)
h(0)
h(1)
h(2)
h(0.5)
*/

abstract class DoubleOption {
  def isEmpty: Boolean
  def get: Double
}
class SomeDouble(val value: Double) extends DoubleOption{
  def isEmpty = false
  def get = value
}
object NoDouble extends DoubleOption{
  def isEmpty = true
  def get = throw new NoSuchElementException
}



/*
def isEmpty(opt: DoubleOption) = opt match {
  case NoDouble => true
  case _ => false
}

def get(opt: DoubleOption) = opt match {
  case NoDouble => throw new NoSuchElementException
  case SomeDouble(value) => value
}
*/