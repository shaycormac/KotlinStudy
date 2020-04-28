package com.assassin.kotlinstudy.designpattern.observe;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-26 09:15
 * Version: 1.0
 * Description: 观察者接口，对外提供方法，来改变自己，它是一对多中的多，
 * 子类实现它，通过实现接口定义的方法，并处理自己属性里面的一些事情
 */
public interface Observe {
    
     void updateMessage(String message);
}
