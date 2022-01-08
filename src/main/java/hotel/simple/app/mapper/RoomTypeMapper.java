package hotel.simple.app.mapper;

import org.mapstruct.Mapper;

import hotel.simple.app.dto.RoomTypeDTO;
import hotel.simple.app.entity.RoomType;

@Mapper(componentModel = "cdi")
public interface RoomTypeMapper extends GenericMapper<RoomTypeDTO, RoomType> {

}
