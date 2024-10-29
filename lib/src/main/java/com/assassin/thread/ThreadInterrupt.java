package com.assassin.thread;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/28 14:40
 * Version:     1.0
 * Description: 测试Thread.interrupt() 这个api方法，中断谁呢，和join还不一样
 * join只是那个谁执行到了这个方法，就被迫wait,等待这个join对应的thread对象执行完自己的runnnable才行
 * 这个interrupt目前看是应该打断所对应对象的sleep,wait,join等这样的方法吧
 */
public class ThreadInterrupt {


    //这里用来打印消耗的时间
    private static long time = 0;

    private static void resetTime() {
        time = System.currentTimeMillis();
    }

    private static void printContent(String content) {
        System.out.println(content + "     时间：" + (System.currentTimeMillis() - time));
    }

    public static void main(String[] args) {

        test1();
        // 执行结果
        /*
        *  num : 100000     时间：5
       num : 101000     时间：5
       num : 102000     时间：5
        main线程执行完thread1.interrupt()方法，马上关闭进程！     时间：5
       线程1-当前子线程被isInterrupted了！     时间：5
        * 
        * 
        * */

    }


    private static void test1() {

        Thread1 thread1 = new Thread1();
        thread1.setName("线程1");
        thread1.start();

        //主线程睡了4毫秒后让thread1这个线程中断，目的在于让Thread1有数据产生，好看，interrupt中断
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//注意了，这个是在主线程中调用子线程的对象thread.interrupt()方法，改变它的中断状态位
        thread1.interrupt();
        printContent("main线程执行完thread1.interrupt()方法，马上关闭进程！");

    }


    private static class Thread1 extends Thread {

        @Override
        public void run() {

            resetTime();

            int num = 0;
            while (true) {
//退出while循环的条件，可以看出，如果不设置这个条件，while是不会推出循环的，也就是不会因为状态值的改变，线程就被暴力的中断，所以是一种软中断！！
                if (isInterrupted()) {
                    printContent(Thread.currentThread().getName() + "-当前子线程被isInterrupted了！");
                    break;
                }

                num++;


                //当前的子线程的sleep一下，所以在看代码的执行的时候，一定要看当前是哪个线程在执行这行代码啊！！
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



                if (num % 1000 == 0) {
                    printContent("num : " + num);
                }
            }

        }

    }
}
