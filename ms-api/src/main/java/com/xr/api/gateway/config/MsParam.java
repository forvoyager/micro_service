package com.xr.api.gateway.config;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Time: 2019-03-27 14:35
 * @Author: yangchangyan@yijiedai.com
 * @Description: 自定义参数注入注解
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface MsParam {

  /**
   * 参数别名
   * @return
   */
  @AliasFor("name")
  String value() default "";

  /**
   * 参数别名
   * @return
   */
  @AliasFor("value")
  String name() default "";

  /**
   * 参数是否必填
   */
  boolean required() default true;

}
