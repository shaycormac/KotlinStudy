package com.assassin.kotlinstudy.delegation

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-11-05 17:32
 * Version: 1.0
 * Description: 类说明
 */
class PreferenceDelegate<T>(private val context: Context, private val name: String, private val defaultValue: T, private val prefName: String = "spTest")
    : ReadWriteProperty<Any?, T> {
    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("getValue from delegate")
        return getPreference(key = name)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("setValue from delegate")
        putPreference(key = name, value = value)
    }

    private fun getPreference(key: String): T {
        return when (defaultValue) {
            is String -> prefs.getString(key, defaultValue)
            is Long -> prefs.getLong(key, defaultValue)
            is Boolean -> prefs.getBoolean(key, defaultValue)
            is Float -> prefs.getFloat(key, defaultValue)
            is Int -> prefs.getInt(key, defaultValue)
            else -> throw IllegalArgumentException("Unknown Type.")
        } as T
    }

    private fun putPreference(key: String, value: T) = with(prefs.edit()) {
        when (value) {
            is String -> putString(key, value)
            is Long -> putLong(key, value)
            is Boolean -> putBoolean(key, value)
            is Float -> putFloat(key, value)
            is Int -> putInt(key, value)
            else -> throw IllegalArgumentException("Unknown Type.")
        }
    }.apply()

}
