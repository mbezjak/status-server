package knock

import com.ning.http.client.Realm.AuthScheme
import java.net.ConnectException
import java.util.concurrent.TimeoutException

import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.ws.{Response, WS}
import scala.concurrent.Future

class HttpKnock {

  def available(url: String): Future[Boolean] =
    request(url).map(_ => true).recover {
      case _: ConnectException => false
      case _: TimeoutException => false
    }

  def request(url: String): Future[Response] =
    WS.url(url).
      withAuth("none", "none", AuthScheme.NONE).
      withTimeout(1000).
      head()

}
