package com.xr.order.mapper;

import com.xr.order.common.model.OrderModel;
import com.xr.base.jdbc.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b>time</b>: 2019-05-30 17:59:33 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品购买信息 mapper操作 <br>
 */
@Mapper
public interface OrderMapper extends IBaseMapper<OrderModel> {
}
