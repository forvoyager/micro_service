package com.xr.account.common.model;

import com.xr.base.core.model.BaseModel;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-05-31 16:13:56 <br>
 * <b>description</b>: 账户资金流水 模型 <br>
 */
public class FundsDataModel extends BaseModel {

  public static final String ID = "id";
  public static final String USER_ID = "user_id";
  public static final String PRICE = "price";
  public static final String BALANCE = "balance";
  public static final String TYPE = "type";
  public static final String FLAG = "flag";
  public static final String REF_ID = "ref_id";
  public static final String REF_TABLE = "ref_table";

  /**
   * ID
   */
  private Integer id;
  /**
   * 用户ID
   */
  private Long user_id;
  /**
   * 发生金额
   */
  private Double price;
  /**
   * 余额
   */
  private Double balance;
  /**
   * 流水类型
   */
  private Integer type;
  /**
   * 标志位 -1减少 0不变 1增加 
   */
  private Integer flag;
  /**
   * 关联ID
   */
  private Long ref_id;
  /**
   * 关联表
   */
  private Integer ref_table;

  public Integer getId() {
    return this.id;
  }
  public FundsDataModel setId(Integer id) {
    this.id = id;
    return this;
  }

  public Long getUser_id() {
    return this.user_id;
  }
  public FundsDataModel setUser_id(Long user_id) {
    this.user_id = user_id;
    return this;
  }

  public Double getPrice() {
    return this.price;
  }
  public FundsDataModel setPrice(Double price) {
    this.price = price;
    return this;
  }

  public Double getBalance() {
    return this.balance;
  }
  public FundsDataModel setBalance(Double balance) {
    this.balance = balance;
    return this;
  }

  public Integer getType() {
    return this.type;
  }
  public FundsDataModel setType(Integer type) {
    this.type = type;
    return this;
  }

  public Integer getFlag() {
    return this.flag;
  }
  public FundsDataModel setFlag(Integer flag) {
    this.flag = flag;
    return this;
  }

  public Long getRef_id() {
    return this.ref_id;
  }
  public FundsDataModel setRef_id(Long ref_id) {
    this.ref_id = ref_id;
    return this;
  }

  public Integer getRef_table() {
    return this.ref_table;
  }
  public FundsDataModel setRef_table(Integer ref_table) {
    this.ref_table = ref_table;
    return this;
  }

}

