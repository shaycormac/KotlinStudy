package com.assassin.kotlinstudy.mvvm.data

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/4 0004 14:19
 * Version: 1.0
 * Description: Bean实体
 */
data class Book(val bookName:String,
                val authorName:String) {
    override fun toString(): String {
        return "$bookName - $authorName"
    }
}
