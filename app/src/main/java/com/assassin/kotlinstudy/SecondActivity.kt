package com.assassin.kotlinstudy

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.assassin.kotlinstudy.adapter.ListAdapter
import com.assassin.kotlinstudy.app.BaseActivity
import com.assassin.kotlinstudy.delegation.PreferenceDelegate
import com.assassin.kotlinstudy.delegation.SPDelegate
import kotlinx.android.synthetic.main.activity_second.*

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/15 0015 14:46
 * Version: 1.0
 * Description: 类说明
 */
class SecondActivity:BaseActivity()
{
    override fun getLayoutId(): Int {
        return R.layout.activity_second
    }

    private var name:String?=null
    private var id:Int?=null
    private var adapter:ListAdapter?=null
    private var lauoutManager: androidx.recyclerview.widget.LinearLayoutManager?=null
    private var list:ArrayList<String>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("SecondActivity","onCreate() is invoked！")
        initView()
    }

    private fun initView() {
        
        name=intent.getStringExtra("name")
        id=intent.getIntExtra("id",1)
        tv_intent2.setText(name+" "+id)
        lauoutManager= LinearLayoutManager(this)
        rvKotlin.layoutManager=lauoutManager
        lauoutManager!!.orientation= RecyclerView.VERTICAL
        list = ArrayList<String>()
        for (i in 0..9)
        {
            list!!.add(""+i)
        }
        adapter=ListAdapter(this,list!!)
        rvKotlin.adapter=adapter

        //执行了get
       var string:String by SPDelegate<String>(this,"张","默认")
       println(string)
        //执行了set
        string="张三"
        println(string)
        
       
        var string2 :String by PreferenceDelegate<String>(this,"what","youA")
        println(string)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SecondActivity","onDestroy() is invoked！")
    }

    override fun onPause() {
        super.onPause();
        Log.e("SecondActivity","onPause() is invoked！");
    }

    override fun onResume() {
        super.onResume();
        Log.e("SecondActivity","onResume() is invoked！");
    }

    override fun onStart() {
        super.onStart();
        Log.e("SecondActivity","onStart() is invoked！");
    }

    override fun onRestart() {
        super.onRestart();
        Log.e("SecondActivity","onRestart() is invoked！");
    }

    override fun onStop() {
        super.onStop();
        Log.e("SecondActivity","onStop() is invoked！");
    }
    
    
}