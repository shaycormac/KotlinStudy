package com.assassin.kotlinstudy.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-20 15:09
 * Version: 1.0
 * Description: 实现生产者和消费者同步的生产
 */
public class LockTest {


    //锁
    Lock lock = new ReentrantLock();
    //监视条件
    Condition condition = lock.newCondition();
    //是否还有值
    boolean hasProduct = false;


    public void produce() {
        try {
            //第一步 线程上锁
            lock.lock();
            //如果有货，那么说明需要停止生产
            while (hasProduct) {
                //停止生产
                condition.await();
            }
            //生产东西
            hasProduct = true;
            System.out.println("生产者生产了一个东西");
            //唤醒当前线程
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //最后别忘记要释放锁资源
            lock.unlock();
        }


    }

    public void consume() {
        try {
            lock.lock();
            while (!hasProduct) {
                condition.await();
            }
            hasProduct = false;
            System.out.println("消费者消费一个东西");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        boolean hasProduct = false;
        final LockTest lockTest = new LockTest();
        // 一个线程生产，一个线程消费
        Thread produceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lockTest.produce();
                }

            }
        }, "Produce");

        Thread consumeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lockTest.consume();
                }
            }
        }, "Consume");
        consumeThread.start();
        produceThread.start();

    }


}

