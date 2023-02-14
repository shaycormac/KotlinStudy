package com.assassin.singleton;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/02 10:31
 * Version:     1.0
 * Description: 用来测试各种单例
 */
class TestSingleTon {
	// 普通方法与同步方法执行代码耗时比较
	static int syncCur = 0;
	static int normalCur = 0;

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, IOException, ClassNotFoundException {

		//测试并发执行，验证单例是唯一的对象
		
	//	ConcurrentTest.init(ConcurrentTest.TYPE_DOUBLE_CHECK);

		//反射获取到类就和之前的不一样了，这叫做破坏单例
		//System.out.println("获取正常调用内部静态类的实例："+StaticInnerClassSingleTon.getInstance());
		//breakSingleton();

		// 验证静态内部类的加载时机-调用方法的时候才加载

		//对于静态内部类，此时并没有加载
		//StaticInnerClassSingleTon.getInstance();
	//	lookClassInJVM();
	//	HungrySingleTon singlton = HungrySingleTon.getSingleTon();
	//	StaticInnerClassSingleTon.getInstance();
		//StaticInnerClassSingleTon.getTest();
		//lookClassInJVM();
		


		// 尝试破坏枚举单例
		//tryBreadEnum();
		tryBreadEnumWithParam();
		
		//测试普通方法与同步方法的耗时比较。
		//syncTest(1000,2000000);
		//normalTest(1000,20000);

	/*	ThreadGroup currentGroup =
				Thread.currentThread().getThreadGroup();
		int noThreads = currentGroup.activeCount();
		Thread[] lstThreads = new Thread[noThreads];
		currentGroup.enumerate(lstThreads);
		for (int i = 0; i < noThreads; i++)
			System.out.println("线程号：" + i + " = " + lstThreads[i].getName());*/
		
		// 测试序列化
		/*HungrySingleTon singleTon =HungrySingleTon.getSingleTon();
		System.out.println("获取到的饿汉式单例为："+singleTon);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
		oos.writeObject(singleTon);
		oos.close();
		//反序列化
		File file = new File("template");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		HungrySingleTon singleTon2 = (HungrySingleTon) ois.readObject();
		System.out.println("通过反序列化获取到的饿汉式单例为："+singleTon2);*/


		/*EnumSingleTon enumSingleTon =EnumSingleTon.INSTANCE;
		System.out.println("获取到的枚举单例为："+enumSingleTon);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
		oos.writeObject(enumSingleTon);
		oos.close();
		//反序列化
		File file = new File("template");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		EnumSingleTon enumSingleTon2 = (EnumSingleTon) ois.readObject();
		System.out.println("通过反序列化获取到的枚举单例为："+enumSingleTon2);*/



	}

	/**
	 * 查看此时加载到虚拟机的类
	 *
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	private static void lookClassInJVM() throws NoSuchFieldException, IllegalAccessException {
		Field f = ClassLoader.class.getDeclaredField("classes");
		f.setAccessible(true);
		Vector<?> classes = (Vector) f.get(ClassLoader.getSystemClassLoader());
		System.out.println("此时虚拟机中的类为：" + classes);
	}

	/**
	 * 破坏静态内部类的单例
	 *
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static void breakSingleton() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class<?> clazz = StaticInnerClassSingleTon.class;
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		StaticInnerClassSingleTon anotherOne = (StaticInnerClassSingleTon) constructor.newInstance();
		System.out.println("通过破坏内部静态类单例，生成了另外一个对象：" + anotherOne);
	}

	/**
	 * 尝试反射获取Enum的空构造方法
	 *
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	private static void tryBreadEnum() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

		// 获得其空参构造器
		Constructor<EnumSingleTon> declaredConstructor = EnumSingleTon.class.getDeclaredConstructor(null);
		// 使得可操作性该 declaredConstructor 对象
		declaredConstructor.setAccessible(true);
		// 反射实例化
		EnumSingleTon ideal2 = declaredConstructor.newInstance();

		System.out.println(ideal2);
	}

	/**
	 * 尝试反射获取Enum的带有两个参数的构造方法
	 *
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	private static void tryBreadEnumWithParam() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

		// 获取Enum的带有两个参数的构造方法
		Constructor<EnumSingleTon> declaredConstructor = EnumSingleTon.class.getDeclaredConstructor(String.class, int.class);
		// 使得可操作性该 declaredConstructor 对象
		declaredConstructor.setAccessible(true);
		// 反射实例化
		EnumSingleTon ideal2 = declaredConstructor.newInstance();

		System.out.println(ideal2);
	}

	public static void syncTest(int size, int count) {
		long now = System.currentTimeMillis();

		for (int i = 0; i < size; i++) {
			new Thread(() -> {
				while (syncCur < count) {
					synchronized ("syncTest") {
						syncCur++;
					}
					if (syncCur == count) {
						System.out.println("syncTime:" + (System.currentTimeMillis() - now));
					}
				}
			}).start();
		}
	}

	public static void normalTest(int size, int count) {
		long now = System.currentTimeMillis();

		for (int i = 0; i < size; i++) {
			new Thread(() -> {
				while (normalCur < count) {

					normalCur++;
					
					if (normalCur == count) {
						System.out.println("normalTime:" + (System.currentTimeMillis() - now));
					}
				}
			}).start();
		}
	}
}
