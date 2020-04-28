package com.assassin.kotlinstudy.lambda

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-11-29 13:58
 * Version: 1.0
 * Description: 类说明
 */
//别名  Summer是(Int,Int)->Int的替代名称
// val summer:Summer 是这个函数的变量名字
//{a,b-> a+b}是这个函数的具体执行逻辑
//summer.invoke(3,4) 真正的实参，执行这个代码
typealias Summer = (Int,Int)->Int

fun main() 
{
    val summer:Summer ={a,b->
        a+b
    }
    println(summer.invoke(3,4))
}