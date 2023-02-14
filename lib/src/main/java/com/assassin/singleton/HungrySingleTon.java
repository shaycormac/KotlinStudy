package com.assassin.singleton;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/05 09:57
 * Version:     1.0
 * Description: 饿汉式单例
 */
class HungrySingleTon  {
	private static HungrySingleTon singleTon = new HungrySingleTon();

	private HungrySingleTon() {
		System.out.println("我是饿汉式的实例构造方法，我被线程："+Thread.currentThread().getName()+"调用并开始自己的初始化");
	}
	
	public static HungrySingleTon getSingleTon(){
		
		return singleTon;
	}

	// 解释在未做改动之前，生成了新的实例，单例被破坏的真正原因了。不加这个函数，相当于readObject()调用反射生成了一个新的实例
	/*private Object readResolve()
	{
		return singleTon;
	}*/
}
