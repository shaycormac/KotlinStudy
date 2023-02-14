package com.assassin.singleton;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/05 13:32
 * Version:     1.0
 * Description: 单线程可以，多线程GG，有的场景就没有多线程的话，这个就可以用了
 */
class LazySingleTon1 {
	private static LazySingleTon1 singleTon1 =null;
	private LazySingleTon1() {
		System.out.println("我是懒汉式方式一的实例构造方法，我被线程："+Thread.currentThread().getName()+"调用并开始自己的初始化");
	}
	
	public static LazySingleTon1 getInstance(){
		if (singleTon1==null){
			singleTon1 =new LazySingleTon1();
		}
		
		return singleTon1;
		
	}
}
