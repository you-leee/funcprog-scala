package week2

/**
  * Created by Julia Joosz on 2016.10.18..
  */
object CurryingTest extends App{
  val c = new Currying

  println(c.sumInts(1,10))
  println(c.sum(x => x)(1,10))

  println(c.factorial(3))
  println(c.factorial2(3))
}
