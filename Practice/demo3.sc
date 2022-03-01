import scala.collection.mutable.ArrayBuffer

// LESSON 3
val nums = new Array[Int](10)
for(i <- 0 until nums.length) nums(i) = i * i
nums
for(ele <- nums) println(ele)

val a = Array("Hello", "World")
a(0) = "Goodbye"
a

val b = new ArrayBuffer[Int]
b += 1
b += (1,2,3,5)
b ++= Array(8,13,21)

val c = ArrayBuffer("Mary", "had", "a", "little", "lamb")

c += "its"
c += ("fleece", "was", "white")
c ++= Array("as", "snow")

c.insert(3, "medium-sized")
c

val num = Array(2,3,5,7,11)
val result = for (ele <- num if ele%2 != 0) yield 2 * ele


val x = Array(1,7,9,2)
x.sorted
x
x.sum
val sortedx = x.sorted
sortedx.reverse
sortedx.max

Array(1,2,3).toString
Array(1,2,3).mkString(" | ")
// For ArrayBuffer toString does the right thing.
b.toString()

// MAP DATA STRUCTURE

// Immutable Map
var scores = Map("Sam" -> 10, "Ram" -> 3, "Bob" -> 8)
// Mutable Map
val mscores = scala.collection.mutable.Map("Sunil" -> 10)

val ramScores = scores("Ram")

scores.getOrElse("Fred", 0)

mscores("Kate") = 7
mscores

scores + ("Alice" -> 10, "Fred" -> 7, "Cindy" -> 8)
scores

scores = scores + ("Alice" -> 10, "Fred" -> 7, "Cindy" -> 8)

scores = scores - "Alice"
scores

for((k, v) <- scores)
  println(k + " has scored " + v)

for((k, v) <- scores) yield (v, k)

scores.keySet
scores.values

// TUPLES
val t = (1, 3.14, "Sunil")
t._1
t._2

val (_, second, third) = t