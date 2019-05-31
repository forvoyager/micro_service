package com.xr.storage.service.impl;

import com.xr.base.core.util.AssertUtils;
import com.xr.base.core.util.MapUtils;
import com.xr.base.core.util.Utils;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.storage.common.model.StorageModel;
import com.xr.storage.mapper.StorageMapper;
import com.xr.storage.service.IStorageService;
import org.springframework.stereotype.Service;

import java.util.Map;

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

  @Override
  public void decreaseStorage(long commodity_id, int count) throws Exception {
    AssertUtils.largeThanZero(count, "非法的商品数量");

    Map updateMap = MapUtils.newHashMap(
            StorageModel.COMMODITY_ID, commodity_id,
            StorageModel.COUNT, count
    );
    if(1 != this.baseMapper.decreaseStorage(updateMap)){
      Utils.throwsBaseException("减少商品库存失败");
    }

  }
}
