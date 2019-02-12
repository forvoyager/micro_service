package com.xr.test.base;

import com.xr.account.AccountServiceApplication;
import com.xr.base.core.util.DateUtil;
import com.xr.base.core.util.JsonUtils;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author Arnold Yang
 * @since 2019-02-11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountServiceApplication.class)
@WebAppConfiguration
public abstract class BaseTestWithoutLogin {

  @Autowired
  protected WebApplicationContext context;

  protected MockMvc mvc;

  protected long currentTimeInSecond = DateUtil.currentTimeInSecond();

  @Before
  public void setUp() throws Exception {
    /**
     * 方式1：测试单个controller
     * 方式2：测试整个springboot应用，推荐使用此方法。
     */
//    mvc = MockMvcBuilders.standaloneSetup(new AccountController()).build();
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  /**
   * 发送普通的请求
   *
   * @param url
   * @param param
   * @return
   * @throws Exception
   */
  protected String request(String url, Map<String, Object> param) throws Exception {

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
      .get(url)
      .contentType(MediaType.APPLICATION_JSON_UTF8)
      ;

    for(String key : param.keySet()){
      requestBuilder = requestBuilder.param(key, param.get(key).toString());
    }

    String result = mvc.perform(requestBuilder
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.content().string(Matchers.anything())).toString();

    return result;
  }

  /**
   * 向restfull风格的url发送请求
   *
   * @param url restful url
   * @param param 需要替换的参数
   * @return
   * @throws Exception
   */
  protected String requestRestful(String url, Map<String, Object> param) throws Exception {

    for(String key : param.keySet()){
      url = url.replace("{"+key+"}", param.get(key).toString());
    }

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
      .get(url)
      .contentType(MediaType.APPLICATION_JSON_UTF8)
      ;

    String result = mvc.perform(requestBuilder
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.content().string(Matchers.anything())).toString();

    return result;
  }

  /**
   * 发送请求，并通过request body传递参数
   *
   * @param url
   * @param param
   * @return
   * @throws Exception
   */
  protected String requestBody(String url, Object param) throws Exception {
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
      .get(url)
      .contentType(MediaType.APPLICATION_JSON_UTF8)
      ;

    requestBuilder.content(JsonUtils.toJson(param));

    String result = mvc.perform(requestBuilder
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.content().string(Matchers.anything())).toString();

    return result;
  }

  /**
   * 发送请求，并通过request body传递参数
   *
   * @param url
   * @param param
   * @return
   * @throws Exception
   */
  protected String requestBody(String url, List<Object> param) throws Exception {
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
      .get(url)
      .contentType(MediaType.APPLICATION_JSON_UTF8)
      ;

    requestBuilder.content(JsonUtils.toJson(param));

    String result = mvc.perform(requestBuilder
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.content().string(Matchers.anything())).toString();

    return result;
  }
}
