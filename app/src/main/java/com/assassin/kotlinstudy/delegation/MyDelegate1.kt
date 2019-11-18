package com.assassin.kotlinstudy.delegation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-11-06 08:59
 * Version: 1.0
 * Description: 自定义代理属性，判断这个值是不是字符串
 */
class   MyDelegate1<T:Any>() :ReadWriteProperty<Any?,T>
{
    private var  targetvalue:T?=null
    /**
     * Returns the value of the property for the given object.
     * @param thisRef the object for which the value is requested.
     * @param property the metadata for the property.
     * @return the property value.
     */
    override fun getValue(thisRef: Any?, property: KProperty<*>): T
    {
        when(targetvalue)
        {
            is String ->
            {
                val tmpString:String = targetvalue as String
                println("get这个值为 ${tmpString.substring(1)}")
            }
           else ->
               throw IllegalStateException("get这个值为其他的类型")
                
        }
        
        return  targetvalue?:throw IllegalStateException("get这个值不能为null")
    }

    /**
     * Sets the value of the property for the given object.
     * @param thisRef the object for which the value is requested.
     * @param property the metadata for the property.
     * @param value the value to set.
     */
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) 
    {
        when(value)
        {
            is String ->
            {
                val tmpString:String = value as String
                println("set这个值为 ${tmpString.substring(1)}")
            }
            else ->
                throw IllegalStateException("set这个值为其他的类型")

        }
        
        targetvalue=value
    }
}

fun main() {
    var ss:Boolean by MyDelegate1<Boolean>()
    
    ss = true
  //  println(ss)
}