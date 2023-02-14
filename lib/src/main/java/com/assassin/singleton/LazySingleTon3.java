package com.assassin.singleton;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/05 13:38
 * Version:     1.0
 * Description: 减小锁的范围，减少耗时，但是却带来了同步不安全的问题
 */
class LazySingleTon3 {

	private static LazySingleTon3 singleTon3 =null;
	private LazySingleTon3() {
		System.out.println("我是懒汉式方式三的实例构造方法，我被线程："+Thread.currentThread().getName()+"调用并开始自己的初始化");

	}

	/**
	 *  似乎解决了暴力加锁的方法，但是这里面还是有问题的，如果同时有多个线程进入了null==singleTon3的判断里，就会生成多个单例
	 * @return
	 */
	public  static LazySingleTon3 getInstance(){
		if (singleTon3==null){
			//
			synchronized (LazySingleTon3.class){
				singleTon3 =new LazySingleTon3();
			}
			
		}

		return singleTon3;

	}
}
