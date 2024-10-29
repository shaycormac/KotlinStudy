package com.assassin;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/03/15 21:06
 * Version:     1.0
 * Description: 简述一下这个类要做的事情
 */
interface TestInterface {

    default int myDefaultFunction(int a, int b) {

        return a + b;
    }

    public static final int aa = 5;
    public final String AA = "dd";

    // 也就是语法问题了，这个testNi变成final了
    public int testNi = 0;
    
    // 好吧，难道他们都是 staic final ?? 是的，都是
    
    static int ehhe(int a){
        return  a;
    }
    
  
}
