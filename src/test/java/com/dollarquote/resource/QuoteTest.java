package com.dollarquote.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class QuoteTest {
	@Test
    public void testDateParameterEndpoint() {
        given()
          .when().get("/quote")
          .then()
             .statusCode(400)
             .body(is("Error, please inform a date."));
    }

	@Test
    public void testDateParameterIsValidEndpoint() {
        given()
          .when().get("/quote/12345")
          .then()
             .statusCode(400)
             .body(is("Error, incorrect date format"));
    }
}