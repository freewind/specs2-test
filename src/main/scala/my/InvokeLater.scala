package my

class InvokeLater {
  def apply(f: => Any): Unit = {
    // do something ...
    f
    // do some other thing
  }
}
