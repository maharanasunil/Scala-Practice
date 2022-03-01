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

val acct = new SavingsAccount with ConsoleLogger with TimeStamp with ShortLogger {
  maxLength = 20
}
acct.withdraw(1000 )