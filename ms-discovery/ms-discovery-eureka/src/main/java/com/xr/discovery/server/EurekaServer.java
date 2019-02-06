package com.xr.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ImportResource;

/**
 * <b>description</b>：账户服务配置 <br>
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2019/2/4 12:00 <br>
 */
@SpringBootApplication
@EnableEurekaServer
@ImportResource("classpath*:spring.xml")
public class EurekaServer {
  public static void main(String[] args) {
    SpringApplication.run(EurekaServer.class, args);
  }
}