package com.test.job

import org.apache.spark.sql.SparkSession

/**
  * 第一步清洗：抽取出我们所需要的列的数据，并用制表符分隔
  * 2017-05-11 14:09:14  http://www.imooc.com/video/4500 304 218.75.35.226
  */
object SparkStatFormatJob {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SparkStatFormatJob")
      .master("local[2]").getOrCreate()

    val access = spark.sparkContext.textFile("file:///C:\\Users\\wgg9696\\Desktop\\access.log")

    access.map(line => {
      val splits = line.split(" ")
      splits(0)
    }).take(20).foreach(println)
    spark.stop()
  }
}
