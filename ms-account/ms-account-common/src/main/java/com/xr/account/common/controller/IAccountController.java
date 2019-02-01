package com.xr.account.common.controller;

import com.xr.account.common.model.AccountModel;
import com.xr.base.core.dto.ResultDto;
import com.xr.base.jdbc.page.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <b>description</b>：账户 restful接口 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：yangchangyan@yijiedai.com
 */
public interface IAccountController {

  /**
   * <p>
   * 插入一条记录（选择字段，策略插入）
   * </p>
   *
   * @param entity 实体对象
   * @return AccountModel 插入成功的对象
   */
  @RequestMapping("")
  ResultDto<AccountModel> insert(@RequestBody AccountModel entity) throws Exception;

  /**
   * <p>
   * 插入（批量），该方法不适合 Oracle
   * </p>
   *
   * @param entityList 实体对象列表
   * @return Integer 插入成功的记录数
   */
  ResultDto<Integer> insertBatch(@RequestBody List<AccountModel> entityList) throws Exception;

  /**
   * <p>
   * AccountModelableId 注解存在更新记录，否插入一条记录
   * </p>
   *
   * @param entity 实体对象
   * @return AccountModel 插入/更新成功的对象
   */
  ResultDto<AccountModel> insertOrUpdate(@RequestBody AccountModel entity) throws Exception;

  /**
   * <p>
   * 根据 ID 删除
   * </p>
   *
   * @param id 主键ID
   * @return Integer 删除的行数
   */
  ResultDto<Integer> deleteById(@RequestParam("id") Long id) throws Exception;

  /**
   * <p>
   * 根据 columnMap 条件，删除记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @return Integer 删除的行数
   */
  ResultDto<Integer> deleteByMap(@RequestBody Map<String, Object> columnMap) throws Exception;

  /**
   * <p>
   * 根据 ID 选择修改
   * </p>
   *
   * @param entity 实体对象
   * @return AccountModel 更新的行数
   */
  ResultDto<Integer> updateById(@RequestBody AccountModel entity) throws Exception;

  /**
   * <p>
   * 根据 ID 查询
   * </p>
   *
   * @param id 主键ID
   * @param master 主节点 or 从节点
   * @return AccountModel
   */
  ResultDto<AccountModel> selectById(@RequestParam("id") Long id, @RequestParam("master") boolean master) throws Exception;

  /**
   * <p>
   * 查询（根据ID 批量查询）
   * </p>
   *
   * @param idList 主键ID列表
   * @param master 主节点 or 从节点
   * @return List<AccountModel>
   */
  ResultDto<List<AccountModel>> selectBatchIds(@RequestBody List<Long> idList, @RequestParam("master") boolean master) throws Exception;

  /**
   * <p>
   * 查询（根据 columnMap 条件）
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return List<AccountModel>
   */
  ResultDto<List<AccountModel>> selectList(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception;

  /**
   * <p>
   * 根据 Wrapper，查询一条记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return AccountModel
   */
  ResultDto<AccountModel> selectOne(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception;

  /**
   * <p>
   * 根据 Wrapper，查询一条记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return Map<String,Object>
   */
  ResultDto<Map<String, Object>> selectMap(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception;

  /**
   * <p>
   * 根据 Wrapper 条件，查询总记录数
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return long
   */
  ResultDto<Long> selectCount(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception;

  /**
   * <p>
   * 翻页查询
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param master 主节点 or 从节点
   * @return
   */
  ResultDto<Page<AccountModel>> selectPage(@RequestBody Map<String, Object> columnMap, @RequestParam("master") boolean master) throws Exception;

}
