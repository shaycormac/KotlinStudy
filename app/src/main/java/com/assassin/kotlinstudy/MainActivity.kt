package com.assassin.kotlinstudy

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import com.assassin.kotlinstudy.app.BaseActivity
import com.assassin.kotlinstudy.coroutine.DownloadActivity
import com.assassin.kotlinstudy.coroutine.GithubApiActivity
import com.assassin.kotlinstudy.dsl._addListener
import com.assassin.kotlinstudy.entity.User
import com.assassin.kotlinstudy.intentservice.MyTestIntentService
import com.assassin.kotlinstudy.lambda.showDialog
import com.assassin.kotlinstudy.mvvm.ui.MvvmActivity
import com.assassin.kotlinstudy.net.APiClient
import com.assassin.kotlinstudy.net.ResultListener
import com.assassin.kotlinstudy.net.ResultObserver
import com.assassin.kotlinstudy.util.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import java.net.NetworkInterface
import java.util.*
import kotlin.collections.ArrayList


/**
 * kotlin学习笔记: ? 和 ?. 和 ?: 和 as? 和 !!
 */
class MainActivity : BaseActivity(), View.OnClickListener {
    override fun getLayoutId()=R.layout.activity_main

    private var users: Call<List<User>>?=null
    private var userList:List<User>?=null
    
    override fun onClick(v: View?) 
    {
        when(v!!.id)
        {
            R.id.tv_getdata ->
            {
                getData()
            }
            R.id.tv_intent ->{
                var intent = Intent(this@MainActivity,SecondActivity::class.java)
                intent.putExtra("name", "名字")
                intent.putExtra("id", 12)
                startActivity(intent)
            }
            R.id.tv_github ->
            {
                startActivity(Intent(this@MainActivity,GithubApiActivity::class.java))
            }
            R.id.tv_download ->
            {
                startActivity(Intent(this@MainActivity,DownloadActivity::class.java))
            }
            R.id.tv_mvvm ->
            {
                startActivity(Intent(this@MainActivity,MvvmActivity::class.java))
            }
            R.id.tv_dsl ->
            {
               /* LambdaTest.showDialog(this@MainActivity,"标题",true,{
                    showToast(this@MainActivity,"标题")
                }){
                    showToast(this@MainActivity,"haha")
                }*/
               // alphaAnimation

                //扩展方法
                this@MainActivity.showDialog("扩展函数",true,{showToast(this@MainActivity,"标题")}){
                    showToast(this@MainActivity,"haha")
                    var shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Here is the Shared text.")
//切记需要使用Intent.createChooser，否则会出现别样的应用选择框，您可以试试
                    //切记需要使用Intent.createChooser，否则会出现别样的应用选择框，您可以试试
                    shareIntent = Intent.createChooser(shareIntent, "Here is the title of Select box")
                    startActivity(shareIntent)

                }
            }
            
        }
    }

    //获取网络数据
    private fun getData() {
        
         Thread(Runnable { 
             users=APiClient().getListRepo("1")
             userList=users!!.execute().body()
             for (i in userList!!.indices)
             {
                 Log.i("info", "用户：" + userList!!.get(i).full_name)
             }
         }).start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MainActivity","onCreate（） is invoked！")
        initView()
        //把可空类型的x赋值给非空类型的y会报错：Type mismatch
        //3、也不能把可空类型的值传给非空类型 var y:String是非空
        //错误样例
        //val x:String?=null
        //var y:String = x
       

        //Intent意图的接收，直接intent接收，不用getIntent了。已经封装好
        var name:String? = intent.getStringExtra("haha")


        var tempList: ArrayList<Int> = ArrayList(5)
        //for循环的不同。例如i从0到9循环，添加到ArrayList
        for (i in 0..9)
        {
            tempList.add(i)
            
        }
        //for(i in 对象集合.indices)
        for (i in tempList.indices)
        {
            Log.i("kotlin学习", "索引：" + tempList!!.get(i))
            
        }

        testString()

        //java的写法
       /* textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //do something
        }
    });*/
        
        //lambda 的最初表达式
        /*   tv_text.setOnClickListener({v->{
               toast("我日")
           }})
           //当lambda的参数没有使用时可以省略，省略的时候用it来替代
           tv_text.setOnClickListener({toast("呵呵大")})
           tv_text.setOnClickListener(){toast("呵呵大")}
           tv_text.setOnClickListener{toast("呵呵大")}*/
        tv_intent.text="产品名："+Build.PRODUCT+"\n"+"设备名："+Build.DEVICE+"\n"+"制造商:"+Build.MANUFACTURER+"\n"+"品牌："+Build.BRAND+"\n设备用户名："+Build.USER
        
        
        MyTestIntentService.startActionFoo(this,"aa","bb")
        MyTestIntentService.startActionFoo(this,"bb","bb")
        MyTestIntentService.startActionFoo(this,"cc","bb")
        
                
    }

    private fun initView() {
        var util = Utils()
        util.foo(this)
        tv_tips.text="马勒份额卖比"
        util.testString3()
        util.testApply(this)
        util.getPoint('C')
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png").into(iv_img)
        runOnUiThread(Runnable { 
            kotlin.run { 
                toast("测试弹出提示")
            }
        })
        tv_getdata.setOnClickListener(this)
        tv_intent.setOnClickListener(this)
        tv_github.setOnClickListener(this)
        tv_download.setOnClickListener(this)
        tv_mvvm.setOnClickListener(this)
        tv_dsl.setOnClickListener(this)
      /*  APiClient().getListRepo("1", ResultObserver(object:ResultListener<List<User>>{
            override fun complete(t: List<User>) {
                showToast(this@MainActivity,t.size.toString()+"  "+t.get(0).full_name)
            }

            override fun onError(e: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }))*/
        
        
        
        //测试dsl语法
        et_text._addListener { 
            //下面这三个方法都可以选择实现或者不实现，看心情
            afterChanged { 
              Log.d("TAG","afterChanged----"+it?.toString())  
            }
            beforeChanged { s, start, count, after ->
                Log.d("TAG", "beforeChanged-----$s")
            }
            onChanged { s, start, before, count ->
                Log.d("TAG", "onChanged----$s")
            }
        }
        
        Log.e("获取唯一的ID",getMacAddress())
        val androidId: String = Settings.System.getString(contentResolver, Settings.Secure.ANDROID_ID)
        Log.e("获取唯一的ID",androidId)


    }

    //  ? 可空类型
    //牛逼了，不能直接调用length方法,直接编译不通过，GG,原因参照注释2
    //1、这里使用了可空类型?，?可以加载任何类型的后面来表示这个类型的变量可以为null
    //2、可空类型的变量在使用的时候不能直接调用它的方法
    
    //fun strLen(x: String?): Int = x.length
    
    // ?. 安全调用运算符
    //如果增加了null检查以后，就可以直接调用s.length了,如下:
    fun strLen1(s:String?):Int = if(s!=null) s.length else 0
    //但是如果每个可空类型都这样检查会显得特别累赘，此时就用到了安全调用运算符?.
    //简便写法
    //如果s不为空就执行方法,如果为空就返回null
    fun strLen2(s: String?): Int? = s?.length
    
    //?: Elvis运算符（null合并运算符）
    fun foo(s:String?){
        //如果?:左边的值不为空返回左边的值，如果为空返回""
        val t :String = s?:""
        
        val gg :String?=null
        gg as? Int ?:"not human"
        
        
        
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity","onDestroy() is invoked！")
    }

    override fun onPause() {
        super.onPause();
        Log.e("MainActivity","onPause() is invoked！");
    }

    override fun onResume() {
        super.onResume();
        Log.e("MainActivity","onResume() is invoked！");
    }

    override fun onStart() {
        super.onStart();
        Log.e("MainActivity","onStart() is invoked！");
    }

    override fun onRestart() {
        super.onRestart();
        Log.e("MainActivity","onRestart() is invoked！");
    }

    override fun onStop() {
        super.onStop();
        Log.e("MainActivity","onStop() is invoked！");
    }


    private fun getMacAddress(): String? {
        try {
            val all: List<NetworkInterface> = Collections.list(NetworkInterface.getNetworkInterfaces())
            for (nif in all) {
                if (!nif.name.equals("wlan0",true)) {
                    continue
                }
                val macBytes: ByteArray = nif.hardwareAddress ?: return ""
                val res1 = StringBuilder()
                for (b in macBytes) {
                    res1.append(String.format("%02X:", b))
                }
                if (res1.isNotEmpty()) {
                    res1.deleteCharAt(res1.length - 1)
                }
                return res1.toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


}
