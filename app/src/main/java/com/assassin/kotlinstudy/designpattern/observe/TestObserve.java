package com.assassin.kotlinstudy.designpattern.observe;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-26 09:36
 * Version: 1.0
 * Description: 类说明
 */
public class TestObserve
{

    public static void main(String[] args) {
        Observable guolin = new GuoLinObservable();
        Observe a = new WeiXinObserve("a");
        Observe b = new WeiXinObserve("b");
        Observe c = new WeiXinObserve("c");
        Observe d = new WeiXinObserve("d");
        Observe e = new WeiXinObserve("e");
        Observe f = new WeiXinObserve("f");
        //被观察者添加观察者
        guolin.addObserve(a);
        guolin.addObserve(b);
        guolin.addObserve(c);
        guolin.addObserve(d);
        guolin.addObserve(e);
        guolin.addObserve(f);
        
        //好了，郭霖要发布新文章了
        guolin.notifyDataChanged("如何好好学Java");
    }
}
