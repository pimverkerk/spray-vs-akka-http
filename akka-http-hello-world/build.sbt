name := "akka-http-hello-world"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val akkaV = "2.3.12"
  val akkaHttpV = "1.0"
  val akkaStreamsV = "1.0"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-contrib" % akkaV,
    "com.typesafe.akka" %% "akka-stream-experimental" % akkaStreamsV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaHttpV
  )
}
