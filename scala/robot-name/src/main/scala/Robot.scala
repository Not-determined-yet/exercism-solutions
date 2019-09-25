object Robot {

  private val Digit = ('0' to '9').toArray
  private val Letter = ('A' to 'Z').toArray
  private val Pattern = Array(Letter, Letter, Digit, Digit, Digit)
  
  private val NameSize = Pattern.map(_.length).product

  private var curIndex = -1

  private val R = new scala.util.Random(new java.util.Date().getTime)
  private val Names: Array[String] = distinctRandomN(NameSize).map(numberToName)

  def distinctRandomN(n:Int): Array[Int] = {
    val res = (0 until n).toArray
    (n - 1 to 1 by -1).foreach(index => {
      val rIndex = R.nextInt(index)
      // swap
      val temp = res(index)
      res(index) = res(rIndex)
      res(rIndex) = temp
    })
    res
  }

  def numberToName(i: Int): String = {
    var number = i % NameSize
    var res = ""
    Pattern.indices.foreach(i => {
      Pattern(Pattern.length - i - 1) match {
        case Digit =>
          res = (number % Digit.length).toString + res
          number /= Digit.length
        case Letter =>
          res = (number % Letter.length + 'A').toChar.toString + res
          number /= Letter.length
      }
    })
    res
  }

  def newName: String = {
    if (curIndex + 1 < NameSize){
      curIndex += 1
      Names(curIndex)
    }
    else {
      "no name to use"
    }
  }

}

class Robot {
  private var realname = ""
  def name: String = {
    if (realname == "")
      realname = Robot.newName
    realname
  }

  def reset(): Unit = {
    realname = ""
  }
}
