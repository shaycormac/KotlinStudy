package com.assassin.kotlinstudy.delegate

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-09-27 13:43
 * Version: 1.0
 * Description: 狗类实现抽象接口
 */
class Dog:Animal {
    override fun run() {
        println("狗类在跑步")
    }

    override fun eat(food: String): String {
        println("狗类吃了$food")
        return "狗类吃了$food"
    }

    override fun drink() {
        println("狗类喝水")
    }
}