package curriculum.server
import cats.effect._
import com.comcast.ip4s._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import org.http4s.ember.server._
import org.http4s.implicits._

val helloWorldService = HttpRoutes
  .of[IO] {
    case req @ POST -> Root / "cv" =>
      for {
        json <- req.as[String]
        _ = println("got json")
        cvInfo = generated_types.decodeRoot(json).map(curriculum.renderCvInfo)
        _ = println("got cvInfo")
        resp <- cvInfo match
          case Left(e)       => BadRequest(e.toString())
          case Right(cvInfo) => Ok(cvInfo)
      } yield (resp)
    case req @ POST -> Root / "cv" / "markdown" =>
      for {
        json <- req.as[String]
        _ = println("got json")
        cvInfo = generated_types
          .decodeRoot(json)
          .map(curriculum.renderMarkdown)
        _ = println("got cvInfo")
        resp <- cvInfo match
          case Left(e)       => BadRequest(e.toString())
          case Right(cvInfo) => Ok(cvInfo)
      } yield (resp)
  }
  .orNotFound

def run(args: List[String]): IO[ExitCode] =
  EmberServerBuilder
    .default[IO]
    .withHost(ipv4"0.0.0.0")
    .withPort(port"8080")
    .withHttpApp(helloWorldService)
    .build
    .use(_ => IO.never)
    .as(ExitCode.Success)
