package com.xr.storage.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <b>description</b>：Account 相关操作feign客户端配置信息 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
@ConfigurationProperties(prefix = StorageClientProperties.PREFIX)
public class StorageClientProperties {

  public static final String PREFIX = "ms.storage.client";

  private boolean enabled = true;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
