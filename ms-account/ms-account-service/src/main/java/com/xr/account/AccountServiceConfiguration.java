package com.xr.account;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <b>description</b>：账户服务配置 <br>
 * <b>author</b>：forvoyager@outlook.com
 * <b>time</b>：2019-02-01 11:41 <br>
 */
@Configuration
//@MapperScan(basePackageClasses = {AccountServiceConfiguration.class})
public class AccountServiceConfiguration {

  @Bean("masterDataSource_1")
  @ConfigurationProperties("spring.datasource.druid.master.1")
  @Primary
  public DataSource masterDataSource_1() {
    return DruidDataSourceBuilder.create().build();
  }

  @Bean(name = "masterTransactionManager_1")
  public DataSourceTransactionManager masterTransactionManager(@Qualifier("masterDataSource_1") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "masterSqlSessionFactory_1")
  @Primary
  public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource_1") DataSource dataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/*.xml");
    sessionFactory.setMapperLocations(resources);
    return sessionFactory.getObject();
  }

  @Bean("slaveDatasource_1")
  @ConfigurationProperties("spring.datasource.druid.slave.1")
  public DataSource slaveDataSource_1() {
    return DruidDataSourceBuilder.create().build();
  }

  @Bean("slaveDatasource_2")
  @ConfigurationProperties("spring.datasource.druid.slave.2")
  public DataSource slaveDataSource_2() {
    return DruidDataSourceBuilder.create().build();
  }

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
}
