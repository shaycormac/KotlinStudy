package com.assassin.kotlinstudy.sample

import android.util.Log

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/14 0014 14:34
 * Version: 1.0
 * Description: 类说明
 */
class KassandraSingle private constructor()
{
    init {
        Log.i("kotlin学习","构造放啊")
    }
    
    private  object  SingletonHolder
    {
        var instance = KassandraSingle()
    }
    
    fun testMethod(){
        Log.i("kotlin学习","测试得分那个发")
    }
    //单例的写法
    companion object {
        val instance:KassandraSingle
        @Synchronized get() = SingletonHolder.instance
    }
}