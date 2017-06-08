package w6

/**
  * Created by Julia Julia on 2016.11.18..
  */
class Maps {
  // Both iterables and functions
  // Class Map[Key, Value] also extends the function type Key => Value, so maps can be used everywhere functions can
  // Maps can be applied as argumaents: capitalOfCountry("US") -> Washington

  // Option type:
  // None
  // Some(x)
  val capitalOfCountry = Map("US" -> "Washington", "HU" -> "Budapest")

  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case None => "missing data"
    case Some(capital) => capital
  }

}

class Polynom(polynomials0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)

  // Maps with default value
  val polynomials = polynomials0 withDefaultValue(0.0)

  override def toString: String = {
    val polyStrings =
    for {
      poly <- polynomials.toList.sorted.reverse
    } yield poly._2 + " * x^" + poly._1

    polyStrings.mkString(" + ")
  }

  //def + (other: Polynom): Polynom = new Polynom(this.polynomials ++ (other.polynomials map adjust))
  def + (other: Polynom): Polynom = new Polynom((other.polynomials foldLeft this.polynomials) (addTerm))

  def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (exp, coef) = term
    terms + (exp -> (coef + terms(exp)))
  }

  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coef) = term
    exp -> (coef + this.polynomials(exp))
  }
}
