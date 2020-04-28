package com.assassin.kotlinstudy.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-26 09:23
 * Version: 1.0
 * Description: 被观察者，它是1，观察者是多, 需要提供几个方法来处理观察者
 */
public interface Observable {
    //简单的用于储存观察者的集合，Java源码的被观察者Observable是一个抽象类，使用Vector集合来储存
    //Vector 类实现了一个动态数组。和 ArrayList 很相似，但是两者是不同的：
    //    Vector 是同步访问的。
    //    Vector 包含了许多传统的方法，这些方法不属于集合框架。
    //Vector 主要用在事先不知道数组的大小，或者只是需要一个可以改变大小的数组的情况。
    //Vector 类支持 4 种构造方法。
    //第一种构造方法创建一个默认的向量，默认大小为 10：
    List<Observe>  observeList = new ArrayList<>();
    //删除观察者
     void removeObserve(Observe observe);
    //添加观察者
    void  addObserve(Observe observe);
    //提供广播，更新所有的观察者
     void notifyDataChanged(String message);
    
}
