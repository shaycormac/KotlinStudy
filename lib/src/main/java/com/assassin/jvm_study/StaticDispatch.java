package com.assassin.jvm_study;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/16 10:35
 * Version:     1.0
 * Description: 注意这个是重载，不是重写，不要搞混了，和多态暂时没有关系
 * 
 * 我们把上面代码中的“Human”称为变量的“静态类型”(Static Type)，或者叫“外观类 型”(Apparent Type)，
 * 后面的“Man”则被称为变量的“实际类型”(Actual Type)或者叫“运行时类 型”(Runtime Type)。
 * 静态类型和实际类型在程序中都可能会发生变化，区别是静态类型的变化仅仅 在使用时发生，变量本身的静态类型不会被改变，
 * 并且最终的静态类型是在编译期可知的;而实际类 型变化的结果在运行期才可确定，编译器在编译程序的时候并不知道一个对象的实际类型是什么。
 * 
 */
class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }

    /**
     * hello,guy!
     * hello,guy!
     */
}
