package com.assassin.kotlinstudy.dsl

import android.view.animation.Animation

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/7/5 0005 15:21
 * Version: 1.0
 * Description: 类说明
 */
class AnimationDSL {

    /**
     *1.定义一个回调的Builder类，
     * 并且在类中定义回调lamba表达式对象成员，
     * 最后再定义Builder类的成员函数，
     * 这些函数就是暴露给外部回调的函数。
     * 个人习惯把它作为一个类的内部类
     */
    inner class ListenerBuilder() {
        //定义回调lamba表达式对象成员
        //简单的说，这几个成员是给内部实现那个接口里面的方法用的
        internal var animationStart: ((animation: Animation?) -> Unit)? = null

        internal var animationEnd: ((animation: Animation?) -> Unit)? = null

        internal var animationRepeat: ((animation: Animation?) -> Unit)? = null

        //定义Builder类的成员函数,这些函数就是暴露给外部回调的函数
        //这几个是留给外面调用这个内部类用的
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

    /**
     *  2、然后，在类中声明一个ListenerBuilder的实例引用，
     *  并且暴露一个设置该实例对象的一个方法，也就是我们常说的注册事件监听或回调的方法，
     *  类似setOnClickListenter这种。但是需要注意的是函数的参数是带ListenerBuilder返回值的lamba

    作者：mikyou
    链接：https://juejin.im/post/5c4f106a6fb9a049de6dc410
    来源：掘金
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    //在类中声明一个ListenerBuilder的实例引用
    private lateinit var mListener:ListenerBuilder
    fun registerListener(listener:ListenerBuilder.()->Unit)
    {
        mListener = ListenerBuilder().also(listener)
    }
    
    //第三部
    val animation = object :Animation.AnimationListener
    {
        override fun onAnimationRepeat(animation: Animation?) 
        {
            if (::mListener.isInitialized)
            {
                mListener.animationRepeat?.invoke(animation)
            }
            
        }

        override fun onAnimationEnd(animation: Animation?) {
            if (::mListener.isInitialized)
            {
                mListener.animationEnd?.invoke(animation)
            }
        }

        override fun onAnimationStart(animation: Animation?) 
        {
            if (::mListener.isInitialized)
            {
                mListener.animationStart?.invoke(animation)
            }
        }

    }
}


