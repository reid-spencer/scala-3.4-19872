import com.ossuminc.sbt.helpers.Publishing
import com.ossuminc.sbt.helpers.RootProjectInfo.Keys.{
  gitHubOrganization,
  gitHubRepository
}
import scala.collection.Seq

enablePlugins(OssumIncPlugin)

Global / onChangedBuildSource := ReloadOnSourceChanges
(Global / excludeLintKeys) ++= Set(mainClass)
Global / scalaVersion := "3.3.3"
scalacOptions := Seq(
  "-deprecation",
  "-feature",
  "-new-syntax",
  "-Werror",
  "-pagewidth:120",
  "-explain",
  // "-rewrite",
  //"-source:3.4-migration"
)

lazy val riddl: Project = Root("", "scala-3.4-19872", startYr = 2024)
  .configure(With.git, With.dynver)
  .settings(
    ThisBuild / gitHubRepository := "reid-spencer",
    ThisBuild / gitHubOrganization := "scala-3.4-19872",
    publish / skip := true,
    libraryDependencies ++= Seq("com.lihaoyi" %% "fastparse" % "3.0.2")
  )
