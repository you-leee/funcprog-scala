package w3

import java.util.NoSuchElementException

/**
  * Created by Julia Julia on 2016.10.19..
  */
class Nil[T] extends List[T]{
  def isEmpty: Boolean = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")

  def add(x: T): List[T] = new Cons(x, new Nil[T])

  def remove(x: T): List[T] = ???
}
