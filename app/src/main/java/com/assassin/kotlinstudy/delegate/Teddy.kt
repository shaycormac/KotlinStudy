package com.assassin.kotlinstudy.delegate

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-09-27 13:46
 * Version: 1.0
 * Description: 代理类，相对于Java笨拙的全部代理，
 * https://github.com/heimashi/kotlin_tips/blob/master/README.md
 * 通过继承的实现容易导致脆弱性，例如如果需要修改其他类的一些行为，这时候Java中的一种策略是采用装饰器模式：
 * 创建一个新类，实现与原始类一样的接口并将原来的类的实例作为一个成员变量。 与原始类拥有相同行为的方法不用修改，只需要直接转发给原始类的实例
 * 
 * 通过by关键字将接口的实现委托给dog成员变量，需要修改的函数再去override就可以了，
 * 通过类委托将10行代码就可以实现上面接近100行的功能，简洁明了，去掉了模版代码。
 * 
 * 用类委托来快速实现装饰器模式
 */
class Teddy constructor(dog: Dog) :Animal by dog
{
    override fun eat(food: String): String {
        println("泰迪狗只吃$food")
        return "泰迪狗只吃$food"
    }
    // 其余的函数你看不写不也是没有报错嘛。直接代理给Dog去搞了
}