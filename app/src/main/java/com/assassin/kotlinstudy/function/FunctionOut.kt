package com.assassin.kotlinstudy.function

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/09 18:03
 * Version:     1.0
 * Description: 作为一个外部函数
 */
class FunctionOut {

    fun testOne(age: Int, score: Float): String {

        println("执行testOne函数")
        return (age + score).toString()
    }
}