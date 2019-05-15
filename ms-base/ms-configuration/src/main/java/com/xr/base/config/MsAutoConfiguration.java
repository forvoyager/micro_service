package com.xr.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Time: 2019-05-15 15:04
 * @Author: forvoyager@outlook.com
 * @Description:
 */
@Configuration
public class MsAutoConfiguration {

  @Bean
  public ConfigLoader configLoader(){
    return new ConfigLoader();
  }

}
