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
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
  public Integer insertBatch(List<T> entityList) throws Exception {
    if (CollectionUtils.isEmpty(entityList)) {
      throw new IllegalArgumentException("Error: entityList must not be empty");
    }
    this.baseMapper.insertBatch(entityList);
    return entityList.size();
  }

  @Override
  public T insertOrUpdate(T entity) throws Exception {
    if(entity != null){
      Object idVal = ReflectUtils.getMethodValue(entity.getClass(), entity, this.getPrimaryKeyName());
      if (StringUtils.isEmpty(idVal)) {
        entity = insert(entity);
      } else {
          /*
           * 更新成功直接返回，失败执行插入逻辑
           */
        if (1 == update(entity)) {
          // do nothing
        } else {
          entity = insert(entity);
        }
      }
    }

    return entity;
  }

  @Override
  public Integer insertOrUpdateBatch(List<T> entityList) throws Exception {
    return null;
  }

  @Override
  public Integer deleteById(Serializable id) throws Exception {
    return this.baseMapper.delete(MapUtils.newHashMap(this.getPrimaryKeyName(), id));
  }

  @Override
  public Integer deleteByMap(Map<String, Object> columnMap) throws Exception {
    return this.baseMapper.delete(columnMap);
  }

  @Override
  public Integer deleteBatchIds(Collection<? extends Serializable> idList) throws Exception {
    return this.baseMapper.delete(MapUtils.newHashMap("idList", idList));
  }

  @Override
  public Integer update(T entity) throws Exception {
    return this.baseMapper.update(entity);
  }

  @Override
  public T selectById(Serializable id, Cluster cluster) throws Exception {
    return this.baseMapper.selectById(id);
  }

  @Override
  public List<T> selectList(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    return this.baseMapper.selectList(columnMap);
  }

  @Override
  public T selectOne(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    return null;
  }

  @Override
  public Map<String, Object> selectMap(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    return null;
  }

  @Override
  public long selectCount(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    return this.baseMapper.selectCount(columnMap);
  }

  @Override
  public Page<T> selectPage(Map<String, Object> columnMap, Cluster cluster) throws Exception {
    return null;
  }

  /**
   * 主键名称
   * @return
   */
  protected abstract String getPrimaryKeyName();
}
