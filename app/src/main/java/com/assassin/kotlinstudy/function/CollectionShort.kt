package com.assassin.kotlinstudy.function

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-10-30 14:36
 * Version: 1.0
 * Description: 集合操作的快捷键
 */

fun main() {
    
    val numList = listOf(1,2,3,4,5)
    
    //从集合中快速刷选出想要的元素
    val resultAny = numList.any { 
        it /2==1
    }
    //所有满足才成立
    val resultAll = numList.all { 
        it > 0
    }
}