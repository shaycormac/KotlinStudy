package com.assassin.kotlinstudy.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-19 16:11
 * Version: 1.0
 * Description: 类说明
 */
public class Wanger {
    public static int count = 0;

    public static int getCount() {
        return count;
    }

    //没有加锁之前，肯定会有问题的，资源竞争问题
   /* public static void addCount() {
        count++;
    }*/

   //加上锁之后，缓解了
    public static void addCount() {
        // 上锁
        Lock writeLock = Locker.INSTANCE.writeLock();
        writeLock.lock();
        count++;
        // 释放锁
        writeLock.unlock();
    }


    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 1000,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));


        for (int i = 0; i < 1000; i++) {
            Runnable r = new Runnable() {

                @Override
                public void run() {
                    Wanger.addCount();
                }
            };
            executorService.execute(r);
        }
        executorService.shutdown();
        System.out.println(Wanger.count);
    }
}

