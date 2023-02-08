import models.Person

object Play extends App {

  import doobie._
  import doobie.implicits._
  import cats.effect.IO

  import cats.effect.unsafe.implicits.global

  val xa = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", "jdbc:postgresql://localhost:5444/postgres", "postgres", "secret123"
  )

  val x = Person.findByName("Mark").transact(xa).unsafeRunSync()
  println(x)
}
