package com.xr.api.gateway.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Time: 2019-03-27 16:19
 * @Author: yangchangyan@yijiedai.com
 * @Description: 登陆 拦截器
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String url = request.getServletPath();
    if(needLogin(url)){
      // do login
    }
    return true;
  }

  private boolean needLogin(String url) {

    return true;
  }
}
