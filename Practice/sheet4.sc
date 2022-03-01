// PART 1
class Time(val hours: Int, var minutes: Int = 0) {
  //def this(h: Int) {this(h,0)}
  if(hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60) throw new IllegalArgumentException
  def before(other: Time) = hours < other.hours || hours == other.hours && minutes < other.minutes
  override def toString = f"${hours}:${minutes}%02d"
}

val morning = new Time(9,0)
//val crazyTime = new Time(-3, 222)
val afternoon = new Time(16, 30)
morning.before(afternoon)
afternoon.before(morning)
val noon = new Time(12)
noon.hours
noon.minutes = 30
noon


// PART 2
class Time2(h: Int,m: Int = 0) {
  private var minutesSinceMidnight = h * 60 + m
  def hours = minutesSinceMidnight / 60
  def minutes = minutesSinceMidnight %60

  def minutes_=(newVal: Int) {
    if (newVal < 0 || newVal >= 60) throw new IllegalArgumentException
    minutesSinceMidnight = hours * 60 + newVal
  }

  if(h < 0 || h >= 24 || m < 0 || m >= 60) throw new IllegalArgumentException
  def before(other: Time2) = minutesSinceMidnight < other.minutesSinceMidnight
  override def toString = f"${hours}:${minutes}%02d"
}
val morning2 = new Time2(9,0)
//val crazyTime = new Time(-3, 222)
val afternoon2 = new Time2(16, 30)
morning2.before(afternoon2)
afternoon2.before(morning2)
val noon2 = new Time2(12)
noon2.hours
noon2.minutes = 30
noon2

//noon2.minutes = -999
//noon2

// PART 3
class Time3(val hours: Int, val minutes: Int) {
  def this(h: Int) {this(h,0)}
  if(hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60)
    throw new IllegalArgumentException

  override def toString = f"${hours}:${minutes}%02d"
  def -(other: Time3) = hours * 60 +  minutes - other.hours * 60 - other.minutes
  def <(other: Time3) = this - other < 0
}
// companion object
object Time3{
  def apply(h: Int, m: Int) = new Time3(h,m)
}
Time3(9,0) < Time3(12,30)