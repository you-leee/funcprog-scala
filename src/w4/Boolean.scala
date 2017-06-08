package w4

/**
  * Created by Julia Julia on 2016.10.24..
  */

abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean) = ifThenElse(x, false)
  def || (x: => Boolean) = ifThenElse(true, x)
  def unary_! = ifThenElse(false, true)

  def == (x: Boolean) = ifThenElse(x, x.unary_!)
  def != (x: Boolean) = ifThenElse(x.unary_!, x)

  def < (x: Boolean) = ifThenElse(false, x)

 /* object true extends Boolean.super {
    def ifThenElse[T](t: => T, e: => T) = t
  }

  object false extends Boolean.super {
    def ifThenElse[T](t: => T, e: => T) = e
  } */

}
