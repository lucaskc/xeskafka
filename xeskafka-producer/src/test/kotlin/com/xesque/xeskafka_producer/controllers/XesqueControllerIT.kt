package com.xesque.xeskafka_producer.controllers

import com.xesque.xeskafka_producer.models.Xesque
import com.xesque.xeskafka_producer.services.XesqueConsumer
import io.restassured.http.ContentType
import io.restassured.http.ContentType.JSON
import io.restassured.module.mockmvc.RestAssuredMockMvc
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito.atLeastOnce
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
@ExtendWith(SpringExtension::class)
@EmbeddedKafka(partitions = 1, brokerProperties = ["listeners=PLAINTEXT://localhost:9092", "port=9092"])
internal class XesqueControllerIT(@Autowired val webApplicationContext: WebApplicationContext) {

    @SpyBean
    lateinit var consumer: XesqueConsumer

    @Test
    fun should_Post_To_Controller() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext)

        val xesquedele = Xesque(0, "Xesque", "Dele")

        given().body(xesquedele)
                .contentType(JSON)
                .post("/v1/xesques")
                .prettyPeek()
                .then().statusCode(200);

        verify(consumer).consumeEmployeeDetails(eq(xesquedele))
    }
}