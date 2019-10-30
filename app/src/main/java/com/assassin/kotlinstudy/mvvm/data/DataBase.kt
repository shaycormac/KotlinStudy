package com.assassin.kotlinstudy.mvvm.data

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/4 0004 14:25
 * Version: 1.0
 * Description: 创建database类
在实际生产开发中，一个数据库可能有多个DAO，因为有多张表，例如在聊天的应用中，需要关注用户和用户组，你就已经有两个DAO了
所以需要建立一个Database类来管理所有的Dao，同时拥有两个数据库实例没有意义，所以Database实例应该是单例模式
尽管Kotlin可以通过object关键字来创建单例类，但是通常在实际生产中不适用，因为如果使用object关键字，你无法给构造函数传参，
但实际生产开发中，你需要给ROOM传递Context参数，为了避免这个问题，需要使用类似于java方式来创建单例
---------------------
作者：夜枫狂
来源：CSDN
原文：https://blog.csdn.net/weixin_44407870/article/details/85864927
版权声明：本文为博主原创文章，转载请附上博文链接！
 */
class DataBase private constructor()
{
    //得到dao操作表
    var bookDao:BookDao=BookDao()
        private set

    companion object {
        //@Volatile  - 表示写入此属性对其他线程立即可见
        @Volatile
        private var instance: DataBase? = null

        fun getInstance(): DataBase {
            return instance?: synchronized(this)
            {
                instance?:DataBase().also {
                    instance = it
                }
            }
        }

    }
}