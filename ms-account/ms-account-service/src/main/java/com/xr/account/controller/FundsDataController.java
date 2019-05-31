package com.xr.account.controller;

import com.xr.account.common.controller.IFundsDataController;
import com.xr.account.common.model.FundsDataModel;
import com.xr.account.service.IFundsDataService;
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
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-05-31 16:13:56 <br>
 * <b>description</b>: 账户资金流水 HTTP服务 <br>
 */
@RestController
public class FundsDataController implements IFundsDataController {

  @Resource
  private IFundsDataService fundsDataService;

  @Override
  public ResultDto<FundsDataModel> insert(@RequestBody FundsDataModel entity) throws Exception {
    return ResultDto.successData(fundsDataService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<FundsDataModel> entityList) throws Exception {
    return ResultDto.successData(fundsDataService.insertBatch(entityList));
  }

  @Override
  public ResultDto<FundsDataModel> insertOrUpdate(@RequestBody FundsDataModel entity) throws Exception {
    return ResultDto.successData(fundsDataService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("id") long id) throws Exception {
    return ResultDto.successData(fundsDataService.deleteById(id));
  }

  @Override
  public ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(fundsDataService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Long> update(@RequestBody FundsDataModel entity) throws Exception {
    return ResultDto.successData(fundsDataService.update(entity));
  }

  @Override
  public ResultDto<Long> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(fundsDataService.updateByMap(condition));
  }

  @Override
  public ResultDto<FundsDataModel> selectById(@PathVariable("id") long id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(fundsDataService.selectById(id, master));
  }

  @Override
  public ResultDto<List<FundsDataModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(fundsDataService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<FundsDataModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(fundsDataService.selectList(condition, master));
  }

  @Override
  public ResultDto<FundsDataModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(fundsDataService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<Integer, FundsDataModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(fundsDataService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(fundsDataService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<FundsDataModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(fundsDataService.selectPage(page, size, condition, master));
  }

}
