package com.xr.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>description</b>：账户服务 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：yangchangyan@yijiedai.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AccountServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(AccountServiceApplication.class, args);
  }
}
