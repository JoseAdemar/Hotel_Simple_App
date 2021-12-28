package hotel.simple.app.web.rest;

import java.util.List;

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
	public Response createGuest(@RequestBody @Valid Guest guest) {
		LOG.debugf("REST request to create Guest : {}", guest);
		guestService.create(guest);
		return Response.status(Status.CREATED).entity(guest).build();
	}

	@PUT
	public Response updateGuest(@RequestBody @Valid Guest guest) {
		LOG.debugf("REST request to update Guest : {}", guest);
		Guest getGuest = guestService.update(guest);
		return Response.status(Status.OK).entity(getGuest).build();
	}

	@GET
	public Response getAllGuest() {
		LOG.debugf("REST request to get all Guests");
		List<Guest> listGuet = guestService.findAll();

		return Response.status(Status.FOUND).entity(listGuet).build();
	}

	@GET
	@Path("/{id}")
	public Response getGuestById(@PathParam("id") Long id) {
		LOG.debugf("REST request to get Guest with id : {}", id);

		Guest getGuest = guestService.findOne(id).get();

		return Response.status(Status.FOUND).entity(getGuest).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		LOG.debugf("REST request to delete Guest with id : {}", id);

		guestService.delete(id);

		return Response.status(Status.NO_CONTENT).build();
	}

}