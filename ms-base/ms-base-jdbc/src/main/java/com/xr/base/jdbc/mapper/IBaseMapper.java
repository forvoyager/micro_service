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
   * @return T 插入成功的对象
   */
  T insert(T entity);

  /**
   * <p>
   * 插入（批量），该方法不适合 Oracle
   * </p>
   *
   * @param entityList 实体对象列表
   * @return Integer 插入成功的记录数
   */
  Integer insertBatch(List<T> entityList);

  /**
   * <p>
   * 根据 columnMap 条件，删除记录
   * </p>
   *
   * @param columnMap 表字段 map 对象
   * @return Integer 删除的行数
   */
  Integer delete(Map<String, Object> columnMap);

  /**
   * <p>
   * 根据 ID 选择修改
   * </p>
   *
   * @param entity 实体对象
   * @return T 更新的行数
   */
  Integer updateById(T entity);

  /**
   * <p>
   * 根据 ID 查询
   * </p>
   *
   * @param id 主键ID
   * @return T
   */
  T selectById(Serializable id);

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
