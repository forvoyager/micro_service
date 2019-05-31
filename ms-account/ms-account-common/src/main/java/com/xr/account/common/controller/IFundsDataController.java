package com.xr.account.common.controller;

import com.xr.account.common.model.FundsDataModel;
import com.xr.base.core.dto.ResultDto;
import com.xr.base.core.enums.Cluster;
import com.xr.base.core.page.PageData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-05-31 16:13:56 <br>
 * <b>description</b>: 账户资金流水 HTTP接口 <br>
 */
public interface IFundsDataController {

  /**
   * <p>
   * 插入一条记录
   * </p>
   *
   * @param entity 实体对象
   * @return FundsDataModel 插入成功的对象
   */
  @RequestMapping("/fundsData/insert")
  ResultDto<FundsDataModel> insert(@RequestBody FundsDataModel entity) throws Exception;

  /**
   * <p>
   * 插入（批量）
   * </p>
   *
   * @param entityList 对象列表
   * @return Integer 插入成功的记录数
   */
  @RequestMapping("/fundsData/insert/batch")
  ResultDto<Integer> insertBatch(@RequestBody List<FundsDataModel> entityList) throws Exception;

  /**
   * <p>
   * 存在则更新，否则插入
   * </p>
   *
   * @param entity 实体对象
   * @return FundsDataModel 插入/更新成功的对象
   */
  @RequestMapping("/fundsData/insert/update")
  ResultDto<FundsDataModel> insertOrUpdate(@RequestBody FundsDataModel entity) throws Exception;

  /**
   * <p>
   * 根据 主键ID 删除
   * </p>
   *
   * @param id 主键ID
   * @return Integer 删除的行数
   */
  @RequestMapping("/fundsData/delete/{id}")
  ResultDto<Integer> deleteById(@PathVariable("id") long id) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，删除记录
   * </p>
   *
   * @param condition 删除条件
   * @return Integer 删除的行数
   */
  @RequestMapping("/fundsData/delete")
  ResultDto<Long> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception;

  /**
   * <p>
   * 根据 model 修改数据
   * </p>
   *
   * @param entity 实体对象
   * @return FundsDataModel 更新的行数
   */
  @RequestMapping("/fundsData/update/model")
  ResultDto<Long> update(@RequestBody FundsDataModel entity) throws Exception;

  /**
   * <p>
   * 根据map条件 修改
   * </p>
   *
   * @param columnMap 更新数据/更新条件
   * @return Integer 更新的行数
   */
  @RequestMapping("/fundsData/update/map")
  ResultDto<Long> updateByMap(@RequestBody Map<String, Object> columnMap) throws Exception;

  /**
   * <p>
   * 根据 主键ID 查询
   * </p>
   *
   * @param id 主键ID
   * @param master 主节点 or 从节点
   * @return FundsDataModel
   */
  @RequestMapping("/fundsData/select/{master}/{id}")
  ResultDto<FundsDataModel> selectById(@PathVariable("id") long id, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 ID 批量查询
   * </p>
   *
   * @param idList 主键ID列表
   * @param master 主节点 or 从节点
   * @return List<FundsDataModel> 列表
   */
  @RequestMapping("/fundsData/select/{master}/batch")
  ResultDto<List<FundsDataModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 查询（根据 condition 条件）
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return List<FundsDataModel> 列表
   */
  @RequestMapping("/fundsData/select/{master}/list")
  ResultDto<List<FundsDataModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询一条记录
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return FundsDataModel
   */
  @RequestMapping("/fundsData/select/{master}/one")
  ResultDto<FundsDataModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询并转换成map
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return Map<主键, FundsDataModel>
   */
  @RequestMapping("/fundsData/select/{master}/map")
  ResultDto<Map<Integer, FundsDataModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询总记录数
   * </p>
   *
   * @param condition 查询条件
   * @param master 主节点 or 从节点
   * @return long 记录数
   */
  @RequestMapping("/fundsData/select/{master}/count")
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
  @RequestMapping("/fundsData/select/{master}/page/{page}/{size}")
  ResultDto<PageData<FundsDataModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

}
