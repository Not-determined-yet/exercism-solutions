object SecretHandshake {
  
  private val secrets = 
    List(
      (1,"wink"),
      (2,"double blink"),
      (4,"close your eyes"),
      (8,"jump") 
    )
  
  def commands(n: Int): List[String] = {
    val res = secrets.filter{case(k, v) => (k & n) > 0}.map(_._2)
    if (n > 16) res.reverse else res
  }
}
