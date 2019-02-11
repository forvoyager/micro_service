package com.xr.test.base;

import com.xr.account.AccountServiceApplication;
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
  private WebApplicationContext context;
  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
//    mvc = MockMvcBuilders.standaloneSetup(new UniqueIdSequenceController()).build();
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  protected String request(String url, Map<String, String> param) throws Exception {

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
      .get(url)
      .contentType(MediaType.APPLICATION_JSON_UTF8)
      ;

    for(String key : param.keySet()){
      requestBuilder = requestBuilder.param(key, param.get(key));
    }

    String result = mvc.perform(requestBuilder
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.content().string(Matchers.anything())).toString();

    return result;
  }

  protected String requestBody(String url, Map<String, Object> param) throws Exception {
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
