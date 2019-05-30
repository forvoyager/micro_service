package com.xr.storage.mapper;

import com.xr.storage.common.model.StorageModel;
import com.xr.base.jdbc.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>time</b>: 2019-05-30 18:00:32 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品库存信息 mapper操作 <br>
 */
@Mapper
public interface StorageMapper extends IBaseMapper<StorageModel> {
}
