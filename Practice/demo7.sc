val ch = "sunil"
val sign = ch match {
  case "+" => 1
  case "-" => -1
  case _ => 0
}

// Exceptions
val a = "Sunil"
try{
  a(5)
}catch {
  //case e: StringIndexOutOfBoundsException => println("Caught "+e)
  case _: Throwable => println("Oh Noooooo!")
} finally {
  println("Done")
}

//Extractors
val arr = Array(0)
val arr1 = Array(2,5)
val arr3 = Array(1,2,3)

arr3 match {
  case Array(0) => "0"
  case Array(x, y) => x+ " "+ y
  case Array(0, _*) => "0 ..."
  case _ => "Something Else"
}
// Extractors in Variable Declarations
val(uppercase, lowercase) = "Hello, World".partition(Character.isUpperCase(_))
val Array(first, second, _*) = arr3

val map = Map("Sunil" -> 5)
for((key, value) <- map)  // Extracting key and value from map
  println(key + "->" + value)

// CASE CLASSES
abstract class Amount // not necessary for case classes
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object Nothing extends Amount

val amt = Dollar(20)

amt match {
  case Dollar(v) => "$" + v
  //case Currency(_, u) => "Oh Noo, I got " + u
  //case Nothing => ""
}
// copy function lets you copy values:
val amt1 = Currency(100, "EUR")
val price = amt1.copy()
val price2 = amt1.copy(unit = "CHF")

// Working with Option Type
val scores = Map("Alice" -> 1, "Bob" -> 2)
scores.get("Alice") match {
  case Some(score) => println(score)
  case None => println("No score")
}

// Recursive Data Structures
abstract class Expr
case class Num(value: Int) extends Expr
case class Sum(left: Expr, right: Expr) extends Expr
case class Product(left: Expr, right: Expr) extends Expr

def eval(e: Expr): Int = e match {
  case Num(v) => v
  case Sum(l, r) => eval(l) + eval(r)
  case Product(l, r) => eval(l) * eval(r)
}

val e = Product( Num(3), Sum( Num(4), Num(5) ) )
eval(e)
