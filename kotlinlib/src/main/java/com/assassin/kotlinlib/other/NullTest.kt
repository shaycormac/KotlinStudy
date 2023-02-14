package com.assassin.kotlinlib.other

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/06/07 10:31
 * Version:     1.0
 * Description: 简述一下这个类要做的事情
 */
class NullTest {
    var name: String? = null

    // 默认加锁的
    val lazy: String by lazy {
        "我是延迟加载"
    }


    // 显示使用 线程不安全的
    val lazyTest: String by lazy(LazyThreadSafetyMode.NONE) {
        "我操"
    }
}