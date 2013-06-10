package knock

import play.api.libs.ws.{WS, Response}
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future
import java.net.ConnectException

class HttpKnock {

  def available(url: String): Future[Boolean] =
    request(url).map(_ => true).recover { case _: ConnectException => false }

  def request(url: String): Future[Response] = WS.url(url).head()

}
