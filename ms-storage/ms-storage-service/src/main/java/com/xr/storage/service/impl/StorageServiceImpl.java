package com.xr.storage.service.impl;

import com.xr.storage.common.model.StorageModel;
import com.xr.storage.service.IStorageService;
import com.xr.storage.mapper.StorageMapper;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <b>time</b>: 2019-05-30 18:00:32 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品库存信息 服务实现 <br>
 */
@Service("storageService")
public class StorageServiceImpl extends BaseServiceImpl<StorageMapper, StorageModel> implements IStorageService {
  @Override
  protected String getPrimaryKeyName() {
    return "commodity_id";
  }
}
