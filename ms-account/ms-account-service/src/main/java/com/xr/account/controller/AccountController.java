package com.xr.account.controller;

import com.xr.account.common.controller.IAccountController;
import com.xr.account.common.model.AccountModel;
import com.xr.account.service.IAccountService;
import com.xr.base.core.dto.ResultDto;
import com.xr.base.core.enums.Cluster;
import com.xr.base.core.page.PageData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <b>description</b>：账户信息 相关操作http接口 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
@RestController
public class AccountController implements IAccountController{

  @Resource
  private IAccountService accountService;

  @Override
  public ResultDto<AccountModel> insert(@RequestBody AccountModel entity) throws Exception {
    return ResultDto.successData(accountService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<AccountModel> entityList) throws Exception {
    return ResultDto.successData(accountService.insertBatch(entityList));
  }

  @Override
  public ResultDto<AccountModel> insertOrUpdate(@RequestBody AccountModel entity) throws Exception {
    return ResultDto.successData(accountService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("user_id") long user_id) throws Exception {
    return ResultDto.successData(accountService.deleteById(user_id));
  }

  @Override
  public ResultDto<Integer> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(accountService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Integer> update(@RequestBody AccountModel entity) throws Exception {
    return ResultDto.successData(accountService.update(entity));
  }

  @Override
  public ResultDto<Integer> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(accountService.updateByMap(condition));
  }

  @Override
  public ResultDto<AccountModel> selectById(@PathVariable("user_id") long user_id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(accountService.selectById(user_id, master));
  }

  @Override
  public ResultDto<List<AccountModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(accountService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<AccountModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(accountService.selectList(condition, master));
  }

  @Override
  public ResultDto<AccountModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(accountService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<String, AccountModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(accountService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(accountService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<AccountModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(accountService.selectPage(page, size, condition, master));
  }

}
