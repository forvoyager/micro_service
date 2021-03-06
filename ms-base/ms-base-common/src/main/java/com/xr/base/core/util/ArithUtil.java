package com.xr.base.core.util;

import java.math.BigDecimal;

/**
 * @author Arnold Yand
 * @summary 数学计算工具类
 * @time 2018/4/1 17:14
 */
public class ArithUtil {

  //默认运算精度
  private static final int DEFAULT_SCALE = 10;

  private ArithUtil() {
  }

  /**
   * 提供精确的加法运算。
   *
   * @param v1 被加数
   * @param v2 加数
   * @return 两个参数的和
   */
  public static double add(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.add(b2).doubleValue();
  }

  public static double add(double ...data){
    double sum = 0.0D;
    for(double d :data){
      sum = add(sum, d);
    }

    return sum;
  }

  /**
   * 提供精确的减法运算。
   *
   * @param v1 被减数
   * @param v2 减数
   * @return 两个参数的差
   */
  public static double sub(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.subtract(b2).doubleValue();
  }

  /**
   * 提供精确的乘法运算。
   *
   * @param v1 被乘数
   * @param v2 乘数
   * @return 两个参数的积
   */
  public static double mul(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.multiply(b2).doubleValue();
  }

  public static double muls(double... values) {
    double total = 0;
    if (values != null && values.length > 0) {
      total = 1;
      for (double v : values) {
        total = mul(total, v);
      }
    }
    return total;
  }

  /**
   * 幂运算 a^b
   *
   * @param a
   * @param b
   * @return
   */
  public static double pow(double a, int b) {
    double total = 1;
    for (int i = 0; i < b; i++) {
      total = mul(total, a);
    }
    return total;
  }

  /**
   * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
   * 小数点以后10位，以后的数字四舍五入。
   *
   * @param v1 被除数
   * @param v2 除数
   * @return 两个参数的商
   */
  public static double div(double v1, double v2) {
    return div(v1, v2, DEFAULT_SCALE);
  }

  /**
   * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
   * 定精度，以后的数字四舍五入。
   *
   * @param v1    被除数
   * @param v2    除数
   * @param scale 表示表示需要精确到小数点以后几位。
   * @return 两个参数的商
   */
  public static double div(double v1, double v2, int scale) {
    if (scale < 0) {
      throw new IllegalArgumentException(
              "The scale must be a positive integer or zero");
    }
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
  }

  /**
   * 提供精确的小数位四舍五入处理。
   *
   * @param v     需要四舍五入的数字
   * @param scale 小数点后保留几位
   * @return 四舍五入后的结果
   */
  public static double round(double v, int scale) {
    if (scale < 0) {
      throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
    BigDecimal b = new BigDecimal(Double.toString(v));
    BigDecimal one = new BigDecimal("1");
    return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
  }

  /**
   * 对数计算
   * log base为底 value的对数
   * @param base
   * @param value
   * @return
   * @throws Exception
   */
  public static double log(double base, double value) throws Exception {
    return Math.log(value) / Math.log(base);
  }

  /**
   * log e为底 value的对数
   * @param value
   * @return
   * @throws Exception
   */
  public static double ln(double value) throws Exception{
    return log(Math.E, value);
  }

  /**
   * 平方和
   * @param data
   * @return
   */
  public static double quadraticSum(double ...data) {
    double sum = 0.0D;
    for(double d : data){
      sum = add(sum, pow(d, 2));
    }
    return sum;
  }

  /**
   * 平方根
   * @param data
   * @return
   */
  public static double sqrt(double data){
    return Math.sqrt(data);
  }
}
