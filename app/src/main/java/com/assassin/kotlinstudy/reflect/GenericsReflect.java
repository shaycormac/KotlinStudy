package com.assassin.kotlinstudy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/4/24 13:24
 * Version: 1.0
 * Description: 泛型反射类的尝试
 */
public class GenericsReflect {

    //测试的类成员
    private Map<Integer,String> test;
    
    public  final String HAHA ="HAHA";
    
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("com.assassin.kotlinstudy.reflect.GenericsReflect");
        Field field =clazz.getDeclaredField("test");
        field.setAccessible(true);
      Class<?>  type =  field.getType();
       Type type1 =  field.getGenericType();
       if (type1 instanceof ParameterizedType)
       {
           ParameterizedType parameterizedType = (ParameterizedType) type1;
           Type paramType = parameterizedType.getRawType();
           System.out.println(paramType.toString());
           
           //获取的泛型实际类型
           Type[] actualTypes = parameterizedType.getActualTypeArguments();
           for (Type actualType:actualTypes) {
               System.out.println(actualType.toString());
           }
           
       }else 
       {
           
       }
      GenericsReflect genericsReflect = new GenericsReflect();
      // genericsReflect.HAHA =null;
        
    }
    
    
}
