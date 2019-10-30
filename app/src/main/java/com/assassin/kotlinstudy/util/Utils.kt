package com.assassin.kotlinstudy.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/15 0015 09:15
 * Version: 1.0
 * Description: kotlin一些基础
 */
class Utils {
    //成员函数
    fun foo(context: Context) {
        Toast.makeText(context, "文本", Toast.LENGTH_SHORT).show()
        print("成员函数")
    }

    //类型转换
    fun demo(x: Any) {
        if (x is String) {
            print(x.length)
        }
    }
// kotlin对字符串的加强，三个引号"""中可以包含换行、反斜杠等等特殊字符
    fun testString() {
        var ss: String = """哈哈\n
            |你妈
            |死了
        """
        println(ss)
    }
    //kotlin字符串模版，可以用$符号拼接变量和表达式
    fun testString2()
    {
        val strings = arrayListOf("abc","efg","fdg")
        println("第一个元素是 $strings")
        println("第一个元素是 ${strings[0]}")
        println("第一个元素是 ${if(strings.size>0 ) strings[0] else "null"}")
    }
    //Kotlin中，美元符号$是特殊字符，在字符串中不能直接显示，必须经过转义，方法1是用反斜杠，方法二是${'$'}
    fun testString3()
    {
        println("diyigeyuansu shi \$strings")
        println("diyigeyuansu shi ${'$'}strings")
    }
    // 用apply语句简化类的初始化，在类实例化的时候，就可以通过apply把需要初始化的步骤全部实现，非常的简洁
    fun testApply(context: Context)
    {
        var imageView = ImageView(context).apply { 
            setBackgroundColor(0)
            setImageBitmap(null)
        }
        
        var textView = TextView(context).apply { 
            setTextColor(0)
            textSize=160f
        }
    }
    //
    fun test01()
    {
        val list = listOf(2,5,10)
        //传人函数来过滤
        println(list.filter { it>4 })
    }
    //kotlin中，when是表达式，可以取代Java 中的switch，when的每个分支的最后一行为当前分支的值
    fun getPoint(grade:Char)=when(grade)
    {
        'A' ->"Good"
        'B','C'->{
            println("testWhen")
            "OK"
        }
        else ->"UN-KNOW"
    }
    
    //Activity.toast 指定了this 的含义和使用地方
    fun Activity.toast(msg:String)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        
    }
    //获取版本号VersionCode
    fun getVersionCode(context: Context):Int
    {
        val packageManager = context.packageManager
        val packageInfo:PackageInfo
        var versionCode=""
        try {

            packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            versionCode=packageInfo.longVersionCode.toString()
        }catch (e:PackageManager.NameNotFoundException)
        {
            e.printStackTrace()
        }
        
        
        return Integer.parseInt(versionCode)
        
        
    }
    
}