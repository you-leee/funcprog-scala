package week2

/**
  * Created by Julia Joosz on 2016.10.18..
  */
class FixedPoints {
  // Fixed point, if f(x) = x
  // We can locate the fixed point by applying f() a lot of times => after a while, the value will not vary anymore, we located the fixed point
  val tolerance = 0.0001
  def isCloseEnough(y: Double, x: Double): Boolean = {
    return Math.abs((y - x) / x) < tolerance * x
  }

  def findFixedPoint(f: Double => Double)(initialX: Double): Double = {
    def loop(guess: Double): Double = {
      val estX = f(guess)
      if(isCloseEnough(estX, guess))
        estX
      else
        loop(estX)
    }
    loop(initialX)
  }

  def sqrt(x: Double): Double = {
    findFixedPoint(y => (y + x/y)/2)(1.0)
  }

  def averageDamp(f: Double => Double)(x: Double): Double = {
    (x + f(x)) / 2
  }

  def sqrt2(x: Double): Double = {
    findFixedPoint(averageDamp(y => x/y))(1.0)
  }
}
