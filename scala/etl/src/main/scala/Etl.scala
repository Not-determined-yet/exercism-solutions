object Etl {
  def transform(oldData: Map[Int, Seq[String]]) = 
    for ((k, vs) <- oldData; v <- vs) yield (v.toLowerCase,k)
}
