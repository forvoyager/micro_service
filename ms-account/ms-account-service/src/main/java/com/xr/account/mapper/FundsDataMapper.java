package com.xr.account.mapper;

import com.xr.account.common.model.FundsDataModel;
import com.xr.base.jdbc.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-05-31 16:13:56 <br>
 * <b>description</b>: 账户资金流水 mapper操作 <br>
 */
@Mapper
public interface FundsDataMapper extends IBaseMapper<FundsDataModel> {
}
