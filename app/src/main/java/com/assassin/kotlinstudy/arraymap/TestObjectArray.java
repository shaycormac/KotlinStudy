package com.assassin.kotlinstudy.arraymap;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020-01-08 14:28
 * Version: 1.0
 * Description: 测试Object数组，里面的元素应该还是可以在存放数组吧
 */
public class TestObjectArray {

    public static void main(String[] args) {
        Object[] originArray = new Object[4];
        originArray[0]=0x111;
        originArray[1]="我是value";
        originArray[2]= new String[]{"a","b","c"};

        for (int i = 0; i < originArray.length; i++) {
            System.out.println(originArray[i]);
        }
        
      /*  >>(按位右移)，<<(按位左移)，

>>>(按位右移不足补0),表示无符号右移！
        右移表达式的位，不保留符号。
        result = expression1 >>> expression2
        参数
                result
        任何变量。
        expression1
        任何表达式。
        expression2
        任何表达式。

        说明
                >>> 运算符把 expression1 的各个位向右移 expression2 指定的位数。右移后左边空出的位用零来填充。移出右边的位被丢弃。例如：

        var temp

        temp = -14 >>> 2变量 temp 的值为 -14 （即二进制的 11111111 11111111 11111111 11110010），向右移两位后等于 1073741820 （即二进制的 00111111 11111111 11111111 11111100）。*/
        int aa = -14 >>>2;
        System.out.println(aa);
    }
}
