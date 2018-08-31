name := "sparkStudy"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark".%%("spark-core") % "2.1.0",
  "org.apache.spark".%%("spark-sql") % "2.1.0",
  "org.apache.spark".%%("spark-mllib") % "2.1.0",
  "org.apache.spark".%%("spark-streaming") % "2.1.0",
  "org.apache.spark".%%("spark-streaming-kafka") % "1.6.2",
  "org.apache.spark".%%("spark-streaming-flume") % "1.6.2",
  "mysql" % "mysql-connector-java" % "5.1.38",
  "com.github.scopt" %% "scopt" % "3.3.0",
  "org.apache.kafka" %% "kafka" % "1.0.0"
)