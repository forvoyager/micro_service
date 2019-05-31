package com.xr.test;

import com.xr.account.common.model.AccountModel;
import com.xr.base.core.enums.Cluster;
import com.xr.test.base.BaseTestWithoutLogin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by forvoyager@outlook.com on 2019-02-11 14:22.
 */
public class AccountTest extends BaseTestWithoutLogin {

  @Test
  public void insert() throws Exception {
    AccountModel account = new AccountModel();
    account.setUser_id(6666L);
    account.setBalance(100.0);
    account.setFrozen(10.0);
    account.setCreate_time(currentTimeInSecond);
    account.setUpdate_time(currentTimeInSecond);
    account.setVersion(22222);
    this.requestBody("/account/insert", account);
  }

  @Test
  public void insertBatch() throws Exception {
    List list = new ArrayList<>();

    AccountModel account1 = new AccountModel();
    account1.setUser_id(1L);
    account1.setBalance(100.0);
    account1.setFrozen(10.0);
    account1.setCreate_time(currentTimeInSecond);
    account1.setUpdate_time(currentTimeInSecond);
    account1.setVersion(11);
    list.add(account1);

    AccountModel account2 = new AccountModel();
    account2.setUser_id(2L);
    account2.setBalance(200.0);
    account2.setFrozen(20.0);
    account2.setCreate_time(currentTimeInSecond);
    account2.setUpdate_time(currentTimeInSecond);
    account2.setVersion(22);
    list.add(account2);

    this.requestBody("/account/insert/batch", list);
  }

  @Test
  public void insertOrUpdate() throws Exception {
    AccountModel account = new AccountModel();
    account.setUser_id(6666L);
    account.setBalance(100.0);
    account.setFrozen(10000.0);
    account.setVersion(0);
    this.requestBody("/account/insert/update", account);
  }

  @Test
  public void deleteById() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "1");
    this.requestRestful("/account/delete/{user_id}", param);
  }

  @Test
  public void deleteByMap() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "1");
    this.requestBody("/account/delete", param);
  }

  @Test
  public void update() throws Exception {
    AccountModel account = new AccountModel();
    account.setUser_id(6666L);
    account.setBalance(1.0);
    account.setUpdate_time(currentTimeInSecond);
    account.setVersion(0);
    this.requestBody("/account/update/model", account);
  }

  @Test
  public void updateByMap() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "6666");
    param.put("balance", "10000.0");
    param.put("frozen", "0.0");
    param.put("update_time", currentTimeInSecond);
    param.put("version", "0");
    this.requestBody("/account/update/map", param);
  }

  @Test
  public void selectById() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "1");
    param.put("master", Cluster.slave);
    this.requestRestful("/account/select/{master}/{user_id}", param);
  }

  @Test
  public void selectByIds() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("master", Cluster.slave);
    this.requestRestful("/account/select/{master}/batch", param);
  }

  @Test
  public void selectList() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("master", Cluster.slave);
    this.requestRestful("/account/select/{master}/list", param);
  }

  @Test
  public void selectOne() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("master", Cluster.slave);
    this.requestRestful("/account/select/{master}/one", param);
  }

  @Test
  public void selectMap() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("master", Cluster.slave);
    this.requestRestful("/account/select/{master}/map", param);
  }

  @Test
  public void selectCount() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("master", Cluster.slave);
    this.requestRestful("/account/select/{master}/count", param);
  }

  @Test
  public void selectPage() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("master", Cluster.slave);
    this.requestRestful("/account/select/{master}/page", param);
  }

}
