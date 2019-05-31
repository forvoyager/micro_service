package com.xr.storage.controller;

import com.xr.storage.common.controller.IStorageController;
import com.xr.storage.common.model.StorageModel;
import com.xr.storage.service.IStorageService;
import com.xr.base.core.dto.ResultDto;
import com.xr.base.core.enums.Cluster;
import com.xr.base.core.page.PageData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <b>time</b>: 2019-05-30 18:00:32 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品库存信息 HTTP服务 <br>
 */
@RestController
public class StorageController implements IStorageController {

  @Resource
  private IStorageService storageService;

  @Override
  public ResultDto<StorageModel> insert(@RequestBody StorageModel entity) throws Exception {
    return ResultDto.successData(storageService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<StorageModel> entityList) throws Exception {
    return ResultDto.successData(storageService.insertBatch(entityList));
  }

  @Override
  public ResultDto<StorageModel> insertOrUpdate(@RequestBody StorageModel entity) throws Exception {
    return ResultDto.successData(storageService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("commodity_id") long commodity_id) throws Exception {
    return ResultDto.successData(storageService.deleteById(commodity_id));
  }

  @Override
  public ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(storageService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Long> update(@RequestBody StorageModel entity) throws Exception {
    return ResultDto.successData(storageService.update(entity));
  }

  @Override
  public ResultDto<Long> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.successData(storageService.updateByMap(condition));
  }

  @Override
  public ResultDto<StorageModel> selectById(@PathVariable("commodity_id") long commodity_id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(storageService.selectById(commodity_id, master));
  }

  @Override
  public ResultDto<List<StorageModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(storageService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<StorageModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(storageService.selectList(condition, master));
  }

  @Override
  public ResultDto<StorageModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(storageService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<Integer, StorageModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(storageService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(storageService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<StorageModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.successData(storageService.selectPage(page, size, condition, master));
  }

  @Override
  public ResultDto decreaseStorage(@RequestParam("commodity_id") long commodity_id, @RequestParam("count") int count) throws Exception {
    storageService.decreaseStorage(commodity_id, count);
    return ResultDto.success("减少库存成功");
  }

}
