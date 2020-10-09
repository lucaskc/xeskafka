package com.xesque.xeskafka_producer.services;

import com.xesque.xeskafka_producer.models.Xesque

interface XesqueServiceDefinition {

    fun sendXesque(data: Xesque)
}
