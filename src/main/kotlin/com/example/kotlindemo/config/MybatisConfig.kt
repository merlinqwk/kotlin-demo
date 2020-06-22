package com.example.kotlindemo.config

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.annotation.Resource
import javax.sql.DataSource

@Configuration
class MybatisConfig {
    @Resource(name = "routingDataSource")
    private val routingDataSource: DataSource? = null

    @Bean
    @Throws(Exception::class)
    fun sqlSessionFactory(): SqlSessionFactory? {
        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(routingDataSource)
        sqlSessionFactoryBean.setMapperLocations(*PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*.xml"))
        return sqlSessionFactoryBean.getObject()
    }

    @Bean
    fun platformTransactionManager(): PlatformTransactionManager {
        return DataSourceTransactionManager(routingDataSource!!)
    }
}