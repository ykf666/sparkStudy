import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yankefei on 2017/7/13.
  */
object PiEstimation {
  def main(args: Array[String]): Unit = {
    val NUM_SAMPLES = args(0).toInt
    val conf = new SparkConf().setAppName("PiEstimation")
    val sc = new SparkContext(conf)
    val count = sc.parallelize(1 to NUM_SAMPLES).filter { _ =>
      val x = math.random
      val y = math.random
      x * x + y * y < 1
    }.count()
    println(s"Pi is roughly ${4.0 * count / NUM_SAMPLES}")
  }
}
