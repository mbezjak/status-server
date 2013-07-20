package controllers

import play.api._
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future

import knock.{HttpKnock, Urls}

object Application extends Controller with Urls {

  def index = Action {
    val urls    = getUrls
    val knock   = new HttpKnock
    val futures = urls map { url => knock available url }
    val future  = Future.sequence(futures)

    Async {
      future map (views.html.index(urls)) map (Ok(_))
    }
  }

}
