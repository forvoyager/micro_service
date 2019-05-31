package com.xr.account.service.impl;

import com.xr.account.common.model.FundsDataModel;
import com.xr.account.service.IFundsDataService;
import com.xr.account.mapper.FundsDataMapper;
import com.xr.base.jdbc.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-05-31 16:13:56 <br>
 * <b>description</b>: 账户资金流水 服务实现 <br>
 */
@Service("fundsDataService")
public class FundsDataServiceImpl extends BaseServiceImpl<FundsDataMapper, FundsDataModel> implements IFundsDataService {
  @Override
  protected String getPrimaryKeyName() {
    return "id";
  }
}
