package com.xesque.xeskafka_producer.services

import com.xesque.xeskafka_producer.models.Xesque
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.stereotype.Component

@Component
class XesqueConsumer {

    private val log = LoggerFactory.getLogger(XesqueConsumer::class.java)

    @StreamListener(Processor.INPUT)
    fun consumeEmployeeDetails(data: Xesque) {
        log.info("{}", data)
    }
}