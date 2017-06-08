package w3

/**
  * Created by Julia Julia on 2016.10.19..
  */
object Empty extends IntSet{
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  def contains(x: Int): Boolean = false

  override def toString: String = "."

  def union(other: IntSet): IntSet = other

}
