package my

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class VerifyWithContainSpec extends Specification with Mockito {
  isolated

  trait Connection {
    def sendObject(obj: AnyRef): Unit
    def sendString(str: String): Unit
  }

  class Client(connection: Connection) {
    def helloStr(s: String) = connection.sendString(s)
    def helloObject(obj: AnyRef) = connection.sendObject(obj)
  }


  val connection = mock[Connection]
  val client = new Client(connection)

  "contain() in sendString()" should {
    "when client send a string 'abc', the connection" should {
      "send the string 'abc'" in {
        client.helloStr("abc")
        there was one(connection).sendString("abc")
      }
      "send a string contain(b)" in {
        client.helloStr("abc")
        there was one(connection).sendString(contain("b"))
      }
      "not send a string contain(x)" in {
        client.helloStr("abc")
        there was no(connection).sendString(contain("x"))
      }
    }
  }

  "contain() in sendObject()" should {
    "when client send a string 'abc', the connection" should {
      "send the string 'abc'" in {
        client.helloObject("abc")
        there was one(connection).sendObject("abc")
      }

      // !!!
      // this test is is not passed within IDEA
      // but successful in SBT command line
      "send a string contain(b)" in {
        client.helloObject("abc")
        there was one(connection).sendObject(contain("b"))
      }
      "not send a string contain(x)" in {
        client.helloObject("abc")
        there was no(connection).sendObject(contain("x"))
      }
    }
  }

}
