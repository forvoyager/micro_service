package com.xr.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2019-05-30 19:52 <br>
 * <b>description</b>：订单服务 <br>
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource("classpath*:spring.xml")
public class StorageServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(StorageServiceApplication.class, args);
  }
}