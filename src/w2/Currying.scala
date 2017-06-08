package week2

/**
  * Created by Julia Joosz on 2016.10.14..
  */
class Currying {
  // Sum is a function, that return a locally defined function
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if(a > b) 0 else f(a) + sumF(a + 1, b)
    }
    sumF
  }

  def sumInts = sum(x => x)

  // Shorter definition of sum, that returns a function
  // (Int => Int) => (Int, Int) => Int
  def sumShorter(f: Int => Int)(a:Int, b:Int): Int = {
    if(a>b) 0 else f(a) + sumShorter(f)(a + 1, b)
  }

  // Why not using 3 parameters together? (f,a,b) -> this way, you can pass a function(sum(f)) to a variable and just call it later on with a and b

  // Currying:
  // def f(args_1)...(args_n) = E <===> def f = (args_1 => (args_2 => (... (args_n => E)...))

  // Same, but with product
  def product(f: Int => Int)(a:Int, b:Int): Int = {
    if(a > b) 1 else f(a) * product(f)(a + 1, b)
  }

  def factorial(n: Int) = product(x => x)(1, n)

  def mapReduce(f: Int => Int, combine:(Int, Int) => Int, default: Int)(a: Int, b: Int): Int = {
    if(a > b) default else combine(f(a), mapReduce(f, combine, default)(a + 1, b))
  }

  def factorial2(n: Int) = mapReduce(x => x, (x,y) => x*y, 1)(1, n)

  def product_MapReduce(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x,y) => x*y, 1)(a: Int, b: Int)
}
