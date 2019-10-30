package com.assassin.kotlinstudy.delegation

import android.content.Context
import java.io.Serializable

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/14 0014 09:59
 * Version: 1.0
 * Description: 标准的kotlin双重锁校验
 */
class DCLSingleton private constructor():Serializable{//private constructor()构造器私有化
    private lateinit var  context:Context
    //需要在构造方法中初始化的数据在这里面？？
    //由于是单例，长周期生命值，传参数要小心
    init {
        context.applicationContext
    }

    fun readResolve(): Any {//防止单例对象在反序列化时重新生成对象
        return instance
    }

    companion object {
        //通过@JvmStatic注解，使得在Java中调用instance直接是像调用静态函数一样，
        @JvmStatic
        val instance: DCLSingleton by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            DCLSingleton()
        }
    }

    //普通的方法，想干啥干啥？
    fun doSomething() {
        println("do some thing")
    }
}