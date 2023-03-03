package utils;

def trace[A](msg: String)(x: A): A = {
  println(x)
  println(msg)
  x
}
