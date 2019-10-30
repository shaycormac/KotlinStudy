package com.assassin.kotlinstudy.sample

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/24 0024 15:47
 * Version: 1.0
 * Description: 类说明
 */

fun main(args:Array<String>)
{
    GlobalScope.launch { 
        delay(1000L)
        
        println("launch")
        
    }
    println("----")
    
    //withContext()
    Thread.sleep(2000L)
}