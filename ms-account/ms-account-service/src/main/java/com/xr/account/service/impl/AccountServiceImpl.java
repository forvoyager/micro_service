package com.xr.account.service.impl;

import com.xr.account.common.enums.FundsDataType;
import com.xr.account.common.model.AccountModel;
import com.xr.account.common.model.FundsDataModel;
import com.xr.account.mapper.AccountMapper;
import com.xr.account.service.IAccountService;
import com.xr.account.service.IFundsDataService;
import com.xr.base.core.enums.Cluster;
import com.xr.base.core.util.ArithUtil;
import com.xr.base.core.util.AssertUtils;
import com.xr.base.core.util.DateUtil;
import com.xr.base.core.util.MapUtils;
import com.xr.base.core.util.Utils;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <b>description</b>：账户信息 业务操作接口实现 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, AccountModel> implements IAccountService {

  @Resource
  private IFundsDataService fundsDataService;

  @Override
  protected String getPrimaryKeyName() {
    return "user_id";
  }

  @Override
  public void frozen(long user_id, double price, FundsDataType type) throws Exception {
    AssertUtils.largeThanZero(price, "非法的金额");
    AssertUtils.notNull(type, "非法的资金操作类型");

    long current = DateUtil.currentTimeInSecond();
    AccountModel account = this.selectById(user_id, Cluster.master);

    // 可用资金-- 冻结资金++
    Map updateMap = MapUtils.newHashMap(
            AccountModel.USER_ID, user_id,
            AccountModel.BALANCE, -price,
            AccountModel.FROZEN, price,
            AccountModel.UPDATE_TIME, current,
            AccountModel.WHERE_VERSION, account.getVersion()
    );
    if( 1 != this.baseMapper.updateUserFunds(updateMap)){
      Utils.throwsBaseException("冻结用户资金失败");
    }

    // 记录流水
    this.insertFundsData(user_id, price, ArithUtil.sub(account.getBalance(), price), type, current);
  }

  @Override
  public void unFrozen(long user_id, double price, FundsDataType type) throws Exception {
    AssertUtils.largeThanZero(price, "非法的金额");
    AssertUtils.notNull(type, "非法的资金操作类型");

    long current = DateUtil.currentTimeInSecond();
    AccountModel account = this.selectById(user_id, Cluster.master);

    // 可用资金++ 冻结资金--
    Map updateMap = MapUtils.newHashMap(
            AccountModel.USER_ID, user_id,
            AccountModel.BALANCE, price,
            AccountModel.FROZEN, -price,
            AccountModel.UPDATE_TIME, current,
            AccountModel.WHERE_VERSION, account.getVersion()
    );
    if( 1 != this.baseMapper.updateUserFunds(updateMap)){
      Utils.throwsBaseException("冻结用户资金失败");
    }

    // 记录流水
    this.insertFundsData(user_id, price, ArithUtil.add(account.getBalance(), price), type, current);
  }

  @Override
  public void payment(long user_id, double price, FundsDataType type) throws Exception {
    AssertUtils.largeThanZero(price, "非法的金额");
    AssertUtils.notNull(type, "非法的资金操作类型");

    long current = DateUtil.currentTimeInSecond();
    AccountModel account = this.selectById(user_id, Cluster.master);

    // 可用资金--
    Map updateMap = MapUtils.newHashMap(
            AccountModel.USER_ID, user_id,
            AccountModel.BALANCE, -price,
            AccountModel.UPDATE_TIME, current,
            AccountModel.WHERE_VERSION, account.getVersion()
    );
    if( 1 != this.baseMapper.updateUserFunds(updateMap)){
      Utils.throwsBaseException("冻结用户资金失败");
    }

    // 记录流水
    this.insertFundsData(user_id, price, ArithUtil.sub(account.getBalance(), price), type, current);
  }

  /**
   * 记录资金流水
   * @param user_id
   * @param price
   * @param blance
   * @param type
   * @param current
   * @throws Exception
   */
  private void insertFundsData(long user_id, double price, double blance, FundsDataType type, long current) throws Exception{
    FundsDataModel fundsData = new FundsDataModel();
    fundsData.setUser_id(user_id);
    fundsData.setPrice(price);
    fundsData.setBalance(blance);
    fundsData.setType(type.getType());
    fundsData.setFlag(type.getFlag());
    fundsData.setRef_id(0L);
    fundsData.setRef_table(0);
    fundsData.setCreate_time(current);
    fundsData.setUpdate_time(current);
    fundsDataService.insert(fundsData);
  }
}
