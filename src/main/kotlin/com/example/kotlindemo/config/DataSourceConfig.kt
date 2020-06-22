package com.example.kotlindemo.config

import com.alibaba.druid.pool.DruidDataSource
import com.example.kotlindemo.model.DBTypeEnum
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
open class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.test1")
    fun test1DataSource() : DataSource{
        return DruidDataSource()
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.test2")
    fun test2DataSource() : DataSource{
        return DruidDataSource()
    }

    @Bean
    fun routingDataSource(@Qualifier("test1DataSource") test1DataSource: DataSource,
                          @Qualifier("test2DataSource") test2DataSource: DataSource) : DataSource{
        val targetDataSource = mapOf<Any,Any>(
                DBTypeEnum.TEST1 to test1DataSource,
                DBTypeEnum.TEST2 to test2DataSource
        )
        val routingDataSource = MyRoutingDataSource()
        routingDataSource.setDefaultTargetDataSource(test1DataSource)
        routingDataSource.setTargetDataSources(targetDataSource)
        return routingDataSource
    }
}