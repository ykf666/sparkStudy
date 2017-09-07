name := "sparkStudy"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.0" % "provided",
  "org.apache.spark" %% "spark-sql" % "2.1.0" % "provided",
  "mysql" % "mysql-connector-java" % "5.1.38" % "provided",
  "org.apache.hadoop" % "hadoop-aws" % "2.7.2" % "provided"
)