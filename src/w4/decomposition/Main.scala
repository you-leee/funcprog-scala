package w4.decomposition

/**
  * Created by Julia Julia on 2016.10.25..
  */
object Main {
  def eval(e: Expr): Int = {
    if(e.isNumber) e.numValue
    else if(e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression: " + e)
  }
}
