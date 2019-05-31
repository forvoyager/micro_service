package com.xr.account.common.enums;

/**
 * @Author: forvoyager@outlook.com
 * @Time: 2019-05-31 16:09
 * @Description: 资金流水类型
 */
public enum FundsDataType {


  ;

  private int type;
  private int flag;
  private String description;

  private FundsDataType(int type, int flag, String description){
    this.type = type;
    this.flag = flag;
    this.description = description;
  }

  public int getType() {
    return type;
  }

  public int getFlag() {
    return flag;
  }

  public String getDescription() {
    return description;
  }
}
