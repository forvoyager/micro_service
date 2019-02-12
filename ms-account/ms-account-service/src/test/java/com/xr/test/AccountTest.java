package com.xr.test;

import com.xr.base.core.util.DateUtil;
import com.xr.test.base.BaseTestWithoutLogin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangchangyan@yijiedai.com on 2019-02-11 14:22.
 */
public class AccountTest extends BaseTestWithoutLogin {

  @Test
  public void insert() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "6666");
    param.put("balance", "100.0");
    param.put("frozen", "10.0");
    param.put("create_time", currentTimeInSecond);
    param.put("update_time", currentTimeInSecond);
    param.put("version", "22222");
    this.requestBody("/account/insert", param);
  }

  @Test
  public void insertBatch() throws Exception {
    List list = new ArrayList<>();
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "1");
    param.put("balance", "100.0");
    param.put("frozen", "10.0");
    param.put("create_time", currentTimeInSecond);
    param.put("update_time", currentTimeInSecond);
    param.put("version", "1");
    list.add(param);

    param = new HashMap<>();
    param.put("user_id", "2");
    param.put("balance", "200.0");
    param.put("frozen", "20.0");
    param.put("create_time", currentTimeInSecond);
    param.put("update_time", currentTimeInSecond);
    param.put("version", "2");
    list.add(param);

    this.requestBody("/account/insert/batch", list);
  }

  @Test
  public void insertOrUpdate() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "6666");
    param.put("frozen", "10000.0");
//    param.put("where_version", "0");
    this.requestBody("/account/insert/update", param);
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
    param.put("id", "1");
    this.requestBody("/account/delete", param);
  }

  @Test
  public void update() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "6666");
    param.put("balance", "1.0");
    param.put("update_time", currentTimeInSecond);
    param.put("where_version", "4");
    this.requestBody("/account/update/model", param);
  }

  @Test
  public void updateByMap() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "6666");
    param.put("balance", "1.0");
    param.put("update_time", currentTimeInSecond);
    param.put("where_version", "4");
    this.requestBody("/account/update/map", param);
  }

  @Test
  public void selectById() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("id", "1");
    this.requestRestful("/account/select/{master}/{user_id}", param);
  }
}
