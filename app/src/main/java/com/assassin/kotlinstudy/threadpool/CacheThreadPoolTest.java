package com.assassin.kotlinstudy.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-19 15:18
 * Version: 1.0
 * Description: 类说明
 */
public class CacheThreadPoolTest
{
    public static void main(String[] args) {

        ExecutorService  executorService =Executors.newCachedThreadPool();
        for (int i=0;i<10;i++)
        {
           /* try {
                System.out.println("当前的线程应该是"+Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    //打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName()+"正在被执行");
                }
            });
        }
    }
}
