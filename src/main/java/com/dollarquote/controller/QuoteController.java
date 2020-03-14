package com.dollarquote.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import com.dollarquote.entity.Quote;

@ApplicationScoped
public class QuoteController {

	public Response requestQuote(Date date) {
		Instant instant = Instant.now();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
		LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

		Quote quote = new Quote(1L, localDateTime, localDate, 4.00, 3.00, localDateTime);

		return Response.ok(quote).status(200).build();
	}

}
