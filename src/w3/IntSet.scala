package w3

/**
  * Created by Julia Julia on 2016.10.19..
  */
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet

  // S<:T means S is subtype of T (T is a supertype of S) -> [S <: IntSet]
  // S>:T means S is supertype of T (T is a subtype of S) -> [S >: NonEmpty]
  // In Scala, Arrays are NOT covariant, but Lists are, because List is immutable and Array is not
  // val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
  // val b: Array[Empty] = a -> TYPE ERRRORRRR!!!!
  //def assertAllPos[S <: IntSet](r: S): S
}
