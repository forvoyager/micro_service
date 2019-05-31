package com.xr.order.service;

import com.xr.order.common.model.OrderModel;
import com.xr.base.jdbc.service.IBaseService;

/**
 * <b>time</b>: 2019-05-30 17:59:33 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品购买信息 服务定义 <br>
 */
public interface IOrderService extends IBaseService<OrderModel> {

  /**
   * 创建订单
   * @param commodity_id 商品ID
   * @param count 数量
   * @throws Exception
   */
  OrderModel createOrder(long commodity_id, int count) throws Exception;

}
