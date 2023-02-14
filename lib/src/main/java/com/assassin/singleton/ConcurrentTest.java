package com.assassin.singleton;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/02 10:36
 * Version:     1.0
 * Description: 测试并发的工具，这个工具呢，首先要确保调用init（）方法的那个线程把countDownLatch.countDown()前面的代码执行完毕后，
 * 才继续执行在前面并发出来的那么多的子线程要干的活，一句话，保证调用的线程先处理完，再真正执行所以的子线程干活。
 */

import java.util.concurrent.CountDownLatch;


public class ConcurrentTest {

	/**
	 * 定义并发线程数量
	 */
	public static final int THREAD_NUM = 66;

	/**
	 * 开始时间
	 */
	private static long startTime = 0L;
	/**
	 *  测试的类型 ，饿汉、懒汉、doublecheck、静态内部类、枚举
	 */
	private static int sType;
	
	public static final int TYPE_HUNGRY =1;
	public static final int TYPE_LAZY_1 =2;
	public static final int TYPE_LAZY_2 =3;
	public static final int TYPE_LAZY_3 =4;
	public static final int TYPE_DOUBLE_CHECK =5;
	public static final int TYPE_STATIC_INNER =6;
	public static final int TYPE_ENUM =7;
	

	
	public static void init(int type) {
		try {

			sType =type;
			startTime = System.currentTimeMillis();
			//System.out.println("CountDownLatch started at: " + startTime);

			// 初始化计数器为1
			CountDownLatch countDownLatch = new CountDownLatch(1);

			for (int i = 0; i < THREAD_NUM; i++) {
				new Thread(new MyRunnable(countDownLatch)).start();
			}

			// 启动多个线程
			// 这段代码在调用者的线程中执行，譬如在本例子中的main方法中执行，那么在这里减1了，
			// 那么可以理解完主线程执行完后，开始执行那些子线程的东西
			System.out.println("执行完当前线程的工作，才会执行子线程的真正干活时间："+Thread.currentThread().getName());
			countDownLatch.countDown();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	
	private static class MyRunnable implements Runnable {
		private final CountDownLatch startLatch;

		public MyRunnable(CountDownLatch startLatch) {
			this.startLatch = startLatch;
		}

		@Override
		public void run() {
			try {
				// 当前的线程等待
				startLatch.await();
				System.out.println("开始执行当前线程的工作："+Thread.currentThread().getName());
				/*
				 这里调用你要测试的东西
				 */
				switch (sType){
					case TYPE_HUNGRY:
						// 直接打印的对象是 类名+@+hashcode 其中hashcode是16进制的，总共有8位数，由于一个16进制的占用二进制的4位，总共为32位，8位是一个字节，所以呢，一个对象的变量占用4个字节
						System.out.println("执行线程："+Thread.currentThread().getName()+"--获取的饿汉式的实例:"+HungrySingleTon.getSingleTon());
						break;
					case TYPE_LAZY_1:
						System.out.println("执行线程："+Thread.currentThread().getName()+"--获取的单线程懒汉的实例:"+LazySingleTon1.getInstance());
						break;
					case TYPE_LAZY_2:
						System.out.println("执行线程："+Thread.currentThread().getName()+"--获取的暴力锁的实例:"+LazySingleTon2.getInstance());
						break;
					case TYPE_LAZY_3:
						System.out.println("执行线程："+Thread.currentThread().getName()+"--获取的小锁的实例:"+LazySingleTon3.getInstance());
						break;
					case TYPE_DOUBLE_CHECK:
						System.out.println("执行线程："+Thread.currentThread().getName()+"--获取的双重校验的实例:"+DoubleCheckSingleTon.getInstance());
						break;
					case TYPE_STATIC_INNER:
						System.out.println("执行线程："+Thread.currentThread().getName()+"--获取的静态内部类的实例："+StaticInnerClassSingleTon.getInstance());
						break;
					case TYPE_ENUM:
						System.out.println("执行线程："+Thread.currentThread().getName()+"--获取的枚举的实例："+EnumSingleTon.INSTANCE);
						break;
					default:
						break;
				}
				
			
				// 测量每个线程执行消耗的时间
			//	long endTime = System.currentTimeMillis();
			//	System.out.println(Thread.currentThread().getName() + " ended at: " + endTime + ", cost: " + (endTime - startTime) + " ms.");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}

