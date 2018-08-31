package spark

import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.sql.{SparkSession}

object MachineLearningExample {

  val data = Seq(
    (Vectors.dense(0.0, 0.0, 18.0, 1.0), 1.0),
    (Vectors.dense(0.0, 1.0, 12.0, 0.0), 0.0),
    (Vectors.dense(1.0, 0.0, 15.0, 0.1), 0.0)
  )

  def main(args: Array[String]): Unit = {

    val sqlContext = SparkSession.builder().master("local").appName("SimpleDataOperations").getOrCreate().sqlContext

    // Every record of this DataFrame contains the label and
    // features represented by a vector.
    val df = sqlContext.createDataFrame(data).toDF("label", "features")

    // Set parameters for the algorithm.
    // Here, we limit the number of iterations to 10.
    val lr = new LogisticRegression().setMaxIter(10)

    // Fit the model to the data.
    val model = lr.fit(df)

    // Inspect the model: get the feature weights.
    //    val weights = model.weights
    //    val weights = model.getWeightCol

    // Given a dataset, predict each point's label, and show the results.
    model.transform(df).show()
  }
}
