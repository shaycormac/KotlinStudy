package com.assassin.singleton;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/02 10:28
 * Version:     1.0
 * Description: 静态内部类单例
 */
public class StaticInnerClassSingleTon {
	
	// 阻止反射破坏单例
	//其实还是不行的，用户可以反射，拿到这个属性，重新给他赋值为false，他妈的，还是给你反射出来了
	private static boolean flag = false;

	private StaticInnerClassSingleTon() {

		System.out.println("我是静态内部类的实例构造方法，我被线程："+Thread.currentThread().getName()+"调用并开始自己的初始化");

		synchronized(StaticInnerClassSingleTon.class){
			//阻止单例破坏
			if(!flag){
				flag = true;
			}else {
				throw new RuntimeException("实例已经存在，请通过 getInstance()方法获取！");
			}
		}
	}

	public static StaticInnerClassSingleTon getInstance() {
		return InnerHolder.instance;
	}
	
	public static StaticInnerClassSingleTon getTest(){
		return  new StaticInnerClassSingleTon();
	}

	private static class InnerHolder {
		static StaticInnerClassSingleTon instance = new StaticInnerClassSingleTon();
	}
}
