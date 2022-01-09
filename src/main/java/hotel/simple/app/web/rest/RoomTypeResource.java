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

import hotel.simple.app.dto.RoomTypeDTO;
import hotel.simple.app.service.RoomTypeService;

@Path("/api/room-types")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomTypeResource {
	
	private static final Logger LOG = Logger.getLogger(RoomTypeResource.class);
	
	private final RoomTypeService roomTypeService;
	
	public RoomTypeResource(RoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	@POST
	public Response create(@RequestBody @Valid RoomTypeDTO roomType) {
		LOG.debugf("REST request to create RoomType : {}", roomType);
		
		roomType = roomTypeService.create(roomType);
		
		return Response.status(Status.CREATED).entity(roomType).build();
	}

	@PUT
	public Response update(@RequestBody @Valid RoomTypeDTO roomType) {
		LOG.debugf("REST request to update RoomType : {}", roomType);
		
		roomType = roomTypeService.update(roomType);
		
		return Response.status(Status.OK).entity(roomType).build();
	}
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") Long id) {
		LOG.debugf("REST request to get RoomType : {}", id);
		
		RoomTypeDTO roomType = roomTypeService.findOne(id).get();
		
		return Response.status(Status.FOUND).entity(roomType).build();
	}

	@GET
	public Response getAll() {
		LOG.debugf("REST request to get all RoomTypes");
		
		List<RoomTypeDTO> roomTypes = roomTypeService.findAll();
		
		return Response.status(Status.FOUND).entity(roomTypes).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		LOG.debugf("REST request to delete RoomType : {}", id);
		
		roomTypeService.delete(id);
		
		return Response.status(Status.NO_CONTENT).build();
	}

}
