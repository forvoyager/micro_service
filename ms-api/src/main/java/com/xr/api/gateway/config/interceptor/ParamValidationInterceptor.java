package com.xr.api.gateway.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Time: 2019-03-27 15:27
 * @Author: forvoyager@outlook.com
 * @Description: 参数验证 拦截器
 */
@Component
public class ParamValidationInterceptor extends HandlerInterceptorAdapter {

  /**
   * 在preHandle中做参数验证
   * 如果参数不合法，返回false，结束处理，后续的postHandle,afterCompletion不会被执行（参数验证不通过，没有执行的必要）。
   *
   * @param request
   * @param response
   * @param handler
   * @return
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    // TODO: 2019/3/27

    return true;
  }
}
