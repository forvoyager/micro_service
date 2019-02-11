package com.xr.base.web;

import com.xr.base.web.error.GlobalErrorAttributes;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b>description</b>：web全局处理 自动配置 <br>
 * <b>time</b>：2019-02-11 13:29 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
@Configuration
@ConditionalOnProperty(prefix = BaseWebProperties.PREFIX, name = "enabled", matchIfMissing = true)
public class BaseWebAutoConfiguration {

  @Bean
  public GlobalErrorAttributes errorAttributes() {
    return new GlobalErrorAttributes();
  }

}
