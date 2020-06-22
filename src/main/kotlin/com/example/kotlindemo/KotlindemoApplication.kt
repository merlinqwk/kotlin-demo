package com.example.kotlindemo

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@MapperScan("com.example.kotlindemo.dao")
@SpringBootApplication
class KotlindemoApplication

fun main(args: Array<String>) {
    runApplication<KotlindemoApplication>(*args)
}
