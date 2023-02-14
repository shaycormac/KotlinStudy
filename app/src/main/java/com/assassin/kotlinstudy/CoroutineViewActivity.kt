package com.assassin.kotlinstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class CoroutineViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_view)
        val manager:FragmentManager = supportFragmentManager
        manager.beginTransaction().add(R.id.fl_container,CoroutineViewFragment.newInstance("","")).commit()
    }
}
