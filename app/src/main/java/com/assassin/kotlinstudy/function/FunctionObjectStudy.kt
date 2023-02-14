package com.assassin.kotlinstudy.function

import com.assassin.kotlinstudy.lambda.LambdaTest

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/09 18:05
 * Version:     1.0
 * Description: 函数对象的学习
 */


fun main() {

    // 拿到函数对象的类型
    val funcOut: (FunctionOut, Int, Float) -> String = FunctionOut::testOne
    // 由于它是函数对象，所以使用的时候，需要它的类对象
    val outClass = FunctionOut()
    // 调用
    funcOut.invoke(outClass, 5, 6.8F)
    funcOut(outClass, 7, 8F)

    // 调用顶层函数呢,由于是实际的静态方法，也没有类给它创建了

    val twoSam: (Runnable, Runnable) -> Unit = ::testTwoASM

    twoSam.invoke({ "NIMA" }, { "wocao" })

}
