package com.assassin.thread;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/03/02 15:01
 * Version:     1.0
 * Description: 测试线程启动次数，不能多次
 */
class ThreadStartCount {

   public static void main(String[] args) {
      Thread thread = new Thread();
      thread.start();
      // 测试连续启动多次试试
      /**
       * Exception in thread "main" java.lang.IllegalThreadStateException
       * 	at java.lang.Thread.start(Thread.java:710)
       * 	at com.assassin.thread.ThreadStartCount.main(ThreadStartCount.java:16)
       */
      thread.start();
   }
}
