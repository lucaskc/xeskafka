package com.xesque.xeskafka_producer.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.xesque.xeskafka_producer.models.Xesque
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.messaging.Source
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder.createMessage
import org.springframework.stereotype.Service

@Service
class XesqueService: XesqueServiceDefinition {

    private val log = LoggerFactory.getLogger(XesqueService::class.java)

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Autowired
    lateinit var output: Source

    override
    fun sendXesque(data: Xesque) {

        val dataString = mapper.writeValueAsString(data)

        val map = hashMapOf(MessageHeaders.CONTENT_TYPE to "application/octet-stream") as Map<String, Any>

        val datatByte = mapper.writeValueAsBytes(dataString)

        val msg = createMessage(datatByte, MessageHeaders(map))

        output.output().send(msg)
        log.info("Xesque received: {}", msg);
    }
}