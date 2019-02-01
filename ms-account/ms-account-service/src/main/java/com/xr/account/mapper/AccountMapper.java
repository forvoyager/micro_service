package com.xr.account.mapper;

import com.xr.account.common.model.AccountModel;
import com.xr.base.jdbc.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>description</b>：账户信息 相关操作mapper <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：yangchangyan@yijiedai.com
 */
@Mapper
public interface AccountMapper extends IBaseMapper<AccountModel> {
}
