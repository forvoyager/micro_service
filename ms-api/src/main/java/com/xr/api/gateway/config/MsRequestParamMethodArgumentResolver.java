package com.xr.api.gateway.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.xr.base.core.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;

import java.lang.reflect.Type;

/**
 * @Time: 2019-03-27 14:37
 * @Author: forvoyager@outlook.com
 * @Description:
 *
 * 自定义参数注入，从data中取出数据，并注入到controller中MsParam注解修饰的属性上。
 *
 * data：json数据
 *
 * 请求数据格式如下：
 * {
 * 	"data": {"regid":"6666"},
 * 	"user_id": 657759,
 * 	"channel": 3,
 * 	"token": "69cdd25dfbf657c376aafca0d05bf68f",
 * 	"v":""
 * }
 *
 */
public class MsRequestParamMethodArgumentResolver extends AbstractNamedValueMethodArgumentResolver {
  @Override
  protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
    MsParam ann = parameter.getParameterAnnotation(MsParam.class);
    return (ann == null ? new NamedValueInfo("", false, ValueConstants.DEFAULT_NONE) : new NamedValueInfo(ann.name(), ann.required(), ValueConstants.DEFAULT_NONE));
  }

  @Override
  protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
    Object value = null;

    String data = request.getParameter("data");

    // LRU缓存 todo

    if(StringUtils.isNotEmpty(data)){
      // 解析data json
      JSONObject jsonObject = JsonUtils.parseObject(data);
      Object objectValue = jsonObject.containsKey(name) ? jsonObject.get(name) : jsonObject;

      // 参数类型
      Type paramType = parameter.getGenericParameterType();
      if(isObject(paramType)){
        value = JSON.parseObject(objectValue.toString(), paramType);
      } else {
        value = objectValue;
      }
    }

    return value;
  }

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.hasParameterAnnotation(MsParam.class);
  }

  /**
   * 判断是否是对象类型
   *
   * 此处的对象类型是指，除了以下几种类型之外的类型：
   * 1、9大基本类型及其封装类
   * 2、String类型
   *
   * 此处是简单实现，利用fastjson getDeserializer返回的Deserializer来判断是否是java bean类型
   * 如果返回的是JavaBeanDeserializer，则当前类型是一个对象类型
   *
   * 具体实现
   * // todo
   *
   * @param paramType
   * @return
   */
  public static final boolean isObject(Type paramType){
    if(null == paramType ) throw new IllegalArgumentException("参数类型未定义");
    return ParserConfig.global.getDeserializer(paramType) instanceof JavaBeanDeserializer;
  }
}
