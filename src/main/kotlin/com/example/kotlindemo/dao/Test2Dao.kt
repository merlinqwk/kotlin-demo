package com.example.kotlindemo.dao

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Repository("test2Dao")
interface Test2Dao {

    fun getInfoById(@Param("id") id: Int) : Map<String,Any>?

}