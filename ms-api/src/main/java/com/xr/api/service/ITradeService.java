package com.xr.api.service;

import com.xr.base.core.service.IService;
import com.xr.order.common.model.OrderModel;

/**
 * @Author: forvoyager@outlook.com
 * @Time: 2019-05-31 13:23
 * @Description: 交易 服务定义
 */
public interface ITradeService extends IService{

  /**
   * 购买商品
   * @param user_id
   * @param commodity_id 商品id
   * @param count 数量
   * @throws Exception
   */
  OrderModel purchase(long user_id, long commodity_id, int count) throws Exception;

}
