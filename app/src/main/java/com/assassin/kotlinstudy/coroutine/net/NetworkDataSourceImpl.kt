package com.assassin.kotlinstudy.coroutine.net

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.content.Context
import com.assassin.kotlinstudy.coroutine.bean.LoginObject
import com.assassin.kotlinstudy.coroutine.bean.LoginResult
import com.assassin.kotlinstudy.coroutine.util.Convert
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/29 0029 17:04
 * Version: 1.0
 * Description: 类说明
 */
class NetworkDataSourceImpl(private val gmApiService: GMApiService, private val context: Context):NetworkDataSource {
    //请求错误结果,这里的SingleLiveData是继承自LiveData,当读取error信息之后自动清空其中的信息,防止下一个观察者读取到之前的错误信息
    private val _errorResult:SingleLiveData<ErrorResponse> = SingleLiveData<ErrorResponse>()
    
    
    // 这个用于给外界使用,LiveData值无法在修改,MutableLiveData才可以修改,防止其他类修改值
    override val errorResult: LiveData<ErrorResponse>
        get() = _errorResult
    
    override suspend fun userLogin(param: LoginObject): LiveData<LoginResult>
    {
      return  handleRequest("用户登录") {
           gmApiService.loginGM(Convert.toJson(param)).execute()
       }
    }


    /**
     * 统一处理请求错误以及向LiveData发送数据
     * 这是一个高阶函数,第一个参数用于标识是哪个网络请求
     * 第二个参数就是一个方法(这和javaScript中把方法当作参数传递类似)
     * 这个BaseResult是用来判断业务逻辑失败的,根据项目实际情况自行定义,下面"description"和"code"来自于BaseResult
     * 
     *  ---------------------
    作者：夜枫狂
    来源：CSDN
    原文：https://blog.csdn.net/weixin_44407870/article/details/87642687
    版权声明：本文为博主原创文章，转载请附上博文链接！
     */
   
    private suspend fun<T> handleRequest(tag:String,action:() -> Response<T>):LiveData<T>
    {
        val liveData = MutableLiveData<T>()
        withContext(Dispatchers.IO)
        {
            try {
                val response:Response<T> = action()
                if (response.isSuccessful)
                {
                    //取得结果的值。
                    val body: T? = response.body()
                    //这个根据具体前后端接口协议来定
                    if (body != null )
                    {
                        liveData.postValue(body)
                        
                    }else
                    {
                        //逻辑异常通过实际项目中具体制定的前后端接口文档来决定,我们将异常结果发送出去
                        _errorResult.postValue(
                                ErrorResponse(
                                        ErrorType.RESPONSE_ERROR,
                                        tag,
                                        null,
                                        "第三层的原因"
                                )
                        )
                    }
                    
                }else
                {
                    //这表示请求结果非200,服务器异常,将错误信息和响应码发送出去
                    _errorResult.postValue(
                            ErrorResponse(
                                    ErrorType.SERVICE_ERROR,
                                    tag,
                                    response.code(),
                                    response.message()
                            )
                    )
                }
                
                
            }catch (e:Exception)
            {
                //如果有IO异常,那说明是网络有问题,直接将错误信息的值发送出去
                e.printStackTrace()
                _errorResult.postValue(ErrorResponse(ErrorType.NETWORK_ERROR,tag,null,e.toString()))
            }
        }
        return  liveData
    }
}