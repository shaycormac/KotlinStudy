package com.assassin.kotlinstudy.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assassin.kotlinstudy.R
import kotlinx.coroutines.*
import java.lang.Exception


class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        niduoniyema()
    }

    fun niduoniyema(): Unit {

        val uiScope = CoroutineScope(Dispatchers.Main)
        uiScope.launch { 
            
        }
        //测试SupervisorJob作为爷爷，儿子和孙子采用默认的job，会一荣俱荣。
      /*  val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("捕获到的异常：${throwable.message}")
        }
        val scope = CoroutineScope(Dispatchers.Main+ SupervisorJob()+handler)
        
        scope.launch { 
            launch { 
                launch { 
                    throw  Exception("我是第一个，出了问题！")
                }
                launch {
                    println("我是第二个要在执行"+Thread.currentThread().name)
                }
            }
        }*/


        /*val handler1 = CoroutineExceptionHandler { coroutineContext, throwable ->
            println(throwable.message)
        }
        val scope1 = CoroutineScope(Dispatchers.Main+ SupervisorJob()+handler1)

        scope1.launch {
            
                launch {
                    throw  Exception("我是第一个，出了问题！看第二个会不会影响呢")
                }
                launch {
                    println("我是第二个，我在运行")
                }
            
        }*/

        val handler2 = CoroutineExceptionHandler { coroutineContext, throwable ->
            println(throwable.message)
        }
        val scope2 = CoroutineScope( Dispatchers.IO)
        
            scope2.launch {
                throw  Exception("我是第一个，出了问题！看第二个会不会影响呢"+Thread.currentThread().name)
            }
            scope2.launch {
                println("我是第二个，我在运行"+Thread.currentThread().name)
            }


        // Scope 控制我的应用中某一层级的协程
        val scope = CoroutineScope(Job())

        scope.launch {
            supervisorScope {
                launch {
                    // Child 1
                }
                launch {
                    // Child 2
                }
            }
        }
        
    }
}
