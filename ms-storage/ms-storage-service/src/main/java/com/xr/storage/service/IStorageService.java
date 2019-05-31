package com.xr.storage.service;

import com.xr.storage.common.model.StorageModel;
import com.xr.base.jdbc.service.IBaseService;

/**
 * <b>time</b>: 2019-05-30 18:00:32 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品库存信息 服务定义 <br>
 */
public interface IStorageService extends IBaseService<StorageModel> {

  /**
   * 减少库存
   * @param commodity_id 商品ID
   * @param count 数量
   * @throws Exception
   */
  void decreaseStorage(long commodity_id, int count) throws Exception;

}
