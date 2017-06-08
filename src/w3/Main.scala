package w3

import week2.Rational

/**
  * Created by Julia Julia on 2016.10.19..
  */
object Main extends App{
  val t1 = new NonEmpty(3,  Empty,  Empty)
  val t2 = t1 incl 4

  println(t2)

  new Rational(3,4)
  println(new Planar {
    def height: Int = 1

    def width: Int = 2
  }.surface)

  val r1 = new Rational(1,2)
  val r2 = new Rational(1,2)
  println(r1.equals(r2))
  println(r1 == r2)

  val i1: Integer = new Integer(1)
  val i2: Integer = new Integer(1)
  println(i1.equals(i2))
  println(i1 == i2)

  def error(message: String): Nothing = {
    throw new Error(message)
  }

  //error("test")

  def nth[T](n: Int, list: List[T]): T = {
    if(list.isEmpty) {
      throw new IndexOutOfBoundsException
    } else if(n == 0) {
      list.head
    } else {
      nth(n - 1, list.tail)
    }
  }

  val myList = new Cons(1,new Cons(2, new Nil[Int]))
  println(nth(1,myList))
}
