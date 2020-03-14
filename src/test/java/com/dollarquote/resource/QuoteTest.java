package com.dollarquote.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class QuoteTest {
	@Test
	public void testDateParameterEndpoint() {
		given().when().get("/quote").then().statusCode(400).body(is("Error, please inform a date."));
	}

	@Test
	public void testDateParameterIsValidEndpoint() {
		given().when().get("/quote/12345").then().statusCode(400).body(Matchers.containsString("Error"));
	}

	@Test
	public void testReturnQuoteEndpoint() {
		given().contentType("application/json").when().get("/quote/20200313").then().statusCode(200).body("buyrate",
				Matchers.not(Matchers.equalTo(0f)), "sellrate", Matchers.not(Matchers.equalTo(0f)));
	}
}
