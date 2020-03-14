package com.dollarquote.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dollarquote.service.QuoteService;

@Path("/quote")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuoteResource {

	@Inject
	private QuoteService quoteController;

	@GET
	public Response quote() {
		return Response.ok("Error, please inform a date.").status(400).build();
	}

	@GET
	@Path("{date}")
	public Response quote(@PathParam("date") String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setLenient(false);

		try {
			Response quoteResponse = quoteController.requestQuote(sdf.parse(date));

			return quoteResponse;

		} catch (ParseException e) {
			return Response.ok("Error, incorrect date format").status(400).build();
		}
	}
}