package com.assassin.kotlinstudy.collection

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-03 09:22
 * Version: 1.0
 * Description: List 集合 学习 api 学习
 */

val list : MutableList<String> = mutableListOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")

val stringList = mutableListOf<String?>(null,"","a","b","aa","da")

fun main() {
    //切片  slice
   val list1 =list.slice(IntRange(2,3))
    println(list1.toString())//[c, d]
    
   val list2 =  list.slice(listOf(1,3,5,7,9))
    println(list2.toString())//[b, d, f, h, j]
    
    //过滤集合中需要的数据
    val list3 = list.filter { 
        it=="c"
    }
    println(list3.toString())//[a]

    val list4= list.filterTo(mutableListOf())
    {
        it.startsWith("z")
    }
    println(list4.toString()) //[z]
//筛选出集合中前五个元素,同时字符串以z开头的元素。
    val list5=list.filterIndexed { index, s -> 
        index<5 && s.startsWith("z")
    }
    println(list5.toString())//[]
    
    //反向过滤
    val list6=  stringList.filterNot { 
        it?.startsWith("a")?:false
    }
    println(list6.toString())//[null, , b, da]

    val list7=stringList.filterNotNull()
    println(list7.toString())//[, a, b, aa, da],包括空字符串
    //根据传入数值n，表示从左到右顺序地删除n个集合中的元素，并返回集合中剩余的元素
    val list8  = stringList.drop(3)
    println(list8.toString())//[b, aa, da]
//根据传入数值n，表示从右到左倒序地删除n个集合中的元素，并返回集合中剩余的元素。
    val list9  = stringList.dropLast(3)
    println(list9.toString())//[null, , a]
    //从原集合的第一项开始顺序取集合的元素，取n个元素，最后返回取出这些元素的集合。换句话说就是取集合前n个元素组成新的集合返回。
    val list10 = list.take(5)
    println(list10.toString())//[a, b, c, d, e]

    val list11 = list.takeLast(5)
    println(list11.toString())//[v, w, x, y, z]
}
