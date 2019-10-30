package com.assassin.kotlinstudy.dsl

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/7/9 0009 14:18
 * Version: 1.0
 * Description: 类说明
 */

typealias AFTER =(s: Editable?)->Unit
typealias BEFORE =(s: CharSequence?, start: Int, count: Int, after: Int)->Unit
typealias ON =(s: CharSequence?, start: Int, before: Int, count: Int)->Unit
class TextWatcherDSL:TextWatcher 
{
    //第一步，设置三个属性，分别用于实现三个接口的调用
    private var a:AFTER?=null
    
    private var b:BEFORE?=null
    
    private var o:ON?=null
    
    //第二步，设置三个对外函数
    
    fun afterChanged(aa:AFTER?)
    {
        a = aa
        
    }
    
    fun beforeChanged(bb:BEFORE?)
    {
        b =bb
    }
    
    fun onChanged(oo:ON?)
    {
        o =oo
    }
    
    //第三步， 在实现方法中将属性的Lambda执行
    //如果不用typeAlias关键字来命名Lambda，你看看有多蛋疼啊
    override fun afterTextChanged(s: Editable?) 
    {
        a?.invoke(s)
        
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) 
    {
        b?.invoke(s,start,count, after)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        o?.invoke(s, start, before, count)
    }
}

//第四步，写一个扩展函数,记住参数是一个接收者函数,最后一行其实没看懂，我日
//1.带上内联关键字
//2，参数是一个接收者函数
//3.这个接收者函数在后面的具体方法中要执行，怎么执行呢，实例化这个接收者对象，并用apply来执行，碉堡了，实际上，因为
//你的这个函数参数吧，里面都是具体的调用对外暴露方法，那么好了，正好在实例化的对象中，调用Apply扩展方法，执行它里面的方法，它里面的方法恰好是你传的
//都是这个套路啊。
inline  fun EditText._addListener(watchDSL:TextWatcherDSL.()->Unit) =addTextChangedListener(TextWatcherDSL().apply(watchDSL))