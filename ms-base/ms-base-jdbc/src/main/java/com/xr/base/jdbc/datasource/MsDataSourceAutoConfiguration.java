package com.xr.base.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据源自动配置（默认不会启动）
 * Created by yangchangyan@yijiedai.com on 2019-02-13 10:10.
 */
@Configuration
@ConditionalOnProperty(prefix = MsDataSourceProperties.PREFIX, name = "enabled", matchIfMissing = false)
public class MsDataSourceAutoConfiguration {

  private Logger logger = LoggerFactory.getLogger(getClass());

  public MsDataSourceAutoConfiguration(){
    logger.info("init datasource...");
  }


  // ------------ master datasource 1 start ---------------
  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource.druid.master.1")
  public DataSource masterDataSource_1() {
    /*
    配置信息会在初始化时注入
    配置信息来源@ConfigurationProperties
     */
    return new DruidDataSource();
  }

  @Bean
  @Primary
  public DataSourceTransactionManager masterTransactionManager_1(@Qualifier("masterDataSource_1") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  @Primary
  public SqlSessionFactory masterSqlSessionFactory_1(@Qualifier("masterDataSource_1") DataSource dataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    // set data source
    sessionFactory.setDataSource(dataSource);

    // set config location
    sessionFactory.setConfigLocation(new ClassPathResource("/mybatis/mybatis-config.xml"));

    // set mapper xml location
    Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/*.xml");
    sessionFactory.setMapperLocations(resources);

    // set plugin
//    PageHelper pageHelper = new PageHelper();
//    Properties props = new Properties();
//    props.setProperty("dialect", "mysql");
//    props.setProperty("reasonable", "true");
//    props.setProperty("supportMethodsArguments", "true");
//    props.setProperty("returnPageInfo", "check");
//    props.setProperty("params", "count=countSql");
//    pageHelper.setProperties(props);
//    sessionFactory.setPlugins(new Interceptor[]{pageHelper});

    return sessionFactory.getObject();
  }
  // ------------ master datasource 1 end ---------------


  // ------------ slave datasource 1 start ---------------
  @Bean
  @ConfigurationProperties("spring.datasource.druid.slave.1")
  public DataSource slaveDataSource_1() {
    return new DruidDataSource();
  }

  @Bean
  public DataSourceTransactionManager slaveTransactionManager_1(@Qualifier("slaveDataSource_1") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  public SqlSessionFactory slaveSqlSessionFactory_1(@Qualifier("slaveDataSource_1") DataSource dataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    // set data source
    sessionFactory.setDataSource(dataSource);

    // set config location
    sessionFactory.setConfigLocation(new ClassPathResource("/mybatis/mybatis-config.xml"));

    // set mapper xml location
    Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/*.xml");
    sessionFactory.setMapperLocations(resources);

    return sessionFactory.getObject();
  }
  // ------------ slave datasource 1 end ---------------


  // ------------ druid monitor config start ---------------
  @Bean
  public ServletRegistrationBean DruidStatViewServlet() {
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    // 添加初始化参数
    servletRegistrationBean.addInitParameter("allow","127.0.0.1");
    servletRegistrationBean.addInitParameter("loginUsername", "admin");
    servletRegistrationBean.addInitParameter("loginPassword", "123456");
    // 是否可以重置
    servletRegistrationBean.addInitParameter("resetEnable", "fase");
    return servletRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean druidStatFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
    // 添加过滤规则.
    filterRegistrationBean.addUrlPatterns("/*");
    // 添加不需要忽略的格式信息.
    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
    return filterRegistrationBean;
  }
  // ------------ druid monitor config end ---------------

}
