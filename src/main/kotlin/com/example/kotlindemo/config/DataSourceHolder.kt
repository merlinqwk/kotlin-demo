package com.example.kotlindemo.config

import com.example.kotlindemo.model.DBTypeEnum

object DataSourceHolder {
    private val contextHolder = ThreadLocal<DBTypeEnum>();

    fun set(type: DBTypeEnum){
        contextHolder.set(type)
    }

    fun get() : DBTypeEnum{
        return contextHolder.get()
    }
}