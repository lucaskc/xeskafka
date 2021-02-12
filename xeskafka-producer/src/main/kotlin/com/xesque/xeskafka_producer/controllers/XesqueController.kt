package com.xesque.xeskafka_producer.controllers

import com.xesque.xeskafka_producer.models.Xesque
import com.xesque.xeskafka_producer.services.XesqueProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class XesqueController {

    @Autowired
    lateinit var xesqueProducer: XesqueProducer

    @PostMapping("/xesques")
    fun postXesque(@RequestBody xesque: Xesque): Xesque {
        xesqueProducer.sendXesque(xesque)
        return xesque

    }
}