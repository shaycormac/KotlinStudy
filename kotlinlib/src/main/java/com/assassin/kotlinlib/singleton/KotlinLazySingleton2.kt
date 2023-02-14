package com.assassin.kotlinlib.singleton

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/13 14:33
 * Version:     1.0
 * Description: 懒汉式第一种写法，线程安全的么，但是在方法上加锁，牺牲效率
 */
class KotlinLazySingleton2 private constructor(){
    
    companion object{
        private var instance:KotlinLazySingleton2? = null
        get() {
            if (field==null){
                field = KotlinLazySingleton2()
            }
            return field
        }
        
        @Synchronized
        fun getSingleton():KotlinLazySingleton2{
            return instance !!
        }
    }
}