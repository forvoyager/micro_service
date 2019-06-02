package com.xr.api.gateway.controller;

import com.xr.api.gateway.base.BaseController;
import com.xr.api.service.ITradeService;
import com.xr.base.core.dto.ResultDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: forvoyager@outlook.com
 * @Time: 2019-05-31 15:53
 * @Description: 交易相关操作
 */
@RestController
public class TradeController extends BaseController {

  @Resource
  private ITradeService tradeService;

  @RequestMapping("/purchase")
  public ResultDto purchase(long user_id, long commodity_id, int count) throws Exception {
    return ResultDto.successData(tradeService.purchase(user_id, commodity_id, count));
  }

}
