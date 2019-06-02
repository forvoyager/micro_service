package com.xr.order.common.model;

import com.xr.base.core.model.BaseModel;

/**
 * <b>time</b>: 2019-05-30 17:59:33 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品购买信息 模型 <br>
 */
public class OrderModel extends BaseModel {

  public static final String USER_ID = "user_id";
  public static final String COMMODITY_ID = "commodity_id";
  public static final String COUNT = "count";
  public static final String MONEY = "money";
  public static final String TRADE_TIME = "trade_time";

  /**
   * 用户ID
   */
  private Long user_id;
  /**
   * 商品ID
   */
  private Long commodity_id;
  /**
   * 商品数量
   */
  private Integer count;
  /**
   * 成交金额
   */
  private Double money;
  /**
   * 成交时间（秒数）
   */
  private Long trade_time;

  public Long getUser_id() {
    return this.user_id;
  }
  public OrderModel setUser_id(Long user_id) {
    this.user_id = user_id;
    return this;
  }

  public Long getCommodity_id() {
    return this.commodity_id;
  }
  public OrderModel setCommodity_id(Long commodity_id) {
    this.commodity_id = commodity_id;
    return this;
  }

  public Integer getCount() {
    return this.count;
  }
  public OrderModel setCount(Integer count) {
    this.count = count;
    return this;
  }

  public Double getMoney() {
    return this.money;
  }
  public OrderModel setMoney(Double money) {
    this.money = money;
    return this;
  }

  public Long getTrade_time() {
    return this.trade_time;
  }
  public OrderModel setTrade_time(Long trade_time) {
    this.trade_time = trade_time;
    return this;
  }

}

