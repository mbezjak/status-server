package knock

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class HttpKnockSpec extends Specification {

  "availability check" should {
    "return true for www.google.com" in {
      val knock = new HttpKnock
      await(knock.available("http://www.google.com")) must_== true
    }

    "return false when server is unavailable" in {
      val knock = new HttpKnock
      await(knock.available("http://localhost:49542")) must_== false
    }
  }
}
