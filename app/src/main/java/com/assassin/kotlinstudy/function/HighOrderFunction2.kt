package com.assassin.kotlinstudy.function

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-02 14:47
 * Version: 1.0
 * Description: 类说明
 */


//扩展函数
//你看，这是一个真正执行的函数，等号右侧对参数进行各种操作
fun Int.sampleTest(a:Float,b:Float):Long=this*(a+b).toLong()

//怎么理解函数作为普通变量
// val function :String = "zhang", 类似这样，好理解了吧，至于后面的Int::sampleTest 为函数的引用常用写法

val  functionTest:Int.(Float,Float)->Long = Int::sampleTest

//高阶函数
//需要赋值了，你看，等号右侧开始赋值了吧
fun sampleHighorder(aa:Int.(Float,Float)->Long):Long =3.aa(2f,1f)

/*fun main() {
    println(sampleHighorder(functionTest))
}*/


//个人使用感觉，最后真正执行的函数，是对着参数进行各种工料开撸的，不需要实际的赋值
//而它作为高阶函数的参数后，相反那个高阶函数要在加工的过程中（即等号右侧）进行实际参数传入
//最后一步，在实际引用的时候，可以直接使用了
//注意，作为高阶参数后，只需要类型，不用给每个参数带上一个值了
//函数引用
fun trueFunction(a:Float):Unit =println(a)

//第二个高阶函数
fun abstractFUnction(b:(Float)->Unit):Unit = b(6.0f)

//实际的使用

/*fun main() {
    abstractFUnction (::trueFunction)
}*/

//成员引用和绑定引用
//卧槽，基本的高阶函数还是不会写，死了算了，😂
//函数的基本规则知道吧，先命名，括号里面的函数参数要有个自己名字，然后后面是类型。
class TestParam
{
    fun niDuo(aa:Int)= println(aa)
}

//成员引用
fun test1(a:TestParam.(Int)->Unit ):Unit= TestParam().a(3)
//绑定引用
fun test2(aa:(Int)->Unit):Unit = aa(4)

//使用
fun main() {
    //使用成员引用，即 使用类名引用成员函数（扩展函数）
    //此时TestParam::niduo 的类型为 TestParam.(Int)->Unit
    test1 (TestParam::niDuo)
    
    //绑定引用，即 直接使用对象去引用成员函数（扩展函数）
    //此时 testParam::niduo 的类型为 (Int)->Unit
   val testParam: TestParam= TestParam()
    test2(testParam::niDuo)
     
}
