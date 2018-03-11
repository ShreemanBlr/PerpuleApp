package com.perpule.customer;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginCheck {

	@Path("/check")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response checkCredentials(@FormParam("username") String name,
			@FormParam("password") String pass) throws URISyntaxException
	{
		
		if("admin".equals(name) && "password".equals(pass))
		{
			URI targetURIForRedirection = new URI("../choice.html");
		    return Response.seeOther(targetURIForRedirection).build();
		}
		
		else
		{
			URI targetURIForRedirection = new URI("../loginFail.html");
			return Response.seeOther(targetURIForRedirection).build();
		}
	}
}
