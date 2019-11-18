package com.assassin.kotlinstudy.lambda

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-11-04 09:49
 * Version: 1.0
 * Description: Lambda 反编译成字节码的过程
 */


typealias Sum = (Int, Int, Int) -> Int

fun main(args: Array<String>) {
    val sum: Sum = { a, b, c ->//定义一个很简单的三个数求和的lambda表达式
        a + b + c
    }

    println(sum.invoke(1, 2, 3))
}

data class Person(val name:String,val age:Int)

