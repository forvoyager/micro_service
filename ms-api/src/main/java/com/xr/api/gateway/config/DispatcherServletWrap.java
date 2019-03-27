package com.xr.api.gateway.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Time: 2019-03-27 16:37
 * @Author: forvoyager@outlook.com
 * @Description:
 */
@Component
public class DispatcherServletWrap extends DispatcherServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      super.service(request, response);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
