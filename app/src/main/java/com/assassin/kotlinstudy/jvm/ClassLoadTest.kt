package com.assassin.kotlinstudy.jvm

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-17 10:11
 * Version: 1.0
 * Description: 测试类加载器
 */
class ClassLoadTest {
    
    
}

class LoadTest{
    
}

fun main() {
    val classload:ClassLoader ?=Thread.currentThread().contextClassLoader
    println(classload)
    println(classload?.parent)
    println(classload?.parent?.parent)

    //打印结果
 //   sun.misc.Launcher$AppClassLoader@18b4aac2
 //   sun.misc.Launcher$ExtClassLoader@2c7b84de
  //  null
    //从上面的结果可以看出，并没有获取到ExtClassLoader的父Loader，
    // 原因是Bootstrap Loader（引导类加载器）是用C语言实现的，找不到一个确定的返回父Loader的方式，于是就返回null。
}