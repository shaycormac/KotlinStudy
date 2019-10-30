package com.assassin.kotlinstudy.function

import android.os.Build
import android.support.annotation.RequiresApi

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/10/30 0030 09:40
 * Version: 1.0
 * Description: 
 * 中缀调用使用非常简单，准确来说它使用类似加减乘除运算操作符的使用。调用结构: A (中缀函数名) B 例如: element into list
 * 
 * 
 * 1、前面所讲to, into，sameAs实际上就是函数调用，如果把infix关键字去掉，那么也就纯粹按照函数调用方式来。比如1.to("A"), element.into(list)等，只有加了中缀调用的关键字infix后，才可以使用简单的中缀调用例如 1 to "A", element into list等


2、并不是所有的函数都能写成中缀调用，中缀调用首先必须满足一个条件就是函数的参数只有一个。然后再看这个函数的参与者是不是只有两个元素，这两个元素可以是两个数，可以是两个对象，可以是集合等。
 
 * 
 */
class infixTest
{
}


@RequiresApi(Build.VERSION_CODES.N)
fun main()
{
    println("zhangdan")
    //利用to函数初始化一个map
    val map = mapOf(1.to("a"),2.to("b"))
    map.forEach { (key, value) ->
        println("key: $key value:$value")
    }
    //利用to函数中缀调用初始化一个map
    val map1 = mapOf(1 to "A",2 to "B", 3 to "C")
    map1.forEach { t, u ->
        println("t: $t u:$u")
    }
    
    val strA ="A"
    val strB ="B"
    if (strA sameAs strB)
    {
        
    }


    val list = listOf(1, 3, 5, 7, 9)
    val element = 2
    if (element into list) {//中缀调用，这样的写法，会更加接近我们自然语言的表达，更容易理解
        println("element: $element is into list")
    } else {
        println("element: $element is not into list")
    }

    
    
}