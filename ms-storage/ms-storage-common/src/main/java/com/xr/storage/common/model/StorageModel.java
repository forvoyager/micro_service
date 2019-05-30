package com.xr.storage.common.model;

import com.xr.base.core.model.BaseModel;

/**
 * <b>time</b>: 2019-05-30 18:00:32 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品库存信息 模型 <br>
 */
public class StorageModel extends BaseModel {

  public static final String COMMODITY_ID = "commodity_id";
  public static final String COUNT = "count";

  /**
   * 商品ID
   */
  private Integer commodity_id;
  /**
   * 库存数量
   */
  private Integer count;

  public Integer getCommodity_id() {
    return this.commodity_id;
  }
  public StorageModel setCommodity_id(Integer commodity_id) {
    this.commodity_id = commodity_id;
    return this;
  }

  public Integer getCount() {
    return this.count;
  }
  public StorageModel setCount(Integer count) {
    this.count = count;
    return this;
  }

}

