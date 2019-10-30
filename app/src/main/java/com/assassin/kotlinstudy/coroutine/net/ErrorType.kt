package com.assassin.kotlinstudy.coroutine.net

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/29 0029 15:07
 * Version: 1.0
 * Description: 网络请求的错误，三种类型
 * 
 * 当一个网络请求得到的结果并非是你的期望值,我们就可以看作是请求异常,那么请求异常有哪些原因呢,我把请求异常分为三类:
第一类,网络问题,可能是设备网络未连接,连接信号弱,网络拥堵,等等原因,这就是IOException;
第二类,连接服务器问题,我们都知道正常的网络访问结果返回的code是200,如果返回502,404等,那就是服务器,可能是请求地址有问题可能是请求方式有问题或者服务器原因,这种在retrofit中也有表达;
第三类,返回值异常,就是服务器能正常返回给你数据,但是数据不是你想要的,这就是逻辑问题,可能你的参数不对,可能后端处理不对,也可能根据你的请求本身逻辑就应该显示这种异常.这种需要根据你项目具体的接口文档进行决定,需要自行对结果进行判断
好,
---------------------
作者：夜枫狂
来源：CSDN
原文：https://blog.csdn.net/weixin_44407870/article/details/87642687
版权声明：本文为博主原创文章，转载请附上博文链接！
 * 
 */
enum class ErrorType 
{
    NETWORK_ERROR,//网络出错
    SERVICE_ERROR,//服务器访问异常
    RESPONSE_ERROR//请求返回值异常
}