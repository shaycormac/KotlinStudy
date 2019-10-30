package com.assassin.kotlinstudy.mvvm.ui

import com.assassin.kotlinstudy.mvvm.data.BookRepository
import com.assassin.kotlinstudy.mvvm.data.DataBase

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/4 0004 14:46
 * Version: 1.0
 * Description: 
 * 通过依赖注入连接ViewModelFactory和Repository
来理一理前面的关系，数据层：Dao直接操作底层数据，DataBase管理Dao，Repository需要使用Dao操作数据，所以他先要获取DataBase对象
ViewModel层：
ViewModel来控制UI显示，但是ViewModel需要通过ViewModelFactory来产生实例，ViewModelFactory需要依赖Repository
那么现在应该创建一个依赖注入类，来连接所有的关系了，同样，该类也应该是单例，因为无需参数，我们直接使用object来创建单例
 */
object InjectorUtils
{
    fun provideBookViewModelFactory(): BooksViewModelFactory 
    {
        val repository: BookRepository = BookRepository.getInstance(DataBase.getInstance().bookDao)
        return BooksViewModelFactory(repository)
    }
}