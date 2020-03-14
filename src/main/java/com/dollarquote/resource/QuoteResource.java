package com.dollarquote.resource;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/quote")
@Produces(MediaType.APPLICATION_JSON)
public class QuoteResource {

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
			Date dt = sdf.parse(date);
			return Response.ok("Ok with date " + dt).status(200).build();

		} catch (ParseException e) {
			return Response.ok("Error, incorrect date format").status(400).build();
		}
	}
}