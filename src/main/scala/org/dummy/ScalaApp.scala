package org.dummy

import org.apache.spark._
import org.apache.spark.streaming._

object ScalaApp extends App {
  val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
  val ssc = new StreamingContext(conf, Seconds(10))


  //ATENCION: Antes de arrancar ejecutar el comando  it

  val lines = ssc.socketTextStream("localhost", 9999)

  lines.foreachRDD(x=>x.foreach(y=>println(y)))

  ssc.start()
  ssc.awaitTermination()

}

