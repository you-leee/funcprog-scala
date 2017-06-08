package w3

/**
  * Created by Julia Julia on 2016.10.19..
  */
class Cons[T](val head: T, val tail: List[T]) extends List[T]{

  def isEmpty: Boolean = false

  def singleton[T](elem: T): Cons[T] = new Cons[T](elem, new Nil[T])

  def add(x: T): List[T] = ???

  def remove(x: T): List[T] = ???
}
