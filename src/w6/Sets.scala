package w6

/**
  * Created by Julia Julia on 2016.11.17..
  */
class  Sets {
  // Unordered, no duplicate elements, the fundamental operation on them is contains

  // n queens problem:
  // place n queens on a chessboard(nxn), so that they are not threatened by each other
  def nQueens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if(k == 0)
        Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
    }
    placeQueens(n)
  }
  // List contains the columns in which the queens are, in order of rows:
  // List(3, 1) ->  - * - -     -> List((1, 3), (0, 1))
  //                - - - *
  //                - - - -
  //                - - - -
  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    if(row == 0) {
      true
    }
    else {
      val queensWithRow = (row - 1 to 0 by -1) zip queens // tuples, where the queens are
      val newQueen = (row, col)
      queensWithRow forall (t => t._2 != newQueen._2 && Math.abs(t._1 - newQueen._1) != Math.abs(t._2 - newQueen._2))
    }
  }

  def show(queens: List[Int]): String = {
    val lines =
    for {
      q <- queens.reverse
    } yield Vector.fill(queens.length)("-").updated(q, "X").mkString(" ")

     "\n" + lines.mkString("\n") + "\n"
  }
}
