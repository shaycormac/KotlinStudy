package com.assassin.kotlinstudy.coroutine.net

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/29 0029 15:08
 * Version: 1.0
 * Description: 错误类用于封装错误信息
 */
data class ErrorResponse (
        val errorType: ErrorType,//错误类型
        val errorTag:String,//错误tag,用于区别哪个请求出错
            val errorCode: Int?,//错误代码
        val message: String?//错误信息
)