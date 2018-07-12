import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yankefei on 2017/9/5.
  */
object SimpleDataOperations {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SimpleDataOperations").getOrCreate()
    val url = "jdbc:mysql://localhost:3306/test"
    val df = spark
      .read
      .format("jdbc")
      .option("url", url)
      .option("dbtable", "t_spark")
      .option("user", "root")
      .option("password", "root123")
      .load()

    // Looks the schema of this DataFrame.
    df.printSchema()

    // Counts people by age
    val countsByAge = df.groupBy("age").count()
    countsByAge.show()

    // Saves countsByAge to S3 in the JSON format.
    countsByAge.write.format("json").save("s3a://test")
  }
}