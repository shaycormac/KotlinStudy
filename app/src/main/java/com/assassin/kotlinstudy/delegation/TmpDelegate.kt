package com.assassin.kotlinstudy.delegation

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/14 0014 13:52
 * Version: 1.0
 * Description: 局部委托属性
 */
class TmpDelegate 
{
    fun print(): Unit {
        println("temp.Printer print")
    }
}

fun getPrinter(): TmpDelegate {
    println("tmp.Printe")
    return TmpDelegate()
}

//局部委托
//局部变量作为委托。
fun exampleDelegate(getPrinter:() ->TmpDelegate):Unit
{
     val lPrinter by lazy(getPrinter)
    val valid = true
    if (valid)
    {
        lPrinter.print()
    }
    
}

fun main()
{
    exampleDelegate { 
        getPrinter()
    }
}
