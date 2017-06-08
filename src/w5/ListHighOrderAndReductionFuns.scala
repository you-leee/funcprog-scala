package w5

/**
  * Created by Julia Julia on 2016.11.16..
  */
class ListHighOrderAndReductionFuns {

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => Nil
    case x :: ys => x*factor :: scaleList(ys, factor)
  }

  def scaleListWithMap(xs: List[Double], factor: Double): List[Double] = {
    xs map (x => x*factor)
  }

  def squareList(xs: List[Double]): List[Double] = xs match {
    case Nil => Nil
    case x :: ys => x*x :: squareList(ys)
  }

  def squareListWithMap(xs: List[Double]): List[Double] = {
    xs map (x => x*x)
  }

  def posElems(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => if(y > 0) y :: posElems(ys) else posElems(ys)
  }

  def filter[T](xs: List[T])(implicit fun: T => Boolean): List[T] = xs match {
    case Nil => Nil
    case y :: ys => if(fun(y)) y :: filter(ys) else filter(ys)
  }

  def pack[T](xs : List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case y :: ys => {
      val(first, rest) = xs span (x => x == y)
      first :: pack(rest)
    }
  }

  def encode[T](xs : List[T]): List[(T, Int)] = xs match {
    case Nil => Nil
    case y :: ys => {
      val(rest) = xs dropWhile (x => x == y)
      (y, xs.length - rest.length) :: encode(rest)
    }
  }

  def encodeWithPack[T](xs : List[T]): List[(T, Int)] = {
    pack(xs) map (l => (l.head, l.length))
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = {
    (xs foldRight ys)(_ :: _)
  }

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())(f(_) :: _)

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)((x, y) => 1 + y)

}
