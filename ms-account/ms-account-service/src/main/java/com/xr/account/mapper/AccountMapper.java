package com.xr.account.mapper;

import com.xr.account.common.model.AccountModel;
import com.xr.base.jdbc.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * <b>description</b>：账户信息 相关操作mapper <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：forvoyager@outlook.com
 */
@Mapper
public interface AccountMapper extends IBaseMapper<AccountModel> {

  /**
   * 更新用户资金信息
   * @param condition
   * @return
   * @throws Exception
   */
  int updateUserFunds(Map<String, Object> condition) throws Exception;

}
