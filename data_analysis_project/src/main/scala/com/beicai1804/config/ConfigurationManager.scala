package com.beicai1804.config

import org.apache.hadoop.conf.Configuration

/**
  * Created by IDEA on 2019/4/26.
  */
object ConfigurationManager {

  private val configuration = new Configuration()
  //加载配置文件
  configuration.addResource("project-config.xml")
  configuration.addResource("mysql-site.xml")

  def getValue(key: String) = {
    configuration.get(key)
  }

}
