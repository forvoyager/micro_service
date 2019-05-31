package com.xr.order.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * <b>description</b>：Account 相关操作feign客户端自动配置 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
@Configuration
@EnableFeignClients
@ConditionalOnProperty(prefix = OrderClientProperties.PREFIX, name = "enabled", matchIfMissing = true)
public class OrderClientAutoConfiguration {
}