package w3

/**
  * Created by Julia Julia on 2016.10.19..
  */
class NonEmpty(root: Int, left: IntSet, right: IntSet) extends IntSet {

  def incl(x: Int): IntSet = {
    if(x < root)
      new NonEmpty(root, left incl x, right)
    else if(x > root)
      new NonEmpty(root, left, right incl x)
    else
      this
  }

  def contains(x: Int): Boolean = {
    if(x < root)
      left.contains(x)
    else if(x > root)
      right.contains(x)
    else
      true
  }

  override def toString: String = "{" + left + root + right + "}"

  def union(other: IntSet): IntSet = {
    ((left union right) union other) incl root
  }
}
