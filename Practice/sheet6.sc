import javafx.scene.control.Separator

// PART 1
val zones = java.util.TimeZone.getAvailableIDs
zones.map(s => s.split("/"))

// select the arrays whose length is greater than 1
zones.map(s => s.split("/")).filter(a => a.length > 1)
// Get the 1st element of all the arrays a(1)
zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1))

// get every 10th one
zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1)).grouped(10).toArray
// get every 10th element
zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1)).grouped(10).toArray.map(a => a(0))

// PART 2
1.to(10).reduceLeft(_ * _)

def fac(n: Int) = (1 to n).reduceLeft(_ * _)
fac(10)

(1 to 10). map(x => 2).reduceLeft(_ * _)

def powerN(a: Int, b: Int) = (1 to b).map(n => a).reduceLeft(_ * _)
powerN(2,16)

def concat(strings: Seq[String], separator: String) = strings.reduceLeft(_ + separator + _)
concat(Array("Hello", "Sunil", "Whats","Up!"), "//")

// PART 3

// Creating our own while loop

def While(cond: => Boolean)(body: => Unit) {
  if (cond) {
    body; While(cond)(body)
  }
}

val n = 10
var i = 1
var f = 1
While (i < n) { f *= i; i += 1; print(i+"-"+f+",")  }
f