package w6

/**
  * Created by Julia Julia on 2016.11.17..
  */
object Main extends App {
  // Sequences
  val xs = Array(1, 2, 3, 44)
  println(xs map (x => x*2) mkString(" "))

  // Sequence: exists, map, zip/unzip, forall, flatMap, sum, product, max, min
  val s = "Hello World"
  println(s map (x => x.isUpper))

  val pairs = List(1,2,3) zip s
  println(pairs.mkString(" "))

  val dots = s flatMap(c => List('.', c))
  println(dots)

  println(((1 to 5) flatMap(x => (1 to 10) map (y => (x, y)))) )


  val sequences = new Sequences
  val n = 17
  println(sequences.isPrime(n))

  println(sequences.buildSpecialPairs(7))
  println(sequences.buildSpecialPairs_ForExpression(7))

  // Sets
  val sets = new Sets
  print((sets.nQueens(4) map sets.show) mkString)

  //Maps
  val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10) // Map[String, Int]
  val capitalOfCountry = Map("US" -> "Washington", "HU" -> "Budapest")

  println(capitalOfCountry("US"))
  println(capitalOfCountry get "US")
  println(capitalOfCountry get "andorra") // vs. println(capitalOfCountry("andorra")) will throw an error

  val maps = new Maps
  println(maps.showCapital("HU"))
  println(maps.showCapital("DE"))

  // Sorting and groupby
  val fruits = List("Apple", "pear", "orange", "pineapple")
  println((fruits sorted).mkString(" "))
  println((fruits sortWith(_.length < _.length)).mkString(" "))

  println((fruits groupBy(_.head)).mkString(" "))

  val p1 = new Polynom(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p2 = new Polynom(Map(0 -> 3.0, 3 -> 7.0))

  println((p1 + p2).toString)

  // With default values
  println((p1.polynomials(7)).toString)

  // Constructor with sequence of pairs
  val p3 = new Polynom(0 -> 3.1, 2 -> 2.9, 3 -> 7.0)
  println(p3.toString)


  // Translator
  val trans = new Translator
  println("asd1234ertz" take 5)
  println(trans.encode("7225247386"))
  println(trans.translate("7225247386"))
}
