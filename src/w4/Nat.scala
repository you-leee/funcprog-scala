package w4

/**
  * Created by Julia Julia on 2016.10.24..
  */
abstract class Nat {
  def isZero: scala.Boolean
  def predecessor: Nat // one before that, exception if zero
  // next Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat //exception if neg
}
