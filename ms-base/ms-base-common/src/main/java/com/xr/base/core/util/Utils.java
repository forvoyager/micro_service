package com.xr.base.core.util;

import com.xr.base.core.enums.ResultCodeEnum;
import com.xr.base.core.exception.BaseException;

/**
 * <b>description</b>：工具类 <br>
 * <b>time</b>：2019-02-11 13:29 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
public final class Utils {

  /**
   * 抛出系统异常
   * @param message
   * @throws Exception
   */
  public static void throwsBaseException(String message) throws Exception {
    throw new BaseException(ResultCodeEnum.SYSTEM_ERROR, message);
  }

  private Utils(){}
}
