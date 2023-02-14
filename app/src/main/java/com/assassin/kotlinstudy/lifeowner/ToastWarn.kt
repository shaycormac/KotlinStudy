package com.assassin.kotlinstudy.lifeowner

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020-01-14 09:19
 * Version: 1.0
 * Description: 类说明
 */
class ToastWarn : LifecycleObserver
{
    
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun forground() {
        Log.d("当前app","进入前台")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun backGRound() {
        Log.d("当前app","进入后台")
    }
}