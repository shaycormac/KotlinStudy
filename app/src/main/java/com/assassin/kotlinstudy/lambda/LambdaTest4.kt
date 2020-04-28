package com.assassin.kotlinstudy.lambda

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-02 16:49
 * Version: 1.0
 * Description: lambda测试
 */

//fun lambdaHaHa(call:(Int,Int)->Int):Int=call(5,6)
fun lambdaHaHa(call:(Int,Int)->Int):Int{
    return  call(5,6)
}


fun main() {
   val htes =  lambdaHaHa { i, i2 -> 
        i+i2
    }
    println(htes)
}