package com.xr.account.service.impl;

import com.xr.account.common.model.AccountModel;
import com.xr.account.mapper.AccountMapper;
import com.xr.account.service.IAccountService;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;

/**
 * Created by yangchangyan@yijiedai.com on 2019-02-01 16:41.
 */
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, AccountModel> implements IAccountService {
  @Override
  protected String getPrimaryKeyName() {
    return "userId";
  }
}
