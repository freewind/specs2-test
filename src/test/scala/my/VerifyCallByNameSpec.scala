package my

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class VerifyCallByNameSpec extends Specification with Mockito {
  isolated

  class InvokeLater {
    def apply(f: => Any): Unit = {
      // do something ...
      f
      // do some other thing
    }
  }

  class HelloWorld(invokeLater: InvokeLater, printString: PrintString) {

    def apply(s: String): Unit = invokeLater {
      printString(s)
    }

  }

  class PrintString {

    def apply(s: String): Unit = {
      println(s)
    }

  }

  "mock a method with call-by-name" should {
    "run the code inside the answer block correctly" in {
      val invokeLater = mock[InvokeLater]
      invokeLater.apply(any) answers { f =>
        println("######### run in invokeLater")
        f.asInstanceOf[Function0[Unit]](): Unit
      }

      val printString = mock[PrintString]

      val helloWorld = new HelloWorld(invokeLater, printString)
      helloWorld.apply("Hello world")

      there was one(printString).apply("Hello world")
    }
  }

}
