package week2

/**
  * Created by Julia Joosz on 2016.10.14..
  */
class HigherOrder {

  def cube(x: Int): Int = x*x*x
  def id(x: Int):Int = x
  def fact(x: Int):Int = if(x == 0) 1 else fact(x - 1)

  def sumCubes(a: Int, b: Int): Int = {
    if(a > b) 0 else cube(a) + sumCubes(a + 1, b)
  }

  // Generalize summing function
      // Function type: A => B
  def sumGeneral(f:(Int => Int), a: Int, b: Int): Int = {
    if(a > b) 0 else f(a) + sumGeneral(f, a + 1, b)
  }

  // Use the general summing with custom function
  def sumFactorial(a: Int, b: Int) = sumGeneral(fact, a, b)

  // Literals for functions: anonymus functions. Ex: (x: Int) => x*x*x  . You can always write: def f(x1: t1, x2: t2...) = E
  def sumInts(a:Int, b:Int) = sumGeneral((x: Int) => x, a, b)

  // Tail recursive sumGeneral function
  def sumGeneralTail(f:(Int => Int))(a: Int, b: Int): Int = {
    def loop(a:Int, acc: Int): Int = {
      if(a > b) acc else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }
}
