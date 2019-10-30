package com.assassin.kotlinstudy.app

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.assassin.kotlinstudy.sample.KassandraSingle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/14 0014 14:10
 * Version: 1.0
 * Description: 基类，实现协程的接口，统一管理协程
 * https://ikirby.me/133.html
 */
//todo   首先使需要使用的 Activity 实现 CoroutineScope 接口
abstract class BaseActivity :AppCompatActivity(),CoroutineScope {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        //单例
        KassandraSingle.instance
    }
    
    fun showToast(context: Context,msg:String)
    {
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
    }
    
    object Conf{
        val BASE_URL:String? ="https://api.github.com/"
    }
    
    fun testString(){
        val str1="abc"
        val str2 ="""line\n
            |line2
            |line3""".trimMargin()
        println(str2)
    }
    
    fun Activity.toast(msg:String)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        
    }

    //todo  然后添加一个 SupervisorJob 的全局变量（用于管理这个 Activity 中全部的 Coroutine），并重写 coroutineContext
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main +job

    //todo  接下来在 onDestroy 方法中添加  以便 Activity 结束时取消所有的操作。 做完以上工作，就可以开始使用了
    //这样无需修改原先 API 接口的返回值，即可使用 Kotlin Coroutines 了
    override fun onDestroy() {
        super.onDestroy()
        coroutineContext.cancelChildren()
    }
    
    abstract fun getLayoutId(): Int 
}