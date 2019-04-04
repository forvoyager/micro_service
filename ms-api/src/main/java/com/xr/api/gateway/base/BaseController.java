package com.xr.api.gateway.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Time: 2019-04-04 19:09
 * @Author: forvoyager@outlook.com
 * @Description: base Controller
 */
public abstract class BaseController {

  @Autowired
  protected HttpServletRequest request;

  @Autowired
  protected HttpServletResponse response;

  protected Logger logger = LoggerFactory.getLogger(getClass());

}
