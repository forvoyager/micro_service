package com.xr.account.service.impl;

import com.xr.account.common.model.AccountModel;
import com.xr.account.service.IAccountService;
import com.xr.account.mapper.AccountMapper;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <b>description</b>：账户信息 业务操作接口实现 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, AccountModel> implements IAccountService {
  @Override
  protected String getPrimaryKeyName() {
    return "user_id";
  }
}
