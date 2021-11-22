package hotel.simple.app.web.rest;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
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
import hotel.simple.app.service.impl.GuestServiceImpl;

@Path("/api/guests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GuestResource {

	private static final Logger LOG = Logger.getLogger(GuestResource.class);

	@Inject
	private GuestServiceImpl guestServiceImpl;

	@POST
	@Transactional
	public Response createGuest(@RequestBody @Valid Guest guest) {
		LOG.debugf("REST request to create Guest : {}", guest);
		guestServiceImpl.create(guest);
		return Response.status(Status.CREATED).entity(guest).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateGuest(@PathParam("id") Long id, Guest guest) {

		Guest getGuest = guestServiceImpl.update(id, guest);
		return Response.status(Status.OK).entity(getGuest).build();
	}

	@GET
	public Response getAllGuest() {
		LOG.debugf("REST request to get all Guests");
		List<Guest> listGuet = guestServiceImpl.findAll();

		return Response.status(Status.FOUND).entity(listGuet).build();

	}

	@GET
	@Path("/{id}")
	public Response getGuestById(@PathParam("id") Long id) {
		LOG.debugf("REST request to get Guest with id : {}", id);

		Guest getGuest = guestServiceImpl.findOne(id).get();

		return Response.status(Status.FOUND).entity(getGuest).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		LOG.debugf("REST request to delete Guest with id : {}", id);

		guestServiceImpl.delete(id);

		return Response.status(Status.NO_CONTENT).build();
	}

}