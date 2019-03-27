package com.xr.api.gateway.config;

import com.xr.api.gateway.config.interceptor.LoginInterceptor;
import com.xr.api.gateway.config.interceptor.ParamValidationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Time: 2019-03-27 14:32
 * @Author: forvoyager@outlook.com
 * @Description: 自定义MVC配置
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

  @Autowired
  private DispatcherServlet dispatcherServletWrap;

  @Autowired
  private ParamValidationInterceptor paramValidationInterceptor;

  @Autowired
  private LoginInterceptor loginInterceptor;

  /**
   * 自定义拦截器
   * order升序，小的先被执行
   *
   * @param registry
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    // 参数验证
    registry.addInterceptor(paramValidationInterceptor)
            .order(0)
            .addPathPatterns("/**")
            .excludePathPatterns("/static/**")
    ;

    // 登陆验证
    registry.addInterceptor(loginInterceptor).order(1).addPathPatterns("/**");

  }

  /**
   * 添加自定义参数注入处理器
   *
   * @param resolvers
   */
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(new MsRequestParamMethodArgumentResolver());
  }

  @Bean
  public ServletRegistrationBean dispatcherRegistration() {
    return new ServletRegistrationBean(dispatcherServletWrap, "/*");
  }
}
