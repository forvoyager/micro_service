package com.xr.account.common.model;

import com.xr.base.core.model.BaseModel;

/**
 * <b>description</b>：账户信息 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：yangchangyan@yijiedai.com
 */
public class AccountModel extends BaseModel {
  /**
   * 用户ID
   */
  private Long userId;

  /**
   * 账户余额
   */
  private Double blance;

  /**
   * 冻结金额
   */
  private Double frozen;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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
