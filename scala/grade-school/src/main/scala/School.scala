import scala.collection.mutable.ArrayBuffer

class School {
  private var data: Map[Int, ArrayBuffer[String]] = Map()

  def db: Map[Int, ArrayBuffer[String]] = data

  def this(d: Map[Int, ArrayBuffer[String]]) {
    this()
    this.data = d
  }

  def add(name: String, grade: Int): Unit =  {
    data.get(grade) match {
      case Some(names) => names += name
      case None => data += grade -> ArrayBuffer(name)
    }
  }

  def grade(grade: Int): ArrayBuffer[String] = data.get(grade) match {
    case Some(names) => names
    case None => ArrayBuffer()
  }

  def sorted: Map[Int, ArrayBuffer[String]] = {
    data.toSeq.map(x => (x._1, x._2.sorted)).sortBy(_._1)(Ordering.Int).toMap
  }

  def keys: Iterable[Int] = data.keys
}
