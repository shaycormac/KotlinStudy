package com.assassin;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/02/22 00:24
 * Version:     1.0
 * Description: 递归这个玩意，你可以想象成一个栈，然后递归不是自己调用自己嘛，
 * 从最大函数的压到栈底，一次往上押入次大，次次大的自己函数（参数不同），最后栈顶是函数的边界值
 * <p>
 * 而出栈是从栈顶开始的，就像人的大脑一样，边界值出来，会继续执行次大，再次大，一直到所谓的边界
 */
public class TestDiGui {

    public static void main(String[] args) {

        // 譬如计算一个整形数组的里面元素的和，使用简单的for循环，没问题

        // 递归呢。都是从最大值开始计算，那么 结果Sn是元素的最后一位a[n]和前面的结果相加S【n-1】，对吧 这个是栈底
        // 然后S【n-1】是S[n-2] 和a[n-1]的之和 这个是次栈底
        // 一直到 S[1] 是a[0] 和a[1]的和，这个就是边界  这个是栈顶
        

    }


    public static int S(int[] array, int n) throws Exception {
        if (array.length < 1) {
            throw new Exception("InvaidArgument");
        }

        if (array.length == 1) {
            return array[0];
        }
        // 递归
        // array[]
        if (n < 2) {
            return S(array, 1);
        }

        return -1;
    }
}
