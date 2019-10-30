package com.assassin.kotlinstudy.function

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-10-30 14:30
 * Version: 1.0
 * Description: 标准函数的IO流 ，大大简化
 */


fun main() {
    
    BufferedReader(FileReader(File("zhang.txt"))).use { 
        var line:String
        while (true)
        {
            //跳出while循环的条件就是读取的值为null了。
            line = it.readLine()?:break
            //打印每一行的值，具体的行为。
            println(line)
        }
    }
    //更加简洁的写法。
    File("zhang.txt").readLines().forEach(::println)
}