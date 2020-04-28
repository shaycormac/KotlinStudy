package com.assassin.kotlinstudy.widget

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import com.assassin.kotlinstudy.R

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/4/26 10:07
 * Version: 1.0
 * Description: 测试 clipRect的用法
 *  @JvmOverloads 这个注解必须加上，否则会出现找不到方法的错误
 */
class ClipRectTextView  @JvmOverloads constructor(context: Context,attributeSet: AttributeSet? = null,defAttrStyle: Int = 0):androidx.appcompat.widget.AppCompatTextView(context,attributeSet,defAttrStyle) {
    
    private val paint: Paint by lazy { 
        Paint(Paint.ANTI_ALIAS_FLAG)
    }
    
    private val rectf:RectF by lazy { 
        RectF(50F, 50F, (width-50).toFloat(), (height-50).toFloat())
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.d("ondraw执行","呵呵执行")
        //裁剪出来一块区域，这个区域距离这个View的左上右下各是50px
        canvas.clipRect(rectf)
        //在这个区域开始绘制图片
        canvas.drawBitmap(BitmapFactory.decodeResource(resources,R.mipmap.bg_quality_general_manage),0F,0F,paint)
    }
}