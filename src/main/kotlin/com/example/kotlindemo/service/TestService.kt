package com.example.kotlindemo.service

import com.example.kotlindemo.dao.Test1Dao
import com.example.kotlindemo.dao.Test2Dao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestService {

    @Autowired
    private lateinit var test1Dao: Test1Dao

    @Autowired
    private lateinit var test2Dao: Test2Dao

    fun getInfoList() : List<Map<String,Any>>?{
        return test1Dao.getInfoList()
    }

    fun getInfoById(id: Int) : Map<String,Any>?{
        return test2Dao.getInfoById(id)
    }


}