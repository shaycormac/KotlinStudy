package com.assassin.kotlinstudy.designpattern.observe;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-26 09:29
 * Version: 1.0
 * Description: 类说明
 */
public class GuoLinObservable implements Observable {
    @Override
    public synchronized  void removeObserve(Observe observe) 
    {
        observeList.remove(observe);
        
    }

    //需要将方法进行同步
    @Override
    public synchronized void addObserve(Observe observe) {
        if (!observeList.contains(observe))
        {
            observeList.add(observe);
        }
    }

    @Override
    public void notifyDataChanged(String message) {

        Observe observe;
        int size = observeList.size();
        for (int i = 0; i < size; i++) {
            observe = observeList.get(i);
            observe.updateMessage(message);
            
        }

    }
}
