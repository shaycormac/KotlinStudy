package com.assassin.kotlinstudy.lambda

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/7/9 0009 13:24
 * Version: 1.0
 * Description: 定义Kotlin扩展函数或者说需要把某个操作或函数当做值传入的某个函数的时候。
 */
class LambdaTest 
{
    //譬如常见的操作，Dialog弹框
    companion object {
        fun showDialog(context: Context,content:CharSequence,isCancelAble:Boolean=true,positiveLambda:(()->Unit)?=null,negativeLambda:(()->Unit)?=null):Unit
        {
            val builder:AlertDialog.Builder = AlertDialog.Builder(context).apply {
                setMessage(content)
                setCancelable(isCancelAble)
                setPositiveButton("确定", DialogInterface.OnClickListener { dialog, which ->
                    positiveLambda?.invoke()
                })
                setNegativeButton("取消", DialogInterface.OnClickListener { dialog, which ->
                    negativeLambda?.invoke()
                })
            }

            val alertDialog :AlertDialog=builder.create()
            alertDialog.show()
        }
    }
    
   /* fun showDialog(context: Context,content:CharSequence,isCancelAble:Boolean=true,positiveLambda:(()->Unit)?=null,negativeLambda:(()->Unit)?=null):Unit
    {
        val builder:AlertDialog.Builder = AlertDialog.Builder(context).apply { 
            setMessage(content)
            setCancelable(isCancelAble)
            setPositiveButton("确定", DialogInterface.OnClickListener { dialog, which -> 
                positiveLambda?.invoke()
            })
            setNegativeButton("取消", DialogInterface.OnClickListener { dialog, which -> 
                negativeLambda?.invoke()
            })
        }
        
        val alertDialog :AlertDialog=builder.create()
        alertDialog.show()
    }*/
}

//对外的扩展函数

fun Context.showDialog(content:CharSequence,isCancelAble:Boolean=true,positiveLambda:(()->Unit)?=null,negativeLambda:(()->Unit)?=null):Unit
{
    //看见没，这个传的参数就是自己啦
    val builder:AlertDialog.Builder = AlertDialog.Builder(this).apply {
        setMessage(content)
        setCancelable(isCancelAble)
        setPositiveButton("确定", DialogInterface.OnClickListener { dialog, which ->
            positiveLambda?.invoke()
        })
        setNegativeButton("取消", DialogInterface.OnClickListener { dialog, which ->
            negativeLambda?.invoke()
        })
    }

    val alertDialog :AlertDialog=builder.create()
    alertDialog.show()
}