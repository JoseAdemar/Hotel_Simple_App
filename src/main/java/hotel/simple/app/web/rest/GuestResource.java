package hotel.simple.app.web.rest;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.Logger;

import hotel.simple.app.entity.Guest;
import hotel.simple.app.repository.GuestRepository;

@Path("/api/guests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GuestResource {
	
	private static final Logger LOG = Logger.getLogger(GuestResource.class);

	@Inject
	private GuestRepository guestRepository;

	@POST
	@Transactional
	public Response create(@RequestBody @Valid Guest guest) {
		LOG.debugf("REST request to create Guest : {}", guest);

		guest.persist();

		return Response.status(Status.CREATED).entity(guest).build();
	}
	
	@GET
	public Response getAll() {
		LOG.debugf("REST request to get all Guests");
		
		List<Guest> guests = guestRepository.listAll();
		
		if(guests.isEmpty()) {
			return Response.noContent().build();
		}
		
		return Response.ok(guests).build();
	}
	
	@Path("/{id}")
	@GET
	public Response get(@PathParam("id") Long id) {
		LOG.debugf("REST request to get Guest with id : {}", id);
		
		Guest guest = guestRepository.findById(id);
		
		if(!guest.isPersistent()) {
			return Response.noContent().build();
		}
		
		return Response.status(Status.FOUND).entity(guest).build();
	}
	
}