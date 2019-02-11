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
  public void test_insert() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "6666");
    param.put("balance", "100.0");
    param.put("frozen", "10.0");
    param.put("create_time", "333333");
    param.put("update_time", "22222");
    param.put("version", "22222");
    this.requestBody("/account/insert", param);
  }

  @Test
  public void test_insertBatch() throws Exception {
    List list = new ArrayList<>();
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "1");
    param.put("balance", "1.0");
    param.put("frozen", "1.0");
    param.put("create_time", "1");
    param.put("update_time", "1");
    param.put("version", "1");
    list.add(param);

    param = new HashMap<>();
    param.put("user_id", "2");
    param.put("balance", "6666666.0");
    param.put("frozen", "2.0");
    param.put("create_time", "2");
    param.put("update_time", "2");
    param.put("version", "2");
    list.add(param);

    this.requestBodyList("/account/insert/batch", list);
  }

  @Test
  public void test_update() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "6666");
    param.put("balance", "1.0");
    param.put("update_time", DateUtil.currentTimeInSecond());
    param.put("where_version", "4");
    this.requestBody("/account/update", param);
  }

  @Test
  public void test_insertOrUpdate() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("user_id", "6666");
    param.put("frozen", "10000.0");
    param.put("where_version", "5");
    this.requestBody("/account/insert/update", param);
  }
}
