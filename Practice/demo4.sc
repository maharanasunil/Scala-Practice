class Point(var x: Double, val y: Double) {
  //println("Yo! You called a function")
  def move(dx: Double, dy: Double) = new Point(x + dx, y + dy)
  def distanceFromOrigin = math.sqrt(x * x + y * y)

  override def toString: String = f"(${x}, ${y})"
}

val p = new Point(3, 4)

p.move(10, 20)

p.distanceFromOrigin
p.toString

//p.x
//p.x = 10
//p.x

1 to 10 map(3 * _) filter(_ % 5 == 2)
1.to(10).map(3 * _).filter(_ % 5 == 2)

object Accounts {
  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber += 1; lastNumber}
}
Accounts
Accounts.newUniqueNumber()
Accounts.newUniqueNumber()

