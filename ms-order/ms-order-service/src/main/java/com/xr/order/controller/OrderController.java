package com.xr.order.controller;

import com.xr.order.common.controller.IOrderController;
import com.xr.order.common.model.OrderModel;
import com.xr.order.service.IOrderService;
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
 * <b>time</b>: 2019-05-30 17:59:33 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品购买信息 HTTP服务 <br>
 */
@RestController
public class OrderController implements IOrderController {

  @Resource
  private IOrderService orderService;

  @Override
  public ResultDto<OrderModel> insert(@RequestBody OrderModel entity) throws Exception {
    return ResultDto.success(orderService.insert(entity));
  }

  @Override
  public ResultDto<Integer> insertBatch(@RequestBody List<OrderModel> entityList) throws Exception {
    return ResultDto.success(orderService.insertBatch(entityList));
  }

  @Override
  public ResultDto<OrderModel> insertOrUpdate(@RequestBody OrderModel entity) throws Exception {
    return ResultDto.success(orderService.insertOrUpdate(entity));
  }

  @Override
  public ResultDto<Integer> deleteById(@PathVariable("user_id") long user_id) throws Exception {
    return ResultDto.success(orderService.deleteById(user_id));
  }

  @Override
  public ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.success(orderService.deleteByMap(condition));
  }

  @Override
  public ResultDto<Long> update(@RequestBody OrderModel entity) throws Exception {
    return ResultDto.success(orderService.update(entity));
  }

  @Override
  public ResultDto<Long> updateByMap(@RequestBody Map<String, Object> condition) throws Exception {
    return ResultDto.success(orderService.updateByMap(condition));
  }

  @Override
  public ResultDto<OrderModel> selectById(@PathVariable("user_id") long user_id, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.success(orderService.selectById(user_id, master));
  }

  @Override
  public ResultDto<List<OrderModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.success(orderService.selectByIds(idList, master));
  }

  @Override
  public ResultDto<List<OrderModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.success(orderService.selectList(condition, master));
  }

  @Override
  public ResultDto<OrderModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.success(orderService.selectOne(condition, master));
  }

  @Override
  public ResultDto<Map<Integer, OrderModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.success(orderService.selectMap(condition, master));
  }

  @Override
  public ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.success(orderService.selectCount(condition, master));
  }

  @Override
  public ResultDto<PageData<OrderModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception {
    return ResultDto.success(orderService.selectPage(page, size, condition, master));
  }

}
