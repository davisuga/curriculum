package curriculum;
import syntax._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import scala.io.Source
import better.files._
import File._
import concurrent.ExecutionContext.Implicits.global
import utils._

val staticPath = File("./src/main/static/")
val cssFile = staticPath / "base.css"
val cvDataPath = staticPath / "me.json"

def renderCvInfo(cvInfo: generated_types.RootInterface) =
  val rendered =
    render_cv.renderFromCV(cssFile.lines().reduce(_ + _), cvInfo)
  (File("./output.html"))
    .overwrite(rendered)
    .pipe(trace("created file"))

def onChangeAsset(file: File) =
  println(s"${file.name} was modified. Generating CV...")
  val json =
    Source.fromFile(cvDataPath.toString()).getLines.toList.reduce(_ + _)

  val maybeCvInfo = decode[generated_types.RootInterface](json)
  maybeCvInfo.map(renderCvInfo)

@main def hello: Unit =

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

  Thread.sleep(60 * 10000)

// def msg = "I was compiled by Scala 3. :)"
