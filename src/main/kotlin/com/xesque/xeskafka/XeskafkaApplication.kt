package com.xesque.xeskafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class XeskafkaApplication

fun main(args: Array<String>) {
    runApplication<XeskafkaApplication>(*args)
}
