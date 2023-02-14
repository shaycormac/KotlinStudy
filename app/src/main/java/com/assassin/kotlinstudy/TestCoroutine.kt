package com.assassin.kotlinstudy

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/9/22 09:00
 * Version: 1.0
 * Description: 测试协程并发
 */
fun main() {
    val ioScope = CoroutineScope(Dispatchers.IO)

    ioScope.launch {
        delay(100)
        println("当前执行任务的线程是:${Thread.currentThread().name}")
    }
    // 阻止主线程结束
    Thread.sleep(1000)
}