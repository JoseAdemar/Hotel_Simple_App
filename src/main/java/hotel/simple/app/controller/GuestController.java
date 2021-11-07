package hotel.simple.app.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import hotel.simple.app.entity.Guest;

@Path("/api/guest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class GuestController {

	@POST
	@Transactional
	public Response adicionar(@RequestBody @Valid Guest guest) {

		guest.persist();
		return Response.status(Status.CREATED).entity(guest).build();
	}
	
}