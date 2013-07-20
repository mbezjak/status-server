package knock

import play.api.Play
import play.api.Play.current

import scala.collection.JavaConverters._

trait Urls {

  def getUrls: Seq[String] =
    Play.configuration.getStringList("urls").map(_.asScala).getOrElse(Nil)

}
