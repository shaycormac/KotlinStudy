package com.assassin.kotlinstudy.mvvm.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.assassin.kotlinstudy.R
import com.assassin.kotlinstudy.mvvm.data.Book
import kotlinx.android.synthetic.main.activity_mvvm.*

class MvvmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)

        initUI()
    }

    private fun initUI() {
        //得到工厂类  通过factory生成ViewModel，这是标准写法
        val factory:BooksViewModelFactory = InjectorUtils.provideBookViewModelFactory()
        val viewModel:BooksViewModel = ViewModelProvider(this, factory).get(BooksViewModel::class.java)
        //通过LiveData监听数据改变实现对页面显示的改变
        viewModel.getBooks().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it?.forEach {
                stringBuilder.append("$it\n\n")
            }
            textView_books.text = stringBuilder.toString()
        })

        //通过此操作模拟数据变化
        button_add_quote.setOnClickListener {
            //点击时操作ViewModel而不是直接操作textView_books
            val book = Book(editText_book_name.text.toString(), editText_author_name.text.toString())
            viewModel.addBook(book)
            editText_book_name.setText("")
            editText_author_name.setText("")
        }
    }
}
