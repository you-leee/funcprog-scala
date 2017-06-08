package week2

/**
  * Created by Julia Joosz on 2016.10.18..
  */
object FixedPointTest extends App{
  val fixedPointFinder = new FixedPoints()

  println(fixedPointFinder.findFixedPoint(x => 1 + x/2)(1))

  println(fixedPointFinder.sqrt(4))
  println(fixedPointFinder.sqrt(0.0009))
  println(fixedPointFinder.sqrt(10e10))

  println(fixedPointFinder.sqrt2(4))
  println(fixedPointFinder.sqrt2(0.0009))
  println(fixedPointFinder.sqrt2(10e10))
}
