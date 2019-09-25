object Bob {

  def isShouting(str: String): Boolean = {
    str.filter(_.isLetter).length > 0 &&
    str.filter(_.isLetter).forall(_.isUpper)
  }

  def isQuestion(str: String): Boolean = 
    str.endsWith("?")

  def isBlank(str: String): Boolean = 
    str.length == 0 || str.distinct == " "
  

  def response(statement: String): String = statement.trim match {
    case str if isBlank(str) =>
      "Fine. Be that way!"

    case str if isQuestion(str) && isShouting(str) =>
      "Calm down, I know what I'm doing!"

    case str if isShouting(str) =>
      "Whoa, chill out!"

    case str if isQuestion(str) =>
      "Sure."

    case _ =>
      "Whatever."
  }

}
