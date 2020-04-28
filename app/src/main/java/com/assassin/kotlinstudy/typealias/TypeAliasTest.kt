package com.assassin.kotlinstudy.`typealias`

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-02 09:55
 * Version: 1.0
 * Description: 
 * 
 *   typealias实质原理，大部分情况下是在编译时期采用了逐字替换的扩展方式，还原成真正的底层类型；
 *   但是不是完全是这样的，譬如下面的例子，并没有逐字替换
 */
class Human(val name:String)

typealias LaoZhang = Human?
// Constructing with the alias: 使用别名来构造对象
val laoZhang:LaoZhang = LaoZhang("nima")

//上面的代码不会逐步替换成下面的，🧬都通不过
// The above code does *not* expand verbatim to this (which wouldn't compile):(以上代码不会是逐字扩展成如下无法编译的代码)
//val laoZhang1=Human?("nima")
//Instead, it expands to this:(而是扩展如下代码)
val laoZhang1:Human = Human("nima")


//再看一个伴生对象
// 我们再次看到Kotlin并不总是逐字替换扩展的，特别是在其他情况下是有帮助的。
class Container<T>(var item: T) {
    companion object {
        const val classVersion = 5
    }
}

// Note the concrete type argument of String(注意此处的String是具体的参数类型)
typealias BoxedString = Container<String>

// Getting a property of a companion object via an alias:（通过别名获取伴侣对象的属性：）
val version = BoxedString.classVersion

// The line above does *not* expand to this (which wouldn't compile):(这行代码不会是扩展成如下无法编译的代码)
//val version2= Container<String>.classVersion

// Instead, it expands to this:（它是会在即将进入编译期会扩展成如下代码）
//val version= Container.classVersio
