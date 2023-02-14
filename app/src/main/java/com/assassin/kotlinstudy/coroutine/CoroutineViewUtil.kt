package com.assassin.kotlinstudy.coroutine

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/8/4 09:10
 * Version: 1.0
 * Description: View上使用协程，挂起函数
 */

/**
 *  所以说这个顶层扩展函数啊，主要是让一些view在布局完后在执行其他的代码，注意这是在同一个线程中，没有切换
 *
 * @receiver View
 */
suspend fun View.awaitNextLayout() = suspendCancellableCoroutine<Unit> { cont ->

    // 这里的 lambda 表达式会被立即调用，允许我们创建一个监听器
    //之所以没有使用lambda的方式，因为在后面需要remove这个监听，需要this，这时候就不能使用了
    val listener = object : View.OnLayoutChangeListener {
        override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
            // 视图的下一次布局任务被调用
            // 先移除监听，防止协程泄漏
            this@awaitNextLayout.removeOnLayoutChangeListener(this)
            // v?.removeOnLayoutChangeListener(this)
            // 最终，唤醒协程，恢复执行
            cont.resume(Unit)
        }
    }
    // 如果协程被取消，移除该监听
    cont.invokeOnCancellation {
        removeOnLayoutChangeListener(listener)
    }
    // 最终，将监听添加到 view 上
    // 注意这个方法是View的方法
    addOnLayoutChangeListener(listener)
    // 这样协程就被挂起了，除非监听器中的 cont.resume() 方法被调用
}

/**
 *   这个方法支持两个维度的取消，我们可以分别取消动画或者协程:

#1: 在 Animator 运行的时候，协程被取消。我们可以通过 invokeOnCancellation 回调方法来监听协程何时被取消，这能让我们同时取消动画。

#2: 在协程被挂起的时候，Animator 被取消。我们通过 onAnimationCancel() 回调来监听动画被取消的事件，通过调用协程的 cancel() 方法来取消挂起的协程。
 * @receiver Animator
 * @return Unit
 */
suspend fun Animator.awaitEnd(): Unit = suspendCancellableCoroutine<Unit> { coroutine ->
    // 增加一个处理协程取消的监听器，如果协程被取消，
    // 同时执行动画监听器的 onAnimationCancel() 方法，取消动画
    //这个是#1，协程被取消，那么就取消正执行的动画
    coroutine.invokeOnCancellation {
        //当前的动画被取消
        cancel()
    }

    addListener(object : AnimatorListenerAdapter() {
        //作为动画是否成功关闭的标志
        private var endedSuccessfully = true

        override fun onAnimationEnd(animation: Animator?) {
            super.onAnimationEnd(animation)
            // 为了在协程恢复后的不发生泄漏，需要确保移除监听
            removeListener(this)
            //这时候要判断这个协程的状态
            if (coroutine.isActive) {
                // 并且动画正常结束，恢复协程
                if (endedSuccessfully) {
                    //恢复到之前停止的状态
                    coroutine.resume(Unit)
                } else {
                    //这个是#2 即通过监听endedSuccessfully标志位，动画被取消了，那么
                    // 取消协程,那么这个时候，动画也被干掉了，两个纬度控制了这个动画关闭的监听
                    coroutine.cancel()
                }
            }
        }

        override fun onAnimationCancel(animation: Animator?) {
            super.onAnimationCancel(animation)
            //被迫取消的监听
            endedSuccessfully = false
        }
    })
}

suspend fun RecyclerView.awaitScrollEnd() = suspendCancellableCoroutine<Unit> { coroutine ->

    val listener: RecyclerView.OnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                //结束了。恢复协程
                coroutine.resume(Unit)

            }
        }
    }

    coroutine.invokeOnCancellation {
        clearOnScrollListeners()
    }
    addOnScrollListener(listener)
}