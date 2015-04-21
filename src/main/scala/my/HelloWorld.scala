package my

class HelloWorld(invokeLater: InvokeLater, printString: PrintString) {

  def apply(s: String): Unit = invokeLater {
    printString(s)
  }

}
