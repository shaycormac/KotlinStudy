package com.assassin.kotlinstudy.function

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-10-30 15:22
 * Version: 1.0
 * Description: 函数练习使用
 */

/**
 *  注意这个this 指的就是Int。
 */
fun Int.sample(a: Float, b: Float): Long {
    
    return  this*(a+b).toLong()
}


fun main(): Unit {
    println(5.sample(3f,4f))
    
    //作为成员变量
    //之所以能像后面那样写，是因为符合lmbda的写法，参数，返回值，接收者都是一样的。
    val function: Int.(Float,Float)->Long = Int::sample
    //注意了
    println(function.invoke(5,3f,4f))

    println(sample2(function))
    
    //成员引用
    //能够理解这个过程么
    //functon1是顶层函数，她的参数是一个函数，
    //所以，可以把functionParam放进来，而执行，由于实际执行的这个参数函数的实际赋值是5，从而打印出来5，
    // 这个函数和functionParam参数返回值接收者一模一样，符合引用函数规则
    //最终相当于println(5)
    function1(::functionParam)
}

/**
 * good
 * @param a [@kotlin.ExtensionFunctionType] Function3<Int, Float, Float, Long>
 * @return Long
 */
fun sample2(a:Int.(Float,Float)->Long):Long = 3.a(1f,2f)

//简单成员引用 first-order function
fun functionParam(a: Int)=println(a)
// 高阶函数  high-order function
fun function1(a: (Int) -> Unit)=a(5)
