package com.assassin.kotlinlib.singleton

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/13 14:33
 * Version:     1.0
 * Description: 懒汉式第一种写法，线程不安全
 */
class KotlinLazySingleton1 private constructor(){
    
    companion object{
        private var instance:KotlinLazySingleton1? = null
        get() {
            if (field==null){
                field = KotlinLazySingleton1()
            }
            return field
        }
        
        fun getSingleton():KotlinLazySingleton1{
            return instance !!
        }
    }
}