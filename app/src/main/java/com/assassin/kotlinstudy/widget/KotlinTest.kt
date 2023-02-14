package com.assassin.kotlinstudy.widget

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/15 0015 09:49
 * Version: 1.0
 * Description: 类说明
 */
fun main(args: Array<String>) {
    println()
   
}

/**
 * 测试Kotlin中的lambda
 */
fun testLambda() {
    val array: Array<String> = arrayOf("阿三", "棒子", "毛子")
    array.forEach {
        println(it)
    }
    array.forEach({ 
        element -> println(element)
    })
    for (element in array)
    {
        println(element)
    }
    array.forEach {
        element -> println(element)
    }
}
