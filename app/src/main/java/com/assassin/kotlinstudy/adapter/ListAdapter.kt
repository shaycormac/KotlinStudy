package com.assassin.kotlinstudy.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.assassin.kotlinstudy.R

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/2/15 0015 14:48
 * Version: 1.0
 * Description: 类说明
 */
class ListAdapter(private val context: Context,private val datas:List<String>): androidx.recyclerview.widget.RecyclerView.Adapter<ListAdapter.MyViwHolder>()
{
    private var inflater:LayoutInflater?=null
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViwHolder {
        inflater= LayoutInflater.from(context)
        val view = inflater!!.inflate(R.layout.item_list,p0,false)
        return MyViwHolder(view)
    }

    override fun getItemCount(): Int {
   return  datas!!.size
    }

    override fun onBindViewHolder(p0: MyViwHolder, p1: Int) {
         p0.tv.text = datas!![p1]
    }

    class MyViwHolder(view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view)
    {
        var tv: TextView
        init {
            tv = view.findViewById(R.id.tv_text)
        }
    }
}