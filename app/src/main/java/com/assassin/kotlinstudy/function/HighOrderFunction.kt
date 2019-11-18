package com.assassin.kotlinstudy.function

import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-11-01 10:46
 * Version: 1.0
 * Description:  高阶函数 内联的使用
 */


fun highOrderFunction1(funct: (Int)->Unit): Unit 
{
    var count:Int = 0
    while (count<5)
    {
        funct(count)
        count++
    }
    
}


inline  fun highOrderFunction2(funct: (Int)->Unit): Unit
{
    var count:Int = 0
    while (count<5)
    {
        funct(count)
        count++
    }

}

fun main() {
    /*highOrderFunction2 { 
        println(it)
    }
    
    highOrderFunction1{
        println(it)
    }*/
    
    repeat(100){
        println(it)
    }

    noInlineRepeat(100){
        println(it)
    }
}

inline fun repeat(times: Int,action:(Int)->Unit): Unit 
{
    for (index in 0 until times)
    {
        action(index)
    }
    
}

 fun noInlineRepeat(times: Int,action:(Int)->Unit): Unit
{
    for (index in 0 until times)
    {
        action(index)
    }

}



suspend fun demoFunction1(channel1:ReceiveChannel<Int>,channel2:ReceiveChannel<Int>):Int= coroutineScope { 
    var count = 0
    val mutex = Mutex()
    
    
    count
}

/**
 *  自己实现的扩展函数，过滤集合，涉及到不懂的知识点
 *  
 * 首先Iterable<T> 是一个接收者，代表的是一个可以迭代的集合，后面的 element in this 中this就是它啊
 * 其次，参数是一个函数，这个函数的功能就是传进一个对应的泛🌟，然后对这个泛🌟进行实际使用的时候处理，返回一个boolean结果，
 * 最后，这个函数的返回值是一个经过过滤的结果集合，在这个方法中，需要新建一个集合，然后返回。
 * 最最后，由于涉及到高阶函数，用inline关键字内联一下下。
 * @receiver Iterable<T>
 * @param predicate Function1<T, Boolean>
 * @return List<T>
 */
fun  <T> Iterable<T>.myFilter(predicate: (T)->Boolean): List<T> 
{
    //新建一个数组
    val destination = ArrayList<T>()
    for (element in this)
    {

        if (predicate(element))
        {
            destination.add(element)
        }

    }
    
    return  destination
}
