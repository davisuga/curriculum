package curriculum

import better.files.File

import util.chaining.scalaUtilChainingOps

def renderCvInfo = render_cv.renderFromCV(cssFile.lines().reduce(_ + _), _)

def renderCvInfoToFile(cvInfo: generated_types.RootInterface) =
  val content = renderCvInfo(cvInfo)

  (File("./output.html"))
    .overwrite(content)
    .pipe(trace("created file"))
