package com.xr.storage.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: forvoyager@outlook.com
 * @Time: 2019-05-31 13:37
 * @Description: client 自动化配置
 */
@Configuration
@EnableFeignClients // 启动@FeignClient标注的客户端，并生成代理对象
@ConditionalOnProperty(prefix = StorageClientProperties.PREFIX, name = "enabled", matchIfMissing = true)
public class StorageClientAutoConfiguration {
}
