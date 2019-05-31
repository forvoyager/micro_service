package com.xr.order.service.impl;

import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.order.common.model.OrderModel;
import com.xr.order.mapper.OrderMapper;
import com.xr.order.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * <b>time</b>: 2019-05-30 17:59:33 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品购买信息 服务实现 <br>
 */
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, OrderModel> implements IOrderService {

  @Override
  protected String getPrimaryKeyName() {
    return "user_id";
  }

  @Override
  public OrderModel createOrder(long commodity_id, int count) throws Exception {

    // 计算订单金额
    double price = count * 100;

    // 从账户余额扣款

    // 创建订单

    return null;
  }
}
