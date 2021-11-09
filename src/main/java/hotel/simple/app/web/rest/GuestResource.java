package hotel.simple.app.web.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.Logger;

import hotel.simple.app.entity.Guest;
import hotel.simple.app.service.GuestService;

@Path("/api/guests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GuestResource {
	
	private static final Logger LOG = Logger.getLogger(GuestResource.class);

	private final GuestService guestService;
	
	public GuestResource(GuestService guestService) {
		this.guestService = guestService;
	}

	@POST
	public Response create(@RequestBody @Valid Guest guest) {
		LOG.debugf("REST request to create Guest : {}", guest);

		final Guest result = guestService.create(guest);

		return Response.status(Status.CREATED).entity(result).build();
	}
	
	@PUT
	public Response update(@RequestBody @Valid Guest guest) {
		LOG.debugf("REST request to update Guest : {}", guest);

		// TODO: to implements
		
		return null;
	}
	
	@GET
	public Response getAll() {
		LOG.debugf("REST request to get all Guests");
		
		final List<Guest> result = guestService.findAll();
		
		if(result.isEmpty()) {
			return Response.noContent().build();
		}
		
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") Long id) {
		LOG.debugf("REST request to get Guest with id : {}", id);
		
		Optional<Guest> result = guestService.findOne(id);
		
		if(!result.isPresent()) {
			return Response.noContent().build();
		}
		
		return Response.status(Status.FOUND).entity(result).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		LOG.debugf("REST request to delete Guest with id : {}", id);

		// TODO: to implements
		
		return null;
	}
	
}