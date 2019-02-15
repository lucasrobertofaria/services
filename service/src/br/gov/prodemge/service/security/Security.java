package br.gov.prodemge.service.security;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import br.gov.prodemge.service.util.JWTUtil;

@Path("/security")
public class Security {

	@GET
	@Path("/login")
	public Response login() {
	        String token = JWTUtil.create("teste");
	        return Response.ok().entity(token).build();
	}

}
