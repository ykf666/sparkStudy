import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yankefei on 2017/6/27.
  */
object WordCount {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCount")
    val sc = new SparkContext(conf)

    val input = sc.textFile("/data/sparkStudy/helloSpark")
    val lines = input.flatMap(line => line.split(" "))
    val count = lines.map(word => (word, 1)).reduceByKey((a, b) => a + b)

    count.saveAsTextFile("/data/sparkStudy/sparkRes")
  }
}