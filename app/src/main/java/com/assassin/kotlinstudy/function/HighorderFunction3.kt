package com.assassin.kotlinstudy.function

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-03 17:02
 * Version: 1.0
 * Description:  柯里化函数其实是高阶函数的一种，它的定义是：**返回值是一个函数的函数
 */

//注意观察这个函数，返回值是一个函数(Int)->Int{},花括号里面的是返回的函数体return {y -> x+y }，返回的一个函数
fun sum(x:Int):(Int)->Int{
   return {y ->
    x+y
   }
}

fun main() {
    //test是一个函数
    val test = sum(5)
    //柯里化函数会起到延迟作用的效果，第一次调用返回一个函数，第二次调用才会得到一个值，即在真正被消费的时候，才会生成值。
    //柯里化函数非常适合框架的开发者使用，我们可以通过柯里化函数实现一些阅读简单并且非常有效的API。
    println(test(10))//15
    println(test(20))//25
    println(test(30))//35
}