package com.assassin.kotlinstudy.function

import org.json.JSONObject

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-10-30 13:59
 * Version: 1.0
 * Description: 标准函数的学习
 */

/**
 * 这个顶层函数的意义在于标准函数相对于传统Java的优势，不需要if-else的非空判断，使用这种表达式即可，如果为null的
 * 话，最后走fail函数。
 */
private fun dealCityInfomation(data: JSONObject?, fail: () -> Unit): Unit {
    //takeIf 函数，如果闭包返回的是true就返回这个值，如果返回false就返回null
    //第一步校验是否含有city_info这个字段，如果没有直接结束了，有的话，继续往下走
    
    data?.takeIf { 
        it.has("city_info")
    }
            //这一步是判断city_info中是否含有下面两个字断。
            ?.takeIf { 
        with(it.getJSONObject("city_info"))
        {
            return@takeIf  has("title")&&has("data")
        }
    }?.let { 
        it.getJSONObject("city_info")
    }.apply { 
        //todo 要做的事情。
    }?:fail()
}