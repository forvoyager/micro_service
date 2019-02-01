package com.xr.account.client.api;

import com.xr.account.common.controller.IAccountController;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>description</b>：账户 相关操作feign客户端 <br>
 * <b>time</b>：2019-02-01 11:41 <br>
 * <b>author</b>：yangchangyan@yijiedai.com
 */
@FeignClient(value = "${account.service.application.name}")
public interface AccountClient extends IAccountController {
}
