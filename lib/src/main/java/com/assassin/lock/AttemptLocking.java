package com.assassin.lock;



import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/29 13:52
 * Version:     1.0
 * Description:以下是ReentrantLock中断机制的一个代码实现、如果换成synchronized就会出现死锁  
 */
public class AttemptLocking {
	private final ReentrantLock lock = new ReentrantLock();

	/**
	 * 这个方法表示获取锁
	 */
	public void untimed() {
		boolean captured = lock.tryLock();
		try {
			System.out.println("tryLock(): " + captured);
		} finally {
			if (captured)
				lock.unlock();
		}
	}

	/**
	 * 这个表示最多等待2秒中的获取锁，获取不到的话就返回
	 */
	public void timed() {
		boolean captured = false;
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		try {
			System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
		} finally {
			if (captured)
				lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final AttemptLocking al = new AttemptLocking();
		al.untimed(); // True -- 可以成功获得锁  
		al.timed(); // True --可以成功获得锁  
		//新创建一个线程获得锁并且不释放  
		new Thread() {
			{
				setDaemon(true); // 保证这个线程执行完代码后再死掉。
			}

			public void run() {
				al.lock.lock();
				System.out.println("新的子线程获取到了锁，acquired");
			}
		}.start();
		Thread.sleep(100);// 让mian线程睡一会，保证这个新线程能够先执行  
		al.untimed(); // False -- 马上中断放弃  
		al.timed(); // False -- 等两秒超时后中断放弃  
	}
}  
