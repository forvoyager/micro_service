package com.xr.storage.client.api;

import com.xr.storage.common.controller.IStorageController;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>time</b>: 2019-05-30 18:00:32 <br>
 * <b>author</b>: forvoyager@outlook.com
 * <b>description</b>: 商品库存信息 相关操作feign客户端 <br>
 */
@FeignClient(value = "${storage.service.application.name}")
public interface StorageClient extends IStorageController {
}
