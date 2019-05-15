package com.xr.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Time: 2019-05-15 15:00
 * @Author: forvoyager@outlook.com
 * @Description: 配置模块相关属性
 */
@ConfigurationProperties(prefix = MsConfigurationProperties.PREFIX)
public class MsConfigurationProperties {

  public static final String PREFIX = "ms.config";

  private String dataIds;

  public String getDataIds() {
    return dataIds;
  }

  public MsConfigurationProperties setDataIds(String dataIds) {
    this.dataIds = dataIds;
    return this;
  }
}
