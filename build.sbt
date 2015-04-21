name := "hello"

version := "1.0"

organization := "org.my"

scalaVersion := "2.11.0"

sbtVersion := "0.13.5"

resolvers ++= Seq(
  "ibiblio" at "http://mirrors.ibiblio.org/pub/mirrors/maven2",
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "3.5-20150421030134-582d033" % "test"
)
