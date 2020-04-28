package com.assassin.kotlinstudy.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-20 14:31
 * Version: 1.0
 * Description: 测试LockSupport
 * 
 *  先park再unpark
 */
public class SupportLockTest 
{
    public static void main(String[] args) throws InterruptedException {

        //先park再unpark
        Thread threadTest = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"我要睡觉了");
                //暂停当前的线程
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+"我要起床了");
            }
        });
        threadTest.setName("threadTest");
        threadTest.start();
        //jvm main线程暂停了10秒钟
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName()+"妈妈喊我起床");
        //唤醒threadTest这个线程，让它继续执行。
        LockSupport.unpark(threadTest);
                
    }
}
