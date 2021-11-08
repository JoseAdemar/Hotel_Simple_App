package hotel.simple.app.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import hotel.simple.app.repository.GuestRepository;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import hotel.simple.app.entity.Guest;

import java.util.List;

@Path("/api/guest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class GuestController {


	@Inject
	GuestRepository guestRepository;

	@POST
	@Transactional
	public Response adicionar(@RequestBody @Valid Guest guest) {

		guest.persist();

		return Response.status(Status.CREATED).entity(guest).build();
	}
	@Path("/guests")
	@GET
	public Response loadAllGuests(){
		List<Guest>guests=guestRepository.listAll();
		if (guests.isEmpty()){
			return Response.noContent().build();
		}
		return Response.ok(guests).build();
	}
	@Path("/{id}")
	@GET
	public Response findGuestById(@PathParam("id")Long id){
		Guest guest= guestRepository.findById(id);
		if(!guest.isPersistent()){
			return Response.noContent().build();
		}
		return Response.status(Status.FOUND).entity(guest).build();
	}
}