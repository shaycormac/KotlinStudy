package com.assassin.function_stack;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2021/04/14 14:37
 * Version:     1.0
 * Description: 简述一下这个类要做的事情
 */
class FunctionStack {


	public static void main(String[] args) {
		int a = 1;
		int ret = 0;
		int res = 0;
		ret = add(3, 5);
		res = a + ret;
		System.out.println("res: " + res);

	}
	public static int add(int x, int y) {
		int sum = 0;
		sum = x + y;
		return sum;
	}


}
