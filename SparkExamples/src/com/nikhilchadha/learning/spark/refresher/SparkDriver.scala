package com.nikhilchadha.learning.spark.refresher

import org.apache.spark.sql.SparkSession
import java.io.File

object SparkDriver {
  
  val PRINT_TO_CONSOLE = false
  val WRITE_RESULT_TO_SINGLE_FILE = true

  def main (args: Array[String]): Unit = {
    
    val inputPath = "D:/input_folder";

    val outputPath = "D:/output_folder";
    
    val dataFileName = "source_data.csv";
    
    val dataFilePath = inputPath + "\\" + dataFileName;
    
    val resultFileName = "result_data.csv"; 
    
    val resultFilePath = outputPath + "\\" + resultFileName;
    
    val inputFolder = new File(inputPath)
    
    if (inputFolder.exists()) {
      println("Input folder \"" + inputPath + "\" Does Not Exist!")
      System.exit(1)
    }
    
    val backupOutputDataFolderLocation = outputPath + "_bkp_" + java.time.Instant.now().toEpochMilli().toString()
    
    val outputFolder = new File(outputPath)
    
    if (outputFolder.exists()) {
      outputFolder.renameTo(new File(backupOutputDataFolderLocation))
    }
    
    outputFolder.mkdir()
    
    val sparkSession = SparkSession.builder().appName("ExampleSparkProgram").master("local").getOrCreate()
    
    val sourceDf = sparkSession.read.format("csv").option("header", "true").option("inderSchema", "true").load(dataFilePath)
    
    sourceDf.createOrReplaceTempView(dataFileName)
    
    val dataLoadQuery = "SELECT * FROM " + dataFileName + " LIMIT 5"
    
    val resultDf = sparkSession.sql(dataLoadQuery)
    
     if (WRITE_RESULT_TO_SINGLE_FILE) {
       resultDf.coalesce(1).write.option("header", "true").csv(resultFilePath)
     } else {
       resultDf.write.option("header", "true").csv(resultFilePath)
     }
    
  }

}