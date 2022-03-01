import java.net.URL
import java.util.Scanner
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
// PART 1
val nums = ArrayBuffer(1,2,-3,4,5,-7,6,-9)

val indexes = for(i <- 0 until nums.length if nums(i) < 0 )  yield i
val indexesToRemove = indexes.drop(1)

for(i <- indexesToRemove.reverse) nums.remove(i)
nums

// Convert the above to a Function
val num = ArrayBuffer(1,-3,-5,7,9,11,-15)
def removeAllButFirstNegative(num: ArrayBuffer[Int]) {
  val indexes = for(i <- 0 until num.length if num(i) < 0 )  yield i
  val indexesToRemove = indexes.drop(1)
  for(i <- indexesToRemove.reverse) num.remove(i)
}
removeAllButFirstNegative(num)
num
// OR
def removeAllButFirstNegative2(nums: ArrayBuffer[Int]) = {
  val indexesToRemove = (for (i <- 0 until nums.length if nums(i) < 0) yield i).drop(1)
  for (i <- 0 until nums.length if !indexesToRemove.contains(i)) yield nums(i)
}
removeAllButFirstNegative2(num)

// PART 2
val in = new Scanner(new URL(
  "https://www.w3.org/TR/PNG/iso_8859-1.txt"
).openStream)
var count = Map[String, Int]()
while (in.hasNext) {
  val word = in.next()
  count = count + (word -> (count.getOrElse(word, 0) + 1))
}

count("SPACE")
count("SMALL")
//count

// PART 3
val words = Array("Mary", "had", "a", "little", "lamb", "its", "fleece", "was", "white", "as", "snow", "and", "everywhere", "that", "Mary", "went", "the", "lamb", "was", "sure", "to", "go")

words.groupBy(_.substring(0, 1))

words.groupBy(_.length)

// PART 4

// Partition
"New York".partition(_.isUpper)

val (neg, pos) = nums.partition(_ < 0)
val res = pos
res += neg(0)
res

// Zip Operation
val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)

for((s,n) <- pairs) print(s*n)