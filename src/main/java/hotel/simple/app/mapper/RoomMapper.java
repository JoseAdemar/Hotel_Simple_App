package hotel.simple.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hotel.simple.app.dto.RoomDTO;
import hotel.simple.app.entity.Room;

@Mapper(componentModel = "cdi")
public interface RoomMapper extends GenericMapper<RoomDTO, Room> {
	
	@Mapping(target = "roomTypeId", source = "roomType.id")
	@Mapping(target = "number", source = "number")
	
	public RoomDTO toDto(Room room);
	
	@Mapping(target = "number", source = "number")
	@Mapping(target = "roomType.id", source = "roomTypeId")
	
	Room toEntity(RoomDTO roomDTO);

}
