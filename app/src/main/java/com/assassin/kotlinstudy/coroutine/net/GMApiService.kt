package com.assassin.kotlinstudy.coroutine.net

import android.util.Log
import com.assassin.kotlinstudy.coroutine.Repo
import com.assassin.kotlinstudy.coroutine.bean.LoginResult
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.net.URLDecoder

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/29 0029 15:12
 * Version: 1.0
 * Description: 部分api接口
 */
interface GMApiService 
{

    @GET("users/{user}/repos")
    fun getListRepo(@Path("user") user:String): Call<List<Repo>>

    @Headers("Content-Type: application/json","Accept: application/json")//需要添加头
    @POST("/api/Login/LogOn_Device")
    fun loginGM(@Body json:String): Call<LoginResult>
    
    companion object {
        //operator 是构造函数操作符, operator fun invoke()相当于是实现java的构造函数
        operator fun invoke(): GMApiService 
        {
            //自定义一个拦截器,打印请求地址和请求结果
            val paramInterceptor:Interceptor= Interceptor { chain ->
                val url = chain.request().url().url().toString()
              Log.d("网络请求：","${URLDecoder.decode(url,"utf-8")}")
                val response = chain.proceed(chain.request())
                //注意这里不能直接使用response.body.string(),否则流会关闭,会报异常
                val responseBody = response.peekBody(1024*1024)
                Log.d("网络响应：","${responseBody.string()}")
                return@Interceptor response
                
            }
            val okHttpClient:OkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(paramInterceptor).build()
            
            return Retrofit.Builder()
                    .baseUrl("http://mobile.goldmantis.com:7090")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                    .create(GMApiService::class.java)
            
        }
    }
}