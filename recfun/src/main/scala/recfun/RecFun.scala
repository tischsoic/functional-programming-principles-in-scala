package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = (c, r) match {
    case _ if (c == 0 || r == c) => 1
    case _ => pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceRec(chs: List[Char], lCount: Int, rCount: Int): Boolean = chs match {
      case Nil => lCount == rCount
      case ch::tail =>
        val lIncrease = if (ch == '(') 1 else 0
        val rIncrease = if (ch == ')') 1 else 0

        if (lCount < rCount) false
        else balanceRec(tail, lCount + lIncrease, rCount + rIncrease)
    }

    balanceRec(chars, 0, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    // Can be way simpler -> use if else
    coins.fold(0)((acc, coin) => acc + (money - coin match {
      case _ if (money - coin < 0) => 0
      case 0 => 1
      case _ => countChange(money - coin, coins.filter(n => n >= coin))
    }))
  }
}
