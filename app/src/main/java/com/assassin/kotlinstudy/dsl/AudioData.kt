package com.assassin.kotlinstudy.dsl

import android.view.animation.Animation

class AudioData {
    private lateinit var mListener: ListenerBuilder

    fun setListener(listenerBuilder: ListenerBuilder.() -> Unit) {
        mListener = ListenerBuilder().also(listenerBuilder)
    }

    inner class ListenerBuilder {
        internal var mrepeatAction: ((animation: Animation?) -> Unit)? = null
        internal var mstartAction: ((animation: Animation?) -> Unit)? = null
        internal var mendAction: ((animation: Animation?) -> Unit)? = null

        fun onrepeat(action: (animation: Animation?) -> Unit) {
            mrepeatAction = action
        }

        fun onstart(action: (animation: Animation?) -> Unit) {
            mstartAction = action
        }

        fun onend(action: (animation: Animation?) -> Unit) {
            mendAction = action
        }
    }

}
