package hotel.simple.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hotel.simple.app.dto.RoomTypeDTO;
import hotel.simple.app.entity.RoomType;

@Mapper(componentModel = "cdi")
public interface RoomTypeMapper extends GenericMapper<RoomTypeDTO, RoomType> {

	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	public RoomTypeDTO toDto(RoomType roomType);
	
	
	@Mapping(target = "name", source = "name")
	@Mapping(target = "description", source = "description")
	RoomType toEntity(RoomTypeDTO roomTypeDTO);
}
