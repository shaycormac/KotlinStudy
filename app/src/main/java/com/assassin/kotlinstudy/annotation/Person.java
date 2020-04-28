package com.assassin.kotlinstudy.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020-01-06 14:53
 * Version: 1.0
 * Description: 类说明
 */
public class Person
{
    private String name;
    
    private int age;
    
    @MyAnnotation
    public void empty()
    {
        System.out.println("这是一个空方法");
    }
    //设置值
    @MyAnnotation(values= {"boy","girl"})
    public void isBoy()
    {
        System.out.println();
    }

// 通过反射，获取方法上的注解中的值
    public static void main(String[] args) throws Exception {
        
        Person person = new Person();
       Class clazz =  person.getClass();
       
      Method method =clazz.getMethod("isBoy",new Class[]{});
      MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        for (String value : annotation.values()) {
            System.out.println("获取到的值--"+value);
        }
        System.out.println("-------------------------------");
        Annotation[] annotations =  method.getAnnotations();
        for (Annotation annotation1:annotations)
        {
            System.out.println(annotation1);
        }
        System.out.println("-------------------------------");
        method.getParameterAnnotations();
      Type[] types =  method.getGenericParameterTypes();
        for (Type type : types) {
            System.out.println(type.toString());
        }
    }
}
