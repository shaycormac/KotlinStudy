package com.assassin.kotlinstudy.lifeowner

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020-01-14 10:23
 * Version: 1.0
 * Description:  测试如果在onResume()生命周期中执行的时候，这些onLifeCreate()和onLifeStart()都是可以仍然执行到的
 */
class StateEvent :LifecycleObserver
{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onLifeCreate(): Unit {
        
        Log.d("倒灌问题","onCreate")
    } 
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onLifeResume(): Unit {
        
        Log.d("倒灌问题","onResume")
    } 
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onLifeStart(): Unit {
        
        Log.d("倒灌问题","onStart")
    }
}