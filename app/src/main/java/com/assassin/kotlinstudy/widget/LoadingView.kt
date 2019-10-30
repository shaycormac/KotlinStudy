package com.assassin.kotlinstudy.widget

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.WindowManager
import com.assassin.kotlinstudy.R

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/14 0014 16:41
 * Version: 1.0
 * Description: 自定义控件
 */
class LoadingView: Dialog
{
    //继承父类的构造方法
    constructor(context: Context):super(context)
    {
        init(context)
    }
    
    constructor(context: Context,themeResId: Int):super(context, R.style.Loading)
    {
        init(context)
    }

    protected constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener) : super(context, cancelable, cancelListener) {
        init(context)
    }

    //初始化一些东西
   private fun init(context: Context)
    {
        setContentView(R.layout.layout_loading)
        setCanceledOnTouchOutside(false)
        val  lp = window!!.attributes
        lp.width=WindowManager.LayoutParams.WRAP_CONTENT
        lp.height=WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity=Gravity.CENTER
        lp.dimAmount=0f
        window!!.attributes=lp
        
    }
}