package com.assassin.kotlinstudy.function

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/10/30 0030 10:52
 * Version: 1.0
 * Description: 
 * 
 * 解构声明是把一个对象看成一组单独的变量，有时候我们把一个对象看成一组单独的变量管理会变得更加简单。
 * 注意: 支持解构声明的对象的类必须是数据类(使用data关键字修饰的类),因为只有data class才会生成对应的component()方法(这个会在后续中讲解到)，
 * data class中的每个属性都会有对应的component()方法对应
 * 
 * 
 * 解构声明的对象类型一定是data class，普通的class是不会生成对应的component的方法。

 */
class ComponentTest 
{
    /**
     * 
     */
    fun zhang(x: Any, y: Any): Unit {
        
        
    }
}

fun main()
{
    val student = Student("mikyou", 18, 99.0F)
    val (name,age,score) = student
    println("my name is $name , I'm $age years old, I get $score score")
    
}


data class Student(var name:String,var age:Int,var grade:Float)