package com.assassin.kotlinstudy.function

import android.view.View

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/7/27 10:02
 * Version: 1.0
 * Description: 测试函数变量，匿名函数，lambda
 */
fun testFuck(age: Int, score: Float): String {

    return "$age+$score"
}


class FunctionTest3 {
    val ss = ::testFuck


}

fun a(func: (Int) -> String): Unit {

}

fun main() {
    (::testFuck)(3, 2.0F)
    (::testFuck).invoke(3, 2.0f)


    a(fun(param: Int): String {
        return param.toString()
    });
    val d = fun(param: Int): String {
        return param.toString()
    }
    
    
    assassinCreed(3,5){

    }


}

fun assassinCreed(a:Int,b:Int,funct: (Int) -> Unit): Unit {
    funct.invoke(a)
    
}