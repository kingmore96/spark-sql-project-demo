package com.test.util

import java.util.{Date, Locale}

import org.apache.commons.lang3.time.FastDateFormat

/**
  * 日期解析工具类
  * 注意：SimpleDateFormat是线程不安全的，替换为FastFormat.getInstance()
  */
object DateUtil {
  val SOURCE_FORMAT = FastDateFormat.getInstance("dd/MMM/yyyy:HH:mm:ss Z",Locale.ENGLISH)
  val TARGET_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss")

  /**
    * 获取正确时间格式
    * @param time
    */
  def parse(time:String)= {
    TARGET_FORMAT.format(new Date(doParse(time)))
  }

  /**
    * 把源时间字符串转化为Long类型的timestamp
    * @param time
    * @return
    */
  def doParse(time:String) = {
    try{
      SOURCE_FORMAT.parse(preProcessTime(time)).getTime()
    }catch {
      case e:Exception =>{
        0l
      }
    }
  }
  /**
    * 预处理：原始格式两头带[]，去掉中括号
    * @param time
    */
  def preProcessTime(time:String): String ={
    time.substring(time.indexOf("[")+1,time.lastIndexOf("]"))
  }

  def main(args: Array[String]): Unit = {
    println(DateUtil.parse("[11/Nov/2016:01:00:12 +0800]"))
  }
}
