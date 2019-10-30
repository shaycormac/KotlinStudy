package com.assassin.kotlinstudy.net

import android.content.Context
import android.content.DialogInterface
import com.assassin.kotlinstudy.widget.LoadingView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/14 0014 17:40
 * Version: 1.0
 * Description: 类说明
 */
class ResultObserver<T>:Observer<T>,DialogInterface.OnCancelListener
{
   
    private  var progress = false
    private var resultListener:ResultListener<T>?=null
    private var loadView:LoadingView? = null
    private var disposable:Disposable?=null
    
    constructor(resultListener: ResultListener<T>)
    {
        this.resultListener=resultListener
    }
    constructor(context: Context,progress:Boolean,resultListener: ResultListener<T>)
    {
        this.progress=progress
        this.resultListener=resultListener
        if (progress){
            loadView= LoadingView(context)
            loadView!!.setOnCancelListener(this)
        }
    }


    override fun onComplete() {
        if (progress) {
            hideProgress()
        }
    }

    override fun onSubscribe(d: Disposable) {
        this.disposable = d
        if (progress) {
            showProgress()
        }
    }

    private fun showProgress() {
        loadView?.show()
    }

    override fun onNext(t: T) {
       resultListener!!.complete(t)
    }

    override fun onError(e: Throwable) {
      resultListener!!.onError(e)
        if (progress)
        {
            hideProgress()
        }
    }

    private fun hideProgress() {
        
        if (loadView!=null)
        {
            if (loadView!!.isShowing)
            {
                loadView?.dismiss()
            }
        }
       
    }

    override fun onCancel(dialog: DialogInterface?) {
        if (!disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }



}