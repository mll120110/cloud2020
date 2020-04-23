package com.atguigu.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.activation.DataSource;

@Configuration
public class DruidDataSourceConfig {

    @Bean
    @ConditionalOnMissingBean
    @RefreshScope
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {
        System.out.println("Init DruidDataSource");
        return new DruidDataSource();
    }
}
