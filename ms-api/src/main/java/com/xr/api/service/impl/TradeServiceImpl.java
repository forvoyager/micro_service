package com.xr.api.service.impl;

import com.xr.api.service.ITradeService;
import com.xr.base.core.util.JsonUtils;
import com.xr.order.client.api.OrderClient;
import com.xr.order.common.model.OrderModel;
import com.xr.storage.client.api.StorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: forvoyager@outlook.com
 * @Time: 2019-05-31 13:22
 * @Description: 交易 服务实现
 */
@Service
public class TradeServiceImpl implements ITradeService {

  protected Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private StorageClient storageClient;

  @Autowired
  private OrderClient orderClient;

  @Override
  public OrderModel purchase(long user_id, long commodity_id, int count) throws Exception {

    // 1、减库存
    logger.info("减少库存");
    storageClient.decreaseStorage(commodity_id, count).assertSuccess();

    // 2、创建订单
    logger.info("开始创建订单");
    OrderModel orderModel = orderClient.createOrder(user_id, commodity_id, count).getSuccessData();

    logger.info("购买商品成功，订单信息：{}", JsonUtils.toJson(orderModel));

    return orderModel;
  }

}
