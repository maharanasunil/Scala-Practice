// LESSON 2
val x = -2

val result = if(x > 0) "Something"

val n = 10
for (i <- 1 to n) println(i)

for (c<- "Sunil") println(c)

for (i <- 1 to 3; j <- 1 to 3) println((10 * i+j) + " ")

for (i <- 1 to 3; j <- 1 to 3 if i != j) println((10 * i+j) + " ")

val result = for (i <- 1 to 10) yield i%3

def abs(x: Double) = if (x >= 0) x else -x

def fac(n : Int) = {
  var r = 1
  for (i <- 1 to n) r = r*i
  r
}
fac(10)

// Named and default Parameters
def decorate(str: String, left: String = "[", right: String = "]") =
  left + str + right

decorate("Sunil")
decorate("Sunil", ">>>(")
decorate("Sunil", left = "<<(", right = ")>>")

def sum(args: Int*) = {
  var res = 0
  for(arg <- args) res += arg
  res
}

val s = sum(1,4,9,16,25)

val s1 = sum(1 to 5: _*)
