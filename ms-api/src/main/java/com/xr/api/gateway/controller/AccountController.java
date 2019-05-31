package com.xr.api.gateway.controller;

import com.xr.account.client.api.AccountClient;
import com.xr.account.common.model.AccountModel;
import com.xr.api.gateway.base.BaseController;
import com.xr.base.core.dto.ResultDto;
import com.xr.base.core.enums.Cluster;
import com.xr.base.core.page.PageData;
import com.xr.base.core.util.DateUtil;
import com.xr.base.core.util.MapUtils;
import com.xr.base.core.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by forvoyager@outlook.com on 2019-02-13 13:07.
 */
@RestController
public class AccountController extends BaseController {

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

  @RequestMapping("/account/select/page")
  ResultDto<PageData<AccountModel>> selectPage(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("master") Cluster master) throws Exception {
    Map condition = MapUtils.newHashMap();
    condition.put("sort", "user_id asc");
    return accountClient.selectPage(page, size, condition, master);
  }

}
