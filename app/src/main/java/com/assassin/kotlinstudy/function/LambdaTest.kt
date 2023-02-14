package com.assassin.kotlinstudy.function

import com.assassin.kotlinstudy.delegate.Dog
import com.assassin.kotlinstudy.delegate.Teddy

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-10-30 16:38
 * Version: 1.0
 * Description: 如何理解高阶函数的使用
 */

/**
 * 如何理解？？
 *  这个函数实现了，参数函数执行，参数函数向里面传值为5，6，
 *  至于进一步怎么去计算，暂时还不知道，需要具体的函数来执行，才知道
 *  下面main函数中的lambda的函数就是具体执行的方法
 *  看到么，真正的参数函数执行的逻辑是lambda中相加的逻辑，这样理解才算正确路径吧。
 */
fun lambda1(call: (Int, Int) -> Int): Int {

    return call(5, 6)
}


fun testTwoASM(run1: Runnable, run2: Runnable) {
    run1.run()
    run2.run()
}


fun main(): Unit {
    lambda1 { x, y -> x + y }
    var name: String? = "小明"
    println(name?.length)
    name = null
    println("我是分割线")
    println(name?.length)

    val run1: Runnable = Runnable { println("哎吆，我操！") }
    testTwoASM(run1) {
        println("哎吆，我操！我在第二个线程中执行！")
    }

    val dog: Dog = Dog();
    val teddy: Teddy = Teddy(dog)
    // teddy 的run方法并没有实现，而是委托给Dog了，美滋滋
    teddy.run()

}
