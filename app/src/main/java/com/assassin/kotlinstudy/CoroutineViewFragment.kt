package com.assassin.kotlinstudy

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.assassin.kotlinstudy.coroutine.awaitEnd
import com.assassin.kotlinstudy.coroutine.awaitNextLayout
import kotlinx.android.synthetic.main.fragment_coroutine_view.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CoroutineViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CoroutineViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coroutine_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            // 将该视图设置为不可见，再设置一些文字
            tv_coroutine_view.visibility =View.INVISIBLE
            tv_coroutine_view.text="wocao"

            // 此时应该是拿不到的
            Log.d("协程啊，获取到的控件高度",tv_coroutine_view.height.toString())
            // 等待下一次布局事件的任务，然后才可以获取该视图的高度
            // 这个是suspend了
            tv_coroutine_view.awaitNextLayout()
            Log.d("协程啊，获取到的控件高度",tv_coroutine_view.height.toString())
            // 布局任务被执行
            // 现在，我们可以将视图设置为可见，并其向上平移，然后执行向下的动画
            tv_coroutine_view.visibility =View.VISIBLE
            tv_coroutine_view.translationY = -tv_coroutine_view.height.toFloat()
            tv_coroutine_view.animate().translationY(0f)
            
        }
        
        //执行动画
        viewLifecycleOwner.lifecycleScope.launch { 
            ObjectAnimator.ofFloat(img_coroutine_view,View.ALPHA,0f,1f).run { 
                start()
                //能保证当前页面被销毁的时候，即使回收销毁
                awaitEnd()
            }
            ObjectAnimator.ofFloat(img_coroutine_view,View.TRANSLATION_Y,0f,10f).run { 
                start()
                awaitEnd()
            }
            ObjectAnimator.ofFloat(img_coroutine_view, View.TRANSLATION_X, -100f, 0f).run {
                start()
                awaitEnd()
            }
        }

        //这个例子演示的是三个动画依次执行，如果没有协程的功劳，需要在每一个动画的执行成功的监听中
        //再次执行下一个动画，而通过这样，简单明了。
        //试着用 AnimatorSet 实现一下吧🤯！如果不用协程，那就意味着我们要监听每一个操作，在回调中执行下一个操作，这回调层级想想都可怕。
        btn_test_coroutine_1.setOnClickListener { 
            viewLifecycleOwner.lifecycleScope.launch {

                ObjectAnimator.ofFloat(tv_coroutine_view,View.ALPHA,0f,1f).run {
                    duration=5000
                    start()
                    //能保证当前页面被销毁的时候，即使回收销毁
                    awaitEnd()
                }

                ObjectAnimator.ofFloat(img_coroutine_view,View.TRANSLATION_Y,0f,10f).run {
                    duration=5000
                    start()
                    awaitEnd()
                }

                // #3: ObjectAnimator
                ObjectAnimator.ofFloat(tv_second_coroutine_view, View.TRANSLATION_X, -100f, 0f).run {
                    duration=3000
                    start()
                    awaitEnd()
                }
            }
        }
        
        btn_test_coroutine_2.setOnClickListener { 
            viewLifecycleOwner.lifecycleScope.launch { 
              val animal1 =   async {

                    ObjectAnimator.ofFloat(tv_coroutine_view,View.ALPHA,0f,1f).run {
                        duration=2000
                        start()
                        //能保证当前页面被销毁的时候，即使回收销毁
                        awaitEnd()
                    }
                    
                }

                val animal2 =    async {

                    ObjectAnimator.ofFloat(img_coroutine_view,View.TRANSLATION_Y,0f,100f).run {
                        duration=5000
                        start()
                        awaitEnd()
                    }
                }

                // 等待以上两个操作全部完成
                animal1.await()
                animal2.await()
                
                // 以上两个操作完了，之后，再执行第三个冬瓜

                ObjectAnimator.ofFloat(tv_second_coroutine_view, View.TRANSLATION_X, -100f, 0f).run {
                    duration=3000
                    start()
                    awaitEnd()
                }
                
            }
            
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CoroutineViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = CoroutineViewFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}
