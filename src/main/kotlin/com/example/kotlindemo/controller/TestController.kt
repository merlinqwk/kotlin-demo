package com.example.kotlindemo.controller

import com.example.kotlindemo.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
open class TestController {

    @Autowired
    private lateinit var testService: TestService

    @GetMapping("getInfoList")
    fun getInfoList() : HashMap<String, List<Map<String, Any>>?> {
        val result = testService.getInfoList()
        val map = HashMap<String,List<Map<String,Any>>?>()
        map["result"] = result
        return map
    }

    @GetMapping("getInfoById")
    fun getInfoById(@RequestParam("id") id: Int) : Map<String,Any>?{
        return testService.getInfoById(id)
    }


}