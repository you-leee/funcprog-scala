package w4

/**
  * Created by Julia Julia on 2016.10.25..
  */
trait List[+T] {
  def isEmpty: scala.Boolean
  def head: T
  def tail: List[T]

  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
  //def add(x: T): List[T]
  //def remove(x: T): List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T]{

  def isEmpty: scala.Boolean = false

  //def singleton[T](elem: T): Cons[T] = new Cons[T](elem, new Nil[T])

  //def add(x: T): List[T] = ???

  //def remove(x: T): List[T] = ???
}

object Nil extends List[Nothing]{
  def isEmpty: scala.Boolean = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")

  //def add(x: T): List[T] = new Cons(x, new Nil[T])

  //def remove(x: T): List[T] = ???
}


object test {
  def x: List[String] = Nil
  //def f(xs: List[w3.NonEmpty], x: w3.Empty) = xs prepend x
}

object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, Nil))
  def apply[T](x1: T): List[T] = new Cons(x1, Nil)
  def apply[T](): List[T] = Nil
}
