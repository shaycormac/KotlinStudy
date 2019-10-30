package com.assassin.kotlinstudy.coroutine

import android.os.Bundle
import android.view.View
import com.assassin.kotlinstudy.R
import com.assassin.kotlinstudy.app.BaseActivity
import kotlinx.android.synthetic.main.activity_github_api.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/27 0027 09:26
 * Version: 1.0
 * Description: 模拟请求github的api接口。
 */
class GithubApiActivity : BaseActivity() {


    override fun getLayoutId()=R.layout.activity_github_api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //得到Github的单例
        val githubService:GitHubService = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubService::class.java)
        btn_search.setOnClickListener { 
            //使用携程，
            launch {
                progress_bar.visibility = View.VISIBLE
                //使用挂起函数
                val result:Response<List<Repo>> = withContext(Dispatchers.IO)
                {
                    githubService.getListRepo(editText.text.toString()).execute()
                }
                progress_bar.visibility = View.GONE
                if (result.isSuccessful)
                {
                    result.body()?.forEach {
                        tv_content.append("${it.fullName}\n")
                    }
                }
            }
        }
    }
}
