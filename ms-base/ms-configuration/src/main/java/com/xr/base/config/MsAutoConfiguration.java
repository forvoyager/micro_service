package com.xr.base.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Time: 2019-05-15 15:04
 * @Author: forvoyager@outlook.com
 * @Description:
 */
@Configuration
@EnableConfigurationProperties({MsConfigurationProperties.class})
public class MsAutoConfiguration {

  @Bean
  public ConfigLoader configLoader(){
    return new ConfigLoader();
  }

}
