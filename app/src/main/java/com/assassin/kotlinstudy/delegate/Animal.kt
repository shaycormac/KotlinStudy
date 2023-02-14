package com.assassin.kotlinstudy.delegate

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-09-27 13:40
 * Version: 1.0
 * Description: 委托？
 */
interface Animal {
    fun run(): Unit

    fun eat(food: String): String

    fun drink(): Unit
}
