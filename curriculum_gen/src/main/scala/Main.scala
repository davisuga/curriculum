package curriculum;
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import scala.io.Source
import better.files._
import File._
import concurrent.ExecutionContext.Implicits.global

@main def hello: Unit =
  val staticPath = File("./src/main/static/")
  val fileName = staticPath / "me.json"
  val json = Source.fromFile(fileName.toString()).getLines.toList.reduce(_ + _)
  val decodedFoo = decode[generated_types.RootInterface](json)

  val watcher = new FileMonitor((staticPath), recursive = true) {
    override def onCreate(file: File, count: Int) = println(
      s"$file got created"
    )
    override def onModify(file: File, count: Int) = println(
      s"$file got modified $count times"
    )
    override def onDelete(file: File, count: Int) = println(
      s"$file got deleted"
    )
  }
  watcher.start()

  println(decodedFoo)
  Thread.sleep(60 * 1000)

// def msg = "I was compiled by Scala 3. :)"
