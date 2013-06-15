package controllers

import play.api._
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits._

import knock.HttpKnock

object Application extends Controller {

  def index = Action {
    val url    = "http://google.com"
    val knock  = new HttpKnock
    val future = knock available url

    Async {
      future map (views.html.index(url)) map (Ok(_))
    }
  }

}
