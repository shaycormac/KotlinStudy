package com.assassin.kotlinstudy.decompile

import java.lang.StringBuilder
import java.util.function.Function

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/9/27 14:41
 * Version: 1.0
 * Description: 类说明
 */
val functionA: (String) -> Unit = { x ->
    println(x)
}
val functionB: (Set<String>) -> String = { set ->
    val sb: StringBuilder = StringBuilder()
    set.forEach {
        sb.append(it)
    }

    sb.toString()
}

fun main() {
    functionA.invoke("hahah")
    functionB.invoke(setOf("dd","de"))
}