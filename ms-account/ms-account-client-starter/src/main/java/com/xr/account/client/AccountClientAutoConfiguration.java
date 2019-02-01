package com.xr.account.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * <b>description</b>：账户 相关操作feign客户端自动配置 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：yangchangyan@yijiedai.com
 */
@Configuration
@ConditionalOnProperty(prefix = AccountClientProperties.PREFIX, name = "enabled", matchIfMissing = true)
@EnableFeignClients
public class AccountClientAutoConfiguration {
}
