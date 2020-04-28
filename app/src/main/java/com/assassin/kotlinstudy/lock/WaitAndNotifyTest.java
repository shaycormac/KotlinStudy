package com.assassin.kotlinstudy.lock;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019-12-23 11:11
 * Version: 1.0
 * Description: 锁的测试
 */
public class WaitAndNotifyTest 
{

    public static void main(String[] args) throws InterruptedException {
        MyLock lock = new  MyLock();
        Thread thread1=new Thread(new MyWait(lock));
        Thread thread2=new Thread(new MyWait(lock));
        Thread thread3=new Thread(new MyNotify(lock));
        thread1.start();
        thread2.start();
        Thread.sleep(50);
        thread3.start();
       // Thread.sleep(Integer.MAX_VALUE);
        
    }
    
    private static class MyWait implements Runnable
    {
        
        private final MyLock lock;

        public MyWait(MyLock lock) {
            this.lock = lock;
        }

      
        @Override
        public void run() {
            
            synchronized (lock)
            {
                System.out.println(Thread.currentThread().getName()+"获取了锁，线程执行wait方法，进入等待队列等待了");
                try {
                    //当前线程处于等待
                    lock.wait();
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"线程在wait方法执行完后，开始干活3秒钟后，推出");
                } catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
            
        }
    }


    private static class MyNotify implements Runnable
    {

        private final MyLock lock;

        public MyNotify(MyLock lock) {
            this.lock = lock;
        }


        @Override
        public void run() {

            synchronized (lock)
            {
                System.out.println(Thread.currentThread().getName()+"获取了锁，线程执行notify方法，进入等待队列等待了");
                try {
                    //当前线程处于等待
                    lock.notifyAll();
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+"线程在执行notify同时，需要自己干完活，再释放锁");
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }
    
    
}

class MyLock
{
    private final   Object lock =new Object();

    public Object getLock() {
        return lock;
    }

   
}

