package com.beicai1804.task.etl

import com.beicai1804.task.BaseTask

/**
  * Created by IDEA on 2019/4/25.
  */
object AnalysisLogTask extends BaseTask {

  def main(args: Array[String]): Unit = {
    //todo 1,验证参数是否正确

    //todo 2,验证当天是否存在用户行为日志

    //todo 3,使用spark加载ip规则

    //todo 4,使用spark加载用户行为日志，进行解析

    //todo 5,将解析好的日志，保存到hbase上
  }
}
