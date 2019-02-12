package com.xr.base.jdbc.service.impl;

import com.xr.base.core.util.CollectionUtils;
import com.xr.base.core.util.MapUtils;
import com.xr.base.core.util.ReflectUtils;
import com.xr.base.core.util.StringUtils;
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
    this.baseMapper.insert(entity);
    return entity;
  }

  @Override
  public int insertBatch(List<T> entityList) throws Exception {
    if (CollectionUtils.isEmpty(entityList)) {
      throw new IllegalArgumentException("Error: entityList must not be empty");
    }
    this.baseMapper.insertBatch(entityList);
    return entityList.size();
  }

  @Override
  public T insertOrUpdate(T entity) throws Exception {
    if(entity != null){
      Object idVal = ReflectUtils.getMethodValue(entity, this.getPrimaryKeyName());
      if (StringUtils.isEmpty(idVal)) {
        entity = insert(entity);
      } else {
          /*
           * 更新成功直接返回，失败执行插入逻辑
           */
        if (1 == update(entity)) {
          entity = selectOne(MapUtils.newHashMap(this.getPrimaryKeyName(), idVal), Cluster.master);
        } else {
          entity = insert(entity);
        }
      }
    }

    return entity;
  }

  @Override
  public int deleteById(Serializable id) throws Exception {
    return this.baseMapper.delete(MapUtils.newHashMap(this.getPrimaryKeyName(), id));
  }

  @Override
  public int deleteByMap(Map<String, Object> columnMap) throws Exception {
    return this.baseMapper.delete(columnMap);
  }

  @Override
  public int deleteBatchIds(Collection<? extends Serializable> idList) throws Exception {
    return this.baseMapper.delete(MapUtils.newHashMap("idList", idList));
  }

  @Override
  public int update(T entity) throws Exception {
    return this.baseMapper.update(entity);
  }

  @Override
  public int updateByMap(Map<String, Object> columnMap) throws Exception {
    return this.baseMapper.updateByMap(columnMap);
  }

  @Override
  public T selectById(Serializable id, Cluster cluster) throws Exception {
    return this.baseMapper.selectById(id);
  }

  @Override
  public List<T> selectBatchIds(Collection<? extends Serializable> idList, Cluster cluster) throws Exception {
    if(CollectionUtils.isEmpty(idList)){
      return Collections.EMPTY_LIST;
    }

    return this.baseMapper.selectList(MapUtils.newHashMap("idList", idList));
  }

  @Override
  public List<T> selectList(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    return this.baseMapper.selectList(columnMap);
  }

  @Override
  public T selectOne(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    List<T> datas = this.baseMapper.selectList(columnMap);
    return CollectionUtils.isEmpty(datas) ? null : datas.get(0);
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
