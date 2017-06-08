package w4.decomposition

/**
  * Created by Julia Julia on 2016.10.25..
  */
class Number(n: Int) extends Expr {
  def isNumber: Boolean = true

  def isSum: Boolean = false

  def numValue: Int = n

  def leftOp: Expr = throw new Error("Number.leftOp")

  def rightOp: Expr = throw new Error("Number.leftOp")

  def eval: Int = n
}
