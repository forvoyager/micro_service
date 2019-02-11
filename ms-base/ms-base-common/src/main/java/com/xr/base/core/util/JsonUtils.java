package com.xr.base.core.util;

import com.alibaba.fastjson.JSON;

/**
 * <b>description</b>：JSON工具类 <br>
 * <b>time</b>：2019-02-11 13:29 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
public final class JsonUtils {

  public static String toJson(Object obj){
    if(obj == null){
      return "{}";
    }

    return JSON.toJSONString(obj);
  }

  private JsonUtils(){}
}
