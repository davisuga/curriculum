package syntax;
implicit class RichPipes[Y](y: Y) {
  def |>[Z](f: Y => Z) = f(y)
  def pipe[Z](f: Y => Z) = f(y)
  def &>[X, Z](f: (X, Y) => Z): (X => Z) = (x: X) => f(x, y)
}
implicit class Traceable[Y](y: Y) {

  def &>[X, Z](f: (X, Y) => Z): (X => Z) = (x: X) => f(x, y)
}
