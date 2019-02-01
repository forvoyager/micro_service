package com.xr.account.controller;

import com.xr.account.common.controller.IAccountController;
import com.xr.account.common.model.AccountModel;
import com.xr.account.service.IAccountService;
import com.xr.base.core.dto.ResultDto;
import com.xr.base.jdbc.page.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <b>description</b>：账户信息 相关操作http接口 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：yangchangyan@yijiedai.com
 */
@RestController
public class AccountController implements IAccountController{

  @Resource
  private IAccountService accountService;

  @Override
  public ResultDto<AccountModel> insert(@RequestBody AccountModel entity) throws Exception {
    return null;
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<AccountModel> entityList) throws Exception {
    return null;
  }

  @Override
  public ResultDto<AccountModel> insertOrUpdate(@RequestBody AccountModel entity) throws Exception {
    return null;
  }

  @Override
  public ResultDto<Integer> deleteById(@RequestParam("id") Long id) throws Exception {
    return null;
  }

  @Override
  public ResultDto<Integer> deleteByMap(@RequestBody Map<String, Object> columnMap) throws Exception {
    return null;
  }

  @Override
  public ResultDto<Integer> updateById(@RequestBody AccountModel entity) throws Exception {
    return null;
  }

  @Override
  public ResultDto<AccountModel> selectById(@RequestParam("id") Long id, @RequestParam("master") boolean master) throws Exception {
    return null;
  }

  @Override
  public ResultDto<List<AccountModel>> selectBatchIds(@RequestBody List<Long> idList, @RequestParam("master") boolean master) throws Exception {
    return null;
  }

  @Override
  public ResultDto<List<AccountModel>> selectList(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception {
    return null;
  }

  @Override
  public ResultDto<AccountModel> selectOne(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception {
    return null;
  }

  @Override
  public ResultDto<Map<String, Object>> selectMap(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception {
    return null;
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception {
    return null;
  }

  @Override
  public ResultDto<Page<AccountModel>> selectPage(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception {
    return null;
  }
}
