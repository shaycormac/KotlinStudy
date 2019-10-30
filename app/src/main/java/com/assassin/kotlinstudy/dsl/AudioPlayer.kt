package com.assassin.kotlinstudy.dsl

import android.content.Context
import android.media.MediaPlayer

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/7/5 0005 15:01
 * Version: 1.0
 * Description: 在Kotlin的一个类中实现了DSL配置回调非常简单主要就三步:
 */
class AudioPlayer(context:Context)
{
    
    /**
     *1.定义一个回调的Builder类，
     * 并且在类中定义回调lamba表达式对象成员，
     * 最后再定义Builder类的成员函数，
     * 这些函数就是暴露给外部回调的函数。
     * 个人习惯把它作为一个类的内部类
     */
    inner class ListenerBuilder{
        //定义回调lamba表达式对象成员
        internal var mAudioPlayAction:((AudioData) ->Unit)? =null
        internal var mAudioPauseAction:((AudioData) ->Unit)? =null
        internal var mAudioFinishAction:((AudioData) ->Unit)? =null
        //定义Builder类的成员函数,这些函数就是暴露给外部回调的函数
        fun onAudioPlay (action:(AudioData)->Unit)
        {
            mAudioPlayAction=action
        }

        fun onAudioPause(action: (AudioData) -> Unit) {
            mAudioPauseAction = action
        }

        fun onAudioFinish(action: (AudioData) -> Unit) {
            mAudioFinishAction = action
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
    
    fun registerListener(listenerBuilder:ListenerBuilder.()->Unit)
    {
        mListener = ListenerBuilder().also(listenerBuilder)
    }


    val mediaPlayer = MediaPlayer()
    
    
}