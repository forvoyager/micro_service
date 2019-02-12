package com.xr.base.jdbc.service.impl;

import com.xr.base.core.util.*;
import com.xr.base.jdbc.core.Cluster;
import com.xr.base.jdbc.mapper.IBaseMapper;
import com.xr.base.jdbc.page.Page;
import com.xr.base.jdbc.service.IBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.*;

/**
 * 数据基础操作实现
 * Created by forvoyager@outlook.com on 2019-01-31 14:01.
 */
public abstract class BaseServiceImpl<M extends IBaseMapper<T>, T> implements IBaseService<T> {

  protected Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  protected M baseMapper;

  @Override
  public T insert(T entity) throws Exception {

    AssertUtils.notNull(entity, "insert failed, with invalid param value.");

    this.baseMapper.insert(entity);
    return entity;
  }

  @Override
  public int insertBatch(List<T> entityList) throws Exception {

    AssertUtils.notEmpty(entityList, "insert batch failed, with invalid param value.");

    this.baseMapper.insertBatch(entityList);
    return entityList.size();
  }

  @Override
  public T insertOrUpdate(T entity) throws Exception {

    AssertUtils.notNull(entity, "insert or update failed, with invalid param value.");

    Object idVal = ReflectUtils.getMethodValue(entity, this.getPrimaryKeyName());
    if (StringUtils.isEmpty(idVal)) {
      entity = insert(entity);
    } else {
      if (1 == update(entity)) {
        entity = selectOne(MapUtils.newHashMap(this.getPrimaryKeyName(), idVal), Cluster.master);
      } else {
        entity = insert(entity);
      }
    }

    return entity;
  }

  @Override
  public int deleteById(Serializable id) throws Exception {

    AssertUtils.notNull(id, "delete failed, with invalid primary key id.");

    return this.baseMapper.delete(MapUtils.newHashMap(this.getPrimaryKeyName(), id));
  }

  @Override
  public int deleteByMap(Map<String, Object> columnMap) throws Exception {

    AssertUtils.notEmpty(columnMap, "delete failed, with invalid condition.");

    return this.baseMapper.delete(columnMap);
  }

  @Override
  public int deleteBatchIds(Collection<? extends Serializable> idList) throws Exception {

    AssertUtils.notEmpty(idList, "delete batch by id failed, with invalid param value.");

    return this.baseMapper.delete(MapUtils.newHashMap("idList", idList));
  }

  @Override
  public int update(T entity) throws Exception {

    AssertUtils.notNull(entity, "update failed, with invalid param value.");

    return this.baseMapper.update(Utils.javaBeanToMap(entity));
  }

  @Override
  public int updateByMap(Map<String, Object> columnMap) throws Exception {

    AssertUtils.notEmpty(columnMap, "update failed, with invalid condition.");

    return this.baseMapper.update(columnMap);
  }

  @Override
  public T selectById(Serializable id, Cluster cluster) throws Exception {

    if(id == null){ return null; }

    List<T> data = this.baseMapper.selectList(MapUtils.newHashMap(this.getPrimaryKeyName(), id));
    return CollectionUtils.isEmpty(data) ? null : data.get(0);
  }

  @Override
  public List<T> selectBatchIds(Collection<? extends Serializable> idList, Cluster cluster) throws Exception {
    if(CollectionUtils.isEmpty(idList)){
      return Collections.EMPTY_LIST;
    }

    return this.baseMapper.selectList(MapUtils.newHashMap("idList", idList));
  }

  @Override
  public T selectOne(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    List<T> data = this.baseMapper.selectList(columnMap);
    return CollectionUtils.isEmpty(data) ? null : data.get(0);
  }

  @Override
  public List<T> selectList(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    return this.baseMapper.selectList(columnMap);
  }

  @Override
  public Map<String, T> selectMap(Map<String, Object> columnMap, Cluster cluster) throws Exception {

    Map<String, T> primaryKeyMapData = new HashMap<String, T>();

    List<T> datas = this.baseMapper.selectList(columnMap);
    for(T data : datas){
      primaryKeyMapData.put(ReflectUtils.getMethodValue(data, this.getPrimaryKeyName()).toString(), data);
    }

    return primaryKeyMapData;
  }

  @Override
  public long selectCount(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    return this.baseMapper.selectCount(columnMap);
  }

  @Override
  public Page<T> selectPage(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    // TODO
    return null;
  }

  /**
   * 主键名称
   * @return
   */
  protected abstract String getPrimaryKeyName();
}
