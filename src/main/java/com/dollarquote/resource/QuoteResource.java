package com.dollarquote.resource;

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
	private QuoteService quoteService;

	@GET
	public Response quote() {
		return Response.ok("Error, please inform a date.").status(400).build();
	}

	@GET
	@Path("{date}")
	public Response quote(@PathParam("date") String date) {
		try {
			Response quoteResponse = quoteService.requestQuote(date);

			return quoteResponse;

		} catch (Exception e) {
			return Response.ok(e.getMessage()).status(400).build();
		}
	}
}