package w4.decomposition

/**
  * Created by Julia Julia on 2016.10.25..
  */
trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
  def eval: Int
}
