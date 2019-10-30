package com.assassin.kotlinstudy.coroutine

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming
import retrofit2.http.Url

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/27 0027 09:35
 * Version: 1.0
 * Description: Github的网络服务请求
 */
interface GitHubService 
{
    @GET("users/{user}/repos")
    fun getListRepo(@Path("user") user:String):Call<List<Repo>>

    //改操作用于下载文件,url传入下载的全路径,Streaming在大文件下载时必须添加,ResponseBody封装下载的流
    @Streaming
    @GET
    fun downloadFile(@Url url: String): Call<ResponseBody>
    
    //单例
    companion object {
        //Volatile 注解同java中的 volatile关键字,表示属性更新后在其他线程立即可见
        @Volatile
        private var instance: GitHubService? = null
        
        fun getInstance():GitHubService = instance?: synchronized(GitHubService::class.java) {
            instance?: Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GitHubService::class.java)
                    .also { instance=it }
         
            
        }
    }
}

