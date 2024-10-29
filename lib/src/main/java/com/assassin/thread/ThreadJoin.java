package com.assassin.thread;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/28 13:50
 * Version:     1.0
 * Description: 测试线程对象api的join()用法
 */
public class ThreadJoin {


    public static void main(String[] args) {

        // 这里面都是主线程在执行
        System.out.println("我是主线程:" + Thread.currentThread().getId() + ":开始干活");
        JoinThread joinThread = new JoinThread();
        joinThread.start();
        // 主线程执行到了joinThread的join()方法
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 如果没有上面的join方法延时执行，那么主线程执行完代码应该立刻结束线程
        // 有了之后，会执行完子线程的run方法，才会继续执行主线程的方法


    }


    private static class JoinThread extends Thread {

        @Override
        public void run() {
            super.run();
            // 模拟这个子线程要干活5秒中
            try {
                System.out.println("当前线程:" + Thread.currentThread().getId() + ":开始干活");
                Thread.sleep(5000);
                System.out.println("当前线程干活完毕：花费了5秒钟");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
