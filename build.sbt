name := "heroku-play-sandbox"
 
version := "1.0"

run / fork := true

Test / fork := true

lazy val `heroku_play_sandbox` = (project in file(".")).enablePlugins(PlayScala)

Compile / herokuAppName := "dry-garden-56631"

Compile / herokuJdkVersion := "14"

resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.13.5"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )
