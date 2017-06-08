package w6

/**
  * Created by Julia Julia on 2016.11.17..
  */
case class Person(name: String, age: Int) {
  def getNamesOlder(persons: List[Person], minAge: Int): List[String] = {
    // For expression: it produces a new result(list) and not manipulates an existing one
    // for( s ) yield e, where s is a sequence of generators and filters and e is an expression
    for(p <- persons if p.age > 20) yield p.name
    // persons filter (p => p.age > 20) map (p => p.name)
  }
}
