object Bearing {
  sealed trait Direction
  case object East extends Direction
  case object West extends Direction
  case object North extends Direction
  case object South extends Direction
}


case class Robot(val bearing: Bearing.Direction, val coordinates: (Int, Int)) {
  def turnLeft: Robot = 
    bearing match {
      case Bearing.East =>
        Robot(Bearing.North, coordinates)
      case Bearing.West =>
        Robot(Bearing.South, coordinates)
      case Bearing.North =>
        Robot(Bearing.West, coordinates)
      case Bearing.South =>
        Robot(Bearing.East, coordinates)
    }

  def turnRight: Robot = 
    bearing match {
    case Bearing.East =>
      Robot(Bearing.South, coordinates)
    case Bearing.West =>
      Robot(Bearing.North, coordinates)
    case Bearing.North =>
      Robot(Bearing.East, coordinates)
    case Bearing.South =>
      Robot(Bearing.West, coordinates)
  }


  def advance: Robot = 
    bearing match {
    case Bearing.East =>
      Robot(bearing, (coordinates._1 + 1, coordinates._2))
    case Bearing.West =>
      Robot(bearing, (coordinates._1 - 1, coordinates._2))
    case Bearing.North =>
      Robot(bearing, (coordinates._1, coordinates._2 + 1))
    case Bearing.South =>
      Robot(bearing, (coordinates._1, coordinates._2 - 1))
  }

  def simulate(command: String): Robot = {
    command.foldLeft(this)((robot, curCommand) => {
      curCommand match {
        case 'L' => robot.turnLeft
        case 'R' => robot.turnRight
        case 'A' => robot.advance
      }
    })
  }
}

