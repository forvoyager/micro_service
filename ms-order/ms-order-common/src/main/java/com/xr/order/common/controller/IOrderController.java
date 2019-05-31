package com.xr.order.common.controller;

import com.xr.base.core.dto.ResultDto;
import com.xr.base.core.enums.Cluster;
import com.xr.base.core.page.PageData;
import com.xr.order.common.model.OrderModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <b>time</b>: 2019-05-30 17:59:33 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品购买信息 HTTP接口 <br>
 */
public interface IOrderController {

  /**
   * <p>
   * 插入一条记录
   * </p>
   *
   * @param entity 实体对象
   * @return OrderModel 插入成功的对象
   */
  @RequestMapping("/order/insert")
  ResultDto<OrderModel> insert(@RequestBody OrderModel entity) throws Exception;

  /**
   * <p>
   * 插入（批量）
   * </p>
   *
   * @param entityList 对象列表
   * @return Integer 插入成功的记录数
   */
  @RequestMapping("/order/insert/batch")
  ResultDto<Integer> insertBatch(@RequestBody List<OrderModel> entityList) throws Exception;

  /**
   * <p>
   * 存在则更新，否则插入
   * </p>
   *
   * @param entity 实体对象
   * @return OrderModel 插入/更新成功的对象
   */
  @RequestMapping("/order/insert/update")
  ResultDto<OrderModel> insertOrUpdate(@RequestBody OrderModel entity) throws Exception;

  /**
   * <p>
   * 根据 主键ID 删除
   * </p>
   *
   * @param user_id 主键ID
   * @return Integer 删除的行数
   */
  @RequestMapping("/order/delete/{user_id}")
  ResultDto<Integer> deleteById(@PathVariable("user_id") long user_id) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，删除记录
   * </p>
   *
   * @param condition 删除条件
   * @return Integer 删除的行数
   */
  @RequestMapping("/order/delete")
  ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception;

  /**
   * <p>
   * 根据 model 修改数据
   * </p>
   *
   * @param entity 实体对象
   * @return OrderModel 更新的行数
   */
  @RequestMapping("/order/update/model")
  ResultDto<Long> update(@RequestBody OrderModel entity) throws Exception;

  /**
   * <p>
   * 根据map条件 修改
   * </p>
   *
   * @param columnMap 更新数据/更新条件
   * @return Integer 更新的行数
   */
  @RequestMapping("/order/update/map")
  ResultDto<Long> updateByMap(@RequestBody Map<String, Object> columnMap) throws Exception;

  /**
   * <p>
   * 根据 主键ID 查询
   * </p>
   *
   * @param user_id 主键ID
   * @param master 主节点 or 从节点
   * @return OrderModel
   */
  @RequestMapping("/order/select/{master}/{user_id}")
  ResultDto<OrderModel> selectById(@PathVariable("user_id") long user_id, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 ID 批量查询
   * </p>
   *
   * @param idList 主键ID列表
   * @param master 主节点 or 从节点
   * @return List<OrderModel> 列表
   */
  @RequestMapping("/order/select/{master}/batch")
  ResultDto<List<OrderModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 查询（根据 condition 条件）
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return List<OrderModel> 列表
   */
  @RequestMapping("/order/select/{master}/list")
  ResultDto<List<OrderModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询一条记录
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return OrderModel
   */
  @RequestMapping("/order/select/{master}/one")
  ResultDto<OrderModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询并转换成map
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return Map<主键, OrderModel>
   */
  @RequestMapping("/order/select/{master}/map")
  ResultDto<Map<Integer, OrderModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询总记录数
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return long 记录数
   */
  @RequestMapping("/order/select/{master}/count")
  ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 翻页查询
   * </p>
   *
   * @param page 第几页
   * @param size 每页记录数
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return
   */
  @RequestMapping("/order/select/{master}/page/{page}/{size}")
  ResultDto<PageData<OrderModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * 创建订单
   *
   * @param commodity_id 商品id
   * @param count 数量
   * @return
   * @throws Exception
   */
  @RequestMapping("/storage/decrease")
  ResultDto<OrderModel> createOrder(@RequestParam("commodity_id") long commodity_id, @RequestParam("count") int count) throws Exception;

}
