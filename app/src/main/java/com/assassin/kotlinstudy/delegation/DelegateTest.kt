package com.assassin.kotlinstudy.delegation

import kotlin.reflect.KProperty

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/14 0014 09:25
 * Version: 1.0
 * Description: 委托属性
 *   对值的所有读取操作都会委托调用getValue()方法，同理，对值的所有写操作都会委托调用setValue()方法
 */
class DelegateTest 
{
    val string:String by lazy { 
        "张三"
    }
   operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        
       return  ""
    }

    fun setValue(thisRef: Any?, property: KProperty<*>,value:String) {
        //assign  赋值
    }
}