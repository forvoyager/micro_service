package com.xr.order;

import com.xr.base.core.aspect.LogAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2019-05-30 19:52 <br>
 * <b>description</b>：订单服务配置 <br>
 */
@Configuration
@MapperScan(basePackageClasses = {OrderServiceConfiguration.class})
public class OrderServiceConfiguration {

  @Bean
  public LogAspect logAspect(){
    return new LogAspect();
  }

}
