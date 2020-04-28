package com.assassin.kotlinstudy.coroutine


import android.os.Bundle
import android.view.View
import com.assassin.kotlinstudy.R
import com.assassin.kotlinstudy.app.BaseActivity
import kotlinx.android.synthetic.main.activity_download.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.File
import java.io.InputStream
import java.io.OutputStream

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/27 0027 10:55
 * Version: 1.0
 * Description: 类说明
 */
class DownloadActivity:BaseActivity() {
    override fun getLayoutId()= R.layout.activity_download

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btn_down.setOnClickListener {
            //这里直接从IO线程中启动
            launch(Dispatchers.IO) {
                //切换到主线程操作UI
                withContext(Dispatchers.Main)
                {
                    btn_down.visibility=View.GONE
                }
                //切回IO线程创建下载的文件
                val url = et_url.text.toString()
                val file = File(externalCacheDir?.absolutePath+"/hehe.apk")
                file.createNewFile()
                //通过GitHubService.getInstance()可以直接拿到GitHubService对象
                val response:Response<ResponseBody> = GitHubService.getInstance().downloadFile(url).execute()
                val body: ResponseBody = response.body()!!
                if(response.isSuccessful ) 
                {
                    var inStream: InputStream? = null
                    var outStream: OutputStream? = null
                    /*注意,在kotlin中没有受检异常,
                    如果这里不写try catch,编译器也是不会报错的,
                    但是我们需要确保流关闭,所以需要在finally进行操作*/
                    try {
                        //以下读写文件的操作和java类似
                        inStream = body.byteStream()
                        outStream = file.outputStream()
                        //文件总长度
                        val contentLength = body.contentLength()
                        //当前已下载长度
                        var currentLength = 0L
                        //缓冲区
                        val buff = ByteArray(1024)
                        var len = inStream.read(buff)
                        var percent = 0
                        while (len != -1) {
                            outStream.write(buff, 0, len)
                            currentLength += len
                            /*不要频繁的调用切换线程,否则某些手机可能因为频繁切换线程导致卡顿,
                            这里加一个限制条件,只有下载百分比更新了才切换线程去更新UI*/
                            if ((currentLength * 100 / contentLength).toInt() > percent) {
                                percent = (currentLength / contentLength * 100).toInt()
                                //切换到主线程更新UI
                                withContext(Dispatchers.Main) {
                                    tv_download_state.text = "正在下载:$currentLength / $contentLength"
                                }
                                //更新完成UI之后立刻切回IO线程
                            }

                            len = inStream.read(buff)
                        }
                        //下载完成之后,切换到主线程更新UI
                        withContext(Dispatchers.Main) {
                            tv_download_state.text = "下载完成"
                            btn_down.visibility = View.VISIBLE
                        }

                    } catch (e: Exception) {
                        e.printStackTrace()
                    } finally {
                        inStream?.close()
                        outStream?.close()

                    }
                }
                
                
                
            }
        }
    }
}