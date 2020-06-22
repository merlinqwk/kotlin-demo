package com.example.kotlindemo.aop

import com.example.kotlindemo.config.DataSourceHolder
import com.example.kotlindemo.model.DBTypeEnum
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
class DataSourceAspect {

    @Pointcut("execution(* com.example.kotlindemo.dao.Test1Dao.*(..))")
    fun test1Pointcut(){
    }

    @Pointcut("execution(* com.example.kotlindemo.dao.Test2Dao.*(..))")
    fun test2Pointcut(){}

    @Before("test1Pointcut()")
    fun test1Db(){
        DataSourceHolder.set(DBTypeEnum.TEST1)
    }

    @Before("test2Pointcut()")
    fun test2Db(){
        DataSourceHolder.set(DBTypeEnum.TEST2)
    }
}