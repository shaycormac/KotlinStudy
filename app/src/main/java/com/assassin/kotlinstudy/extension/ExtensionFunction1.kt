package com.assassin.kotlinstudy.extension

import android.widget.TextView

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-11-04 14:26
 * Version: 1.0
 * Description: 扩展属性
 */

//自定义扩展属性
var TextView.isBold: Boolean
    get() {
        return this.paint.isFakeBoldText
    }
    set(value) {
        this.paint.isFakeBoldText = value

    }

// 扩展属性只读

val TextView.readText: CharSequence?
    get() {
        return this.text
    }
