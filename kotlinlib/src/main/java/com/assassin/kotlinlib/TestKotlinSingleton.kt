package com.assassin.kotlinlib

import com.assassin.kotlinlib.other.NullTest
import com.assassin.kotlinlib.tool.ConcurrentTest
import com.assassin.kotlinlib.tool.ConcurrentTest.TYPE_DOUBLE_CHECK
import com.assassin.kotlinlib.tool.ConcurrentTest.TYPE_ENUM
import com.assassin.kotlinlib.tool.ConcurrentTest.TYPE_HUNGRY
import com.assassin.kotlinlib.tool.ConcurrentTest.TYPE_LAZY_1
import com.assassin.kotlinlib.tool.ConcurrentTest.TYPE_LAZY_2

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/13 14:24
 * Version:     1.0
 * Description: 简述一下这个类要做的事情
 */

fun main() {
    println("我是kotlin")
    
   // ConcurrentTest.init(TYPE_HUNGRY)
   // ConcurrentTest.init(TYPE_LAZY_1)
   // ConcurrentTest.init(TYPE_LAZY_2)
   // ConcurrentTest.init(TYPE_ENUM)

    var test: NullTest?
    test = NullTest()
    test.name ="woshinibaba"

    println(test.name)
}