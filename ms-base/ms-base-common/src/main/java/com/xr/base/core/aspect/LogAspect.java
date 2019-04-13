package com.xr.base.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @Time: 2019-04-13 11:32
 * @Author: forvoyager@outlook.com
 * @Description: 日志切面
 */
@Aspect
@Component
public class LogAspect {
  private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

  private static final String BEFORE_PATTERN = "start call {0} method, and input arguments is : {1}";
  private static final String AFTER_RETURN_PATTERN = "after call {0} method, and return value is : {1}";

  /**
   * 拦截所有添加了@Service注解的类
   * @within(org.springframework.stereotype.Service)
   *
   * 拦截BaseServiceImpl及其子类
   * within(com.xr.base.jdbc.service.impl.BaseServiceImpl+)
   * target(com.xr.base.jdbc.service.impl.BaseServiceImpl) && execution(* *())
   * execution(* com.xr.base.jdbc.service.impl.BaseServiceImpl+.*())
   *
   */
  @Pointcut("@within(org.springframework.stereotype.Service)")
  public void pointcut() {
  }

  @Before("pointcut()")
  public void beforMethod(JoinPoint jp) {
    logger.info(MessageFormat.format(BEFORE_PATTERN, jp.getSignature().getName(), Arrays.toString(jp.getArgs())));
  }

  @AfterReturning(value = "pointcut()", argNames = "rtv", returning = "rtv")
  public void aferMethod(JoinPoint jp, Object rtv) {
    logger.info(MessageFormat.format(AFTER_RETURN_PATTERN, jp.getSignature().getName(), rtv));
  }

}
