package models

import doobie.ConnectionIO
import doobie.implicits.toSqlInterpolator

object Person {
 def findByName(name: String): ConnectionIO[Option[Person]] = {
   sql"select * from person where full_name=$name".query[Person].option
 }
}

case class Person(fullName: String, homeAddress: String, yearOfBirth: Int)