package com.assassin.singleton;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/03 20:30
 * Version:     1.0
 * Description: 双重锁校验
 */
class DoubleCheckSingleTon {
	private static volatile DoubleCheckSingleTon singleTon;

	private DoubleCheckSingleTon() {
		System.out.println("我是双重锁校验的实例构造方法，我被线程："+Thread.currentThread().getName()+"调用并开始自己的初始化");

	}

	public static DoubleCheckSingleTon getInstance() {

		if (singleTon == null) {
			synchronized (DoubleCheckSingleTon.class) {
				if (singleTon == null) {
					singleTon = new DoubleCheckSingleTon();
				}
			}
		}
		return singleTon;
	}

	
}
