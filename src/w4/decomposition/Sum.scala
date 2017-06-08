package w4.decomposition

/**
  * Created by Julia Julia on 2016.10.25..
  */
class Sum(left: Expr, right: Expr) extends Expr{
  def isNumber: Boolean = false

  def isSum: Boolean = true

  def numValue: Int = throw new Error("Sum.numValue")

  def leftOp: Expr = left

  def rightOp: Expr = right

  def eval: Int = left.eval + right.eval
}
