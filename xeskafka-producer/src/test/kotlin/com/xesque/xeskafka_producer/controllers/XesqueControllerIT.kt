package com.xesque.xeskafka_producer.controllers

import com.xesque.xeskafka_producer.models.Xesque
import io.restassured.http.ContentType
import io.restassured.http.ContentType.JSON
import io.restassured.module.mockmvc.RestAssuredMockMvc
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
@ExtendWith(SpringExtension::class)
internal class XesqueControllerIT(@Autowired val webApplicationContext: WebApplicationContext) {

    @Test
    fun should_Post_To_Controller() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext)

        given().body(Xesque(0, "Xesque", "Dele"))
                .contentType(JSON)
                .post("/v1/xesques")
                .prettyPeek()
                .then().statusCode(200);
    }
}