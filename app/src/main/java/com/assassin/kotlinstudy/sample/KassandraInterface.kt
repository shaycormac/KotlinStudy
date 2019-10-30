package com.assassin.kotlinstudy.sample

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/14 0014 14:03
 * Version: 1.0
 * Description: 类说明
 */
interface KassandraInterface<T> {
    fun complete(t:T)
    fun onError(e:Throwable)
}