package com.assassin.kotlinstudy.delegation

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/14 0014 11:14
 * Version: 1.0
 * Description: SharePreference 代理
 */
class SPDelegate<T>(private val context: Context, private val name: String, private val default: T, private val prefName: String = "defaultName") : ReadWriteProperty<Any?, T> {
    private val prefs:SharedPreferences by lazy { 
        context.getSharedPreferences(prefName,Context.MODE_PRIVATE)
    }
    
    
    //复写ReadWriteProperty的两个抽象方法
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("getValue from delegate")
        return getPreference(key=name)
        
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("setValue from delegate")
        putPreference(key=name,value = value)
    }


    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    private fun getPreference(key: String): T {
        return when (default) {
            is String -> prefs.getString(key, default)
            is Long -> prefs.getLong(key, default)
            is Boolean -> prefs.getBoolean(key, default)
            is Float -> prefs.getFloat(key, default)
            is Int -> prefs.getInt(key, default)
            else -> throw IllegalArgumentException("Unknown Type.")
        } as T
    }
    
    
    private fun putPreference(key:String,value: T)= with(prefs.edit()){
        when(value)
        {
            is String -> putString(key, value)
            is Long -> putLong(key, value)
            is Boolean -> putBoolean(key, value)
            is Float -> putFloat(key, value)
            is Int -> putInt(key, value)
            else -> throw IllegalArgumentException("Unknown Type.")
        }
    }.apply()


}