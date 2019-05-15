package com.xr.base.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Time: 2019-05-15 14:25
 * @Author: forvoyager@outlook.com
 * @Description: 自定义配置加载
 */
public class ConfigLoader implements PropertySourceLocator {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private MsConfigurationProperties msConfigurationProperties;

  @Override
  public PropertySource<?> locate(Environment env) {

    logger.info("config loading...");
    CompositePropertySource composite = new CompositePropertySource("MS_CONFIG");

    FileInputStream fis = null;
    try {
      String applicationName = env.getProperty("spring.application.name");
      logger.info("load config for application:{}", applicationName);

      // todo load config

//      fis = new FileInputStream("");

      Properties properties = new Properties();
//      properties.load(fis);
//      fis.close();
      PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("config1", properties);

      composite.addFirstPropertySource(propertiesPropertySource);
    }catch (Exception e){
      throw new RuntimeException(e);
    }

    logger.info("config loaded.");
    return composite;
  }
}
