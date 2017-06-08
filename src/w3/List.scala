package w3

/**
  * Created by Julia Julia on 2016.10.19..
  */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def add(x: T): List[T]
  def remove(x: T): List[T]
}
