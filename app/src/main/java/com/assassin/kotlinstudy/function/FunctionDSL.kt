package com.assassin.kotlinstudy.function

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-11-01 15:06
 * Version: 1.0
 * Description: 类说明
 */


class HTML
{
    fun body(): Unit {
        println("HTML BODY")
    }
}

fun html(init: HTML.()->Unit): HTML {
    
    
    val html =HTML()
    html.init()
    
    return html
}

fun main() {
    html { 
        body()
    }
    
    val ss =""
    ss.let { 
        zhang ->
        "nizuoniyema"
    }
}