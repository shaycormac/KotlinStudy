package com.assassin.kotlinstudy.delegate

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/09 22:44
 * Version:     1.0
 * Description: HomeWork是作业 ，黄樟和雷军都应该去实现这里面的方法，写作业，但是呢
 * 雷军是学霸，它委托作业让黄樟帮他写，自己玩游戏，美滋滋
 * 类委托的核心思想是将一个类的一些具体实现委托给另一个类去完成
 */
interface HomeWork {

    fun doHomeWork()
}

class HuangZhang : HomeWork {
    override fun doHomeWork() {
        println("我是黄樟，我在苦逼的写作业")
    }
}

// 雷军把这个homeWork 委托给 homework这个冤大头来做了
class LeiJun(homework: HomeWork) : HomeWork by homework


fun main() {
    val huangZhang: HuangZhang = HuangZhang()
    val leiJun: LeiJun = LeiJun(huangZhang)
    // 实际上是被黄樟干活了！！
    leiJun.doHomeWork()
}