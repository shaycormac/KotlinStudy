package com.assassin.kotlinstudy.mvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/4 0004 14:20
 * Version: 1.0
 * Description: 创建数据访问类，也就是DAO
在实际项目开发中，如果你有一个bean对象，你通常需要将它保存到数据库中（如果需要使用sqlite数据库，你可以使用相关组件ROOM），
DAO类就是用于操作数据库的接口。但是本文主要介绍MVVM架构的体系，对于数据库操作以后的教程会展示，为了简便起见，
我们是做一个列表来模拟一个假数据库
---------------------
作者：夜枫狂
来源：CSDN
原文：https://blog.csdn.net/weixin_44407870/article/details/85864927
版权声明：本文为博主原创文章，转载请附上博文链接！
 */
class BookDao
{
    //用list模拟一个假的数据库表
    private val bookList = mutableListOf<Book>()
    //LiveData是Architecture 组件的重要部分，它可以监听值的改变
    //MutableLiveData是LiveData的子类，它的值可以被改变，而LiveData的值不能被修改
    private val books = MutableLiveData<List<Book>>()
    
    init {
        books.value=bookList
    }

    fun addBook(book: Book): Unit {
        //模仿添加到本地数据库
        bookList.add(book)
        //重新取值
        books.value = bookList
    }

    //这里返回值是LiveData而不是MutableLiveData，因为我们不想其他的类能修改它的值
    //解释的牛逼
    fun getBooks(): LiveData<List<Book>> {
        return books
    }
}