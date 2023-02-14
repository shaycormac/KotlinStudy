package com.assassin.kotlinlib.singleton

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/13 14:41
 * Version:     1.0
 * Description: 双重锁校验，
 * Lazy是接受一个 lambda 并返回一个 Lazy 实例的函数，返回的实例可以作为实现延迟属性的委托： 
 * 第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
 */
class KotlinDoubleCheckSingleton {
    
    companion object{
        val instance :KotlinDoubleCheckSingleton by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { 
            KotlinDoubleCheckSingleton()
        }
    }
}