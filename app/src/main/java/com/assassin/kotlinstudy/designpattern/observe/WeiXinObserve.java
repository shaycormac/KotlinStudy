package com.assassin.kotlinstudy.designpattern.observe;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-26 09:17
 * Version: 1.0
 * Description: 类说明
 */
public class WeiXinObserve implements Observe {
    private String name;
    private String message;

    public WeiXinObserve(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void updateMessage(String message) {
        //在这里面改变了这个类的某些属性，即被观察者的改变，通知了你，你跟着相应
        this.message = message;
        System.out.println(name+"接受新文章--"+message);
    }
}
