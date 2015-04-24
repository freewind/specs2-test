package my

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class VerifyIntTypesSpec extends Specification with Mockito {
  isolated

  class Sender {
    def send(objects: Any): Unit = ()
  }

  class User(sender: Sender) {
    def hello(): Unit = {
      sender.send("hello")
      sender.send(1)
      sender.send(2)
    }
  }

  "user" should {
    "send 3 objects, but two ints only" in {
      val sender = mock[Sender]
      val user = new User(sender)
      user.hello()
      there was two(sender).send(haveClass[Integer]) // !!! failed
      there was one(sender).send(1)
      there was one(sender).send(2)
    }
  }

}
