package com.danielbohry.demo.imagehandlerservice;

import com.danielbohry.demo.imagehandlerservice.controller.FeatureController;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeatureControllerTest {

    @Autowired
    private FeatureController controller;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldReturnAWeatherFromACityName() {
        RestAssured
                .given()
                .port(port)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .get("features")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("", hasSize(14))
                .body("[0].id", equalTo("39c2f29e-c0f8-4a39-a98b-deed547d6aea"))
                .body("[0].timestamp", equalTo(1554831167697L))
                .body("[0].beginViewingDate", equalTo(1554831167697L))
                .body("[0].endViewingDate", equalTo(1554831202043L))
                .body("[0].missionName", equalTo("Sentinel-1"))
                .body("[13].id", equalTo("08a190bf-8c7e-4e94-a22c-7f3be11f642c"))
                .body("[13].timestamp", equalTo(1555044772083L))
                .body("[13].beginViewingDate", equalTo(1555044772083L))
                .body("[13].endViewingDate", equalTo(1555044797082L))
                .body("[13].missionName", equalTo("Sentinel-1"))
        ;
    }

}