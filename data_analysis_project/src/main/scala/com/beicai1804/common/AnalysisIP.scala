package com.beicai1804.common

import com.beicai1804.bean.caseclass.{IPRule, RegionInfo}
import com.beicai1804.util.Utils
import scala.util.control.Breaks._
/**
  * Created by IDEA on 2019/4/25.
  */
object AnalysisIP {

  /**
    * 通过ip，获取ip对应的地域信息，将地域信息封装到RegionInfo对象中
    *
    * @param ip
    * @param ipRuleArray
    */

  def getRegionInfoByIP(ip: String, ipRuleArray: Array[IPRule]) = {
    val regionInfo = RegionInfo()
    //1,将ip转换成数字
    val numIP = Utils.ipToLong(ip)
    //2，通过二分查找法，查找ip对应的地域信息
    var index = binarySearch(numIP, ipRuleArray)
    //3，将地域信息封装到RegionInfo对象中
    if (index != -1) {
      var ipRule = ipRuleArray(index)
      regionInfo.country = ipRule.country
      regionInfo.province = ipRule.province
      regionInfo.city = ipRule.city
    }
    regionInfo
  }


  /**
    * 二分查找法，找到了返回对应的角标，找不到返回-1
    *
    * @param numIP
    * @param ipRuleArray
    */

  def binarySearch(numIP: Long, ipRuleArray: Array[IPRule]) = {
    var index = -1
    var min = 0
    var max = ipRuleArray.length - 1
    breakable({
      while (min <= max) {
        val middle = (min + max) / 2
        val ipRule = ipRuleArray(middle)
        if (numIP >= ipRule.startIP && numIP <= ipRule.endIP) {
          index = middle
          break()
        } else if (numIP > ipRule.endIP) {
          min = middle + 1
        } else if (numIP < ipRule.startIP) {
          max = middle - 1
        }
      }
    })
    index
  }

}
