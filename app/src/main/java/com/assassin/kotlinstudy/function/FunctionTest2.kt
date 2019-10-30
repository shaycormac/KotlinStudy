package com.assassin.kotlinstudy.function

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-10-30 16:12
 * Version: 1.0
 * Description: 成员引用
 */

class Test{
    fun functionParma(a: Int)=println(a)
}

//带有接收者的参数函数
fun function1(a: Test.(Int)->Unit): Unit 
{
    Test().a(6)
    
}
//没有接收者的参数， 体会两者的使用方式不同
fun function2(a: (Int)->Unit): Unit 
{
    a(6)
}

fun main(): Unit {
    /**
     *  使用成员引用，类名引用成员函数（扩展函数）
     *  此时 Test::functionParma 的类型为 Test.(Int)->Unit
     */
    function1 (Test::functionParma)
    /**
     * 使用绑定引用， 直接使用对象去引用成员函数'
     * 此时  test::functionParma 的类型为  (Int)->Unit
     */
    val test = Test()
    function2 (test::functionParma)
}