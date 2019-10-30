package com.assassin.kotlinstudy.delegation

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/14 0014 10:51
 * Version: 1.0
 * Description: Delegates.observable()主要用于监控属性值发生变更，类似于一个观察者。当属性值被修改后会往外部抛出一个变更的回调。
 * 它需要传入两个参数，一个是initValue初始化的值，另一个就是回调lamba, 回调出property, oldValue, newValue三个参数。
 
 */
class DelegateObservable
{
    var address:String by Delegates.observable("张无忌",onChange = {property: KProperty<*>, oldValue: String, newValue: String ->
        println("property: ${property.name}  oldValue: $oldValue  newValue: $newValue")
    })
}

fun main(args: Array<String>) {
    val tmp = DelegateObservable()
    tmp.address = "BeiJing"
    tmp.address = "ShenZhen"
    tmp.address = "GuangZhou"
}