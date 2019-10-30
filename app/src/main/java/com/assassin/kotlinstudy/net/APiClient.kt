package com.assassin.kotlinstudy.net

import com.assassin.kotlinstudy.entity.User
import com.assassin.kotlinstudy.util.Conf
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/14 0014 17:19
 * Version: 1.0
 * Description: 类说明
 */
class APiClient constructor()
{
    private var apiService:ApiService?=null
    
    private var retrofit:Retrofit?=null
    
    init {
        retrofit = Retrofit.Builder().baseUrl(Conf.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        
        apiService=retrofit!!.create(ApiService::class.java)
    }
    
    fun getListRepo(id:String): Call<List<User>>
    {
        return apiService!!.listRepos(id)
    }
    
    private fun <T> subscribeOnobserveOn(observable:Observable<T>,observer:Observer<T>)
    {
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer)
    }
    
    fun getListRepo(id:String,resultObserver:ResultObserver<List<User>>)
    {
        subscribeOnobserveOn(apiService!!.getUserList(id),resultObserver)
    }
}