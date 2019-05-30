package com.xr.order.client.api;

import com.xr.order.common.controller.IOrderController;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>time</b>: 2019-05-30 17:59:33 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品购买信息 相关操作feign客户端 <br>
 */
@FeignClient(value = "${order.service.application.name}")
public interface OrderClient extends IOrderController {
}
