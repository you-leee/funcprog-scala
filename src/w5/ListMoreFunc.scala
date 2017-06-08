package w5

/**
  * Created by Julia Julia on 2016.11.10..
  */
class ListMoreFunc[T] {
  /*
  Return last element of list
   */
  def last(xs: List[Int]): Int = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys) //O(n)
  }
  /*
  Return elements of list except last
 */
  def init(xs: List[Int]): List[Int] = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys) //O(n)
  }
  /*
  Concatenates two lists. If length of xs is n and lenght of ys is m, than the lenght of returned list is n+m
  Complexity: O(n) [O(|xs|)]
   */
  def concat(xs: List[Int], ys: List[Int]): List[Int] =  xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  /*
  Reverses the order of a lists.
  Complexity: O(n^2) :( (n: recursion, n: concatenation(++))
   */
  def reverse(xs: List[Int]): List[Int] =  xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y)
  }

  /*
  Removes the nth element
   */
  def removeAt(xs: List[Int], n: Int): List[Int] =  {
    if(n >= xs.length || n < 0) {
      xs
    } else {
      xs match {
        case List() => List()
        case y :: ys => if (n == 0) ys else y :: removeAt(ys, n-1)
      }
    }
  }

  /*
  Removes the nth element
   */
  def removeAt2(xs: List[Int], n: Int): List[Int] =  (xs take n) ::: (xs drop n+1)

  /*
  Nem jó :(
   */
  def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case y :: ys => y :: flatten(ys)
  }

  def mergesort(xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if( n == 0) {
      xs
    } else {
      val (first, second) = (xs splitAt n)

      // First attempt
      def merge(a : List[Int], b : List[Int]): List[Int] = {
        a match {
          case Nil => b
          case a1 :: a2 =>
          b match {
            case Nil => a
            case b1 :: b2 =>
              if (a1 <= b1) {
                a1 :: merge (a2, b)
              } else {
                b1 :: merge (a, b2)
              }
          }
        }
      }

      // Merge with tuples
      def merge2(a : List[Int], b : List[Int]): List[Int] = {
        (a,b) match {
          case (Nil, b) => b
          case (a, Nil) => a
          case (a1 :: a2, b1 :: b2) => if(a1 <= b1) a1 :: merge(a2, b) else b1 :: merge(a, b2)
        }
      }

      merge2(mergesort(first), mergesort(second))
    }
  }

  def mergesortGeneral[T](xs: List[T])(lt: (T, T) => Boolean): List[T]= {
    val n = xs.length/2
    if( n == 0) {
      xs
    } else {
      // Merge with tuples
      def merge(a : List[T], b : List[T]): List[T] = {
        (a,b) match {
          case (Nil, b) => b
          case (a, Nil) => a
          case (a1 :: a2, b1 :: b2) => if(lt(a1,b1)) a1 :: merge(a2, b) else b1 :: merge(a, b2)
        }
      }

      val (first, second) = (xs splitAt n)
      merge(mergesortGeneral(first)(lt), mergesortGeneral(second)(lt))
    }
  }

  def mergesortGeneral2[T](xs: List[T])(implicit ord: Ordering[T]): List[T]= {
    val n = xs.length/2
    if( n == 0) {
      xs
    } else {
      // Merge with tuples
      def merge(a : List[T], b : List[T]): List[T] = {
        (a,b) match {
          case (Nil, b) => b
          case (a, Nil) => a
          case (a1 :: a2, b1 :: b2) => if(ord.lt(a1,b1)) a1 :: merge(a2, b) else b1 :: merge(a, b2)
        }
      }

      val (first, second) = (xs splitAt n)
      merge(mergesortGeneral2(first), mergesortGeneral2(second))
    }
  }

}
