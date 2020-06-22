package com.example.kotlindemo.dao

import org.springframework.stereotype.Repository

@Repository("test1Dao")
interface Test1Dao {

    fun getInfoList() : List<Map<String,Any>>?

}