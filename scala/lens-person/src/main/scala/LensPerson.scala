import java.time.LocalDate
import monocle.macros.syntax.lens._

object LensPerson {
  case class Person(_name: Name, _born: Born, _address: Address)

  case class Name(_foreNames: String, _surName: String)

  type EpochDay = Long

  case class Born(_bornAt: Address, _bornOn: EpochDay)

  case class Address(_street: String, _houseNumber: Int,
                     _place: String, _country: String)

  case class Gregorian(_year: Int, _month: Int, _dayOfMonth: Int)

  // Implement these.


  def bornStreet(b: Born): String = b._bornAt._street

  def setCurrentStreet(street: String)(p: Person): Person =
    p.lens(_._address._street).modify(_ => street)

  def setBirthMonth(month: Int)(p: Person): Person =
    p.lens(_._born._bornOn).modify(_ => LocalDate.of(
      LocalDate.ofEpochDay(p._born._bornOn).getYear,
      month,
      LocalDate.ofEpochDay(p._born._bornOn).getDayOfMonth
    ).toEpochDay)

  // Transform both birth and current street names.

  def renameStreets(f: String => String)(p: Person): Person =
    p.lens(_._address._street).modify(f)
    .lens(_._born._bornAt._street).modify(f)
  
}

