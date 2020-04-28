package com.assassin.kotlinstudy.jvm;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-17 10:26
 * Version: 1.0
 * Description: 测试类加载器的加载类的策略
 */
public class LoadClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = HelloWord.class.getClassLoader();
        System.out.println(classLoader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块 ,
        //只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
        //注意这个类就是 LoadTes类，和目前这个类位于同一个包名下
        // classLoader.loadClass("com.assassin.kotlinstudy.jvm.LoadTes");

        //使用Class.forName()来加载类，默认会执行初始化块 
        //将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块；
        //会打印那段代码
        Class.forName("com.assassin.kotlinstudy.jvm.LoadTes");

        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块 
        //带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象 。
        Class.forName("com.assassin.kotlinstudy.jvm.LoadTes", false, classLoader);
    }
}

