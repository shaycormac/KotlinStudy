package com.assassin.kotlinstudy.arraymap;


import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.collection.SparseArrayCompat;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020-01-08 15:52
 * Version: 1.0
 * Description: 测试arraymap
 */
public class ArrayMapTest {
    
   
    

    public static void main(String[] args) {
        ArrayMap<String,Person> arrayMap = new ArrayMap<>(8);
        Person person = new Person("你们",18);
        Person person2= new Person("们",19);
        Person person3 = new Person("你",20);
        arrayMap.put("aa", person);
        arrayMap.put("bb", person2);
        arrayMap.put("cc", person3);

        for (int i = 0; i < arrayMap.size(); i++) 
        {
           String  key =  arrayMap.keyAt(i);
         Person person1 =    arrayMap.valueAt(i);
            System.out.println("key的值为："+key+"--value的值为"+person1);
            
        }
   //只能key的值为int整形
        SparseArrayCompat<Person> sparseArray = new SparseArrayCompat<>();
        sparseArray.put(11, person);
        sparseArray.put(12, person2);
        sparseArray.put(13, person3);
        for (int i = 0; i < sparseArray.size(); i++) {
          Person person1 =   sparseArray.valueAt(i);
           int key=sparseArray.keyAt(i);

            System.out.println("key的值为："+key+"--value的值为"+person1);       
        }
                
    }
}


class Person
{
    public String name;
    public int  age;

    public Person(String name,int age)
    {
        this.age=age;
        this.name=name;
    }

    @NonNull
    @Override
    public String toString() {
        return name+age;
    }
}
