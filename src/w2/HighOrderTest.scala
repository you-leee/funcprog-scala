package week2

/**
  * Created by Julia Julia on 2016.10.14..
  */
object HighOrderTest extends App{
  val ho = new HigherOrder

  println(ho.sumFactorial(1,4))

  println(ho.sumGeneralTail(x => x*x)(3,4))
}
