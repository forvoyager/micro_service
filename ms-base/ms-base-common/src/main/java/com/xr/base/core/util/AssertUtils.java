package com.xr.base.core.util;
import com.xr.base.core.enums.ResultCodeEnum;
import com.xr.base.core.exception.BaseException;

import java.util.Collection;
import java.util.Map;

/**
 * 断言工具类
 * Created by forvoyager@outlook.com on 2019-01-31 11:14.
 */
public final class AssertUtils {

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }
    
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void notEmpty(String str, String message) {
        if (str == null || str.trim().length() == 0) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void notEmpty(Map<?, ?> map, String message) {
        if (map == null || map.isEmpty()) {
            throw new BaseException(ResultCodeEnum.ILLEGAL_STATUS, message);
        }
    }

    public static void largeThanZero(double a, String message) {
        notNull(a, "data must not be null");
        if( a <= 0){
            throw new BaseException(ResultCodeEnum.ILLEGAL_ARGUMENT, message);
        }
    }

    public static void largeThanZero(long a, String message) {
        notNull(a, "data must not be null");
        if( a <= 0){
            throw new BaseException(ResultCodeEnum.ILLEGAL_ARGUMENT, message);
        }
    }

    public static void isNumber(Object obj, String message) {
        notNull(obj, "data must not be null");
        try {
            Double.valueOf(obj.toString());
        } catch (NumberFormatException nfe){
            throw new BaseException(ResultCodeEnum.ILLEGAL_ARGUMENT, message);
        }
    }
    
    private AssertUtils(){}
}
