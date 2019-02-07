package com.xr.account;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <b>description</b>：账户服务配置 <br>
 * <b>author</b>：yangchangyan@yijiedai.com
 * <b>time</b>：2019-02-01 11:41 <br>
 */
@Configuration
//@MapperScan(basePackageClasses = {AccountServiceConfiguration.class})
public class AccountServiceConfiguration {

  @Bean("masterDatasource_1")
  @ConfigurationProperties("spring.datasource.druid.master.1")
  @Primary
  public DataSource masterDataSource_1() {
    return DruidDataSourceBuilder.create().build();
  }

  @Bean(name = "masterTransactionManager_1")
  public DataSourceTransactionManager masterTransactionManager(@Qualifier("masterDatasource_1") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "masterSqlSessionFactory_1")
  @Primary
  public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDatasource_1") DataSource dataSource) throws Exception {
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
}
