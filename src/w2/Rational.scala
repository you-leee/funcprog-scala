package week2

/**
  * Created by Julia Julia on 2016.10.18..
  */
class Rational(x: Int, y: Int) {
  require(y != 0, "Denominatior must not be zero")

  def this(x: Int) = this(x, 1)

  // Legnagyobb kozos oszto
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  override def toString: String = numer + "/" + denom

  def + (that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def unary_- : Rational = new Rational(-numer, denom)

  def - (that: Rational): Rational = this + -that

  def * (that: Rational): Rational = new Rational(this.numer * that.numer, this.denom * that.denom)

  def < (that: Rational): Boolean = numer * that.denom < that.numer * denom

  def max(that: Rational): Rational = if(this < that) that else this
}
