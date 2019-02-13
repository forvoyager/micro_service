package com.xr.api.gateway.controller;

import com.xr.account.client.api.AccountClient;
import com.xr.account.common.model.AccountModel;
import com.xr.base.core.dto.ResultDto;
import com.xr.base.core.util.DateUtil;
import com.xr.base.core.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by forvoyager@outlook.com on 2019-02-13 13:07.
 */
@RestController
public class AccountController {

  @Autowired
  private AccountClient accountClient;

  @RequestMapping("/account/insert")
  public ResultDto insert() throws Exception {
    long current = DateUtil.currentTimeInSecond();
    AccountModel account = new AccountModel();
    account.setUser_id((long)RandomUtils.nextInt(Integer.MAX_VALUE));
    account.setBalance(RandomUtils.nextDouble());
    account.setFrozen(RandomUtils.nextDouble());
    account.setCreate_time(current);
    account.setUpdate_time(current);
    return accountClient.insert(account);
  }

}
