package com.xr.account.common.controller;

import com.xr.account.common.enums.FundsDataType;
import com.xr.account.common.model.AccountModel;
import com.xr.base.core.dto.ResultDto;
import com.xr.base.core.enums.Cluster;
import com.xr.base.core.page.PageData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <b>description</b>：账户信息 restful接口 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
public interface IAccountController {

  /**
   * <p>
   * 插入一条记录
   * </p>
   *
   * @param entity 实体对象
   * @return AccountModel 插入成功的对象
   */
  @RequestMapping("/account/insert")
  ResultDto<AccountModel> insert(@RequestBody AccountModel entity) throws Exception;

  /**
   * <p>
   * 插入（批量）
   * </p>
   *
   * @param entityList 实体对象列表
   * @return Integer 插入成功的记录数
   */
  @RequestMapping("/account/insert/batch")
  ResultDto<Integer> insertBatch(@RequestBody List<AccountModel> entityList) throws Exception;

  /**
   * <p>
   * 存在则更新，否则插入
   * </p>
   *
   * @param entity 实体对象
   * @return AccountModel 插入/更新成功的对象
   */
  @RequestMapping("/account/insert/update")
  ResultDto<AccountModel> insertOrUpdate(@RequestBody AccountModel entity) throws Exception;

  /**
   * <p>
   * 根据 ID 删除
   * </p>
   *
   * @param user_id 主键ID
   * @return Integer 删除的行数
   */
  @RequestMapping("/account/delete/{user_id}")
  ResultDto<Integer> deleteById(@PathVariable("user_id") long user_id) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，删除记录
   * </p>
   *
   * @param condition 表字段 map 对象
   * @return Integer 删除的行数
   */
  @RequestMapping("/account/delete")
  ResultDto<Integer> deleteByMap(@RequestBody Map<String, Object> condition) throws Exception;

  /**
   * <p>
   * 根据model条件 修改
   * </p>
   *
   * @param entity 实体对象
   * @return AccountModel 更新的行数
   */
  @RequestMapping("/account/update/model")
  ResultDto<Integer> update(@RequestBody AccountModel entity) throws Exception;

  /**
   * <p>
   * 根据map条件 修改
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @return Integer 修改的行数
   */
  @RequestMapping("/account/update/map")
  ResultDto<Integer> updateByMap(@RequestBody Map<String, Object> columnMap) throws Exception;

  /**
   * <p>
   * 根据 ID 查询
   * </p>
   *
   * @param user_id 主键ID
   * @param master 主节点 or 从节点
   * @return AccountModel
   */
  @RequestMapping("/account/select/{master}/{user_id}")
  ResultDto<AccountModel> selectById(@PathVariable("user_id") long user_id, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 ID 批量查询
   * </p>
   *
   * @param idList 主键ID列表
   * @param master 主节点 or 从节点
   * @return AccountModel
   */
  @RequestMapping("/account/select/{master}/batch")
  ResultDto<List<AccountModel>> selectByIds(@RequestBody Collection<? extends Serializable> idList, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 查询（根据 condition 条件）
   * </p>
   *
   * @param condition 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return List<AccountModel>
   */
  @RequestMapping("/account/select/{master}/list")
  ResultDto<List<AccountModel>> selectList(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询一条记录
   * </p>
   *
   * @param condition 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return AccountModel
   */
  @RequestMapping("/account/select/{master}/one")
  ResultDto<AccountModel> selectOne(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询并转换成map
   * </p>
   *
   * @param condition 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return Map<String,Object>
   */
  @RequestMapping("/account/select/{master}/map")
  ResultDto<Map<String, AccountModel>> selectMap(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 根据 condition 条件，查询总记录数
   * </p>
   *
   * @param condition 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return long
   */
  @RequestMapping("/account/select/{master}/count")
  ResultDto<Long> selectCount(@RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * <p>
   * 翻页查询
   * </p>
   *
   * @param page 第几页
   * @param size 每页记录数
   * @param condition 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return
   */
  @RequestMapping("/account/select/{master}/page/{page}/{size}")
  ResultDto<PageData<AccountModel>> selectPage(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody Map<String, Object> condition, @PathVariable("master") Cluster master) throws Exception;

  /**
   * 冻结用户资金
   * @param user_id 用户id
   * @param price 金额
   * @param type 流水类型
   * @throws Exception
   */
  ResultDto frozen(@RequestParam("user_id") long user_id, @RequestParam("price") double price, @RequestParam("type") FundsDataType type) throws Exception;

  /**
   * 解冻用户资金
   * @param user_id 用户id
   * @param price 金额
   * @param type 流水类型
   * @throws Exception
   */
  ResultDto unFrozen(@RequestParam("user_id") long user_id, @RequestParam("price") double price, @RequestParam("type") FundsDataType type) throws Exception;

  /**
   * 支出用户资金
   * @param user_id 用户id
   * @param price 金额
   * @param type 流水类型
   * @throws Exception
   */
  ResultDto payment(@RequestParam("user_id") long user_id, @RequestParam("price") double price, @RequestParam("type") FundsDataType type) throws Exception;
}
