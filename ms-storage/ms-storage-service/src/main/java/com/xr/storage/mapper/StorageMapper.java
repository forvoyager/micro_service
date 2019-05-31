package com.xr.storage.mapper;

import com.xr.storage.common.model.StorageModel;
import com.xr.base.jdbc.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * <b>time</b>: 2019-05-30 18:00:32 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品库存信息 mapper操作 <br>
 */
@Mapper
public interface StorageMapper extends IBaseMapper<StorageModel> {

  /**
   * 减少库存
   *
   * @param columnMap 更新参数/查询条件
   * @return
   */
  int decreaseStorage(Map<String, Object> columnMap);

}
