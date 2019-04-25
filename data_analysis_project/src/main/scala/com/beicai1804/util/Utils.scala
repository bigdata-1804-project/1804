package com.beicai1804.util

/**
  * Created by IDEA on 2019/4/25.
  */
object Utils {

  /**
    * 将ip转换成完整的32位2机制对应的十进制数字
    */

  def ipToLong (ip:String) = {
    var numIP: Long = 0
    val items = ip.split("[.]")
    for (item <- items) {
      numIP = (numIP << 8 | item.toLong)
    }
    numIP
  }

}
