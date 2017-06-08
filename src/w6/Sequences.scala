package w6

/**
  * Created by Julia Julia on 2016.11.17..
  */
class Sequences {
  // Sequence: List, Vector, Range (Array, String); Set; Map
  // Sequence: exists, map, zip/unzip, forall, flatMap, sum, product, max, min

  // List all combinations of numbers x and y, where x is drawn from 1...M and y from 1...N
  def combination(M: Int, N: Int): IndexedSeq[(Int, Int)] = {
    (1 to M) flatMap (x => (1 to N) map (y => (x, y))) // Vector(1...N, 1...N, ..., 1...N) M times (so: M*N) mapped to tuples
  }

  def combination(M: Range, N: Range): IndexedSeq[(Int, Int)] = {
    M flatMap (x => N map (y => (x, y))) // Vector(1...N, 1...N, ..., 1...N) M times (so: M*N) mapped to tuples
  }

  // Compute the scalar product of 2 vectors
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double = {
    // First, we couple the vectors togethers by index, then we calculate the products of each tuple and sum them up.
    // Example: [1,2,3] * [4,5,2] => (1,4) (2,5) (3,2) => 1*4 2*5 3*2 => 4 + 10 + 6 = 20
    (xs zip ys).map(z => z._1 * z._2).sum
  }
  // A number n is prime, if the only divisors of n are 1 and n itself
  def isPrime(n: Int): Boolean = {
    ! ((combination(2 to n-1, n to n)) exists (t => t._2%t._1 == 0))
  }

  // A number n is prime, if the only divisors of n are 1 and n itself
  def isPrime2(n: Int): Boolean = {
    (2 until n) forall (x => n%x != 0)
  }

  def buildSpecialPairs(n: Int): IndexedSeq[(Int, Int)] = {
    (1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (x => isPrime(x._1 + x._2))
  }

  def buildSpecialPairs_ForExpression(n: Int): IndexedSeq[(Int, Int)] = {
    for{
      i <- 1 until n
      j <- 1 until i
      if isPrime(i + j)
    } yield (i, j)
  }

  def scalarProduct_ForExpression(xs: List[Double], ys: List[Double]): Double = {
    (for { (x, y) <- xs zip ys } yield x*y ).sum
  }
}
