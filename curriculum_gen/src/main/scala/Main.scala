package curriculum;

import better.files._
import cats.effect.unsafe.IORuntime
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

import scala.io.Source

import File._
import concurrent.ExecutionContext.Implicits.global
import util.chaining.scalaUtilChainingOps
implicit val runtime: IORuntime = cats.effect.unsafe.IORuntime.global

val staticPath = File(
  sys.env.get("STATIC_FILES_PATH") getOrElse ("./src/main/static/")
)

val cssFile = staticPath / "base.css"
val cvDataPath = staticPath / "me.json"

def onChangeAsset(file: File) =
  println(s"${file.name} was modified. Generating CV...")
  val json =
    Source.fromFile(cvDataPath.toString()).getLines.toList.reduce(_ + _)

  val maybeCvInfo = decode[generated_types.RootInterface](json)
  maybeCvInfo.map(renderCvInfoToFile)

def startFileWatcher() =
  val watcher = new FileMonitor((staticPath), recursive = true) {
    override def onCreate(file: File, count: Int) = println(
      s"$file got created"
    )
    override def onModify(file: File, count: Int) = onChangeAsset(file)
    override def onDelete(file: File, count: Int) = println(
      s"$file got deleted"
    )
  }
  watcher.start()
  // sleep forever
  Thread.sleep(10000000)

@main def hello(command: String) =
  if command == "server" then server.run(List()).unsafeRunSync()
  else startFileWatcher()
