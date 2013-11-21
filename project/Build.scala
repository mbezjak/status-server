import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "status-server"
  val appVersion      = "0.1"

  val appDependencies = Seq()


  val main = play.Project(appName, appVersion, appDependencies).settings(
    javacOptions ++= Seq("-source", "1.6", "-target", "1.6")
  )

}
