package w4

/**
  * Created by Julia Julia on 2016.10.24..
  */
object Zero extends Nat{
  def isZero: scala.Boolean = true

  // one before that, exception if zero
  def predecessor: Nat = throw new Error("There is no natural number preceding zero.")

  def + (that: Nat): Nat = that

  //exception if neg
  def - (that: Nat): Nat = if(that.isZero) this else throw new NoSuchElementException("Negative number.")
}
