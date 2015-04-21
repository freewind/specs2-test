package my

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class HelloWorldSpec extends Specification with Mockito {
  isolated

  "something" should {
    "do something" in {
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
