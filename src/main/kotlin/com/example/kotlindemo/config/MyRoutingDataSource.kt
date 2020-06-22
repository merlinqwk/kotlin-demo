package com.example.kotlindemo.config

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

class MyRoutingDataSource : AbstractRoutingDataSource() {

    override fun determineCurrentLookupKey(): Any? {
        return DataSourceHolder.get() //To change body of created functions use File | Settings | File Templates.
    }
}