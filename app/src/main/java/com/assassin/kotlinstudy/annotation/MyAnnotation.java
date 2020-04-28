package com.assassin.kotlinstudy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020-01-06 14:49
 * Version: 1.0
 * Description: 自定义注解
 */
//表明注解的范围
@Target(ElementType.METHOD)
//在jvm中停留的时间
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation 
{
    //默认一个方法
    String[] values()  default "unKnow";
}
