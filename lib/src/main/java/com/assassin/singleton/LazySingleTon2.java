package com.assassin.singleton;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/05 13:35
 * Version:     1.0
 * Description: 暴力的加把锁啊，解决了多线程的同步问题，但是每次调用的时候都会synchronized，非常耗性能，约是普通方法耗时的200倍
 */
class LazySingleTon2 {

	private static LazySingleTon2 singleTon2 =null;
	private LazySingleTon2() {
		System.out.println("我是懒汉式方式二的实例构造方法，我被线程："+Thread.currentThread().getName()+"调用并开始自己的初始化");

	}

	/**
	 *  通过暴力加把锁，似乎可以解决问题，但是执行效率不行了啊，加锁大约需要花费普通方法的200个cpu时间片倍数
	 * @return
	 */
	public synchronized static LazySingleTon2 getInstance(){
		if (singleTon2==null){
			singleTon2 =new LazySingleTon2();
		}

		return singleTon2;

	}
}
