package com.xr.base.jdbc.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 业务基础操作定义
 *
 * Created by forvoyager@outlook.com on 2019-01-31 13:08.
 */
public interface IBaseMapper<T> {

  /**
   * <p>
   * 插入一条记录（选择字段，策略插入）
   * </p>
   *
   * @param entity 实体对象
   */
  void insert(T entity);

  /**
   * <p>
   * 插入（批量），该方法不适合 Oracle
   * </p>
   *
   * @param entityList 实体对象列表
   */
  void insertBatch(List<T> entityList);

  /**
   * <p>
   * 根据 columnMap 条件，删除记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @return Integer 删除的行数
   */
  int delete(Map<String, Object> columnMap);

  /**
   * 根据传入的map参数进行更新
   *
   * @param columnMap 参数
   * @return
   */
  int update(Map<String, Object> columnMap);

  /**
   * <p>
   * 查询（根据 columnMap 条件）
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @return List<T>
   */
  List<T> selectList(Map<String, Object> columnMap);

  /**
   * <p>
   * 根据 Wrapper 条件，查询总记录数
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @return long
   */
  long selectCount(Map<String, Object> columnMap);

}
