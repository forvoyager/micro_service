package com.xr.order.service.impl;

import com.xr.account.client.api.AccountClient;
import com.xr.account.common.enums.FundsDataType;
import com.xr.base.core.util.DateUtil;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import com.xr.order.common.model.OrderModel;
import com.xr.order.mapper.OrderMapper;
import com.xr.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>time</b>: 2019-05-30 17:59:33 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品购买信息 服务实现 <br>
 */
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, OrderModel> implements IOrderService {

  @Autowired
  private AccountClient accountClient;

  @Override
  protected String getPrimaryKeyName() {
    return "user_id";
  }

  @Override
  public OrderModel createOrder(long user_id, long commodity_id, int count) throws Exception {

    // 计算订单金额
    double price = count * 100;

    // 从账户余额扣款
    accountClient.frozen(user_id, price, FundsDataType.PURCHASE_F).assertSuccess();
    accountClient.unFrozen(user_id, price, FundsDataType.PURCHASE_UF).assertSuccess();
    accountClient.payment(user_id, price, FundsDataType.PURCHASE_P).assertSuccess();

    // 创建订单
    long current = DateUtil.currentTimeInSecond();
    OrderModel order = new OrderModel();
    order.setUser_id(user_id);
    order.setCommodity_id(commodity_id);
    order.setCount(count);
    order.setMoney(price);
    order.setTrade_time(current);
    order.setCreate_time(current);
    order.setUpdate_time(current);

    return order;
  }
}
