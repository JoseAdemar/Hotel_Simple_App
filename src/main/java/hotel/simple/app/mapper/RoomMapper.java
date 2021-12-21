package hotel.simple.app.mapper;

import org.mapstruct.Mapper;

import hotel.simple.app.dto.RoomDTO;
import hotel.simple.app.entity.Room;

@Mapper(componentModel = "cdi")
public interface RoomMapper extends GenericMapper<RoomDTO, Room> {

}
