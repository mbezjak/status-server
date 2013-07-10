package controllers

import play.api._
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future

import knock.HttpKnock

object Application extends Controller {

  def index = Action {
    val urls    = Seq("http://google.com", "http://wikipedia.com")
    val knock   = new HttpKnock
    val futures = urls map { url => knock available url }
    val future  = Future.sequence(futures)

    Async {
      future map (views.html.index(urls)) map (Ok(_))
    }
  }

}
