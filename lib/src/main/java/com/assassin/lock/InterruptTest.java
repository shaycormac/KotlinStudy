package com.assassin.lock;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/29 17:43
 * Version:     1.0
 * Description: 测试interrupt这个类
 */
public class InterruptTest {
	//这里用来打印消耗的时间
	private static long time = 0;
	private static void resetTime(){
		time = System.currentTimeMillis();
	}
	private static void printContent(String content){
		System.out.println(content + "     时间：" + (System.currentTimeMillis() - time));
	}

	public static void main(String[] args) {

		test1();

	}

	private static void test1(){

		Thread1 thread1 = new Thread1();
		thread1.setName("线程1");
		thread1.start();

		//主线程延时100毫秒后让thread1这个线程中断，interrupt中断
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread1.interrupt();
		printContent("执行中断");

	}

	private static class Thread1 extends Thread{

		@Override public void run() {

			resetTime();

			int num = 0;
			while (true){
				if(isInterrupted()){
					printContent(Thread.currentThread().getName()+"-当前线程 isInterrupted");
					break;
				}

				num++;

				//当前的子线程的sleep一下
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if(num % 10000 == 0){
					printContent("num : " + num);
				}
			}

		}

	}

}

