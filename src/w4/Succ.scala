package w4

/**
  * Created by Julia Julia on 2016.10.24..
  */
class Succ(n: Nat) extends Nat{
  def isZero: scala.Boolean = false

  def predecessor: Nat = n

  def + (that: Nat): Nat = new Succ(n + that)

  def - (that: Nat): Nat = if(that.isZero) this else (n - that.predecessor)
}
