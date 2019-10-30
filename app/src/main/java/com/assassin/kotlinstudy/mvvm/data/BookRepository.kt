package com.assassin.kotlinstudy.mvvm.data

import android.arch.lifecycle.LiveData

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/4 0004 14:31
 * Version: 1.0
 * Description:
 * Repository类是有关数据决策的类，是应该从服务器获取新数据还是使用本地数据？ 需要保留5天的天气数据或仅需3天？ 做出这样的决定是Repository类的工作
   同样，拥有多个Repository对象没有意义，因此它也是一个单例。 这次你需要传递Dao以便实现其功能。使用依赖注入的方式将Dao实例提供给Repository。
   将Dao作为构造参数传给Repository，也许你会觉得为什么不直接在Repository类内部直接初始化Dao呢？这样会破坏程序的可测试性，
   因为你在测试程序时可能需要传递一个模拟的Dao版本给Repository，模拟测试的原则是只在最少的地方将数据修改为模拟数据。
   这是依赖注入背后的核心理念 - 使事物完全模块化和独立。
 */
class BookRepository private constructor(private val bookDao: BookDao)
{
    fun addBook(book: Book): Unit {
        bookDao.addBook(book)
    }

    fun getBooks(): LiveData<List<Book>>
    {
      return bookDao.getBooks() 
    }

    companion object {
        @Volatile
        private var instance: BookRepository? = null

        fun getInstance(bookDao: BookDao): BookRepository {
            return instance?: synchronized(this){
                instance?:BookRepository(bookDao).also { instance = it }
            }
        }

    }
}