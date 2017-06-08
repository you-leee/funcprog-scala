package week2

/**
  * Created by Julia Julia on 2016.10.18..
  */
object RationalTest extends App{
  val x = new Rational(1,3)
  println("Numer: " + x.numer + ", Denom: " + x.denom)

  val y = new Rational(5,7)
  println(x + y)

  val z = new Rational(3,2)
  println(x - y - z)

  println(y + y)

  println(x < y)
  println(x.max(y))

  val strange = new Rational(1, 0)
  //println(strange.add(strange))

  // Infix operator
  println(x + z)
}
