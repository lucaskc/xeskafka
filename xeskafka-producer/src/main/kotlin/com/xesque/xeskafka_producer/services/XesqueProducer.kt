package com.xesque.xeskafka_producer.services

import com.xesque.xeskafka_producer.models.Xesque
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.messaging.Processor

import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class XesqueProducer: XesqueServiceDefinition {

    @Autowired
    private lateinit var processor: Processor

    override
    fun sendXesque(data: Xesque) {
        val message = MessageBuilder.withPayload(data).build()

        processor.output().send(message)
    }
}