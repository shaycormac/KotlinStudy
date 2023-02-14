package com.assassin.kotlinstudy.app

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.assassin.kotlinstudy.lifeowner.ToastWarn

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/14 0014 16:59
 * Version: 1.0
 * Description: 类说明
 */
class KotlinApp:Application()
{
    override fun onCreate() {
        super.onCreate()
        //监测app的生命周期
        ProcessLifecycleOwner.get().lifecycle.addObserver(ToastWarn())
    }
}