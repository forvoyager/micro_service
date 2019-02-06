package com.xr.base.jdbc.service;

import com.xr.base.core.service.IService;
import com.xr.base.jdbc.core.Cluster;
import com.xr.base.jdbc.page.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 数据基础操作定义
 *
 * Created by forvoyager@outlook.com on 2019-01-31 13:08.
 */
public interface IBaseService<T> extends IService {

  /**
   * <p>
   * 插入一条记录（选择字段，策略插入）
   * </p>
   *
   * @param entity 实体对象
   * @return T 插入成功的对象
   */
  T insert(T entity) throws Exception;

  /**
   * <p>
   * 插入（批量），该方法不适合 Oracle
   * </p>
   *
   * @param entityList 实体对象列表
   * @return Integer 插入成功的记录数
   */
  Integer insertBatch(List<T> entityList) throws Exception;

  /**
   * <p>
   * TableId 注解存在更新记录，否插入一条记录
   * </p>
   *
   * @param entity 实体对象
   * @return T 插入/更新成功的对象
   */
  T insertOrUpdate(T entity) throws Exception;

  /**
   * <p>
   * 批量修改插入
   * </p>
   *
   * @param entityList 实体对象列表
   * @return Integer 插入/更新成功的记录数
   */
  Integer insertOrUpdateBatch(List<T> entityList) throws Exception;

  /**
   * <p>
   * 根据 ID 删除
   * </p>
   *
   * @param id 主键ID
   * @return Integer 删除的行数
   */
  Integer deleteById(Serializable id) throws Exception;

  /**
   * <p>
   * 删除（根据ID 批量删除）
   * </p>
   *
   * @param idList 主键ID列表
   * @return Integer 删除的行数
   */
  Integer deleteBatchIds(Collection<? extends Serializable> idList) throws Exception;

  /**
   * <p>
   * 根据 columnMap 条件，删除记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @return Integer 删除的行数
   */
  Integer deleteByMap(Map<String, Object> columnMap) throws Exception;

  /**
   * <p>
   * 修改
   * </p>
   *
   * @param entity 实体对象
   * @return T 更新的行数
   */
  Integer update(T entity) throws Exception;

  /**
   * <p>
   * 根据ID 批量更新
   * </p>
   *
   * @param entityList 实体对象列表
   * @return Integer 更新的行数
   */
  Integer updateBatchById(List<T> entityList) throws Exception;

  /**
   * <p>
   * 根据 ID 查询
   * </p>
   *
   * @param id 主键ID
   * @param cluster 主节点 or 从节点
   * @return T
   */
  T selectById(Serializable id, Cluster cluster) throws Exception;

  /**
   * <p>
   * 根据 Wrapper，查询一条记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param cluster 主节点 or 从节点
   * @return T
   */
  T selectOne(Map<String, Object> columnMap, Cluster cluster) throws Exception;

  /**
   * <p>
   * 查询（根据 columnMap 条件）
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param cluster 主节点 or 从节点
   * @return List<T>
   */
  List<T> selectList(Map<String, Object> columnMap, Cluster cluster) throws Exception;

  /**
   * <p>
   * 根据 Wrapper，查询一条记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param cluster 主节点 or 从节点
   * @return Map<String,Object>
   */
  Map<String, Object> selectMap(Map<String, Object> columnMap, Cluster cluster) throws Exception;

  /**
   * <p>
   * 根据 Wrapper 条件，查询总记录数
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param cluster 主节点 or 从节点
   * @return long
   */
  long selectCount(Map<String, Object> columnMap, Cluster cluster) throws Exception;

  /**
   * <p>
   * 翻页查询
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @param cluster 主节点 or 从节点
   * @return
   */
  Page<T> selectPage(Map<String, Object> columnMap, Cluster cluster) throws Exception;

}
