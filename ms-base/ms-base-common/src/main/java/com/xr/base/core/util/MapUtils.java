package com.xr.base.core.util;

import java.util.Map;

/**
 * Created by forvoyager@outlook.com on 2019-01-31 15:27.
 */
public final class MapUtils {

  public static boolean isEmpty(Map collection) {
    if (collection == null || collection.size() == 0) {
      return true;
    }

    return false;
  }

  private MapUtils(){}
}
