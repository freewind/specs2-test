name := "hello"

version := "1.0"

organization := "org.my"

scalaVersion := "2.11.6"

sbtVersion := "0.13.8"

resolvers ++= Seq(
  "ibiblio" at "http://mirrors.ibiblio.org/pub/mirrors/maven2",
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-mock" % "3.3.1" % "test",
  "org.specs2" %% "specs2" % "3.3.1" % "test"
)
