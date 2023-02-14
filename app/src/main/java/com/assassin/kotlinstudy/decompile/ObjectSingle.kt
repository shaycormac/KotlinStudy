package com.assassin.kotlinstudy.decompile

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/9/24 09:41
 * Version: 1.0
 * Description: 类说明
 */
object ObjectSingle {
    
    var j = 0
    
    @Volatile
    var i:Int =0
    
    @Synchronized
    fun testHe()
    {
        println("这尼玛啊")
    }
    
    
    fun nihao(){
        synchronized(this){
            println("里面的方法哎")
        }
    }
    
    
    fun normalMethod()
    {
        println("我是一个普通的方法")
    }
}