package com.imooc.coupon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>忽略统一响应注解定义</h1>
 * Created by oyj.
 */
@Target({ElementType.TYPE, ElementType.METHOD}) //表明当前注解可以定义在类和方法上面
@Retention(RetentionPolicy.RUNTIME) //表示注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；

//定义IgnoreResponseAdvice注解
public @interface IgnoreResponseAdvice {
}
