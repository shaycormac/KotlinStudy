package com.assassin.kotlinstudy

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.assassin.kotlinstudy.adapter.ListAdapter
import com.assassin.kotlinstudy.app.BaseActivity
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
    private var lauoutManager:LinearLayoutManager?=null
    private var list:ArrayList<String>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        
        name=intent.getStringExtra("name")
        id=intent.getIntExtra("id",1)
        tv_intent2.setText(name+" "+id)
        lauoutManager= LinearLayoutManager(this)
        rvKotlin.layoutManager=lauoutManager
        lauoutManager!!.orientation=OrientationHelper.VERTICAL
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
        
       
        
    }
}