package com.assassin.kotlinstudy.study

import android.view.animation.Animation

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/3/11 0011 14:24
 * Version: 1.0
 * Description: 高阶函数+lambda简化代码  
 * 
 *   当我们监听TabLayout的select的时候，一般我们这么写：

tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
override fun onTabReselected(tab: TabLayout.Tab?) {
//do something
}

override fun onTabUnselected(tab: TabLayout.Tab?) {
//do something
}

override fun onTabSelected(tab: TabLayout.Tab?) {
//do something
}
})
有时候我们只需要调用其中的一个方法，则显得代码臃肿。这个时候高阶函数和lambda就可以派上用场了。 
      核心思想是把参数变成函数
 * 
 */

//1.实现接口，并重写三个方法
class KotlinAnimationListener:Animation.AnimationListener{
    //2.定义三个函数成员(animation: Animation?)->Unit 这个函数形参里面的参数是第一步要重写的方法所需要的参数。
    private var animationStart:((animation: Animation?)->Unit)?=null
    
    private var animationEnd:((animation:Animation?)->Unit)?=null
    
    private var animationRepeat:((animation:Animation?)->Unit)?=null
    override fun onAnimationEnd(animation: Animation?)
    {
       //属性函数执行
        animationEnd?.invoke(animation)
    }

    
    override fun onAnimationStart(animation: Animation?) 
    {
        //3.使用自定义的函数invoke这个参数
        animationStart?.invoke(animation)
    }

    override fun onAnimationRepeat(animation: Animation?) {
       animationRepeat?.invoke(animation)
    }
    
    fun onAnimationEnd(func:(animation: Animation?)->Unit)
    {
        animationEnd=func
        
    }
    
    //4.外部函数调用，传一个函数，这个函数形参应该和成员变量一致。
    fun onAnimationStart(func:(animation:Animation?)->Unit)
    {
        animationStart =func
    }
    
    fun onAnimationRepeat(func:(animation:Animation?)->Unit)
    {
        animationRepeat =func
    }

}


//
fun Animation.addAnimationListener(func:KotlinAnimationListener.()->Unit)
{
    //一个类生成对象
    val listener = KotlinAnimationListener()
    //对象调用这个函数形参
    listener.func()
    //什么鬼
    addAnimationListener(func)
}
