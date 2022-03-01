import scala.math._

val num = 3.14
val fun = ceil _
fun(num)

Array(3.14,1.42,2.0).map(fun)
Array(3.14,1.42,2.0).map((x: Double) => 3 * x)

def valAtOneQuarter(f: (Double) => Double) = f(0.25)
valAtOneQuarter(ceil _)
valAtOneQuarter(sqrt _)

def mulBy(factor: Double) = (x: Double) => factor * x
val quintuple = mulBy(3)
quintuple(20)

Array(3.14,1.42,2.0).map(x => 3 * x)
Array(3.14,1.42,2.0).map(3*_)
//If only one parameter then we can use _
valAtOneQuarter(x => 3 * x)
valAtOneQuarter(3 * _)

// MAP
(1 to 9).map(0.1 * _)
// Filter
(1 to 9).filter(_ % 2 == 0)
// ReduceLeft
(1 to 9). reduceLeft(_ * _) // (....(((1*2)*3)*4....)*9)

(1 to 9).filter(_ % 2 == 0).map(_ * 0.1)
// Same As
for(n <- 1 to 9 if n%2 == 0) yield 0.1 * n

def mul(x: Int,y: Int) = x * y
// curried version
def mulOneAtATime(x: Int) = (y: Int) => x * y
mulOneAtATime(3) // 3 * y
mulOneAtATime(3)(14) // 3*14

// Scala provides some Syntactic Sugar
def mulOneAtATimee(x: Int)(y: Int) = x*y


def runInThread(block: => Unit) {
  new Thread{
    override def run() { block }
  }.start()
}

//runInThread {
//  println("Hi"); Thread.sleep(10); println("Bye")
//}
