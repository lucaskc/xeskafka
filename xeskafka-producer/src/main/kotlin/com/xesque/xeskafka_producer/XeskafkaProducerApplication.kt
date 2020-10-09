package com.xesque.xeskafka_producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Source
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
@EnableBinding(Source::class)
class XeskafkaProducerApplication

    fun main(args: Array<String>) {
        runApplication<XeskafkaProducerApplication>(*args)
    }
