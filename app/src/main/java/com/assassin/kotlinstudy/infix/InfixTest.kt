package com.assassin.kotlinstudy.infix

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-02 17:12
 * Version: 1.0
 * Description: 类说明
 */

//这个抽象的中缀函数表达式
//真正的使用的时候，表示(T)->R 这个扩展函数最后执行后面param:T这个参数。
infix fun <T,R> ((T)->R).call(param:T):R = this(param)

//函数相加
//注意这个扩展函数的this指的是 (T)->R 这个函数
//这个函数的意思是 (T)->R 这个扩展函数 和参数函数 function:(R)->S 相加然后，对外产出为 (T)->S
//具体到花括号中执行就是下面说的那样
operator fun <T,R,S> ((T)->R).plus(function:(R)->S):(T)->S=
        {
            //用一个x作为这个泛型T的一个具体参数名字，然后调用this(x) === (T)->R ，
            //然后 function(this(x)) == 调用具体的后面函数  function:(R)->S ，最后产出的是S也就是这个函数最后的返回值S
            x ->  
            function(this(x))
        }