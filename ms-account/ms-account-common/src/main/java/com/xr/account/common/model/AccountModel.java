package com.xr.account.common.model;

import com.xr.base.core.model.BaseModel;

/**
 * <b>description</b>：账户信息 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
public class AccountModel extends BaseModel {
  /**
   * 用户ID
   */
  private Long user_id;

  /**
   * 账户余额
   */
  private Double blance;

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

  public Double getBlance() {
    return blance;
  }

  public void setBlance(Double blance) {
    this.blance = blance;
  }

  public Double getFrozen() {
    return frozen;
  }

  public void setFrozen(Double frozen) {
    this.frozen = frozen;
  }
}
