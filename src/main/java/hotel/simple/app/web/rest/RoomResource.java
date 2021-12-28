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

import hotel.simple.app.dto.RoomDTO;
import hotel.simple.app.service.RoomService;

@Path("/api/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {
	
	private static final Logger LOG = Logger.getLogger(RoomResource.class);
	
	private final RoomService roomService;
	
	public RoomResource(RoomService roomService) {
		this.roomService = roomService;
	}

	@POST
	public Response create(@RequestBody @Valid RoomDTO room) {
		LOG.debugf("REST request to create Room : {}", room);
		
		room = roomService.create(room);
		
		return Response.status(Status.CREATED).entity(room).build();
	}

	@PUT
	public Response update(@RequestBody @Valid RoomDTO room) {
		LOG.debugf("REST request to update Room : {}", room);
		
		room = roomService.update(room);
		
		return Response.status(Status.OK).entity(room).build();
	}
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") Long id) {
		LOG.debugf("REST request to get Room : {}", id);
		
		RoomDTO room = roomService.findOne(id).get();
		
		return Response.status(Status.FOUND).entity(room).build();
	}

	@GET
	public Response getAll() {
		LOG.debugf("REST request to get all Rooms");
		
		List<RoomDTO> rooms = roomService.findAll();
		
		return Response.status(Status.FOUND).entity(rooms).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		LOG.debugf("REST request to delete Room : {}", id);
		
		roomService.delete(id);
		
		return Response.status(Status.NO_CONTENT).build();
	}

}
