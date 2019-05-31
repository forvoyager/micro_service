package com.xr.account.client.api;

import com.xr.account.common.controller.IFundsDataController;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2019-05-31 16:13:56 <br>
 * <b>description</b>: 账户资金流水 相关操作feign客户端 <br>
 */
@FeignClient(value = "${account.service.application.name}")
public interface FundsDataClient extends IFundsDataController {
}
