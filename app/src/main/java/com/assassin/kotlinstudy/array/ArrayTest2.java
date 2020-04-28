package com.assassin.kotlinstudy.array;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020-01-10 11:21
 * Version: 1.0
 * Description: 类说明
 */
public class ArrayTest2 {

    public static void main(String[] args)
    {
        int a = 1; int b = 2;
        System.out.println(a);
        System.out.println(b);
        change(a, b);
        System.out.println(a);
        System.out.println(b);


        int[] arr = {1,3,5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);


      /*  Dog dog = new Dog("haha", 1);
        Dog dog1 = new Dog("haha1", 2);
        Dog dog2 = new Dog("haha2", 3);
        Dog dogArray[] = new Dog[]{dog,dog1,dog2};
        //要排序的类型，必须实现Comparable接口，否则调用这个会报错
        Arrays.sort(dogArray);
        for (int i = 0; i < dogArray.length; i++) {
            System.out.println(dogArray[i]);
        }
*/

        String[] strs = {"沉", "默","王", "二"};

        List<String> list = Arrays.asList(strs);
        System.out.println(list);
        // 输出[沉, 默, 王, 二]

        String[] strs1 = new String[list.size()];
        System.out.println(Arrays.toString(list.toArray(strs1)));
        // 输出 [沉, 默, 王, 二]

        String[] strs2 = new String[5];
        System.out.println(Arrays.toString(list.toArray(strs2)));
        // 输出 [沉, 默, 王, 二, null]

        String[] strs3 = new String[1];
        System.out.println(Arrays.toString(list.toArray(strs3)));
        // 输出 [沉, 默, 王, 二]

        String[] strs4 = {};
        System.out.println(Arrays.toString(list.toArray(strs4)));
        // 输出 [沉, 默, 王, 二]

       
    }
    public static void change(int a, int b) {
        a = a + b; b = b + a;
        
    }

    public static void change(int[] arr) {
        arr[0] = 200;
    }
    
   
}



class Dog
{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
