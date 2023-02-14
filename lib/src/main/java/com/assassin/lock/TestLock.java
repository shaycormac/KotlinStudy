package com.assassin.lock;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/07 14:09
 * Version:     1.0
 * Description: 简述一下这个类要做的事情
 */
class TestLock {

	public static void main(String[] args) {
		
		TestLock lock =new TestLock();
		
		new Thread(() -> lock.testWait()).start();
		
		new Thread(() -> {
			
			lock.testNotify();
			
		}).start();
	}



	public void testWait(){
		synchronized (this){
			System.out.println(Thread.currentThread().getName()+"--我获取了锁，我要马上进入wait了");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--执行完了wait方法，在锁以内");

		}
		System.out.println(Thread.currentThread().getName()+"--执行完了synchronized方法，在锁以外");
	}
	
	public void testNotify(){
		synchronized (this){
			System.out.println(Thread.currentThread().getName()+"--要求释放锁，马上调用NotifyAll");
			notifyAll();
		}
	}
}
