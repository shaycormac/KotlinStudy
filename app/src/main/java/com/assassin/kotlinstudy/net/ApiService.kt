package com.assassin.kotlinstudy.net

import com.assassin.kotlinstudy.entity.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/14 0014 17:15
 * Version: 1.0
 * Description: 网络请求类
 */
interface ApiService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user")user:String): Call<List<User>>
    
    @GET("users/{user}/repos")
    fun getUserList(@Path("user")user:String):Observable<List<User>>
}