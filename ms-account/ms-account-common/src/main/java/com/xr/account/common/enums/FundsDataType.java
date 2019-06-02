package com.xr.account.common.enums;

/**
 * @Author: forvoyager@outlook.com
 * @Time: 2019-05-31 16:09
 * @Description: 资金流水类型
 */
public enum FundsDataType {

  PURCHASE_F(101, 0, "购买商品冻结"),
  PURCHASE_UF(102, 0, "购买商品解冻"),
  PURCHASE_P(103, -1, "购买商品支出"),
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
