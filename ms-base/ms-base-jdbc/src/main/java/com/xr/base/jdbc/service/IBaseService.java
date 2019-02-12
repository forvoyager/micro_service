package com.xr.base.jdbc.service;

import com.xr.base.core.service.IService;
import com.xr.base.jdbc.core.Cluster;
import com.xr.base.jdbc.page.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
  @Transactional(propagation = Propagation.REQUIRED)
  T insert(T entity) throws Exception;

  /**
   * <p>
   * 插入（批量），该方法不适合 Oracle
   * </p>
   *
   * @param entityList 实体对象列表
   * @return Integer 插入成功的记录数
   */
  @Transactional(propagation = Propagation.REQUIRED)
  int insertBatch(List<T> entityList) throws Exception;

  /**
   * <p>
   * 存在则更新，否则插入
   * </p>
   *
   * @param entity 实体对象
   * @return T 插入/更新成功的对象
   */
  @Transactional(propagation = Propagation.REQUIRED)
  T insertOrUpdate(T entity) throws Exception;

  /**
   * <p>
   * 根据 ID 删除
   * </p>
   *
   * @param id 主键ID
   * @return Integer 删除的行数
   */
  @Transactional(propagation = Propagation.REQUIRED)
  int deleteById(Serializable id) throws Exception;

  /**
   * <p>
   * 根据ID 批量删除
   * </p>
   *
   * @param idList 主键ID列表
   * @return Integer 删除的行数
   */
  @Transactional(propagation = Propagation.REQUIRED)
  int deleteBatchIds(Collection<? extends Serializable> idList) throws Exception;

  /**
   * <p>
   * 根据 columnMap 条件，删除记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @return Integer 删除的行数
   */
  @Transactional(propagation = Propagation.REQUIRED)
  int deleteByMap(Map<String, Object> columnMap) throws Exception;

  /**
   * <p>
   * 修改
   * </p>
   *
   * @param entity 实体对象
   * @return T 更新的行数
   */
  @Transactional(propagation = Propagation.REQUIRED)
  int update(T entity) throws Exception;

  /**
   * <p>
   * 根据 columnMap 条件，修改记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @return Integer 删除的行数
   */
  @Transactional(propagation = Propagation.REQUIRED)
  int updateByMap(Map<String, Object> columnMap) throws Exception;

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
   * 根据 ID 批量查询
   * </p>
   *
   * @param idList
   * @param cluster
   * @return
   * @throws Exception
   */
  List<T> selectBatchIds(Collection<? extends Serializable> idList, Cluster cluster) throws Exception;

  /**
   * <p>
   * 根据 columnMapt条件，查询一条记录
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
  Map<String, T> selectMap(Map<String, Object> columnMap, Cluster cluster) throws Exception;

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
