package com.assassin.jvm_study;

import java.io.Serializable;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/16 10:09
 * Version:     1.0
 * Description: 需要注意Javac编译器虽然能确定出方法的重载版本，但在很多情况下这个重载版本并不是“唯 一”的，
 * 往往只能确定一个“相对更合适的”版本。这种模糊的结论在由0和1构成的计算机世界中算是个 比较稀罕的事件，
 * 产生这种模糊结论的主要原因是字面量天生的模糊性，它不需要定义，所以字面量 就没有显式的静态类型，
 * 它的静态类型只能通过语言、语法的规则去理解和推断。下面代码演示了 何谓“更加合适的”版本。
 * 
 * 其实可以通过编译器智能的推导出来了，牛逼
 * 
 * 
 */
class OverloadStudy {


    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    public static void sayHello(char... arg) {
        System.out.println("hello char ...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }

    /**
     * 代码清单8-7演示了编译期间选择静态分派目标的过程，这个过程也是Java语言实现方法重载的本 质。
     * 演示所用的这段程序无疑是属于很极端的例子，除了用作面试题为难求职者之外，在实际工作中 几乎不可能存在任何有价值的用途，
     * 笔者拿来做演示仅仅是用于讲解重载时目标方法选择的过程，对 绝大多数下进行这样极端的重载都可算作真正的“关于茴香豆的茴有几种写法的研究”。
     * 无论对重载的 认识有多么深刻，一个合格的程序员都不应该在实际应用中写这种晦涩的重载代码。
     */
}
