package com.assassin.kotlinstudy.sample

import android.app.Activity
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/4/29 09:01
 * Version: 1.0
 * Description: 高阶函数
 */
class HighOrderFun {


 
}

inline  fun createAlertDialog(activity: Activity, title: String? = null, message: String? = null,crossinline positiveAction: () -> Unit): AlertDialog {

    val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
    builder.setTitle(title).setMessage(message).setPositiveButton("确定") { _, which ->
        positiveAction()
    }
    return builder.create()

}