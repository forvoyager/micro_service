package com.xr.api.gateway.controller;

import com.xr.api.gateway.base.BaseController;
import com.xr.base.core.dto.ResultDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @Time: 2019-04-04 19:08
 * @Author: yangchangyan@yijiedai.com
 * @Description: 上传操作
 */
@RestController
public class UploadController extends BaseController {

  /**
   * 单文件上传
   *
   * @param uploadFile
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public ResultDto uploadAvatarImg(@RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {

    // TODO

    return ResultDto.success("上传成功");
  }

  /**
   * 多文件上传
   * @param multipartRequest
   * @return
   * @throws Exception
   */
  @RequestMapping("/upload/batch")
  public ResultDto uploadAvatarImg(MultipartHttpServletRequest multipartRequest) throws Exception {

    // TODO

    return ResultDto.success("上传成功");
  }
}
