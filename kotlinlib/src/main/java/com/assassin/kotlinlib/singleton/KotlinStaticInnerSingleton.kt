package com.assassin.kotlinlib.singleton

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/13 14:45
 * Version:     1.0
 * Description: 静态内部类
 */
class KotlinStaticInnerSingleton private constructor() {

    // 静态方法
    companion object {
        val instance = InnerHolder.singleton
    }

    // 静态内部类
    private object InnerHolder {
        val singleton = KotlinStaticInnerSingleton()

    }
}