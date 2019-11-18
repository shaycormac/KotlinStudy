package com.assassin.kotlinstudy.coroutine.net

import androidx.lifecycle.LiveData
import com.assassin.kotlinstudy.coroutine.bean.LoginObject
import com.assassin.kotlinstudy.coroutine.bean.LoginResult

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/29 0029 16:55
 * Version: 1.0
 * Description: 用于网络请求获取数据的接口,两个方法对应上面两个网络请求
 */
interface NetworkDataSource 
{
    //用于封装请求错误的LiveData,UI通过监听这个值来判断网络是否发生异常
    val errorResult: LiveData<ErrorResponse>
    //登录 挂起函数
    suspend fun userLogin(param:LoginObject):LiveData<LoginResult>
}