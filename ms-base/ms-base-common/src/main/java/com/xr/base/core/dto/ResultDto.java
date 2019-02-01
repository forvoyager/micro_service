package com.xr.base.core.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * 统一响应信息格式
 *
 * Created by yangchangyan@yijiedai.com on 2019-02-01 11:54.
 */
public class ResultDto<T> implements Serializable{
  /**
   * 响应代码 see ResultCodeEnum
   */
  private String code;
  /**
   * 信息提示
   */
  private String message;
  /**
   * 数据
   */
  private T data;
  /**
   * 扩展数据
   */
  private Map extData;
  /**
   * 时间
   */
  private Long time;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Map getExtData() {
    return extData;
  }

  public void setExtData(Map extData) {
    this.extData = extData;
  }

  public Long getTime() {
    return time;
  }

  public void setTime(Long time) {
    this.time = time;
  }
}
