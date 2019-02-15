package br.gov.prodemge.service.security;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api")
public class Services {

	@GET
	@Path("/hora")
	public Date getHora() {
		
		return new Date();
	}
	
}
