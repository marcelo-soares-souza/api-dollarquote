package com.dollarquote.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/quote")
@Produces(MediaType.APPLICATION_JSON)
public class Quote {

    @GET
    public Response quote() {
        return Response.ok("Error, please inform a date.").status(400).build();
    }
}