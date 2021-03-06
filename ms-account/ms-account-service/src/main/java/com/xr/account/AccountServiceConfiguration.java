package com.xr.account;

import com.xr.base.core.aspect.LogAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b>description</b>：账户服务配置 <br>
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2019-02-01 11:41 <br>
 */
@Configuration
@MapperScan(basePackageClasses = {AccountServiceConfiguration.class})
public class AccountServiceConfiguration {

  @Bean
  public LogAspect logAspect(){
    return new LogAspect();
  }

}
