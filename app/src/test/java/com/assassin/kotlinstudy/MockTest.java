package com.assassin.kotlinstudy;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Author:      fangfang.fan
 * CreateDate:  2022/04/04 21:20
 * Description: 简述一下这个类要做的事情
 * Version:     1.0
 */
@RunWith(MockitoJUnitRunner.class)
public  class MockTest {

   private static final String FAKE_STRING = "AndroidUnitTest";
   private static final String FAKE_STRING2 = "AndroidUnit";
   
   @Mock
   Context context;
   
   @Test
   public void readFromContext(){

      //模拟方法调用的返回值，隔离对Android系统的依赖
      //when.. thenReturn 前提条件有的话，就返回后面的值
      // 通过模拟框架Mockito，指定调用context.getString(int)方法的返回值，达到了隔离依赖的目的，其中Mockito使用的是cglib动态代理技术。
      when(context.getString(R.string.app_name)).thenReturn(FAKE_STRING);
      assertThat(context.getString(R.string.app_name),is(FAKE_STRING2));

      when(context.getPackageName()).thenReturn("com.jdqm.androidunittest");
      System.out.println(context.getPackageName());
      
   }
   
}
