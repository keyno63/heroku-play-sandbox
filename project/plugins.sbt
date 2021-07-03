logLevel := Level.Warn

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.8")

addSbtPlugin("com.heroku" % "sbt-heroku" % "2.1.4")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.5.2")
