package com.assassin.kotlinstudy.mvvm.ui

import androidx.lifecycle.ViewModel
import com.assassin.kotlinstudy.mvvm.data.Book
import com.assassin.kotlinstudy.mvvm.data.BookRepository

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/6/4 0004 14:37
 * Version: 1.0
 * Description: 前面已经完成了很多工作了，现在是时候将前面的内容链接到View部分了（也就是Activity或者Fragment），ViewModel就是处于链接的作用， 
 * Activities 和Fragments仅用于在屏幕上显示内容和接收用户操作，所有的逻辑，数据，数据操作都转移到ViewModel中，然后View仅仅调用ViewModel的函数。
 * 我们要实现一些功能还是需要通过Repository类来实现，同样，通过依赖注入的方式传递参数过来
 */
class BooksViewModel(private val bookRepository: BookRepository):ViewModel()
{
    fun addBook(book: Book): Unit {
        bookRepository.addBook(book)
    }

    fun getBooks() = bookRepository.getBooks()
}