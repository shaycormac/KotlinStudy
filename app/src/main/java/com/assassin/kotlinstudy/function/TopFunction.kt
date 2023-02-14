package com.assassin.kotlinstudy.function

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/09 16:54
 * Version:     1.0
 * Description: 测试一下顶层函数
 *
 */

val name :String by lazy { 
    "wocao"
}

var age:Int? = null

fun getMyWrapperName(name: String, id: Int): String {

    val wrapperName: String = "${id}${name}"

    return wrapperName;
}


fun getMyFuckName(name: String?, age: Int?): String? {

    val wrapperName: String? = "${age}${name}"
    return wrapperName;
}