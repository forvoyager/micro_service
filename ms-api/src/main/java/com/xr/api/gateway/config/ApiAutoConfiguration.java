package com.xr.api.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @Time: 2019-04-04 19:41
 * @Author: forvoyager@outlook.com
 * @Description: API 自动配置
 */
@Configuration
public class ApiAutoConfiguration {

  @Bean(name = "multipartResolver")
  public MultipartResolver multipartResolver() {
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    resolver.setDefaultEncoding("UTF-8");
    resolver.setResolveLazily(true); // resolveLazily属性启用是为了推迟文件解析
    resolver.setMaxInMemorySize(40960);
    resolver.setMaxUploadSize(3 * 1024 * 1024); // 上传文件大小 3M
    return resolver;
  }

}
