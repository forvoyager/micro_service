package com.xr.account.common.model;

import com.xr.base.core.model.BaseModel;

/**
 * <b>description</b>：账户信息 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
public class AccountModel extends BaseModel {

  public static final String USER_ID = "user_id";
  public static final String BALANCE = "balance";
  public static final String FROZEN = "frozen";

  /**
   * 用户ID
   */
  private Long user_id;

  /**
   * 账户余额
   */
  private Double balance;

  /**
   * 冻结金额
   */
  private Double frozen;

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Double getFrozen() {
    return frozen;
  }

  public void setFrozen(Double frozen) {
    this.frozen = frozen;
  }
}
