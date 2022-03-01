// PART 1
/*
import java.awt._
import java.awt.geom.Ellipse2D
val r = new Rectangle(5, 10, 20, 30)
r.translate(10, 20)
r

trait RectangleLike {
  def setFrame(x: Double, y: Double, w: Double, h: Double): Unit
  def getX: Double
  def getY: Double
  def getWidth: Double
  def getHeight: Double
  def translate(dx: Double, dy: Double) { setFrame(getX + dx, getY + dy, getWidth, getHeight) }
  override def toString = f"(${getX}, ${getY})"
}
val egg = new Ellipse2D.Double(5,10,20,30) with RectangleLike
egg.translate(10,20)
egg.toString

 */

// PART 2
trait logged {
  def log(msg: String) {}
}

trait ConsoleLogger extends logged {
  override def log(msg: String) { print(msg) }
}

class SavingsAccount extends logged {
  private var balance: Double = 0
  def withdraw(amount: Double) {
    if (amount > balance) log("Insufficient Funds")
    else balance -= amount
  }
}

trait TimeStamp extends logged {
  override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger extends logged {
  var maxLength = 15

  override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) + "..."
    )
  }
}

val acct1 = new SavingsAccount with ConsoleLogger with TimeStamp with ShortLogger {
  maxLength = 20
}
acct1.withdraw(1000 )

val acct2 = new SavingsAccount
  with ConsoleLogger with ShortLogger with TimeStamp  {
  maxLength = 40
}
acct2.withdraw(1000 )

val acct3 = new SavingsAccount
  with ShortLogger with TimeStamp with ConsoleLogger {
  maxLength = 20
}
acct3.withdraw(1000 )

// PART 3
