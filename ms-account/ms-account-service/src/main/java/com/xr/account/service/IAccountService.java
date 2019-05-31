package com.xr.account.service;

import com.xr.account.common.enums.FundsDataType;
import com.xr.account.common.model.AccountModel;
import com.xr.base.jdbc.service.IBaseService;

/**
 * <b>description</b>：账户信息 业务操作接口 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
public interface IAccountService extends IBaseService<AccountModel> {

  /**
   * 冻结用户资金
   * @param user_id 用户id
   * @param price 金额
   * @param type 流水类型
   * @throws Exception
   */
  void frozen(long user_id, double price, FundsDataType type) throws Exception;

  /**
   * 解冻用户资金
   * @param user_id 用户id
   * @param price 金额
   * @param type 流水类型
   * @throws Exception
   */
  void unFrozen(long user_id, double price, FundsDataType type) throws Exception;

  /**
   * 支出用户资金
   * @param user_id 用户id
   * @param price 金额
   * @param type 流水类型
   * @throws Exception
   */
  void payment(long user_id, double price, FundsDataType type) throws Exception;
}
