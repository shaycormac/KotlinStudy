package com.assassin.kotlinstudy.coroutine.net

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/29 0029 17:01
 * Version: 1.0
 * Description: 类说明
 */
class SingleLiveData<T>:MutableLiveData<T>()
{
    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
        super.observe(owner, Observer { 
            if (it!=null)
            {
                observer.onChanged(it)
                postValue(null)
            }
        })
    }
}