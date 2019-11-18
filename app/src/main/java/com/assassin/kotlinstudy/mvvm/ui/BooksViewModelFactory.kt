package com.assassin.kotlinstudy.mvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assassin.kotlinstudy.mvvm.data.BookRepository

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/4 0004 14:42
 * Version: 1.0
 * Description: 
 * 创建ViewModelFactory
请注意，ViewModel实体必须通过ViewModelProvider来创建，因为上面的BookViewModel的构造方法中包含参数，
所以我们还必须创建ViewModelFactory类提供给ViewModelProvider，以此创建ViewModel实体类
 */
class BooksViewModelFactory (private val repository: BookRepository):ViewModelProvider.NewInstanceFactory()
{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  BooksViewModel(repository) as T
    }
}