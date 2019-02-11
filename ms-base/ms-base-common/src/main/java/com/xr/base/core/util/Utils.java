package com.xr.base.core.util;

import java.lang.reflect.Field;
import java.util.*;

/**
 * <b>description</b>：工具类 <br>
 * <b>time</b>：2019-02-11 13:29 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
public final class Utils {

  /**
   * java bean 转 map
   * @param javabean
   * @return
   * @throws Exception
   */
  public static Map<String, Object> javaBeanToMap(Object javabean) throws Exception {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    if (javabean == null) { return map; }

    Class javabeanClass = javabean.getClass();
    List<Field> fields = getClassAndParentFields(javabeanClass);
    for (Field field : fields) {
      if (!field.isAccessible()) {
        field.setAccessible(true);
      }
      map.put(field.getName(), field.get(javabean));
    }

    return map;
  }

  private static List<Field> getClassAndParentFields(Class cs) {
    List<Field> list = new ArrayList<Field>();
    for (; cs != Object.class; cs = cs.getSuperclass()) {
      Field[] fields = cs.getDeclaredFields();
      for (Field field : fields) {
        list.add(field);
      }
    }
    return list;
  }

  private Utils(){}
}
