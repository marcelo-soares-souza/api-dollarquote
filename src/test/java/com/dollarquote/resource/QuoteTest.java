package com.dollarquote.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

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
	
	@Test
    public void testReturnQuoteEndpoint() {
        given()
          .when().get("/quote/20200314")
          .then()
          .statusCode(200)
          .body("$.size()", is(1),
                "[0].buyrate", not(0.0),
                "[0].sellrate", not(0.0));
    }
}